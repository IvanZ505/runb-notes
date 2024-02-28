# [Files](sys-prog)

> In Unix, a file is a stream of **bytes**. (So now, files can contain *anything!*)

- Previous systems represented files as sequences of records.

> → Byte streams are more general, but require more work.

## Generalization

- Unix generalizes this concept to work with all byte streams.
- Things that you don't think are files are actually files.
	- Actual files on disk (`text1.txt`)
	- Console I/O
	- Other I/O devices
	- Inter-process communication (IPC)
	- Network communications

> All of these have the concept of a stream of bytes that can be read from and/or written to.

## Differences

- Some streams are read-only or write-only
	- Ex: You can `write` to StdIn, but you can't read it. You can `read` the StdOut, but you can't write to it.
- Some streams have random access.

> Byte streams have the same general base, but can have more things built onto it.

## File Functions

### From the C Language Standard

- `fopen`, `fclose`, `fread`, `fwrite`, `fscanf`, `fprintf`
- Identify files using FILE *
- Buffered

### From POSIX

`<unistd.h>` - The standard POSIX Library (Important this if you want it)

- `open`, `read`, `close`, `write`
- Identify files using file descriptors (integers)
- Not buffered
- *Lower-level*: These exist on every Unix system

#### Open

```C
#include <fcntl.h>  
int open(char *pathname, int flags);  
int open(char *pathname, int flags, mode_t mode);   // pathname: indicates where a file is located in the file system
```

- A name by itself (no slashes) refers to a file in the working directory.
- A path with slashes indicates directory containment
	- `foo/bar/baz/quux` indicates `quux` inside `baz` inside `bar` inside `foo` inside the working directory.
- A path that begins with a slash is **absolute**: it starts from the filesystem root  
special directory entries:
	- `..` - The parent of the directory  
	- `.` - The directory itself  
	- `../foo` - means foo in the parent directory of the working directory  
- *Flags*: bitmap indicating how we intend to use the file
	- `O_RDONLY` - open file for reading
	- `O_WRONLY` - open file for writing
	- `O_RDRW` - open file for reading and writing.
