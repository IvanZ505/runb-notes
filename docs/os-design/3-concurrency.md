# [Concurrency](0-os-design)

## Concurrency: Threads

> Previous info about [threads](../sys-prog/multithreading#Threads)

**Questions Answered:**

- Why is concurrency useful?
- What  is a thread and how does it differ from processes?
- What can go wrong if scheduling of critical sections is not atomic?

### Motivation for Concurrency

#todo get graph

- The speeds of each CPU by itself sort of tapered off, and is no longer growing (individually)
- Needing more and more power
- Smaller and smaller transistors may leak power.
- Improving one CPU is a *General Purpose* approach.

**Goal:**

- Write applications that fully utilize many cores.

#### Option 1
- Build apps from many communicating **processes**.
	- Example: Chrome (process per tab)
	- Communicate via `pipe()` or similar.
- **Pros:** Don't need new abstractions; good for security
- **Cons?**
	- Cumbersome programming
	- High communication overheads
		- Programming becomes a lot harder
	- Expensive context switching (why expensive?)

#### Option 2
- **New abstraction:** ***thread***
- Threads are like processes, except:
	- Multiple threads of the same process share an address space.
- Divide large task across several cooperative threads.

### Common Programming Models

- Multi-threaded programs tend to be structured as:
- **Producer/consumer:**
	- Multiple producer threads create data (or work) that is handled by one of the multiple consumer threads.
	- *Example:* Matrix multiplication, producer thread makes the matrix, allocates the memory, and then gives it to consumer threads to work on.
- **Pipeline:**
	- Task is divided into series of subtasks, each of which is handled in series by a different thread.
	- Each following thread **does not wait** for the previous thread to finish.
	- Once some data is compile, it is passed to the next thread to start.
	- Assembly line for threads, but you don't just wait for the thread to complete, but just finish some intermediate step.
- **Defer work with background thread:**
	- One thread performs non-critical work in the background (when CPU idle)
	- *Only useful* if you want something to run way ahead.

### What do Threads Share?

- Everything in the address space. (PTBR)
- Shares code, but each thread may be executing *different code* at the *same time*
- Do they share Instruction Pointers?
	- **NO!** As they run in different CPUs, they have different IPs.
	- However, they *can* access another thread's IP.
- Do they share a stack pointer?
	- **NO!** Also bad practice to share stack pointers.

### OS Support

#### Approach 1

##### User-Level Threads
- **Many-to-one** thread mapping
- Implemented by user-level runtime libraries.
	- Create, schedule, synchronize threads at user-level
- OS is not aware of user-level threads (You can make hundreds and thousands)
	- OS thinks each process contains only a single thread of control.

###### Advantages
- Does not require OS support; Portable
- Can tune scheduling policy to meet application demands
- Lower overhead thread operations since no system call

###### Disadvantages
- Cannot leverage multiprocessors
- Entire process blocks when one thread blocks

#### Approach 2

##### Kernel-level threads: One-to-one thread mapping  
- OS provides each user-level thread with a kernel thread
- Each kernel thread scheduled independently
- Thread operations (creation, scheduling, synchronization) performed by OS  

###### Advantages
- Each kernel-level thread can run in parallel on a multiprocessor  
- When one thread blocks, other threads from process can be scheduled  

###### Disadvantages  
- Higher overhead for thread operations
- OS must scale well with increasing number of thread

## Locks

#### Non-Determinism

> Previous notes on [non-determinism](../sys-prog/multithreading)

- Concurrency leads to non-deterministic results!
- [Race conditions](../sys-prog/multithreading#Race-Condition)

Whether a bug manifests depends on CPU schedule!

- Passing tests means little...
- How to program: Imagine scheduler is malicious.
- Assume scheduler will pick bad ordering at some point...

---

#### Program Verification


---

### What do we want?
- What 3 instructions to execute as an uninterruptable group
- That is, we want them (on the software layer) to execute atomically...

```assembly
mov 0x123, %eax
add %0x1, %eax                      // CRITICAL SECTION
mov %eax, 0x123
```

- I have some piece of code that, where there are multiple threads running at the same time, ONE MUST be serialized.

##### More Generally
- Need mutual exclusion for *critical sections*
	- If process `A` is in critical section `C`, process `B` can't.
	- (Okay if other processes do unrelated work)

### Synchronization
- Build higher-level synchronization primitives in OS
	- Operations that ensure correct ordering of instructions across threads.
- Motivation: Build them once and get them right.

### Mutex
- **Goal:** Provide mutual exclusion (Mutex)
- **Three common operations:**
	- Allocate and Initialize: `Pthred_mutex_t mylock = PTHREAD_MUTEX_INITIALIZER;`
- **Acquire:**
	- Acquire exclusion access to lock.
	- Wait if lock is not available (some other process in critical section)
	- *Spin* or *Block* (relinquish CPU) while waiting.
		- Block says, "I will delay my checking of the lock instead of perpetually checking"
	- `Pthread_mutex_lock(&mylock);`
- **Release:**
	- #todo fill out this


#### Example: Shared Linked List Issues
1. Functionality is a problem (Visibility)
