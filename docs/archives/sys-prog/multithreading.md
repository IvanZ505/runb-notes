# [Multithreading](sys-prog.md)

## Threads

##### Task

- instance of a fetch execute cycle.
- has an instruction pointer, usually a stack.

##### Process

- Usually  has one task
- Private virtual memory

> A Multitasking system can run more than one task concurrently.

- Can switch between multiple tasks on a single processor.
- Can schedule tasks between multiple processors (multiprocessing)

**Processes with separate virtual memories are protected from each other but can not easily communicate.**

##### Threads

> Tasks within a single process

- A multithreading process has multiple tasks sharing the same virtual memory.
- **Multithreading** greatly simplifies communication between tasks and allows for miscommunication/interference between tasks.

### Major Types of Multithreading

#### OS Threads

> Also known as "**kernel threads**"

- Threads visible to OS
- Scheduling handled by OS

The OS can schedule threads on *separate* processors.

#### Green Threads

> Also known as "library threads", or "language threads"

- Threads implemented within programming language.
- Process handles scheduling of its own threads.
- Cannot take advantage of multiple threads.
- *Lower overhead than OS threads but are generally less powerful than OS threads.*

## Need for Synchronization

### Race Condition
- Outcome of program depends on which thread finishes first.
- Nondeterminism introduced by thread scheduling.
- **Ex:** If Thread A sets `X=1` and Thread B sets `X=2`. Program starts both threads and waits for both to finish, then prints `X`. Does it print 1 or 2?
	- Yes... Instead of a single outcome, we have a set of possible outcomes (*nondeterminism*)

### Data Race
- Multiple threads make unsynchronized access to a piece of data, at least one of which writes to it.

##### Example of Data Race
- 2 Threads, Thread 1: `X = 1, A = Y`, Thread 2: `Y = 1, B = X`
- There are 4 different outcomes. (3 Assuming sequential model of C)

---

> C programs containing data races are undefined!

```
THREAD A                                                  THREAD B
---                                                       ----

for(i = 0; i < 100; i++) {                                X = 0; 
	X = 1;
	a[i] = X;
}

> There are 101 possible outcomes, depending on when thread B runs. There can be a 1 in any of the array entries, or NONE of the array entries.

THREAD A (Optimized)

X = 1;
for(i = 0; i < 100; i++) {
	a[i] = X;
}

101 possible outcomes, depending on when thread B runs. (It could have any amount of 1s, then followed by any amount of 0s.)
```

- We **WANT** data optimizations such as the one above, so C declares data races to have undefined behavior.
- **Solution:** don't have data races.
	- Forbid shared mutable data at language level (*Rust*)
	- Synchronize access to shared data
		- **Enforce** sequential access

> Memory Fence (All incomplete thread writes MUST finish)

#### Memory Fence
- A memory fence is an instruction that pauses a thread until all pending writes have finished.
- Knowing when to use a memory fence can be difficult.
	- Using *too many* fences slow down our thread.
	- Not using the right fences can lead to data races.
- Compilers (*currently*) aren't smart enough to know where memory fences are needed.
	- Typically, these are inserted in library code by experts.

## Tools for Synchronization

#### Locks
- Mutual exclusion / "**locks**"
	- Idea: resources that at most one thread can access simultaneously.

- e.g. a shared queue
	- Only one thread can enqueue or dequeue at a time, but otherwise, they can be scheduled freely.
- **Anytime you want to read information, YOU NEED MUTUAL EXCLUSION**
- In a concurrent world, you can not READ information in the way we are used to.
	- By the time we return the info, it would have already changed.

### How can we make a lock?

#### Wrong Way

```C
int lock = 0;      // 0 to unlock, 1 to lock.

example:
	while(lock == 1) {do nothing}
	lock = 1;
	// Use shared resource
	lock = 0;

// THIS DOES NOT WORK!
// Another thread could acquire the lock between exiting the loop and setting lock = 1.
```

##### Problem
- The operation is not atomic!
	- Another thread could be scheduled between the test and the set.

In other words, there are gaps in the execution and in these gaps, another program can come along and modify the resource.

### Solution
- `Test-and-set` - Obtains the current value of the variable and changes it in one fell swoop.
- `Compare-and-go`
- `fetch-and-add`

#### Test and Set
- We can think of this as a function that sets a variable and returns its old value.
	- `while(test_andset(&lock) == 1) { // do nothing }`
	- This works in a single step, making it impossible for another thread to go in a modify the lock.

