# [Overview of Comp Arch](../comp-arch/comp-arch)

- Systems Knowledge
	- How hardware (processors, memories, disk drives, network infrastructure) plus software (operating systems, compilers, libraries, network protocols) combine to support the execution of application programs.
	- Programmmer centric
	
### 5 Great Realities of Systems

1. Ints are not Integers, Floats are not Reals
	- They have limits to how much value they can store and how they can store it.
	- Can not assume all "usual" mathematical properties.
		- Mathematical computations and representations of numbers are finite. (ints can only store so many bytes of data)
	- Integer operations satisfy "ring" properties
		- Commutativity, associativity, distributivity
	- Floating point operations satisfy "ordering" properties.

2. You've got to know Assembly
	- You might not have to write programs in assembly but still.
	- Understanding assembly is key to machine-level execution model.
		- Behavior of programs in presence of bugs.
			- High level language models break down.
		- Tuning program performance
			- Understand optimization done / not done by the compiler
			- Understand sources of program inefficiency.
		- Creating / fighting malware
			- x86 assembly is the language of choice.
			
3. Memory Matters
	- Memory is not unbounded
		- It must be allocated and managed
		- Many applications are memory dominated
	- Memory referencing bugs are especially pernicious
		- Effects are distant in both time and space
	- Memory Performance is not uniform
		- Cache and virtual memory effects can greatly affect program performance.
		- TODO: Get this
		
	Why is this a problem?
	
	- C and C++ does not provide any memory protection
		- Out of bounds array references
		- Invalid pointer values
		- Abuses of malloc/free
	- Nasty bugs can occur
	
4. There's more to performance ????? TODO: Complete

5. Comptuers do more than execute Programs
	- They need to get data in and Out
		- I/O system critical to program reliability and performance
	- They communicate with each other over networks
		- Many system-level issues arise in the presence of networks.

How a Computer Turns on
1. Power supply is clicked
2. The ROM initiates the bootloader associated with the operating System into memory.
3. The bootloader then finds the storage location of the operating system in the hard drive, initiating the kernel.

How a Program Gets Executed

Fetch --> Decode --> Execute

- Fetch: Grabs the snippet of the program from the disk, moving it to RAM and then moving it to the CPU.
- Decode: Identify the snippet of the program.
- Execute

### Memory Hierarchy (More to come)

- Registers
	- Fastest memory
	- Small
	- Inside the CPU
	- Used for storing the most important data.

---

### How Source Code Becomes Executable

- Source code is written in a high level language.
- The preprocessing stage is where the preprocessor replaces the macros with the actual code.
- The compiler then converts the code into assembly code.
- The assembler then converts the assembly code into machine code.
- The linker then links the machine code with the libraries and other code.
- After the linking, the executable is created.

### Preprocessing Phase
- First phase that takes the source code as input.
  - Includes the header files and replaces the macros with the actual code.
  - The output of this phase is the expanded source code.
  - Removes comments and whitespace.
  - Conditional compilation.
    - #ifdef, #ifndef, #else, #endif, #if, #elif
  - Stored in a file with the extension .i

To use it in iLab:

`gcc -E <input_file> -o <output_file>`

### Compiler
- Second phase that takes the expanded source code as input.
  - Converts the code into assembly code.
  - The output of this phase is the assembly code.
  - Stored in a file with the extension .s


### Assembler
- Third phase that takes the assembly code as input.
  - Converts the assembly code into machine code.
  - The output of this phase is the object code.
  - Stored in a file with the extension .o

### Linker
- Fourth phase that takes the object code as input.
  - Links the object code with the libraries and other code.
  - The output of this phase is the executable.
  - Stored in a file with the extension .out

---