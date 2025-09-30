# Exam 1 Study Guide

## Concepts

- Data: Facts, products of observation in the world. Data is information in its raw form.
- Information: Information is how data is interpreted. *Data becomes information* based on answers to a *specific question*.
- Mini World: Because there is **so much data in the world**, we can not capture all of the data in it, so we restrict the domain of the data. 
	- This data can be:
		- Used directly
		- Through a system (Information system)
- Information System Design:
	- ![](imgs/info-sys-design.png)
- Data Storage:
	- There are two different ways to store data in files..
		- **Sequentially:** Each block is right after the next, meaning you would have to read through each one to find the one you're looking for.
		- **Random access:** Efficient algorithm for insertion, deletion and searching.
- Concurrency: How do we ensure that multiple people are able to access the data and modify it without leading to any issues?
- DBMS: The Database Management System (DBMS) is a system designed to:
	- Take care of concurrency issues.
	- Store data in a way such that the user doesn't have to know where or how the data is being stored.
	- Provide efficient algorithms for insertion, deletion and searching.
	- Generalized so it's easy to define the structure of the data.
	- Should be reliable.
	- Should not have limits on the amount of data stored.
	- **All in all, it is an efficient, convenient and safe multi-user storage of and access to a massive amount of persistent data.**

## Types of Database Models

### Hierarchical

> The Hierarchical model for databases looks a little bit like a tree design with each node having just one parent. (1960s)

![](imgs/dbms-hier.png)

- These models are still used to this day in file systems and GIS systems.

### Network Model

> Looks very similar to the hierarchical model, except each child could have multiple parent nodes that point to it. (1970s)

![](imgs/dmbs-network.png)

- You would search by following pointers, which meant that insertions, deletions and updates would take *a lot* of pointer operations.

### Relational Model

> Searching by **content**, not by following links or pointers. It relies on a structure known as **Relational Tables**. (1970)

![](imgs/dmbs-relational.png)

- There are many such relational databases out there including: MySQL, Oracle, SQL Server, DB2, etc...

### Object Oriented Model

> Store data in *objects*, similar to the OO programming languages that were coming out at the time. (1990s)

![](imgs/dbms-oo.png)

- Lots of issues with communicating OO apps with databases in relational models. 
- Led to the creation of Post-relational **No-SQL** content...
	- XML, JSON (Mongo uses JSON), Ajax

## Entity Relationship Diagrams

### Concepts

- *Entity Set*: A collection of similar individual things...
	- **Think about it like a *class* in OOP.**
- *Attribute:* A simple value that is associated with an entity, usually helping to describe it.
	- **All entities in an entity set have the same set of attributes.**
	- Each of them have a specific *domain*...
		- Type: `int`, `bool`, `float`, `string`, `date`, etc...
	- Each of these attributes could also be **composite** (made up of multiple other attributes) or **multi-value** (have multiple different values).
	- Attributes *may also be derived*, meaning their value comes from another attribute.

> The following image describes how each of these look in the ER Diagram.

![](imgs/erd-attribute.png)

### Relationship Sets

> Set of specific relationships/tuples between individuals in the entity linked to it. (e.g. Mary works in the sales department)

![](imgs/er-diagram.png)

**Relationship set attributes**: Specific attributes that apply to the relationship to help qualify the nature of the relationship.

- In this example, the `since` field is the relationship set attribute to help quantify the time the employee has worked in a certain department.

> Relationships do not need to be between two different entities. They can link to itself in something called a **reflexive relationship.**

![](imgs/er-model-reflexive.png)

- In the case above, the employee may also be a manager that has employees reporting to him/her. 

#### `n`-ary Relationships

> Relationship sets with multiple different (`n`-ary) sets that may all be related via this one relationship.

![](imgs/n-ary-relationship.png)

### Constraints

#### Key Constraints

- **Candidate keys:** Minimal set of attributes that uniquely identify an element. (There can be many candidate keys in a *entity*)
	- If multiple candidate keys are needed to uniquely identify an employee, they would form a *composite key*.
- **Primary keys**: These are the candidate keys that will be enforced by the DBMS to keep track of unique entries.
	- In a ERD, you would **underline** the attribute that is being used as the primary key.

#### Cardinality Constraints

 > What is the mapping between two different entity sets?
 
 - **Many-to-many:** You can have multiple entries mapping to multiple different entries from either entity set. (No cardinality limits)
	 - This is represented in arrow notation as just a **regular line**.
	 - *Note:* You can write in more general cardinality constraints using *cardinality notation*.
	 - ![](imgs/erd-many-many.png)
 - **One-to-many:** You can only have one of a particular entity in the relationship set.
	 - Represented by a **arrow** in arrow notation.
	 - Ex: A user can post any number of posts... but each post *only has one user who posted*.
	 - ![](imgs/erd-one-many.png)
 - **One-to-One:** Each relationship set is unique, and has only one singular mapping.
	 - **Arrows on both sides** in arrow notation.
	 - ![](imgs/erd-one-one.png)
#### Participation Constraints

> Are all the entities in the relationship set participating in the following relationship?

- **Partial Participation:** Each entity is not required to be part of this relationship.
	- Normal line in arrow notation.
- **Total participation:** Each entity *MUST* participate in the given relationship *at least once*.
	- THICC line in arrow notation.

![](imgs/erd-total-participation.png)

- In this example, there is a one-to-many, total participation relationship where each post *has to* be posted by one user, and the user could post many different posts.

#### Domain Constraints

> What is the data type of the attributes in the entity set.

- **Composite types:** Use multiple different types and attributes to form a singular attribute.
- `int`, `float`, `double`, `boolean`, `date`, `datetime`, `time`
- `char(10)` - Fixed length of 10 characters.
- `varchar(10)` - Variable length of *up to* 10 characters.

### ISA Relationships

> Allows the inheriting of attributes and relationships from a particular entity set whilst *tacking on* specific attributes depending on a specific instance.

![](imgs/isa-relationships.png)

- Used to factor out commonalities and avoid repetitions in the ERD.
- Precisely identify specific *subsets* of entities that may require different attributes.
- Organizing large models and the process of creating and modifying models.

#### Constraints

> Each *ISA Relationship* has these constraints!

##### Cover Constraint
- **Partial vs Complete:** Do all the entities participate in the *ISA Relationship*? If so, it is a *complete* ISA Relation.
	- For this case, do *all employees* have to be either an Hourly or Contracted employee?

##### Overlap Constraint
- **Overlapping vs Disjoint:** Can the particular entity be part of *both* subsets and domains? If so, it is an *overlapping* ISA Relation.
	- For this case, *can an employee* be **both** Hourly and Contracted?

### Weak Entities

> Weak entities do not have enough attributes "stored" to uniquely identify it's existence.

- Used when an entity set is *entirely dependent* on a relationship set for its existence.
	- Represented using a double diamond and a double rectangle around the weak entity.
- Weak entities have to be *One-to-many* relationships and have *total* participation in it's identifying relationship.
- They can also have a *partial key* that assists in identifying a weak entity alongside the key of stronger entity sets.

![](imgs/weak-entity.png)

### Aggregation

> Allows you to treat the entire Relationship set as an entity set, and connect another relationship set to it.

![](imgs/erd-aggregation.png)

### Reification

> Converts relationship sets into entity sets with binary relationships with its participants, allowing each of the participants to have relationships of their own.

![](imgs/erd-reification.png)

- It makes the relationship into a *weak entity* and connects it to the original strong entities.
- Considered an *alternative* to aggregation.

### Notations

#### Chen Notation

#### Arrow Notation

#### Crow-Foot

#### Cardinality

