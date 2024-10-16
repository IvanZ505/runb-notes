# Memory Virtualization

**Questions answered in this lecture:**

- What is in the address space of a process (review)?
- What are the different ways that the OS can virtualize memory?
	- Time sharing, static relocation, dynamic relocation.
		- (base, base + bounds, segmentation)
- What hardware support is needed for dynamic programming?

#### Linux Facts and Trivia
- Name an application that accelerated Linux adoption?
	- Webservers.
		- Linux schedules threads super well, and since loading each webpage requires a thread, it was more efficient to use Linux.
- Name of Google's Linux distribution for internal employee use?
	- Goobuntu (now replaced with *gLinux*)
- What percent of supercomputers use Linux?
	- 100%
- Is malloc a system call or a library call?
	- Library call

### General Virtualization
- In virtualization, you want to give the *illusion* of **private** resources.
- CPU Virtualization is the *illusion* of **private CPU registers**
- Memory Virtualization is the *illusion* of **private memory addresses**

#### Memory Virtualization History

##### Then
- 16 kbs of magnetic-core memory and 1 Processor.
- Developed virtual memory system to handle files on tape that were larger than the available memory on HP 2116 microcomputer.

##### Now
- The astronomer now stands in front of a datacenter system with 40 processor cores, 138 terabytes of storage capacity and 83 gigabytes of RAM.

#### Memory Is Expensive

#todo get picture of mem

### Motivation for Virtualization
- **Uniprogramming:** One process runs at a time.

#todo get addr space breakdown.

#### Disadvantages
- Only one process runs at a time.

---

Why do processes need dynamic allocation of memory?

- Do not know amount of memory needed at compile time
- Must be pessimistic when allocate memory statically
	- Allocate enough for worst case; Storage is used inefficiently.

##### Recursive Procedures

#todo  huh? what is dis

## Multiprogramming Goals

##### Transparency
- Processes are not aware that memory is shared.
- Works regardless of number and/or location of processes.

##### Protection
- Cannot corrupt OS or other processes.
	- Should not be able to change anything internally within the OS memory. `kmalloc()` (kernel malloc)
		- **OS** is trusted, processes are *untrusted*
- Privacy: Cannot read data of other processes.

##### Efficiency
- Do not waste memory resources (minimize fragmentation)

##### Sharing
- Cooperative processes can share portions of address space.
- *Although* you want to keep the processes separate, you should be able to allow sharing *memory* between two processes.


---

## Heap Organization

**Definition:** Allocate from any random location: `malloc()`, `new()`

- Heap memory consists of allocated areas and free areas (holes)
	- **It is not necessarily sequentially done!!!**
- Order of allocation and free is unpredictable.

#### Advantage
- Works for all data structures.

#### Disadvantages
- Allocation can be slow.
- End up with small chunks of free space - fragmentation.
- Where to allocate 12 bytes? 16 bytes?? 24 bytes???

> What is the OS's role in managing heap? \
>> OS gives big chunk of free memory to process; library manages individual allocations.

- Every time you do a `mmap` or `sbreak`, you are doing a system call, which has significantly higher costs.
- This is why you do not go to the OS for every single memory allocation.

#### Quiz: Match that Address Space

```C
int x;
int main(int argc, char *argv[]) {
	int y;
	int *z = malloc(...);
}
```

| Address | Location    |
| ------- | ----------- |
| x       | Static data |
| main    | code        |
| y       | stack       |
| z       | stack       |
| \*z     | heap        |

```Assembly
0x10: movl  0x8(%rbp), %edi
0x13: addl  $0x3, %edi
0x19: movl %edi, 0x8(%rbp)
```

- In the code segment above, we have **two** memory references. (for the actual data being computed)
- **However, the code segments** are *also* in memory, meaning it would be **FIVE** memory references.

---

**Time to access memory:** 60-100 ns


---

### Time Sharing of Memory
- Try similar approach to how OS virtualizes CPU.
- #todo fill out this

#### Problems with Time Sharing Memory
- **Problem:** Ridiculous poor performance.
	- You need to kick out every other process...
- Better alternative: space sharing
	- #todo whataaaaa

### Static Relocation
- Idea; OS rewrites each program before loading it as a process in memory.
	- *Take program from disk* (before putting it into memory), use different addresses and different pointers.
- Each rewrite for different process uses different addresses and pointers.
	- So, you can run *two instances* of the program.
	- They each get their own heap, stack segments, etc...
- Change jumps, loads of static data.


> Better techniques out there, this ones old.


##### Static: Layout in Memory:

#todo get shit

#### Disadvantages
- **No protection**
	- Processes can just go access other processes/ destroy the OS.
	- No privacy.
- #todo what
	- Heap should dynamically grow with the memory.

### Dynamic Relocation
- **Goal:** Protect processes from one another.
- **Requires hardware support**
	- Memory Management Unit (MMU)
		- Works with OS to provide a mechanism for dynamic memory addresses.
- MMU dynamically changes process address at every memory reference.
	- Process generates *logical* or *virtual* addresses (in their address space)
		- *Virtual Address* - some address that is a *proxy* to where the data is stored physically.
		- **Converts** the virtual address back to the physical address.
	- Memory hardware uses *physical* or *real* addresses.

#### Hardware Support

- **Two operating modes**
	- *Priveleged* (protected, kernel) mode: OS runs.
		- When enter OS (trap, system calls, interrrupts, exceptions)
		- Allows certain instructions to be executed.
			- **Can manipulate contents of MMU**
		- Allows OS to access all of physical memory.
	- *User mode*: User processes run.
		- Perform translation of logical address to physical address.