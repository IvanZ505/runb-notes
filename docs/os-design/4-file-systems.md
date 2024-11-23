# File Systems

### File System Trend

- File systems have several layers. 

### Allocation Strategies

- Many different approaches:
	- Contiguous
	- Extent-based
	- Linked
	- File-allocation Tables
	- Indexed
	- Multi-level Indexed
- **Question:**
	- Amount of fragmentation (internal and external)
		- Free space that can't be used.
	- Ability to grow file over time?
	- Performance of sequential accesses (contiguous layout?)
	- #todo what did i miss

## Contiguous Allocation

Allocate each file to contiguous sectors on disk...

- Meta-data: *Starting block and size of*
- OS allocates by finding sufficient free space.
	- Must predict future size of file. (Show space be reserved?)
- Example: IBM OS/360

#### Problems?

- Fragmentation (Internal and external)?
- Ability to grow file over time?
	- Horrible external fragmentation (needs periodic compaction)
	- May not be able to without moving
- Seek cost for sequential accesses?
	- Excellent performance
	- Very simple calculation.
- Speed to calculate random accesses?
- Wasted space for meta-data?
	- Little overhead for metadata.

> The fragmentation is bad, growing the size of it is hard, but *everything else is good*

## Small Num of Extents

- Allocate multiple contiguous regions (extents) per file.
	- Meta-data: Small array (2-6) designating each extent.
		- Each entry: starting block and size.


#todo get the photo

#### Problems?

- Fragmentation (internal and external)?
	- Helps external fragmentation
- Ability to grow file over time?
	- Can grow (until run out of extents)
- Seek cost for sequential accesses?
	- Still good performance
- Speed to calculate random accesses?
	- Still a simple calculation.
- Wasted space for metadata?
	- Still small overhead for meta-data.

## Linked Allocation

- Allocate linked-list of *fixed-sized* blocks (multiple sectors)
	- Meta-data:
	- Examples: TOPS-10, Alto

#todo get the photo

#### Problems?

- Fragmentation (internal and external)?
	- Very good, no external fragmentation (use any block)
	- *Internal fragmentation:* Having to store pointers to another one.
- Ability to grow file over time?
	- Can grow easily.
- Seek cost for sequential accesses?
	- Depends on the data layout.
- Speed to calculate random accesses?
	- Ridiculously poor
- Wasted space for metadata?
	- Waste pointer per block. (Internal fragmentation)

## File-Allocation Table (FAT)

- Variation of Linked Allocation
- Keep linked-list information for all files in on-disk FAT table.
- Metadata: location of first block of file.
	- And, FFAT table itself

#todo get the photo


#### Comparison

- Same basic advantages and disadvantages as linked allocation.
- *Disadvantage:* Read from two disk locations for every data read.
- *Optimization:* Cache FAT in main memory.
	- Advantage: Greatly improves random accesses.
	- What portions should be cached? Scale with larger file systems?


## Multi-level Indexing

- Variation of Indexed Allocation
	- Dynamically allocate hierarchy of pointers to blocks as needed.
	- Metadata: Small number of pointers allocated statically.
		- Additional pointers to blocks of pointers.
	- Examples: UNIX FFS-based file systems, ext2, ext3.

#todo get the photo


#### Comparison

- **Advantage:** Does not waste space for unneeded pointers.
	- Still fast access for small files.
	- Can grow to what size??
- **Disadvantages:** Need to read indirect blocks of pointers to calculate addresses. (extra disk read)
	- Keep indirect blocks cached in main memory.


## Data Blocks

- Everything is in a data block. 
- Think about it like our project 3, where we have a bunch of blocks, and some of the ones at the start store information about the other blocks. (*Inodes*)
	- Inode will contain all the information about the block.

#todo get the stupid photo


### Inodes

- Every inode structure is the same.
- Does not matter if you create a directory, subdirectory, or a file, they're all files, so they will all have indoes.

#todo get the photo of all the different things in a inode
