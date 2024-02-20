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

> For text data, the units of the data we are interested in are variable length: Lines, words, etc...

#### General Idea
- Pick a buffer size, read that many bytes, go through the buffer and look for units.

**Issues:**

- Buffer may contain a partial unit.
- Unit may be bigger than the buffer.

