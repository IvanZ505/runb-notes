# Midterm Review

## Topics
- C programming
	- General syntax
	- Preprocessor, use of #include
	- Standard library (malloc, printf, etc..)
	- helpful tools: gcc, make, man
		- POSIX is in section 2, C standard functions are in section 3
	- Declarations and definitions
		- Function definitions vs prototype
	- Preprocessing vs compiling vs linking
		- How is linking used to support separate compilations?
	- Types
		- char, int (various), float, double
		- struct, **union**, enums
		- arrays
		- pointers
		- sizeof() - *operators*
			- Creating a array using: array variable vs pointer to array.
			- How do we use it.
		- macros
			- macro expansion
			- considerations when defining macros with arguments (recommended parenthesis)
			- `#define SQUARE(X) x*x`
				- Need more parenthesis, where to put them???
- Memory
	- Understanding all data as collections of bytes
	- Pointer vs "pointee"
	- Pointer types and pointer arithmetics
		- What's the difference between `char*` and `int*`?
	- Object location vs. object content.
		- int a; a vs &a -> a is the data in the variable a, &a is where that data is in the memory.
		- int* p; p vs `*p` vs &p -> p is the memory address of whatever p is pointing to, `*p` is the data actually stored at, and `&p` returns the actual memory address of the pointer variable `p`
	- use of malloc(), realloc(), and free()
		- What happens if you use a variable after realloc-ing?
			- It may potentially change the location in memory, so it might rip...
- POSIX File IO
	- open(), close(), read(), write()
	- Use of buffers
		- Why use buffers?
		- How do we use buffers effectively?
			- Read, loop,  double loop pattern #todo wtf is this?
	- opendir(), readdir(), closedir()
- File System
	- inode block vs data block
		- Double, triple, indirect blocks
	- Directory files
		- file names - determined by the paths
			- Because of this, the file may have 0 or more names. (0 if not referenced by any directory)
		- Directories can have **infinitely many** names, since you can just "/usr/../usr/../" and so on.
	- "linking" files
		- can a file have more than one name?
		- Can a directory be linked more than once?

## C Programming
- For notes on C programming, check out the actual file since there is so much.

> [C programming File](c-basics.md)

## Memory

---

## Midterm Practice Questions

1. The difference between p = q and `*p = *q` is that p = q updates the pointer p to point to the same memory object as pointer q did, which in this case would be the integer 20. `*p = *q` sets the value at the address of p, which was the integer 10 before, to the value at q, which would be the integer 20. This means that `*p` now stores 20.
2. 