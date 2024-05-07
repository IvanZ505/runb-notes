# Final Exam Details

- Date: 5/6/2024
- 24 hour window
- Format: primarily multiple choice
- Exam itself will be approximately 1.5 hours
- About 2 mins per question

## C Programming

### Topics
- C syntax
	- basic syntax, standard stuff
- C data types
	- int types (8 different ones)
	- floating point (`float` and `double`)
	- enums, structs, and unions (*not as important?*)
	- arrays
	- [pointers](#pointers)
- 

### Syntax
- C syntax notes from [Computer Architecture](comp-arch/basics-of-c).
- C syntax notes from [Systems Programming](c-basics)

### Pointers
- C pointers have 2 parts, *address of data* and *type* (ex: `char *`)
	- `type` goes away in compilation, so you need to already know what type is the pointer.
	- If given a pointer, there is not way to query what sort of data it locates.
	- `void` pointers have no type information
		- They must be *casted* to a specific pointer type to be used...
		- Or... we can use generic operations such as `memcpy()`
			- (Only if we know the size of the data)
		- To use properly, we need to know (*as programmers*) what sort of data we are using, even if it is not expressed in the types.

### Memory Allocation/Deallocation

`malloc()`, `calloc()` and `realloc()` - reserves space on the heap. 

- (There is some internal data structure that keeps track of the block in the heap that are allocated or free)

`free()` - deallocates a previously allocated heap object. (Programmer's responsibility to only pass an object to `free()` that has been *dynamically allocated*)

#### Object vs Data

**Object** - location in memory that can hold data. (This *address* is also a piece of data)

**Value** - Actual bytes stored in an object at some point in time.

- A *pointer variable* has an object that stores the address of another object.
	- Address of pointer variable is the address that *actually stores the pointer*.

			&p -> addr of the pointer variable itself
			p -> value of the pointer, address of the object it points to.
			*p -> value of the object it pointers to.

			int I;
			int *p = &I;
			Ex: (*p)++ -> is adding 1 to the value of the object at p. (Same as I++)
			(p++)* -> changes p. 


```C

int I[2] = {10, 20};
int *p = &I[0];

++(*p) // Changes I[0] to 11 but returns 11 first.
*(++p) // changes p to I[1] but returns 20 first.
(*p)++ // changes I[0] to 11 but returns 10 first.
*(p++) // changes p to &I[1] but returns 10 first.

```

### Macros

- The *preprocessor* changes C source code into C 
- Ex: `#define SECRET 20` -> Changes every single occurrence of `SECRET` to the number `20`.
	- `#define MEAN(X,Y) (((X)/2) + ((Y)/2))` -> Please put a shit ton of parenthesis.
- Macros basically replace the code at a certain portion of the source code.
	- This means that you *can* use variables in the macro.
- *Simple Text replacement*

## Posix File IO

In the *C and POSIX model*, files are modelled as a stream of bytes
.
- These streams are identified by "file descriptors" -> Numbers that index into a table of open streams.
- Actually, many things can be treated as a stream of bytes.
	- Posix uses the file interface to deal with many of these.
- `open()` -> Files on disk
	- Can include many "non-file" but file-like things
		- These include FIFOs, devices, and terminals, etc...
		- Opening it gives a stream reference to the file.
- `pipe()` -> Piping
- Terminals
- Sockets (`socket()` and `accept()`)

#### Stream Operations

Duplex streams means that reading and writing data do not interfere with one another.

- `read()`
- `write()`
- `lseek()` -> Can move 

**POSIX File operations** are "*unbuffered*" - This means that we need to provide our own buffer, and get data as soon as we ask for it. There is no storage for the `read()` statement.

	char buf[200];
	read(fd, buf, 200); <- Obtains up to 200 bytes

`read()` and `write()` returns the number of bytes read/written...

- You can not assume that just because you asked for 100 bytes to be read but only 50 bytes came in, you *can not* assume that there is no more data in the buffer.
	- You need to wait for the next call to read to return 0.
- `write()` could return less than the asked amount due to many things:
	- Errors, Disk ran out of space, disk was busy (Could especially happen on network disks, where it gets rejected because its busy), etc..
	- You can then try to write again... If it returns `-1`, you know that disk is full.
	- 

**C File operations** are "*buffered*" - The `FILE` struct includes a buffer of data from teh stream.

- Calls to `fscanf()` read from the buffer, and call `read()` internally to refresh it.
- Calls to `fprintf()` write to the buffer, and call `write()` internally to flush it.
## File System

**Files** are identified by an *i-node* number (and device number)

- Every file has exactly 1 i-node and zero or more data nodes.
- *i-node* stores data about the file:
	- Size
	- who owns it
	- what permissions it has
	- where its data are stored.
		- Direct and *single*/*double*/*triple* indirect references allow for very large files whilst still keeping the i-nodes with a small, fixed size.
			- #todo search up wtf this is...
		- Fast access to all parts of the file.
- **Not Included:** file name

### Directory Hierarchy

A *directory file* maps names to *i-nodes* -> Some of these i-nodes will be other subdirectories, some will be files.

- Starting from the root directory, we can define a path to a file:
	- Ex: `/directory/subdirectory/subsubdirectory/name`
	- `directory` is in `/`
	- `subdirectory` is in `/directory`
	- `subsubdirectory` is in `directory/subdirectory`
	- `name` is in `/directory/subdirectory/subsubdirectory`
- Each directory entry that references an i-node is a "link"
- The number of links to a file is the number of entries it has.

Files can be linked *any number of times*!

- Every directory is linked in at least two places:
	- Its parent (via its name)
	- itself (via `.`)
	- If it has: from each of tis subdirectories (via `..`)

## Processes

A *Process* is an abstraction that executes a program.

- This includes *virtual memory*, *current processor state* (The program counter, [registers](../comp-arch/comp-arch-finals#registers), and etc...)
- "Program plus state"
- These processes are identified through *process ID* (PID)

To create a new process, call `fork()`

- This duplicates the current process.
- The new child process starts off with the same state as the parent.
	- Is about to return from the call to `fork()`
	- All data in memory is copeid
	- All open files are now open in the child (as well as in the parent)
- The *only* way to check which process you're in is to check the return value from `fork()`
	- It *returns twice*, in the child, it returns `0` and in the parent, it returns the PID of the child.

> If we call `fork`, we should eventually call `wait()` or one of its variations like `waitpid()`.

- This allows you to confirm that a child has exited, as well as obtain it's exit status.

`execv()` and `execl()` - Changes the current program

- Starts executing a new program and abandons the current program.
- Memory is effectively cleared.
- Retains the PID
- Open files (mostly) remain open...

**Common pattern:**

```C
if(fork() == 0) {
	// set up some stuff with files
	execl(...)
}
wait()
```
## Signals

**Signals** are mechanisms used to interrupt a process.

- An *asynchronous* communication method with a process.
- These **signal types** are identified by by numbers (usually written as constants...)
	- `SIGINT`, `SIGTERM`, `SIGKILL`, `SIGCHLD`, etc...
- Can be triggered by errors or sent by other processes. (Technically could send one to yourself.)
- A process sets a *disposition* for each signal type... of the following:
	- Terminate
	- Ignore
	- Call a handler for the signal
		- The handler function can terminate the function (by calling `exit()`) or attempt to resume where the signal had occurred. (by returning)
		- **It is only safe to resume from non-error signals**.
		- They can also only be called to a subset of "safe" functions.
	- *Stop* -> Specialized
	- *Continue*

We can decide whether system calls resume or stop if we get a signal...

- This is great to stop a unresponsive program but don't want to terminate the program completely.

### Signal Mask

- Set of signals that are "**blocked**"
- Blocked signals are not delivered, but are also not discarded...
	- If the signal is later unblocked, any pending signals will be delivered.

## Multithreading

**Multithreading** allows us to use the benefits of *multitasking* within a single process.

- Single shared memory that can execute multiple tasks. (*easier communication*)
	- However, this makes it **that much easier** for tasks and threads to interfere with one another in memory.

### Data Race

- Multiple threads access a piece of data and at least one access is a write. (without coordination)... You can have multiple reads, but once there are multiple writes, its over...
- Many things that we can not control.

C Programs containing data races are **automatically** undefined. (It *may* be wrong, but it *may* be right too...)

> **Avoid** data races by coordinating...

e.g. Use mutual exclusion to enforce sequential access.

- No uncoordinated access means no data races.
- Still can have nondeterministic behaviors.  (Very good)

### Pthread Library

`pthraed_create()` - Basically our thread version of fork()

`pthread_join()` - Basically our thread version of wait()

`pthread_mutex_t()` - Used to coordinate exclusive access

`pthread_cond_t()` - Allows threads to block until another thread says it can continue.

`pthread_barrier_t()` 

`sem_t()`

### Atomic Instructions

In order to implement something like *mutex*, we need a way to perform multiple memory operations in such a way that other threads/CPU can access it "in between"

Ex: 

- `test-and-set` 
	- check obj has certain val, and set it to something in *one step*

			var M;
			if(test-and-set(M,1) == 0) {
				// We know no other thread saw M was 0 before we could set it to 1.
			}
			
	- Using this, we can create a spinlock.
	- However, without hardware support for atomic instructions, no coordination between threads is possible.

- `compare-and-swap` 
	- Compares content of a memory location with a given value.
	- If they are the same, modify the contents of that memory to new value.
	- Atomic process.
- `deadlock`
	- Mutual exclusion
	- Hold and wait
	- no preemption
	- circular wait...
	- Big problem because your program does go into deadlock, then there is no way to get out of it.
## Networking

**Networking** is sending data from one process to another... Specifically, from *one process* on one device, to **another process** on another device.

- These devices may not be directly connected to each other.

### Network Layers

#### Link Layer
- Communication between directly connected devices.

#### Network Layer
- Communication between devices on the same network. (e.g. the Internet)

#### Transport Layer
- Communication between specific processes.

#### Application layer
- the actual messages.

> Bottom 3 layers are usually given to us... but, we want to write the *application layer*... For that, we use the `sockets` interface.


### Sockets

The **socket interface** is used to establish communication by applications.

- Each *socket* is identified by a file descriptor.
	- Abstract interface that may be connected to the internet.
- `socket()` creates a new (unconnected) socket.
- `connect()` - connects a socket to a specified remote host/service.
- `bind()` - connects a socket to a service on the local host.
- `listen()` - indicates we want to accept incoming connection request.
- `accept()` - waits for a connection request, returns a new socket.
	- Handing the connection.

There are many kinds of sockets that do different things...

- Sockets created with `SOCK_STREAM` will present a stream interface that can be used with `read()` and `write()`
- Transport will ensure that bytes we send are received an that the bytes we receive are in the proper order and not missing anything.

#### Points to Consider

- Avoid blocking...
- Know where your message boundaries are
- Know which party establishes the connection.
- Know how messages are encoded.

### OSI Model
- Physical
- Data Link
- Network
- Transport
- *Session*
- *Presentation*
- *Application* -> These last 3 are the application layer.