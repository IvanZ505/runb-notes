# [C Notes For Programming in C](../comp-arch/comp-arch)

- [C Notes For Programming in C](#c-notes-for-programming-in-c)
    - [Data Types](#data-types)
  - [C Basics](#c-basics)
    - [C Inbuilt Operations](#c-inbuilt-operations)
    - [Getting Length of Array in C](#getting-length-of-array-in-c)
    - [Strings](#strings)
      - [String concatenation](#string-concatenation)
    - [Statics and Global](#statics-and-global)
    - [Pointers (***Very Important***)](#pointers-very-important)
      - [Creation:](#creation)
      - [Deferencing:](#deferencing)
      - [Pointers for Arrays](#pointers-for-arrays)
      - [A Special Pointer in C](#a-special-pointer-in-c)
      - [Void Pointers](#void-pointers)
    - [Understanding Pointer Code](#understanding-pointer-code)
    - [Structures (Structs)](#structures-structs)
      - [Typedefs:](#typedefs)
      - [Pointers to Structures:](#pointers-to-structures)
    - [Dynamic Allocation (***Very Important***)](#dynamic-allocation-very-important)


---

### Data Types

- There is no boolean data type in C.
- To be able to use the boolean data type, you need to define it in the header.

```C
#define BOOL char
#define FALSE 0
#define TRUE 1

// Or, include
#include <stdbool.h>
```

| Data Type     | Size (Bytes) | Range             | Str Format |
| ------------- | ------------ | ----------------- | ---------- |
| char          | 1            | -128 to 127       | %c         |
| unsigned char | 1            | 0 to 255          | %c         |
| short or int  | 2            | -32,768 to 32,767 | %i or %d   |
unsigned int | 2 | 0 to 65535 | %u |
Long | 4 | -9223372036854775808 to 9223372036854775807 | %l|

---

## C Basics

### C Inbuilt Operations

**scanf(format_str, &variable1, &variable2,...)**:
- Takes in an input from the user. format_str takes in input using the str format defined in [Data Types](#data-types).
- & → passes the address of the variable.
- You are *in literal terms* saying to take the parsed data and store it in the memory location of the variable.

**for(initialization; condition; increment/decrement)**:
- The for loop is the same as Java.
- Use the keyword `continue` to skip the current iteration of the loop.
- Use the keyword `break` to break out of the loop.

**Functions**:
- Functions are extremely similar to Java.
- You can pass in pointers to functions as well.
- `int myFunction(int)` can be declared without specific implementation until later. (This allows the functions to be "used" before they are defined.)

### Getting Length of Array in C

- To get array length, C does not have a built in function for getting length.
- The closest thing they have is their sizeof() function.
- To use:
  - ``` sizeof(array) ```
  - This actually only returns the **physical** size of the array in memory.

- Now, in order to get the length of a row of the array:

```C
// Example array
int array[5][4];

// With simple math, you divide the total size of the array with the size of just 1 row, getting you the number of rows in the array.
int rows = sizeof(array) / sizeof(array[0]);

// Here, you divide the size of one row, again. This time, by just one element in the array.
int columns = sizeof(array[0]) / sizeof(array[0][0]);
```
---

### Strings

- Strings need to be declared as character arrays in order to be manipulated.
- Replace letters in str through array.
- However, you can always create a unmanipulatable string by using a pointer.

#### String concatenation
  - ``` strncat(destination_str, source_str, # of character of source_str to append) ```

---

### Statics and Global

- The `static` variables are initiated within the scope of the file, `global` variables are initiated globally.
- Static functions are only accessible in the scope of the file. All functions are global by default.

---

### Pointers (***Very Important***)

**String Pointers:**
- `char * name = John`
- The "*" is used to indicate a pointer.

#### Creation:
- You can create a pointer to a variable by using the "&" operator.
- For example:

```C 
int a = 1;
int* ptr_to_a = &a;
```

#### Deferencing:
- Deferencing is the act of accessing the actual data in the memory.
- To access this deferenced variable, you add the "*" to the beginning of the deference. For example:
  - `*pointer_to_a += 1;`
  - This will affect the actual variable as well.

- You can use a array of pointers to hold a number of pointers.
  - This can be done as such: `int** ptr_to_ptr`
- You can pass a pointer to a function or return a pointer from a function as well.
- Or, just keep pointing.

```C

int main() {
    // The x variable is first stored into the memory without any number attached
    int x;
    // the & operator returns the memory address of x, so that you can write to that address properly.
    scanf("%d", &x);

    printf("\n %d", x);
}

```

**Pointers for functions:**
- While you can reference a variable as static to access it anywhere in the file, you could also just pass a pointer in as a parameter.
- Passing in a pointer allows the function to edit the actual data at the physical location of the data in the memory. (Shit its all making sense)
- So, remember if you are passing in a pointer variable, pass in the actual location of the data, not the variable name itself.
- For example:
```C
void addone(int *a) {
    (*a)++; // This increments the variable by 1.
}

int a = 5;
addone(&a); // Remember to pass in the location
```

#### Pointers for Arrays

Using the example below:

```C
char vowels[] = {'A', 'E', 'I', 'O', 'U'};
char *pvowels = vowels;
```

- Calling on `&vowels[0]`, `pvowel` and `vowels` will all return the location of the data in the memory.
- Calling on `vowels[0]`, `*pvowels`, and `*vowels` will all return the ACTUAL data.

#### A Special Pointer in C
- Special constant pointer `NULL`
- Deferencing a `NULL` pointer is illegal (causes segmentation fault)
  - Memory address of NULL → *0x00000000*
  - `int* ptr = NULL;`
  
#### Void Pointers
- Void pointers can be considered pointers to everything
  - Defined as: `void* ptr;`
  - You can point the pointer at different memory addresses of different data types.
  - However, in order to use the data (deference), you must use typecasting in order to interpret the data at the address in a specific format.
- **When using void pointers, you lose all type safety.**
  - Reduces the effectiveness of the compiler's type checking.
  - You can't do pointer arithmetic with void pointers.

Example:

```C
#include <stdio.h>
#include <stdlib.h>

void main() {
  void* ptr;
  int i;
  char c;

  // You can set the pointer to point to different data types
  p = &i;
  p = &c;

  // However, when deferencing...
  // You must typecast the pointer to the correct data type
  printf("%d\n", *(int*)p);
}
```

### Understanding Pointer Code

```C
int a, b;
    int* ptr1;
    int* ptr2;
    a = 1;
    b = 2;

    ptr1 = &a;
    printf("%i is stored at %i\n",a, &a);
    // This is getting the memory address that pointer is pointer to
    // This memory address was set previously to the memory address of "a"
    // This should be the same address as what was printed previously
    printf("ptr1 is pointing at %i\n",ptr1);
    // This is fetching the memory address of the literal variable ptr
    // The ptr needs space in the memory too!
    printf("the pointer variable ptr1 is physically stored at %i\n", &ptr1);

    // This will set the address held by ptr2 to the same address held by ptr1
    // This will return the same address as "&a" and "ptr1"
    ptr2 = ptr1;
    printf("ptr2 is pointing at %i\n", ptr2);
    // This is going to be different
    printf("the pointer variable ptr2 is physically stored at %i\n", &ptr2);

    // This goes down to the address stored in ptr2
    // which happens to be the same as ptr1 and the variable a
    *ptr2 = 5;
    printf("changed the number to %i\n", *ptr2);
    printf("changed here too %i\n", *ptr1);
    printf("and here too %i\n", a);
  ```

---

### Structures (Structs)

- You can hold multiple different data types in one struct.
- If you want to use strings in the structures, you must use a pointer.
- For example:

```C
struct id {
    char * name;
    int age;
}
```

#### Typedefs:
- Typedefs allow you to make classes like in Java. This allows you to define multiple objects using this same "typedef".
- For example:

```C
typedef struct {
    char * name;
    int age;
} id;

// This lets you define multiple variables with this "id" class like such.
id bob;
```

#### Pointers to Structures:
- Use a pointer to pass in a struct because now, you have access to the ACTUAL structure.
- For example:
```C
// This is a typedef initialization of structs as a parameter.
void move(point * p) {
    (*p.x)++;
    (*p.y)++;
}
```
- Or, use the shorthand if you want to [deference](#deferencing) a structure and access the internal members.

### Dynamic Allocation (***Very Important***)
  
- Dynamic Allocation allows for building complex data structures like linked lists.
- Helps store data without knowing the size.
- Pointer needed to store location of the new data. We use the pointer to access and free the memory.

**Follow the following syntax:**

`typedef_name * example = (typedef_name *) malloc(sizeof(person))`

Now, lets explain:
- `typedef_name` : Self explanatory, the name of the struct, which is where this is very useful.
- `*` : To tell the program that this is a pointer variable.
- `example` : The name of the variable.
- `(typedef_name *)` : Type casting to the  pointer structure, because the return type of `malloc()` is void.
- `malloc(sizeof(person))` : Reserves specific memory space the size of the parameter passed in. (In this case, the `sizeof(person)`)

Now, you can access the different variables in the structure using the `->` operator.

`example->example_var = 100;`

Lastly, you can free the allocated memory using `free()`.

