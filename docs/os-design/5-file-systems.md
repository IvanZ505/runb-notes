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

## Indexed Allocation

### Multi-level Indexing

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

## Flexible # of Extents

- Modern file systems:
	- Dynamic multiple contiguous regions (extents) per file.
	- Organize extents into multi-level tree structure.
		- Each leaf node: starting block and contiguous size.
		- Minimize meta-data overhead when have few extents.

## Data Blocks

- Everything is in a data block. 
- Think about it like our project 3, where we have a bunch of blocks, and some of the ones at the start store information about the other blocks. (*Inodes*)
	- Inode will contain all the information about the block.

#todo get the stupid photo


### Inodes

- Every inode structure is the same.
- Does not matter if you create a directory, subdirectory, or a file, they're all files, so they will all have indoes.
- *Inodes are stored in order so its easy to do the calculations*

#todo get the photo of all the different things in a inode

##### Direct vs Indirect Pointers

- A direct pointer in an inode points directly to a physical block in the memory.
	- A inode structure will have 16 direct pointers.
- An indirect pointer may point a physical block, but each entry in the physical block may point to another physical block of memory.
	- *You can also have a double indirect pointer or a triple indirect pointer*

#### One Inode Block

- Each inode is typically 256 bytes (depending on the FS, maybe 128 bytes)
- 4KB disk block.
- 16 inodes per inode block.

#todo get img

> When you systems like Linux, where everything is a file, you will have a lot of wasted space for the inodes.

- So, you want to put all of the inodes together in a single block.
- The inode will then point to where the block begins.

---

- Assume single level (just pointers to data blocks)
- What is the max file size?
	- Assume 256-byte inodes (all can be used for pointers)
	- Assume 4-byte addresses.
- How to get larger files?

		256/4 = 64
		64 * 4K = 256 KB!


---

#todo get photo of block tree lookin ass..

Optimize for smaller blocks vs more indirect pointers.

---

###### Practice

Assume 256 byte inodes (16 inodes/block)

- What is the offset for inode with number 4?

#todo get photo...

	Since there are 16 inodes for block, and we know that the inodes start at block 3, it will be in block 3. 
	Then, the offset would be 256 bytes * the number of inodes (5, 0-indexed).

---

- Responsibility of the OS to copy the entire item to memory as the CPU can not access the disk itself, and these blocks are in the disk.

> Note for the project: You can not just take the cpu and point to the address of the block. You need to take that address, put the entire block into the memory, and THEN read it.


#### File Organization: The Inode

- Each inode is referred to by inode number.
	- By inode number, File system calculate where the inode is on the disk.
	- Ex: Inode number: 32
		- Calculate the offset into the inode region (`32 * sizeof(inode) (256 bytes)`) = 8192.
		- Add start address of the inode table (12KB) + inode region (8KB) = 20 KB.

#todo get the picture of the inode table.

#### Directories

#todo link it

> File systems may vary

- Directories are for storing *directory entries* in data blocks.
- **Large directories** just use multiple data blocks.
- Use bit in inode to distinguish directories from files.

Various formats could be used...

- Lists
- B-trees

## Superblock

- Need to know basic FS configuration metadata, like:
	- Block size
	- \# of inodes.
- **Store this in the superblock**

#### On Disk Structures


## File Operations

### Creating Files

	Create: /foo/bar

| data bmap | inode bmap | root inode | foo inode | foo inode | bar inode | root data | foo data |
| --------- | ---------- | ---------- | --------- | --------- | --------- | --------- | :------- |
|           |            | 1. read    |           |           |           |           |          |
|           |            |            |           |           |           | 2. read   |          |
|           |            |            | 3. read   |           |           |           |          |
|           |            |            |           |           |           |           | 4. read  |
|           | 5. read    |            |           |           |           |           |          |
|           | 6. write   |            |           |           |           |           |          |
|           |            |            |           |           |           |           | 7. write |
|           |            |            |           |           | 8. read   |           |          |
|           |            |            |           |           | 9. write  |           |          |
|           |            |            |           | 10. write |           |           |          |

#todo figure out 1-4??

5. Read the bmap to find a free `inode` in the bitmap.
6. Immediately write to it and reserve the `inode` so it can't be stolen.
7. Write the data for foo.
8. Every time file gets created, you need to read the `inode` to update the file creation time.
9. Update the file creation time.
10. Write the number of links to the foo inode.