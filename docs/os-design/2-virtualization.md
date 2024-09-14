# Virtualization

## CPU Virtualization

 > **Core Idea:** Understand the different approaches for virtualizing the CPU.
 
### Process

> A *process* is an ***execution stream*** in the context of a *process state*. (A unit of scheduling in the CPU)

- What is an execution stream?
	- Stream of executing instructions
	- Running piece of code
	- "Thread of control"
- What is process state?
	- Everything that the running code can affect or be affect by
	- [Registers](../comp-arch/6-assembly#Data-Size-and-x86-64-Registers)
		- General purpose, floating point, status, PC, Stack pointer, etc...
		- Usually takes less than 1 ns, you can appx to 1 ns.
		- Compilers can do a pretty good job at putting variables in registers.
	- Address space
		- Any and **all** state of your program.
		- A small amount of your address space for the program may be in the register, but the rest will be in the cache or the memory.
		- Heap, stack, and code
	- Open Files

#### Processes vs Threads
- A process is different from a thread
- Thread: "Lightweight process" (LWP)
	- An execution stream that shares an address space.
	- Multiple threads within a single process.
- **Example:**
	- Two *processes* examining same memory address `0xffe84264` see *different* values (I.e different contents)
	- Two *threads* examining memory address `0xffe84264` will see the *same* value. (I.e. same contents)

### How to Provide Good CPU Performance?
- **Direct execution** - Best performance, but no safety checks
	- Allow user process to run directly on hardware.
	- OS creates process and transfers control to starting point (ie main())
- Problems with direct execution?
	- Process could do something restricted
		- Read/write other process data (disk or memory)
	- Process could run forever (slow, buggy, or malicious)
		- OS needs to be able to switch between processes
	- Process could do something slow (like I/O)
		- OS wants to use resources efficiently and switch CPU to other process.

> *Solution* - Limited Direct Execution

## Problems

### 1: Restricted OPS

How can we ensure user process can't harm others?

> Solution - Privelege levels supported by hardware (bit of status)

- User processes run in user mode (restricted mode)
	- Any program running here is generally considered untrusted
	- Ring Levels #todo find pic
- OS runs in kernel mode (not restricted)
	- Instructions for interacting with devices
	- Could have many privelege levels (advanced topic)

- How can process access device? -> System calls and change privilege level through sys calls. (trap)

**System call** -

`read()` --assembly--> `movl $6 %eax;  int $64`


### 3: Slow Operations
- When running process performs operations that does not use CPU, OS switches to process that needs CPU (policy issues)
- OS must track mode of each process:
	- *Running:*
		- On the CPU (only one on a uniprocessor)
	- *Ready:*
		- Waiting for the CPU
	- *Blocked:*
		- Asleep: Waiting for I/O on synchronization to complete.

---

## Scheduling

### Agenda
- What are different scheduling policies, such as:
	- FCFS, SJF, STCF, RR and MLFQ
- What type of workload performs well with each scheduler?
- What scheduler does Linux currently use?

### Terminology

#### Workload
- Set of **job** descriptions (arrival time, run_time)
	- Job: View as current CPU burst of a process.
	- Process alternates between CPU and I/O process moves between ready and blocked queues.

#### Scheduler
- Logic that decides which ready job to run
- Metric
	- Measurement of ... #todo fill out


### Scheduling Performance Metrics

#### Minimizing Turnaround Time
- Do not want to wait long for job to complete.
- **Completion_time = arrival_time**

#### Minimizing Response Time
- Schedule interactive jobs promptly so users see output quickly.
- **Initial_schedule_time = arrival_time**

#### Minimizing Waiting Time
- Do not want to spend much time in Ready queue.

#### Maximize Throughput
- Want many jobs to complete per unit of time.
#### Maximize Resource Utilization
- Keep expensive devices busy

#### Minimize Overhead
- Reduce number of context switches

#### Maximize Fairness
- All jobs get the same amount of CPU time.

### Workload Assumptions
1. Each job runs for the same amount of time.
2. All jobs arrive at the same time.
3. All jobs only use the CPU (no I/O)
4. Run-time of each job is known

### Scheduling Basics

- **Workload**
	- `arrival_time`
	- `run_time`
- #todo find these


### FIFO
- **aka** First in First Out or **FCFS** (First come first serve)
- Run jobs in `arrival_time` order.

##### FIFO Turnaround

`completion_time - arrival_time`

- You must take the average for Turnaround time as each task will finish at different times.

###### Example

| Job | arrival_time | run_time |
|:----|:-------------|:---------|
| A   | ~0           |       60 |
| B   | ~0           |       10 |
| C   | ~0           |       10 |  

> In this case, the turnaround time would be ~20 seconds.

### SJF
- Shortest Job First Scheduler
- **Choose the task with the shortest time**

##### SJF Turnaround

| Job | arrival_time | run_time |
|:----|:-------------|:---------|
| A   | ~0           |       60 |
| B   | ~0           |       10 |
| C   | ~0           |       10 |  

> In this case, the runtime would be (10s + 20s + 80s) /3 = 36.7s avg.


---

> Past here, we will not assume part 1 and 2 of the workload.


---

### Preemptive Scheduling

- Previous schedulers:
	- FIFO and SJF are non-preemptive
	- Only schedule new jobs when previous job voluntarily relinquishes CPU (Performs I/O or exits)
- New Scheduler:
	- Preemptive: Potentially schedule different jobs at any point by taking CPU away from running job.