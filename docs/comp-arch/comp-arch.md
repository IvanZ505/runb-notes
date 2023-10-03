

# Computer Architecture

Taught By Kania Jay

----

## Course Logistics

**Grading:**
- Exams (45%)
	- Midterm : 20%
	- Final : 25%
	- No make-ups
	
- Assigments (35%):
	- Submissions tested on iLab.
	- Due at 2 AM

- Some quizzes and stuff (5%)

### What is a Computer?

There are two Types of computers:

#### Fixed computers
- Programs are loaded onto the computer at manufacturing. (e.g. Calculator)

**vs**

#### Stored Computers
- Like computers nowadays.

#### The Von Neumann Model
A Computer is:

- A single, shared memory for programs and data, a single bus for memory access, an arithmetic unit, and a program control unit.
- The problem with this model was that there was only one line from instructions to memory.
- The instructions and operations could only be operated on one at a time.

#### High Level to Low Level

- Human legible code, such as Java and Python are high level languages, which means that it needs to be converted into Assembly Language and then machine language.

#### Harvard Architecture

- Separation of the different memory types moving the instruction memory and data memory to be separate.
- The problem with this architecture is the size and power consumption of this model because of having two physical memories.

#### The Operating Systems
- Programs run on the hardware, calling into OS for some services.
- On modern systems, OS and hardware collaborate for some features.

#### Moore's Law
- Gordon E. Moore was an Intel Engineer who noticed something.
- Observed that the number  of transistors on a chip doubles every 18 months.
- Exponential growth is seen almost everywhere.

rawr

## The Overview of Comp Arch

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

## Data Representation in Memory

#### Byte-Oriented Memory Organization
- **Modern processors: Byte-Addressable Memory**
	- Conceptually a very large array of bytes.
	- Each byte has a unique address.
	- Processor *address space* determines *address range*.
		- 32-bit address space has 2^32 unique addresses: 4GB max.
			- 0x00000000 to 0xffffffff
		- 64-bit address space has 2^64 unique addresses
		
	- Address space size is not the same as processor size!
		- The original Nintendo was an 8-bit processor with a 16-bit address space.
		
### Why use Bits and Binaries?

![Logical Voltages](imgs/logical-voltages.png)
- Digital transistors operate in high and low voltage ranges.
- Voltage Range dictates binary value on wire.
	- High voltage range (e.g. 2.8V to 3.3V) is a logic 1.
	- Low voltage range (e.g. 0.0V to 0.5V) is logic 0.
	- Voltages in between are indefinite values.
		- The values the in between states take depend on your processor.
- Ternary or Quaternary systems have practicality problems.

### Bits and bytes

- **Computers Use Bits:
	- a "bit" is a base-2 digit.
	- It can only be 0 or 1.
	
- **Single bit offers limited range, so grouped in bytes**
	- 1 byte = 8 bits.
	- a single datum may use multiple bytes.
- **Data representation 101:**
	- Given *N* bits, can represent 2^N unique values.
		- Letters of the alphabet?
		- Colors?

### Encoding Byte values
- **Processors generally use multiples of bytes**
	- common sizes: 1,2, 4, 8 or 16 bytes.
- 1 byte = 8 bits.

**They can be interpreted in many ways!!**