- *Additional flags* (combine using |)
	- `O_CREAT` - create the file if it does not exist (must provide mode)
	- `O_TRUNC` - truncate file (set its length to 0) if it exists
	- `O_EXCL` - fail if the file already exists
	- `O_APPEND` - start writing from the end of the file
	- `O_NONBLOCK` - open file in "non-blocking" mode (doesn't matter much for files on disk)

> The `open()` function from POSIX will open a file if successful, return -1 and sets **errno** if unsuccessful.

## errno
- Errno is a global variable that stores a number describing the last error that occurred. (from a function that will set errno)
- *Not every function will set errno* (Check documentation)
- The library defines constants for important error reasons.
	- `EACCESS` - Don't have the permissions to view the file.
	- `EEXIST` - The file already exists.
	- Etc...

> Instead of looking at it directly, we use `perror()` or `stderror()`.

```C
// prints an error message incorporating msg and describing the current value of errno  
void perror(char *msg);  
int fd = open(filename, flags);  
if (fd == -1) {  
	perror(filename);  
	abort();  
}  

// returns a string describing the given error code
char *strerror(int error_code); 
```

## File Permissions
- A file mode is a traditional Unix way to indicate who has what sort of access to a file.
- *When accessing a file with `O_CREAT`, you must specify the file mode (assess permissions)!*

### Three categories of users  
- u - the owner of a file (every file is owned by some user)  
- g - the group of a file (every file has access for some group)  
- o - everyone else  

### Three forms of access  
- r - read access  
- w - write access  
- x - execute access (needed to run programs or read directories)

> To change the mode of a file, use `chmod <permissions_code> <files...>`

- `chmod -w some_file` -- disable write permission
- `chmod +r some_file` -- enable read permission
- `chmod o-r some_file` -- disable write permissions for others

> You can also use three octal digits to describe permission settings.

## File Descriptor

- A number that identifies an open file.
- The run-time system maintains a table of all open files.
	- The file  descriptor is just an index in the table.
- *Technically* the processor maintains one too, but we won't get much insight into that.

		0 → Standard Input (STDIN_FILEN0)
		1 → Standard output (STDOUT_FILEN0)
		2 → Standard error (STDERR_FILEN0

- `fileno()` returns the file descriptor associated with a FILE
- `fdopen()` creates a FILE for a file descriptor

## Buffering

- Reading or writing a file requires help from the OS.
	- User programs can't talk directly to hardware.
	- Instead, we call the OS to access file data.
	- **OS calls introduce overhead** (Need to context switch in the CPU)
- Idea: Request large number of bytes together.

> A buffer is an array of bytes used to store data that is *about* to be sent from a file or has been received from a file.

We *only* call the OS when the buffer is full/empty and only send the buffer when it is full. (*Think about it like a bucket, you let a lot of water get into the bucket first before dumping it out*)

> The C Functions use FILE, which includes a buffer.
>> ⤷ When you call functions like `getc()` and `putchar()` read/write using the buffer.

### The POSIX Functions

- They don't have their own built in buffers
	- Instead, you provide your own buffer.

> You maintain an array of bytes yourself and then when that's full, you send the whole array of bytes through to `write`

```C

int read
(
int fd,       // file descriptor
void *buf,    // address of buffer
size_t bytes  // number of bytes in the buffer (Always returns less than this)
)
// Returns the number of bytes read
// Returns 0 at end of file
// returns -1 on error
```

#todo copy all the notes from previous lecture I missed.

## Reading Files

`open()` - Opens a file for reading and/or writing

- This returns a file number (File Descriptor)

- `read()` - Obtains the data from a file and writes it to memory
- `write()` - obtains data from memory and writes it to a file.
	- Read and write are system calls, so there is an overhead.
		- We use large buffers to amortize this cost.
- When we call read, we have to specify how much data to read (in bytes)
- If we are reading a binary file, the format may indicate how many bytes to read.

```C
fd = open(data_file, O_RDONLY);  
if (fd < 0) { .... }  

int n;  
int *p;  
int bytes;  

bytes = read(fd, &n, sizeof(int));  
if (bytes < sizeof(int)) { ... }  

p = (int *) malloc(n * sizeof(int));  
bytes = read(fd, p, n * sizeof(int));  
if (bytes < n * sizeof(int)) { ... }
```

> For text data, the units of the data we are interested in are variable length: Lines, words, etc...

#### General Idea
- Pick a buffer size, read that many bytes, go through the buffer and look for units.

**Issues:**

- Buffer may contain a partial unit.
- Unit may be bigger than the buffer.

## Directories
- Directories are a special file that contains directory entries.
- Each *directory entry* has at minimum:
	- The "name" of a file. (What we use to specify the file we want)
	- An *inode* identifier. (How the system specifies the file it wants)
- Every directory has two special entries
	- `.` - Every directory contains a reference to the directory itself.
	- `..` - Refers to the parent directory. (Except for the root directory, which loops to itself)
- The number of times a directory is linked is *at least 2* times `.` and `..`.
	- If there are subdirectories, then it is linked 2 + the number of subdirectories it contains.

> The unix command `ls` skips files starting with a `.`, unless you do `ls -a`

### Open a Directory File
- `open()` can open a directory file and see what bytes make up the directory file.
- `opendir()` - can open the directory without knowing the specifics of the directory format.
	- Convenient way to iterate through directory entries.

`DIR *opendir(char* path);`

- This opens the specified directory and returns a handle on failure, returns NULL and sets `errno`.
- **Errors:** It could fail for multiple reasons such as permission denied, directory not existing, etc...

`struct dirent *readdir(DIR *handle);`

- `readdir()` returns the next entry in the directory.
- returns NULL if we have read all the entries.

> `readdir()` returns entries in no particular order. (possibly the order that entries are stored in the directory file)

The struct `dirent` contains at least these fields:

- `int_t d_ino;    // i-node identifier`
- `char d_name[];  // File name (null terminating string)`

> This pointer we get is only valid until the next call to `readdir()` or a call to `closedir()`.

### Closing a Directory

`int closedir(DIR *handle);`

- Closes the specified open directory.
- **Error**: returns -1 and sets errno to failure

#### Example of Directory Reading

```C
// Reading a directory program
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <dirent.h>

void scan_dir(char *path) {
	DIR *handle = opendir(path);
	if(!handle) {
		perror(path);
		return;
	}

	struct dirent *de;

	// Keep checking until it returns false (You are setting it)
	while((de = readdir(handle))) {
		printf("%d, %s\n", de->d_ino, de->d_name);
	}
}

int main(int argc, char **arv) {
	if(argc < 2) {
		printf("please specify a directory\n");
		return EXIT_FAILURE;
	}
	scan_dir(argv[1]);
	return EXIT_SUCCESS;
}
```

### Stats

`int stats(char *path, struct stat *data);`

- On success, fills out the specific struct with info about the file.
- On failure, returns -1 and sets errno.

`struct stat` - contains the information about the file itself.

- `dev_t st_dev;     // id of the device containing the file (disk)`
- `int_t st_ino;    // inode identifier for the file`
- `mode_t st_mode;  // mode iniformation (permissions, etc)`
	- This is how you look up mode information.

> stat, instead of returning a struct to us, just fills out a struct for us. (So, you can use a local variable or use a malloc-ed one) *we can chose whether to use memory*

> Another thing to know is that the `stat` struct does NOT contain the name of the file.

##### Modes
- Using modes, we can learn things about the file including
	- Permissions
	- File type
- `S_ISREG(m)` - true for regular files
- `S_ISDIR(m)` - directories
- `S_ISLNK(m)` - symbolic links

```C

struct stat sbuf;

int r = stat(pathname, &buf);
if(r<0) {...}

if(S_ISREG(buf.st_mode)) {
...
// Is a regular file
}
else if (S_ISDIR(buf.st_mode)) {
...
// Is a directory
} else {...}
```

> `access()` - Just tells you if you have access to a file

> References: `man 2 stat`, `man 7 inode`

