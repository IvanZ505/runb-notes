# [C Basics](sys-prog)
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

---

#### Implicit Casting
- C implicitly casts items of certain types to a type that is able to carry out the specified operation. 

	int x = 0;
	... x / 1.6;         // This implicitly casts x's value to float (or double)
	x = (int) ((double) x / 1.6);

---
### Arrays
- A continuous sequence of values of some type
- Array variables have a type and dimension
	- Type is used to guide code generation for indexing
	- Dimension is used to guide allocation (Not used in bounds checks *PEAK EFFICIENCY!!!! Your code should never index out of bounds*)

`int array[5], array[10], n, m`
- Dimensions only apply to a single variable.
- The type applies to all variables.

`int matrix[rows][columns]`
- matrix is an array of dimension rows and each element is an array of dimension columns
- each element of those are an int.

---

### Strings
- C **does not** have a string type!!!
	- Instead, we use a array of characters containing a null terminator `\0`.

**Why have a terminator?**
- This is to differentiate the end of the string from the rest of the bytes in the memory.
- The array needs to have a fixed size, but you may want different sized strings, which means the String itself can **not** be a fixed size, so you just use a terminator.
- Good thing that the null terminator `\0` has a ASCII code of 00, which means no other character will conflict with it.

`char *s = "string literal";`
- `s` refers to a specific constant string in memory.

`char s[] = "foo";`
- declares and initializes a char array containing this string because we did not provide a dimension, so `s` will have length **4** (null terminator must be included.)
- It is possible to create the size as something larger than the entered literal, but in that case, only the first few numbers (length of entered literal + null terminator) will be initialized.

> **Do not write `\0` in a string literal**


---
### Enums
- Used to represent small, discrete sets of values

`enum direction { north, south, east, west };`
- This declares a type called "*enum direction*"

Now I can say: `enum direction heading = north;`

> C just implements these enums using integers (You can compare them, add 1 to them, etc...)
> Useful for *documentation* as well as to compare **strings** without having to *use* strings. (Much better for switch statements)

---
## Structs
- Structs are used to bundle multiple values, possibly of different types.

```C
	struct person {
		int age;
		int id;
	}

	struct person Bill;
	Bill.age = 20;
	Bill.id = 283392;

	struct person Bob = {99, 1};
```
- Structs can contain other structs
- Structs can also contain fields of any data type.
- You can give them a name through **typedef**.
- **Struct variables** *can* be the same as a different struct, and C would be able to tell them apart.

---

## Unions
- Allows us to declare variables that could have different types.

```C
	union intorfloat {
		int i;
		float f;
	}
```
- The declaration *may* resemble a struct, but only **one** element is present at a time.
- There exists enough space to store the largest data type.
- If you try to read the wrong variant from the union, it will return `undefined`.

> This means that, in the example, `intorfloat`, declaring `union intorfloat x` means that `x` *could be* a integer OR a float.

---
## Typedef
- Allows me to give a new name to an existing type.
- Purely for documentation and convenience.

`typedef existing_type new_name;`

`typedef struct point point;`

```C

typedef double vector[3];
// Means vector is a name for the type of arrays with 3 doubles!

// This means..
vector v;
// Is the same as...
double v[3];
```

---

## Pointers
- Every datum in C lives in the memory!
- Pointers are a value that represents an address.

**Implications:**
- Every variable has an address.
	- We can obtain the address of *any* variable using the `&` operator in front of the variable.
- Every struct field and array element has an address.
- Every function has an address.
	- Writing a function name with no arguments obtains its address.

When we work with pointers, we need to know the type of the data that they point to. (This is in order to know how far to read into the memory. (*Is it 1 byte? 4-bytes? 100-bytes???*)) 

- This means that we give these pointers a type.

`int *` → pointer to an integer

```C
int *p;       // p holds an address that should point to an integer

int i;        // Some integer value
p = &i;       // p is now going to point to the location in the address of i.

*p = 5;       // Writes to the location whose address is stored in p. (Deferencing)
// This then changes the value of i as well!
```