##### Spinlock
- Test and Set is called a "spinlock"
- It is horribly inefficient
- Don't allow the scheduler to know when a thread is blocked by a lock.
- Requires a lot of bus traffic (needed to ensure the atomic nature of test-and-set)
- **We want to avoid test-and-set**.

> Instead of using spinlocks, we use higher-level system-provided *mutex locks*

## The PThread Library
- The POSIX Threads (PThreads) library provides a mutex abstraction that can be locked and unlocked.
- Only one thread can have a given lock at a time. 
- A thread attempting to lock a locked mutex will block until the mutex is unlocked.

**To Use:** You must include the *-pthread* compilation option.

`#include <pthread.h>` - also include this header.

**Two operations: Lock and unlock**

```C

lock(&m);
// Do stuff        <-- Critical section
unlock(&m);
```

- The idea is to enforce sequential access to shared data structures.
- Only the thread holding the lock has access.
	- -> Other threads must wait for that thread to finish before they can get access.
- C (Posix) gives us the tools to synchronize access to data structures, but it is up to us to use these tools correctly.
- There is **nothing** stopping us from accessing a shared data structure without first getting exclusive access (except our own good sense)
	- **Supply your own discipline**

### `pthread_create`

```C
int pthread_create(
	pthread_t *thread_id,
	pthread_attr_t *attributes,
	void *(*function) (void*),
	void *argument
)
```

We can think of `pthread_create()` as a function that *runs in the background*.

	- The function argument must be a function that takes in a void \* and returns a void \*.

`pthread_attr_t` is a *abstract data type* that is used to specify features for a thread.

- `int pthread_attr_init(pthread_attr_t *attr);` 
	- various `pthread_attr_getX()` and `pthread_attr_setX()` functions to obtain/change the attributes.

`pthread_t` may be an integer or a struct, so best to treat is as opaque data. (Just pass it to other functions)
#### Success

- On success, `pthread_create()` starts a new thread (*task*) within the current process.
	- This new thread will execute the specified function and pass it the provided argument.
	- The **id** of the new thread will be written to `*thread_id`.
	- `*attributes` can be used to specify certain options or features. (Use `NULL` for defaults)
	- Returns `0`.

#### Failure

- On failure, `pthread_create()` will return an **error code**. (*Note:* It does not write to errno.)

### `pthread_join`

```C
int pthread_join(
	pthread_t thread_id,
	void **return_value
)
```

The `pthread_join` function will suspend execution of the *calling thread* until the *target thread* (`thread_id`) has terminated. (*Unless already terminated*)

- Once the target thread has terminated, `pthread_join` writes the return value into `*return_value`.

> On **success**, return 0, on **failure**, return an error code.

### Example Using `pthread`

```C
// Function prototype
void* worker(void *argument);

// Our code
{
	pthread_t work_thread;
	arg_t argument = get_next_argument();
	ret_t = *return_value;

	pthread_create(&work_thread, NULL, worker, argument);

	// Do other things

	pthread_join(work_thread, &return_value);

	// At this point, the worker thread has completely terminated
	// The pointer that it returns is stored within `return_value`
}
```

### Other Functions

`pthread_t pthread_self(void);` - returns the `thread_id` of the current thread.

`void pthread_exit(void *ret_val);` - terminates the current thread and provides the return value. (*Thread version of exit()*)

`int pthread_equal(pthread_t t1, pthread_t t2);` - Tests whether the two `pthread_id` are the same.

`int pthread_kill(pthread_t thread, int sig);` - Send a signal to a thread.

`int pthread_cancel(pthread_t thread);` - Tells a thread to terminate.


### More Complexed Ex

> Start a bunch of threads, wait for them all to terminate.

```C
int main() {
	pthread_t threads[5];
	int args[5];

	// Spawn all the child threads.
	for(int i = 0; i < 5; i++) {
		args[i] = i;
		pthread_create(&threads[i], NULL, thread_function, &args[i]);
	}

	// Wait for them all to terminate
	for(int i = 0; i < 5; i++) {
		pthread_join(threads[i], NULL);
	}
	// All tasks have been completed.
}
```

