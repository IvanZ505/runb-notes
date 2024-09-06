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

#### Problems

##### 1 - Restricted OPS

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

---
