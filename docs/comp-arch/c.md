# C Notes For Programming in C

- [C Notes For Programming in C](#c-notes-for-programming-in-c)
    - [Data Types](#data-types)
    - [Getting Length of Array in C](#getting-length-of-array-in-c)
    - [Strings](#strings)
      - [String concatenation](#string-concatenation)
    - [Statics and Global](#statics-and-global)
    - [Pointers (***Very Important***)](#pointers-very-important)
      - [Deferencing:](#deferencing)
      - [Pointers for Arrays](#pointers-for-arrays)
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

#### Deferencing:

    int a = 1;
    char * pointer_to_a = &a;

- This is when you refer to where the pointer points. So, it's like a pointer to a variable which contains the location of the data.
- You point to the variable using the *&* operator.
- To access this deferenced variable, you add the "*" to the beginning of the deference. For example:
  - `*pointer_to_a += 1;`
  - This will affect the actual variable as well.

- You can use a array of pointers to hold a number of pointers.
- You can pass a pointer to a function or return a pointer from a function as well.
- Or, just keep pointing.

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