> Referring to multitasking, `pthread_create` is analogous to [fork](multitasking.md#process) and `pthread_join` is analogous to [wait](multitasking.md#process).

- The *difference* between **threads** and **processes** however is that *processes* have a parent/child process whereas *every thread* is considered a peer.
	- *Any thread* can call `pthread_join` for another thread.

## Sharing Data Safely

Sharing data between threads is *inherently unsafe* due to [data races](#data-race).

**Question:** What should be sequentially accessed?

- How much sequencing do we need in our program?
	- Too little sequencing means data races could occur.
		- Incomprehensible behavior
	- Too much sequencing means poorer performance.

***Solution:*** Sequentialize access to shared data structures so that *only one* thread can access a data structure at a time.
### Mutex Lock

Using a *mutex*, we can enforce sequential access to data.

`pthread_mutex_t` - An abstract struct

`int pthread_mutex_init(pthread_mutex_t *lock, pthread_mutexattr_t *attrs);` - Initializes the mutex referenced by `*lock` with the attributes specified.

- If there are no attributes specified (`NULL`), the default mutex attributes are used. 
- Upon **success**, the state of the mutex becomes initialized and unlocked.
	- Attempts to initialized a mutex *already* initialized results in **undefined** behavior.

`int pthred_mutex_destroy(pthread_mutex_t *lock);` - Destroys the mutex. (*In effect*, the mutex object becomes uninitialized.)

- A destroyed mutex object can be re-initialized using `pthread_mutex_init()`; the results of otherwise referencing the object after it has been destroyed are undefined.
- **Only destroy unlocked a mutex**, destroying a locked mutex results in undefined behavior.

#### Example

- Example using a bank account and accessing the balance.

```C
typedef struct {
	int balance;
	pthread_mutex_t lock;
} account_t;

void account_init(account_t *a, int initial) {
	a->balance = initial;
	pthread_mutex_init(&a->lock, NULL);  // Init the mutex lock
}

void account_change(account_t *a, int diff) {
	pthread_mutex_lock(&a->lock); // Locks the lock.
	a->balanace += diff;
	pthread_mutex_unlock(&a->lock); // Unlocks after use
}

// Locking and unlocking ensures the sequential access as long as we don't access the field another way.

void account_transfer(account_t *dest, account_t *src, int amount) {
	account_change(src, -amoount);
	account_change(dest, amount);
}
```

### Thread-safe Queue
- For *safety*, ensure only one thread accesses the queue at a time.

**mutex** - abstraction used to coordinate access to a resource.

- "locked" - one thread has access
- "unlocked" - no thread has access

> Only the thread that locked the mutex can unlock it.


#### Operations of a Thread-safe Queue
- **Enqueue**
- **Dequeue**
	- This can't work if the queue is empty.
		- *if it is empty*, we might want to dequeue to block until another thread enqueues.

#### Example

```
C1                      P1                       C2  
dequeue  
	-> wait for  
	read_ready  
						enqueue  
							->signal  
							read_ready  
unblocked
												
												dequeue  
												succeeds  
												length = 0
->wait for  
read_ready
```
#### Producers vs Consumers
- A Consumer thread will dequeue (block because nothing is in there)
	- Wait for read_ready
- A Producer thread will then enqueue (signal read_ready)
- Consumer thread will unblock and dequeue. This will finally dequeue, and once it does, queue is empty again, so it will wait once more.

> Not very good, the number produced and consumed needs to be the same.

- Ideally, we want a way to indicate whether the producers are stopped and to close the queue.

### Condition Variables
- A *condition variable* is something offered by Pthread that allows threads to *block* until some condition is met.
	- Indicated by another thread saying the condition is met

```C
pthread_cond_t

int pthread_cond_init(pthread_cond_t *cv, pthread_condattr_t *attrs);
int pthread_cond_destroy(pthread_cond_t *cv);

int pthread_cond_wait(pthread_cond_t *cv, pthread_mutex+t *lock); // Blocks thread until cv is signaled (temporarily unlocking lock)
int pthread_cond_signal(pthread_cond_t *cv); // Wakes one thread waiting on the cv.
```

#### Condition Broadcasting
- Wakes up every thread that is waiting for this condition and signals to all of them that the condition has been met.
- `pthread_cond_broadcast(pthread_cond_t *cv);`

### Deadlocks

*Deadlock* is a situation where a set of a set threads is being blocked because another thread currently holds the lock to a resource.

#### Conditions

4 Conditions for Deadlock

1. Mutual exclusion
2. Hold-and-wait
	- It is possible to block trying to acquire a resource when holding onto another resource. 
3. No preemptive
	- If a thread has exclusive access, no other thread can force it to give up access.
4. Circular wait
	- e.g. A waits for B, B waits A.

**To avoid deadlocks**, ensure that at least one of these conditions will not apply. (*e.g.* not allowing multiple locks avoids *hold-and-wait*).

> It is also possible to design higher-level abstractions (*monitors*) to manage locks in a way that will not allow *deadlocks*.

**Note:** Deadlocking does **not** require threads. Any two communicating processes can also deadlock.

### Barriers

*Barriers* are an abstraction that creates a "rendezvous".

**Rendezvous** are a point where *all threads* wait until every thread has reached that point.

> For in-depth information, visit [pthread_barrier_wait()](https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_barrier_wait.html).

```C
pthread_barrier_t

int pthread_barrier_init(
	pthread_barrier_t *bar,
	pthread_barrierattr_t *attr,
	unsigned count     // Indicates how many threads must wait at the barrier until any of them can proceed.
);

int pthread_barrier_destroy(pthread_barrier_t *bar);

int pthread_barrier_wait(pthread_barrier_t *bar); // Block until the correct number of threads has reached this point.

// Example of pthread_barrier_wait

for(...) {
	// Do stuff
	pthread_barrier_wait(&bar);
}
```

### Semaphore

A *semaphore* is essentially an integer that represents the number of available resources.

#### Operations

Two operations in a semaphore: *Post / increment* and *wait / decrement*.

*Post* increases the integer by 1 whereas *wait* decreases this integer by 1 (*If it is positive*).

- If the *semaphore* is 0, then it blocks until the *semaphore* is positive again.

> A *mutex* is a semaphore whose maximum value is 1. 

```
mutex      semaphore  
-----      ---------  
init()     init(1)  
locked     1  
unlocked   0  
lock()     wait()  
unlock()   post()
```

> A *conditional variable* can also be a semaphore.

```
cond.var    semaphore  
--------    ---------  
init()      init(0)  
wait()      wait()  
signal()    post()

... almost
```

- Signaling a *condition variable* when there is no thread waiting has no effect.
	- Posting to a semaphore *always* raises its value.

#### The Little Book of Semaphores

```C
#include <semaphore.h>

sem_t;
int sem_init(sem_t *sem, int pshared, unsigned int value);
	// Initialize semaphore with specific initial value.
	// pshared is typically 0.

int sem_wait(sem_t *sem);
int sem_post(sem_t *sem);

typedef struct {
	int first;
	int last;
	int size;
	data_t *data;
	sem_t lock;
	sem_t empty;
	sem_t full;
} queue_t;

void q_init(queue_t *q, int capacity) {
	q->first = 0;  
	q->last = 0;  
	q->size = capacity;  
	q->data = malloc(sizeof(data_t) * capacity);  
	sem_init(&q->lock, 0, 1); // mutex initially unlocked  
	sem_init(&q->empty, 0, capacity); // all spots are empty  
	sem_init(&q->full, 0, 0); // no spots are full
}

void q_enqueue(queue_t *q, data_t item) {
	sem_wait(&q->empty);
	
	sem_wait(&q->lock);  
	
	q->data[q->last] = item;  
	q->last++;  
	if (q->last == q->size) q->last = 0;  
	
	sem_post(&q->lock);  
	
	sem_post(&q->full);
}

void q_dequeue(queue_t *q, data_t *dst)  
{  
	sem_wait(&q->full);  
	
	sem_wait(&q->lock);  
	
	*dst = q->data[q->first];  
	q->first++;  
	if (q->first == q->size) q->first = 0;  
	
	sem_post(&q->lock);  
	
	sem_post(&q->empty);  
}
```

---

#### Major Differences

- In general, any thread can post to any *semaphore*.

- **Mutexes** have more restrictive rules, so it's easier to see when they are being misused.
- More possible states...
	- E.g. we can *count* the number of available resources.
- Semaphores can simulate condition variables, but work needs to be done to handle broadcasts or to "lose" signals when no thread is waiting.

##### Posix Specific Differences

- `sem_post` and `sem_wait` are "safe" to use in signal handlers.
- Semaphores can be shared among multiple processes.
	- `sem_open()` associates a `sem_t` object with a semaphore file in the file system. (*Accessible by multiple processes*)

> Possible tools: *Thread sanitizer* -> `-fsanitize=threads`... (Can not be used with address sanitizer)

### Starvation

**Starvation** occurs when a thread is waiting for a resource, but other threads prevent it from acquiring the resource.

- Ex: Multiple threads can be getting read locks in overlapping finite time periods. A thread waiting for write access may wait indefinitely.
- *What are the chances of that happening?*
	- We don't want to rely on chance though...

#### Solutions
- One possible solution: enforce turn-taking.
	- e.g. don't allow threads to get read access if a thread is waiting to get write access.

### Livelock

*Livelock* occurs when two or more tasks make state changes that undo the work of the other tasks.

- The tasks end up spending all their time undoing and redoing the same state changes, and never actually advancing to do something productive.