- For example: consider byte: 0101010101_2 (base 2 because it's a binary string)
	- As ASCII text: "U"
	- As Integer: 85_10
	- As IA32 Instruction: pushl %ebp
	- The 86th byte of memory in a Computer
	- A medium gray pixel in a gray-scale image
	- Etc...
	
---

### Binary is Hard to represent!

(Since it can be represented in so many ways)

**Problem with binary - cumbersome to use**
- e.g. appx. how big is: 1110101010101011₂?
- It would take forever to calculate each time.

**Let's Define a larger Base so that:**

 R¹ = 2ˣ

- For equivalence, R and x must be initegers - then 1 digit in R equals x bits.
- Equivalence allows direct conversion between representations.
- Two options closest to decimal:
  - Octal: 8¹ = 2³ (Base 8)
  - Hexadecimal: 16¹ = 2⁴
  
#### So, in order to use it, we change it into a different representation.
- Octal
- Hexadecimal numbers
- Decimals

**Octal and Hexadecimal are closer in size to decimal, BUT...**
- Octal : 8/3 = 2.67 octal digits per byte - BAD
- Hex: 8/4 = 2 octal digits per byte - GOOD

***We will run into alignment issues if we use the octal system... So, Hexadecimal is better***

---

#### Expressing Byte Values

- **Common ways of expressing a byte**
  - Binary: 00000000₂ to 11111111₂
  - Decimal: 0₁₀ to ...

---

**Binary Workshop**

I Have 4 bits to work with (I can represent 2⁴ unique digits.)

	1011 => (1 * 2³) + (0 * 2²) + (1 * 2¹) + (1 * 2⁰) => 11

---

#### Convert Bteween Binary and Hex
- Convert hex to binary
  - Simply replace each hex digit with its equivalent 4-bit binary sequence.
		
		Example:

		6D19F3C₁₆ → Convert to base 2.

		6: 0110 | D: 1101 | 1: 0001 | 9: 1001 | F: 1111 | 3: 0011 | C₁₆: 1100₂

- Convert Binary to Hexadecimal
  - Starting from the radix point, replace each sequence of 4 bits with the equivalent hexadecimal digits.
  - Each **DIGIT** corresponds with 4 bits of information.

---

### Signed VS Unsigned
- Positive numbers are typically "unsigned".
- Negative numbers are "signed"

#### Unsigned Integers - Binary

- **Computers store Unsigned integer numbers in Binary (base-2)
  - Binary numbers use place valuation notation, just like decimal.
  - Decimal value of *n*-bit unsigned binary number:

	`value₁₀ = (n-1)∑(i=0) aᵢ*2ⁱ`

	| 0   | 1   | 1   | 1   | 0   | 1   | 0   | 1   |
	| --- | --- | --- | --- | --- | --- | --- | --- |
	| 2⁷  | 2⁶  | 2⁵  | 2⁴  | 2³  | 2²  | 2¹ |   2⁰  |

	This is all equal to:
	
		(0 * 2⁷) +  (1 * 2⁶) + (1 * 2⁵) + (1 * 2⁴) + (0 * 2³) + (1 * 2²) + (0 * 2¹) + (1 * 2⁰) = 

#### Unsigned Integers - Hexadecimals
- Commonly used for converting hexadecimal numbers
  - Hexadecimal numbers is an "equivalent" representation to binary, so often need to determine decimal value of a hex number.
    - `value₁₀ = (n-1)∑(i=0) aᵢ*16ⁱ`
  - However, remember that there are letters `A-F` which correspond to `10-15` respectively.

#### Unsigned Integers - Convert Decimal to Base-R

- Also need to convert decimal numbers to desired base.
- Algorithm to convert it:
  
	1. Assign decimal number to NUM.
	2. Divide NUM by R
      	1. Save the remainder REM as next least significant digit.
      	2. Assign quotient Q as new NUM
	3. Repeat step b) until quotient is 0.

	Example (Binary):

		52₁₀ = ?₂

		52/2 = 26 r 0 -> First bit
		26/2 = 13 r 0 -> Second bit
		13/2 = 6 r 1 -> Third bit
		6/2 = 3 r 0 -> Fourth bit
		3/2 = 1 r 1 -> Fifth Bit
		1/2 = 0 r 1 -> Sixth Bit

		So total: 110100

	Example (Hexa):

		437₁₀ = ?₁₆

		437/16 = 27 r 5 -> First digit
		27/16 = 1 r 11 -> Second
		1/16 = 0 r 1 -> Most significant digit

		So in Hexa: 1B5₁₆
	

