# Systems Programming

Taught by: David Menendez (davemm@cs.rutgers.edu)
- Please put [CS214] in your subject line

- Please attend lecture and recitation
- Project oriented class
	- 3-4 programming assignments (2 person assignments)

### Topics

> Programming Language: C Programming Language
> Working in a Unix-style operating systems (Linux/Posix)
> File systems
> Multitasking / process control (how to start a program / communicate btwn programs)
> Multithreading (Creating threads, pthreads)
> Network Communications (Sockets)

## C Basics
- Use `-Wall` to give all warnings
- C is a relatively simple programming language
	- Gives good visibility into the lower-level aspects of the computer
	- Designed to run (and to be compiled) on low-powered hardware

### C vs Java
- Similar syntax
- Similar orientation
- Different libraries
- Java has class and objects, C has functions
	- Implications for this are:
		- No implicit arguments for C (`this`)
		- No polymorphism / no overloading
- Java has hierarchical namespace (e.g. java.util.Scanner.Blah.Blah) whereas C has a flat namespace.
	- All functions and global variables in a program must have unique names in C


Java is an interpreted language:
- Java source code → Java Compiler → "bytecode" (`.class` files) → Java Virtual machine → Execution

C is a Compiled Language:
- C Program (`.c`) → GCC Compiler → executable program

> For more information on C Basics, check out [C Basics](../comp-arch/basics-of-c)

### Compile Time vs Run time

**Compile Time** - Things that happen in the translation process. (Things such as syntax errors that cause your programs to be unable to be compiled. E.g. missing semicolons, missing brackets)

**Run Time** - Things that happen when executing the program. (Bad arguments to functions, division by zero, not being able to open a file)

---

### Stages of Compilation

> For more information on the stages of Compilation, check out [Comp Arch](../comp-arch/1-overview-of-comp-arch#how-source-code-becomes-executable)

#### Side Note

Why separate compilation and linking?
- It enables separate compilation
	- We are able to split a large program into many source files.
	- Each source file can be compiled separately.
	- All the objects can be linked afterwards.

### Integer Types

C has a small set of built-in types

**Integers:**
- Signed or unsigned
- "regular", short, or long
	- C does not mandate specific lengths
	- **short int** is at least 2 bytes
	- **int** is at least as big as a short int
	- **long int** is at least as big as an int
	- **long int** is bigger than a short in
- **signed and unsigned char**
	- characters are also considered integers
	- ASCII is the standard mapping of integers to "characters"
	- These are one byte (Of course, it's just the smallest unit of your memory)

**Floating Point:**
- Floats and doubles
	- In practice always use **double**

