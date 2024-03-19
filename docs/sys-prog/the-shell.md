# The Shell

When we type out the name of the shell, the first word we type out is the name of the command. This can come 1 of 2 ways:

- `bare name` - look for a program in the specified directories
- `path` - specifies the specific program

> `cp`  - will be found in `/usr/bin`, which is a place the shell will look for programs.
> `/usr/bin/cp` - is the absolute path starting from the root directory.
> `./cp` - is the relative path, indicating you want the `cp` in the working directory.

So, when you type `prog` in the shell, you are running a program "prog" in the search directories whereas `./prog` is running a "prog" in the working directory.

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

### stdin, stdout, stderr
- Normally, these files are inherited from the shell (Or other parent processes)
- Redirection lets us change these.
	- `<` means to read from the file specified after. `>` means to write to the file specified after.
		- Ex: `./program < input.txt > out.txt` - Reads from `input.txt`, outputs to `out.txt`.
	- `>>` Use the file afterwards as stdout in *append mode*.
- `some_programs 2> errs`
	- This uses "errs" as stderr.
- `some_program 3< foo 4> bar`
	- This says to open "foo" for input as file number 3.
	- Open "bar" for input as file number 4.

## Pipes

- Pipes are used to chain two or more programs together.
- The output of one program becomes the input of the next.

`some_program | grep ERROR`

- Runs `some_program` and `grep`
	- `stdout` for `some_program` writes to `stdin` for `grep`.

`cat errs | grep ERROR | sort | uniq -c`

- This would read the 'errs' file and match the lines with `ERROR`, then sorts it and makes it unique (uniq) with a count (-c).

### Useful Programs For Pipe
- `grep` - matching patterns in a file. (Line by line)
	- Adding a `^` in front of the pattern says to only match *beginning of the line*
	- `grep 'foo.*bar' files` - prints lines containing "foo" then followed at some point by "bar". (Single quotes tell shell this is not a file)
	- **grep regex are very very powerful!!!**
- `uniq` - Unique lines
- `tee` - Reads from stdin (or the output is piped) and sends what it reads to the file and to stdout. (This way, you can watch the messages and also save it to a file)
- `wc` - wordcount
- `cat` - concatenates 1 or more files and writes it to stdout without pagination.
	- ex: `cat *.c | grep foo`
- `more` - reads from a file or stdin and paginates its output
	- also, `less` - cus it lets you do *more* than `more`, by letting you go backwards.

## Exit Status
- After a program executes, the shell will set a environment variable containing the exit status of the most recent process.
	- `$?` is the name of this environment variable.

`foo && bar` - This says to execute `foo` and then if `foo` succeeds, execute `bar`

> `make prog && ./prog` - This says to make prog, and if the make succeeds, then it will immediately run `prog`. Very useful!

`foo || bar` - This says to execute `foo` and if `foo` fails, then `bar` will execute.

## Processes
- A process is a program that is being executed. (How it is organized in the CPU)
- The process includes the state of the computer (memory, files, etc), as well as a program it is executing.
	- Every process is unique and has a unique processing ID. (**PID**)
		- A process does whereas a program is.
		- *However*, processes can be running the same program.

### Process Group
- A collection of one or more processes. This process group created by a shell is a "job".
- Running a single program starts a job.
	- The shell tracks the process groups it creates and assigns them job numbers.
- All processes in a pipeline are part of the same job.

> They can be in the foreground or the background.

**However, keep in mind that only *one* process group is in the "foreground"**

- This means it receives input from the terminal.
- Notably, ^C and ^Z signal every process in the foreground group.

#### Session
- A session is a set of process groups.
- Typically, each time you log into a system, you get a new login session.
- Every job and process you start will be part of this session.

> [!Think about like Task manager on Windows]

- These login sessions can be associated with a terminal.

### Useful Control Codes
- `^C` - interrupts (kills) every process in the foreground process group.
- `^Z` - stops (pauses) every process in the foreground process group.
	- `fg` - brings a stopped job back to the foreground.
	- `bg` - says to restart the stopped job in the *background*.
- `kill` - If `^C` don't work, `^Z` the program and then `kill` that mofo.
	- Sends a signal (DEFAULT=`TERMINATE`), which tells the process to terminate.
	- Unless you send it `kill -KILL` -> Kills the program without ANY opportunity to block.
- `jobs` - lists all active jobs with their job statuses.
- `ps` - lists all processes in the current session.
	- `ps -e` - lists all processes.

> Put an `&` at the end of a shell command to **start** the job in the background. Ex: `long_program > lp.out &`

### What Happens to Processes Running in the Background After I Log Out?
- They are sent `HUP` ("Hang up")
- By default, a process receiving `HUP` will terminate.
	- However, some processes will ignore `HUP`, e.g. servers.

> `nohup` - shell command runs the shell command but blocks the hang-up signal. E.g. `nohup ./my_server &`

**Note:** `HUP`, `INT`, and `KILL` terminates a program whereas `STOP` just stops a program. A stopped program can be resumed, a terminated program can not!

### How to Create a Process
- The Shell makes a process by calling a POSIX function called `fork`.

`pid_t fork(void);` - Fork duplicates the current process and makes a identical duplicate.

- In a sense, it returns twice, once in the original process and once in the new process.
- In the **original process**: `fork()` will return the PID of the new process.
- In the **Child process**: `fork()` will return a 0.

```C
pid_t child = fork();
if(child == 0) {
	// We are in the child
	exit()
}
// We are in th eparent
```

- The child process will begin as a exact duplicate of the parent:
	- Same program
	- Same contents of memory
	- Same instruction pointer
	- Same open files
	- Different process ID
- Once fork returns, the parent and child will (most likely) *diverge* from there.

> [!If you call `fork()` at some point, the parent MUST call `wait()` eventually]

All `wait()` does is blocks until a child terminates.

```C
pid_t wait(int *wstatus);
// Blocks until a child terminates
// Returns PID of the child that terminated.
// If we give it a pointer, it will write an int containing the exit status.
```

###### Puzzle

What does this do?

```C
for(int i = 0; i < 5; i++) {fork();}

// Why is this a terrible idea?
while(1) {fork();}
```