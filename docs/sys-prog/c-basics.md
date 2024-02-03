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

## Declarations and Definitions
- **Declaration** says what something is, but does not create it.
	- e.g. A **function prototype** declares that a function exists

```C
int compare(double, double);
extern int some_global;    // Says there is a variable of this type, but I didnt make it. (Like external)
```

- **Definitions** create the thing being described. (Every definition is an implicit declaration1)
	- e.g. function definition, global variable definition.

> A given program can *declare* the same thing many times, but it **must** be defined exactly once.

---

When do we need a explicit declaration?

	1) I might want to refer to something defined in another source file...
	2) We want to reference something defined later in the same source file
		- Maybe we want to organize code in some way.
		- Maybe we have mutual recursion. (One function calls another function, which calls the other function. **This needs explicit declarations**) 

## Header Files

- A header file is a C source file containing **declarations**
	- Header files usually end in `.h`
		- `<stdio.h>, <stlib.h>, <unistd.h>`

> Header files should contain **only** declarations, function prototypes, extern variables (but globals are often bad style), and type declarations.
> Typically, a header file will be included into multiple .c files.

```C
#include "myheader.h" // Look for the header file in the current directory
#include <standardheader.h> // Look for something in the *include* path list.
```

**Do not include your definitions in your `.h` file**

Instead, the usual convention is that:

- For each `source.c` you would have a `source.h`

For example, a project may have:

- `main.c`
- `queue.h`
- `queue.c`

> We should expect both `.c` files to include `queue.h`

## Preprocessor

- The C preprocessor is a separate program that runs through your source code and makes changes prior to compilation.
- The `#include` directive literally includes the contents of the specific file.
	- All declarations in the included header file becomes part of the source file after preprocessing.

> The lines that begin with `#` are preprocessor directives.

`#define MACRO "hello"`

- After this line in the source, the preprocessor will replace all **MACRO** tokens with "hello"
- macros can also have parameters

```C

#define SQUARE(X) X * X

y = SQUARE(x);
// This equals...
y = x * x;

y = SQUARE(a+b);
// And this equals
y = a + b * a + b;
```

`#undefine MACRO` - Just undefines it lol

- Subsequent uses of this token will not be replaced
- Allows us to define the macro again, if we want to.

### Conditional Processing

```C
#ifdef SOME_MACRO

	...code...

#else 

	...code...

#endif

```

- Useful if we want to have slightly different versions of a program or library defined in the same file.

**Related is**

```C
#ifndef SOME_MACRO    // If not defined.
...
#endif

// and...

#if SOME_MACRO < 5    // Ex: Like checking Versions of stuff
...
#endif
```

### GOOD USES FOR MACROS
- Enable and disable debugging without having to modify our source code. Look below.

```C
#ifndef DEBUG    // If DEBUG is not defined
#define DEBUG 0  // Then, define DEBUG as 0 automatically
#endif

if(DEBUG) printf("the value of x is %d\n", x);
```

Then, by using `gcc -DDEBUG`, you can define DEBUG as 1. (`gcc -DDEBUG=2` tells the preprocessor to define DEBUG as 2.)

> The option `-e` tells GCC to preprocess your code and then **stop**.

## Memory Objects

- All data is in memory.
- An object is a place in memory to store data.
- Every variable is associated with an object.
	- The compiler keeps track of which object goes with each variable.
- Some objects contain smaller objects (e.g. arrays and structs contains smaller objects)

> In order to make use of an object, we need to know its location (**pointers**) and we need to know its type.

However, we can create objects that are not associated with a variable. This is the `malloc()` command.

`malloc()` - **Dynamic Allocation**

- A static analysis can not tell us how many times we will call `malloc()` of what arguments we will give it (in general).

- How do we know how many bytes to request?
	- Types (like `int`)  do not have one specific size across all architectures. Instead, we use a special C operator called **sizeof()** in order to learn the size of the data type we want.
- What kind of pointer does `malloc()` return?
	- `void *malloc(size_t)` void pointer gets returned. `void` pointers do not have a specified type.

> You can typecast the pointer `int *array = (int *) malloc(arraysize + sizeof(int))`

## Types of Objects

Three categories of objects

