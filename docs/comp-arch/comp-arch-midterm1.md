# Computer Architecture Midterm


## Computer Overviews
- There are two types of computers...
  - Fixed Computers: Computers that are designed to do a specific task and have their programs built in when manufactured. (e.g. calculators)
  - Stored computers: Computers that can be programmed to do different tasks. (e.g. PCs)

### The Von Neumann Model

According to the Von Neumann Model, a computer consists of the following components:
- A single, shared memory for programs and data
- A single bus for memory access (read/write on only 1 bus)
- An arithmetic unit (ALU)
- A program control unit (PCU)

![](imgs/vn-model.png)

**Problems with the Von Neumann Model**
- The Von Neumann Model is not scalable. The bus is a bottleneck for the system.
- The instructions and the operations could only be operated one at a time.

### The Harvard Model
- The Harvard Model corrects this problem by having separate buses for instructions and data.

![](imgs/harvard-model.png)

## C Programming

### Compilation Process Overview

![](imgs/compilation-process.png)

**Preprocessing**
- Comments in the source files are removed
- Macros are expanded
- Inclusion of header files (.h)
- Conditional compilation
  - `#ifdef`, `#ifndef`, `if`, `#else`, `#endif`, `elif`

After preprocessing, the file has a `.i` extension.

**Compilation**
- The preprocessed file is converted into assembly code
- The output will produce another intermediate file with a `.s` extension
- *Syntax errors and warnings are reported at this stage*

**Assembler**
- The assembly code is converted into (object) machine code using the assembler.
- The assembler will produce an object file with a `.o` extension.
  - The assembler will name the file the same name as the source code.
  - e.g. `hello.c` will produce `hello.o`

**Linker**
- The linker will link the object files together with the object code from the libraries.
  - e.g. using `printf()` calls the `printf()` function from the `stdio.h` library, which needs to be linked in the linker.
- The linker then generates a executable file.

### Memory Layout

![](imgs/memory-layout.png)

**Text Segment**
- The text segment contains the machine code of the program in a read-only format for the CPU.
- Code and constants, like string literals, are stored here.
- It is a shared segment.

**Data Segment**
- The data segment is divided into two parts, the initialized data segment and the uninitialized data segment.
- The initialized data segment contains the global variables and the static variables that are initialized (or contain a value).
- The uninitialized data segment contains the global variables and the static variables that are uninitialized (or are set to 0).
  
**Stack Segment**
- The stack is used for function calls and memory allocation for local variables.
- Each function call creates a stack frame, which contains the local variables and the return addresses.
- The stack operates in a LIFO (Last In First Out) manner.
- The stack is usually of a limited size so it is unsuitable for larger data types.

**Heap Segment**
- The heap is a dynamically allocated playground for memory.
- It is very suitable for holding larger data types and can be managed through the use of `malloc()`, `calloc()`, `realloc()` and `free()`.
- Memory allocated on the heap persists until it is freed and is not automatically managed.

**Cmd Line Args and Env Variables**
- The command line arguments and environment variables are stored in the higher address, above the stack.

### C Language Basics

[See the C Language Basics](./c.md)

## Data Representation in Memory

![](imgs/memory-organization.png)

**Conceptually:** Memory is a large array of bytes, with each index being a memory address 1 byte apart.

- In a 32-bit system, there are 2³² unique memory addresses.
  - `0x00000000` to `0xffffffff` (in decimal: 0 to 4,294,967,295)
- In a 64-bit system, there are 2⁶⁴ unique memory addresses.
  - `0x0000000000000000` to `0xfffffffffffffff` (in decimal: 0 to 18,446,744,073,709,551,615)

### Bits

- A bit is the smallest unit of data in a computer.
- It's value can be either 0 or 1. That's it.

![](imgs/bit-voltages.png)

Voltage Range dictates Binary Value on wire
- High voltage range (e.g. 2.8V to 3.3V) is a logic 1
- Low voltage range (e.g. 0.0V to 0.5V) is a logic 0
- Voltages in between are indefinite Values
  - In many different systems, this indefinite voltage range represents the previous definite value.

### Bytes

- Due to the limited representational power of a bit, we group bits together to form a byte.
- A byte is 8 bits.
- A single datum could use multiple bits.

**When encoding bytes:**

1 Byte / 8 bits:
- In Binary: 00000000₂ → 11111111₂

### Number Representational Formats

- Due to the cumbersome nature of trying to count binary, it is easier to use something closer to our decimal system, which is base 10.

For comparison, the binary system is base 2.

---
*In order to find a larger base, we need to find a power of 2 that is closest to the base.*

We use the equation: `R¹=2ⁿ`
- `R¹` is representative of one digit in the number system.
- `n` is the number of bits per digit.
- `2` is the base of the binary system, 0 or 1.

---

**There are two types of number representational formats closest to decimal:**
- Octal : Base 8 : 2³ (3 bits per digit)
- Hexadecimal : Base 16 : 2⁴ (4 bits per digit)

#### Octal or Hexadecimal?

---

    Binary: 1010011101010001011101011₂
    Octal: 123521353₈
    Hexadecimal: 14EA2EB₁₆
    Decimal: 21930731₁₀

Both of these are closer in size to decimal however, which one is superior???
- To see this, let's compare how many digits of each representational system we can fit into a byte.

**Octal**:
- As 1 octal digit takes 3 bits and 1 byte contains 8 bits, 8/3 = 2.667 octal digits per byte. (*not good*)
**Hexadecimal**:
- As 1 hexadecimal digit takes up 4 bits, and 1 byte contains 8 bits, 8/4 = 2 hexadecimal digits per byte. (*very good*)

#### Expressing Byte Values with Our Representational Formats
- Binary: 00000000₂ → 11111111₂
- Octal: 000₂ → 377₂
- Hexadecimal: 00₁₆ → FF₁₆
  - Base-16 format uses the letters A-F to represent the values 10-15.
- Decimal: 0₁₀ → 255₁₀

![](imgs/Hex-to-Decimal-Table.jpg)

#### Converting From Binary to Hexadecimal
- Easy, simply group the binary digits into groups of 4 and convert each group into a hexadecimal digit.
- To convert from hexadecimal to binary, simply convert each hexadecimal digit into 4 binary digits and slap em together.
