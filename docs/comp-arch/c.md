# C Notes For Programming in C

- [C Notes For Programming in C](#c-notes-for-programming-in-c)
    - [Data Types](#data-types)
    - [Getting Length of Array in C](#getting-length-of-array-in-c)
    - [Strings](#strings)
      - [String concatenation](#string-concatenation)

---

### Data Types

- There is no boolean data type in C.
- To be able to use the boolean data type, you need to define it in the header.

```C
#define BOOL char
#define FALSE 0
#define TRUE 1
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