#### Static objects
- Global variables
- string literals
- code
- These static objects exist the entire time the program runs:
- **They are neither created nor destroyed**

#### Stack objects
- local variables
- Tied to the execution of a particular function
- other information about functions used by the runtime
- **Created when the call begins and destroyed when the call ends**

#### Heap Objects
- Created by calls to `malloc()`
- **Destroyed by calls to `free()`**
- Heap objects are user declared and **not associated with a variable**.
- This could be "*garbage*" if not properly deallocated.
- The size of a heap object can be decided at run-time.

### Addressing Objects

> Any object can be referred to indirectly, using a pointer, but only static and stack objects can be referred to directly.
> Heap objects can only be referred to with a pointer.

- In order to properly use an object, we need to know its address and its type.
- The compiler tracks the type and location of the variables.

#### For Indirect References
- The value of the pointer says its address.
- The type of the pointer indicates the type of object

## Pointers
- A typed address (**Note:** Type is only known during compilation)

> **Special pointer `NULL`**
> `NULL` represents "no address" and attempting to deference `NULL` will cause a memory error

### Void Pointers

`(void *)`

- These are "*untyped*" pointers
- All we can do with these are
	- Compare for equality
	- Cast to some other pointer type
		- (It is your responsibility to make sure the type you cast to is reasonable!)
	- Use with various functions

### Arrays vs Array Objects

When we declare an array variable, we must specify the dimensions

`int a[20];    // a directly refers to an array object`

- `a` by itself is effectively a pointer...
	- Meaning that `*a = 5;` is the same as `a[5] = 5;`
- We can not reassign `a` to refer to a different array.
- We can make pointers point to arrays.
	- We can still use array indexing with the pointer that points to the array!

```C
int *p = a;
	// p is a pointer variable
	// It initially holds the address of a
p[1] = 20;
	// Also the same as *(p+1) = 20
	// Also the same as *(a+1) = 20
	```

> Why would we ever index using pointer arithmetics?
>> Pointer arithmetics defined: *If p points to something, p+1 points to the "next thing" in memory*
>> The actual address we get depends on the type of `p`. Ex: `int` ptr will point 4-bytes past the original point of `p`
>> Only valid with pointers into an array, where the indexing leaves us within the array.
>> Otherwise, memory error.

This sort of indexing is only defined when:

- The pointer points to an array
- The index is within the bounds of the array.

`p = &a[5];`

- Now `p[0]` refers to the same int as `a[5]` since we passed the memory address of `a[5]` to the pointer.
- Now, `p[1]` is the same as `a[6]`
- `p[-1]` is the same as `a[4]`

### Pointer vs Array Variables
- Array variables always point to a specific array
	- Pointer variables can be changed at any time
- Pointer variables store their address at run-time
	- Array variables have a fixed address.

> `&a` is the exact same thing as `a`

## The Heap
- Use `malloc()` to create objects in the heap

`void *malloc(size_t);`

- Returns a void pointer to a heap object of the size (*in bytes*) we want.
	- Or, can return `NULL` if it can't get enough space.
- We do not need to explicitly cast the `malloc-ed` object into the correct pointer type, as it can be done implicity.
	- However, you can declare it for "protection"

```C
int n = get_dimension_from_user();
int *p = malloc(n * sizeof(int));
```

> If `malloc` succeeded, we can treat the returned object like we treat any other array.
>> `p[10] = p[5] + 1;`

### Deallocating

`void free(void *)`

The `free()` function deallocates an object on the heap.

- Free can only be used with addresses returned by `malloc()`

> This means that you only need to deallocate the heap objects that you yourself had allocated. Otherwise, you get left with garbage.

```C

int *p, *q;

p = malloc(20 * sizeof(int));

q = p;
```

	In the above scenario, what do we need to deallocate the array?
	1. free(p)
	2. free(q)
	3. free(p); free(q);

	1 and 2 both deallocate the array, bc they both hold the same pointer
	3 is wrong, (double freeing) once you have freed the first one, the second one is no longer allocated on the stack.

	Also wrong: free(p+10);
	p+10 points to a valid int object, but it isn't the object allocated by malloc()
### Data Structures on the Heap
#### Best way to make a Stack

