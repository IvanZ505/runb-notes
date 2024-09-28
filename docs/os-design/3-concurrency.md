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