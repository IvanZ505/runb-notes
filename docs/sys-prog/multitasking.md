# Multitasking

A **task** refers to the execution of a program.

- Some program being executed.
- Instruction pointer, registers, etc.

## Multitasking System
- Executes multiple tasks concurrently.
	- Splits time between multiple tasks.

### Why do we multitask?
- Usually, multitasking is slower than single-tasking, because it takes more time to switch.
- However, sometimes we need to **keep the CPU busy** when there is something else required for running a task.
	- This splitting of time will allow the CPU to continue working on something until the task can continue running.
- It also **improves responsiveness** for programs with user interfaces.
- **Take advantage** of multiple CPUs

### Virtual Memory Environment
- Pointers in user programs are "logical addresses" ("virtual addresses")
	- These are distinct from the actual *physical addresses* in the data bank.
- The hardware and OS maintain a *mapping* of logical addresses to physical addresses, per process.
- This means that different processes aren't able to screw up another processes' memory or access it in any way.

> This means, the same logical address will refer to **different** physical addresses in different processes.

### Scheduling
- When do we switch from one task to another?

#### The Scheduler
- Decides which task runs next, and primarily uses 2 different methods to determine what runs?

##### Cooperative Multitasking
- Tasks run until they block or explicitly yield control.
- If one task goes into a infinite loop, the entire system will seize up.

##### Preemptive Multitasking
- Tasks are given a time slice and run until the slice ends.
- This does not block everyone else.
- **Mostly used nowadays**

## Process
- A process is a *task*, with its own **virtual memory space**.
- Process groups are groups of one or more processes.

How to make a process?

`pid_t fork(void);` - Creates a new process (the child) by cloning the current process (the parent).

- They originally begin the same. *they use the same virtual address*, but refer to *different physical addresses*.
- `fork()` returns 0 in the child
- `fork()` returns the [PID](the-shell#processes) of the child in the parent.
- `fork()` returns -1 and sets errno if something went wrong.

If you call `fork()`, you must call...

`pid_t wait(int *status);` - obtains exit information from a child process.

- Blocks until a child finishes.
- If the child finishes before `wait()` is called, it returns immediately.
- *On success,* returns the PID of the child that has terminated and writes exit information into status.

#### Process Table
- In the OS
- Keeps track of running processes
- When a process terminates, it *remains* in the process table.
	- However, it becomes a "zombie"
	- When the parent calls `wait()`, it "reaps" the zombie, which cleans up the entry in the process table.

### What happens if a Parent Dies Before a Child
- If a parent dies before its child processes, they become "*orphans*"
	- This means the parent can't wait for their child anymore.
- When a "orphan" terminates, it becomes a orphan zombie.
	- Typically when this happens, a designated OS process (usually *init*) will "adopt" the orphans and wait for them to terminate.

---

`int execl(char *path, ..., NULL);`

`int execv(char *path, char **args);`

- Starts executing a different program (replacing the current program)
- On Success, it does not return.
- On failure, returns -1 and sets errno.

`execl("/path/to/program_file", "/path/to/program/file", "Arg1", "Arg2, NULL)`