```C
struct node {
	data_t payload;
	struct node *next;
};

struct node *head = NULL;

void push(data_t item) {
	struct node *new = malloc(sizeof(struct node));    // Need to use malloc to create new node
	// (*new).payload = item;     // Or you can use the arrows (new->payload = item;)
	new->payload = item;
	new->next = head;
	head = new;
};

int pop(data_t *dest) {
	if(head == null) return 0;

	struct node *temp = head;
	if(dest) *dest = head->payload;
	head = head->next;
	free(temp);
}
```

## Generic Memory Operations

### Case Study: Sorting an Array

`void sort_ints(int *array, int length);`

`void sort_chars(char *array, int length);`

What is the difference between these?

- Comparison function
- Size of the data units

**What do we need to write a generic sorting function?**

- Some way to pass an array without restricting its type (*hint hint: `void`*)
- Some way to specify how to compare items (*hint hint: `function pointer`*)
	- `return_type (*compare) (arg1_type, arg2_type, ....)`

So... it looks something like...

```C
int (*compare) (void*, void*)
```

- However, we also need a way to copy the memory to the new address! There is a way to do that!!! (There are [multiple](#copying-memory))
#### Put it all together

```C
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void sort(void *array, size_t array_length, size_t item_size, int (*comparison_function) (void *, void *)) {
// This sorting algorithm will take in a pointer to a void array, and a pointer to a function that takes in two void pointers.
	char *base = array;
	// Need to malloc some temperorary space for the swap
	void *temp = malloc(esize);
	for(int i = 0; i < alength; i++) {
		for(int j = 1; j < alength; j++){
			char *prev = base + (j-1)* esize;
			char *this = base + j * esize;
			if(compare(prev, this) > 0){
				// swap the two elements
				
				memcpy(temp, this, esize);
				memcpy(this, prev, esize);
				memcpy(prev, temp, esize);
				}
			}
		}
	free(temp);
}

int compare_ints(void *x, void *y) {
	return *(int *) x - *(int *) y;
}

#define ALEN 5

int main(int argc, char **argv) {
	int A[] = {-5, 29, 45, 3, -5};

	sort(A, ALEN, sizeof(int), compare_ints);
	for(int i = 0; i < ALEN; i++) {
		printf(" %d", A[i]);
	}
	return EXIT_SUCCESS;
}
```

---

## Copying Memory

### `memcpy()`

`memcpy()` - Copies a specific number of bytes from one location to another.

> There are **NO** safety checks in `memcpy()`, meaning we must ensure that the source and destination objects are large enough (and that they are allocated)
>> The memory spaces can not overlap at all!

```C

void *memcpy(void *dest, void *src, size_t size);
// Copies size nummber of bytes from src to dest
// returns dest
```

Example: a and b are both arrays of 20 ints.

```C
b = a; // Nope!
memcpy(b, a, sizeof(int) * 20); // Yes!
```

### `memmove()`

`memmove()` - Copies a specific number of bytes from one location to another (location may overlap)

```C
void *memmove(void *dest, void *src, size_t size);
```

### `strcpy()`

`strcpy()` - Copies a string from one place to another

- Must make sure that the source contains a string (with a terminator)
- And we need to make sure the destination is large enough.
- **Never going to be faster than `memcpy()`**
	- So, just use `memcpy()` if you know the length of the string.

```C
char *strcpy(char *dest, char *src);
// Note that no size is provided
// This is because strcpy() copies from the source until it finds a terminator
```

### `strncpy()`

`strncpy()` - copies up to n bytes from a location to another.

- Copies a string, or the first n bytes.
	- If it stops before the end of the string, it doesn't write a terminator...

```C
char *strncpy(char *dest, char *src, size_t n);
```

### `strcat()`

`strcat()` - Concatenates one string to the end of another string

- `src` will be copied to `dest` starting at the terminator in `dest`.
- `dest` must have a terminator and enough space...
- Annoyingly, `strcat()` always reads through `dest`, so repeatedly copying to a `dest` is quadratic time. *use pointers and `memcpy()`*

```C
char *strcat(char *dest, char *src);
char *strncat(char *dest, char *src, size_t n);
```

### `memset()`
