# Multithreading

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

### Major Types of Multithrading

#### OS Threads

> Also known as "**kernel threads**"

- Threads visible to OS
- Scheduling handled by OS

#### Green Threads

> Also known as "library threads", or "language threads"

- Threads implemented within programming language.
- Process handles scheduling of its own threads.
- Cannot take advantage of multiple threads.
- *Lower overhead than OS threads but are generally less powerful than OS threads.*

##  Need for Synchronization

### Race Condition
- Outcome of program depends on which thread finishes first.
- Nondeterminism introduced by thread scheduling.
- **Ex:** If Thread A sets `X=1` and Thread B sets `X=2`. Program starts both threads and waits for both to finish, then prints `X`. Does it print 1 or 2?
	- Yes. Instead of a single outcome, we have a set of possible outcomes (*nondeterminism*)

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
		- Enforce sequential access

> Memory Fence (All incomplete thread writes MUST finish)

#### Memory Fence
- A memory fence is an instruction that pauses a thread until all pending writes have finished.
- Knowing when to use a memory fence can be difficult.
	- Using *too many* fences slow down our thread.
	- Not using the right fences can lead to data races.
- Compilers (*currently*) aren't smart enough to know where memory fences are needed.
	- Typically, these are inserted in library code by experts.

## Tools for Synchronization
- Mutual exclusion / "**locks**"
	- Idea: resources that at most one thread can access simultaneously.

- e.g. a shared queue
	- Only one thread can enqueue or dequeue at a time, but otherwise, they can be scheduled freely.
- **Anytime you want to read information, YOU NEED MUTUAL EXCLUSION**
- In a concurrent world, you can not READ information in the way we are used to.
	- By the time we return the info, it would have already changed.

### How can we make a lock?

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

### Solution
- `Test-and-set` - Obtains the current value of the variable and changes it in one fell swoop.
- `Compare-and-go`
- `fetch-and-add`

#### Test and Set
- We can think of this as a function that sets a variable and returns its old value.
	- `while(test_andset(&lock) == 1) { // do nothing }`
	- This works in a single step, making it impossible for another thread to go in a modify the lock.

- Test and Set is called a "spinlock"
- It is horribly inefficient
- Don't allow the scheduler to know when a thread is blocked by a lock.
- Requires a lot of bus traffic (needed to ensure the atomic nature of test-and-set)
- **We want to avoid test-and-set**.

> Instead of using spinlocks, we use higher-level system-provided *mutex locks*

##### The PThread Library
- The POSIX Threads (PThreads) library provides a mutex abstraction that can be locked and unlocked.
- Only one thread can have a given lock at a time. 
- A thread attempting to lock a locked mutex will block until the mutex is unlocked.

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

