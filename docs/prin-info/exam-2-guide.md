# Midterm 2 Study Guide

## ERD To Relational Models

### Mapping ISA Relationships

> The mapping of ISA Relations is very simple! Create separate schemas for each of the ISA(s) and make their primary key the primary key of the parent.

![](imgs/real/isa-relationship.png)

- For this example, you would have:
	- `Employees(ssn: char(11) primary key, ...)` -> This is your parent entity.
		- `Hourly_Emps(ssn: char(11) primary key, ..., Foreign key (ssn) References Employees)` -> This ISA entity will be referencing the parent.
		- Same thing on the other side.

### Merge Rule

> Merge Rule is the process of combining tables together in order to have less references and tables than would be necessary.

- There are *three* different scenarios where you can use merge rule.
	- These scenarios depend of the state of the ERD.

![](imgs/real/merge-rule.png)

- When merging a table into another, you can only do it if the primary key of a table is *also* the foreign key, and references another table.

### Enforcing Participation Constraints

-  Participation constraints can be enforced through the use of **NOT NULL** in the foreign key.

## SQL

### Basic SQL Data Types

- `int`, `float`, `double`, `decimal(size, places)`
- `time` (HH:MM:SS:...DD), `date` (YYYY-MM-DD), `datetime`
- `char()`, `varchar()`
- `enum('mon', 'tues', ...)`
- `text`: ~6,500 characters
- `blob`: Binary (for sounds, images, videos)

### Schema to Tables

- `create database db_name;` - Creates the database
- `use db_name;` - How to tell the DMBS you are managing a certain database
- `drop database db_name;` - Removes everything (Schemas, Tables, Data, EVERYTHING)
- `show databases;`
- `create table table_name (f1 d1, f2 d2, ...)` - Create a table with the specified fields
- `describe table_name;` - Describes the schema of the table
- `drop table;` - This isn't allowed if the behavior is unspecified for what happens to any foreign keys that reference it.
- `alter table table_name add fn dn;` - Adds a column to the table with the field name and datatype.

> [!IMPORTANT NOTE]
>> When creating the table, the schema looks *slightly differently* for referencing the foreign keys... `foreign key (sid) references Students (sid)` <- You must make a reference to the actual field name of the table.

#### Inserting Into Tables

- **Inserting full sets of tuples:**
	- `insert into table_name values (___, ___, ...), (___, ___, ...), ...;`
	- This inserts multiple different tuples (rows) of entries into the table with the values specified in each tuple.
- **Inserting partial sets of tuples:**
	- `insert into table_name (f1, f2) values (v1_1, v2_2), (v1_2, v2_2), ...;`
	- This inserts different tuples, but partially filled out. Any row unspecified this way will be left as `NULL`.

#### Update and Delete

- **Updating the table:**
	- `UPDATE table_name SET f1=" ", f2=" " WHERE COND;`
	- Updates rows that match the conditional.
- **Deleting Entries:**
	- `DELETE FROM table_name WHERE COND;`
		- Allows deletion by matching the conditions. If you don't include the `WHERE`, it deletes everything.
	- `TRUNCATE TABLE table_name;`
		- Does the same thing where it deletes everything.

### Query Commands

> SQL Queries come in the following *basic* format:
>> `SELECT __, __, ... FROM table_1 t1, table_2 t2, ... WHERE COND;`

#### Subqueries

> You can also use *another* `SELECT` statement inside a query, in something called a *subquery*. This allows you to loop SQL commands and chain them together.

#### Aggregate Operators

`sum()`, `max()`, `min()`

## Relational Algebra

## Practice 1

1.

```
CREATE TABLE enrolled (
	snum: int,
	cname: varchar(30),
	primary key(snum, cname),
	Foreign key (snum) References student (snum),
	Foreign key (cname) References class (cname)
)

CREATE TABLE class (
	cname: varchar(30) primary key,
	meets_at: time,
	room: varchar(30),
	fid: int,
	Foreign key (fid) References faculty (fid)
)

CREATE TABLE faculty (
	fid: int primary key,
	fname: varchar(30),
	dept: varchar(30)
)

CREATE TABLE student(
	snum: int primary key,
	sname: varchar(30),
	major: varchar(20),
	level: varchar(10),
	age: int
)
```

b.

if the table were to be populated, you would need to populate the students and faculty table first, and then the class and enrolled tables.

2.

```
SELECT f.name
FROM faculty f
WHERE f.dept = "cs"
AND f.name = "W%";
```

3.

```
SELECT s.name
FROM student s
WHERE s.age = ( SELECT s.age 
FROM student s
WHERE s.name = "Horatio")
```

4.

```
SELECT s.name
FROM student s
WHERE s.age > (SELECT MAX(s.age) FROM student WHERE s.name = "A%");
```

5.

```
SELECT c.cname
FROM class c
WHERE c.cname NOT IN (SELECT e.cname FROM enrolled e WHERE e.cname = c.cname)
```

6.

dfadfasdfdasfasdf