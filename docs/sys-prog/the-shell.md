# The Shell

When we type out the name of the shell, the first word we type out is the name of the command. This can come 1 of 2 ways:

- `bare name` - look for a program in the specified directories
- `path` - specifies the specific program

> `cp`  - will be found in `/usr/bin`, which is a place the shell will look for programs.
> `/usr/bin/cp` - is the absolute path starting from the root directory.
> `./cp` - is the relative path, indicating you want the `cp` in the working directory.

## Shell Wildcards
- `?` - Wildcard that can be replaced by any character.
- `*` - Any sequence of zero or more characters

The Shell wildcards will only match files in the current subdirectory. To match files in more than 1 directory, you do something like `ls /example/*/*.c`

> When given a wildcard, the shell will return every file matching the word with the wildcard.

#### Example
- Current directory contains: `a.txt`, `b.txt`, `cd.txt`
	- `ls ?.txt` - shell replaces this with `ls a.txt b.txt`
	- `ls *.txt` - shell will replace this with everything.

> This is not something that `ls` is doing, but something that shell is doing.

#### Funny

`ls -d ?????` - This lists out all the files with *exactly* 5 letters in its file name.

---

`mv <old_name> <new_name>` - Either renames the first file or moves the file (If the new name is an already existing directory.)

> You can not do `mv *.c *.cpp` - Rename all `.c` files to `.cpp` files.