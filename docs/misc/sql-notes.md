# SQL Notes

## Databases

---

- A database is a logically coherent collection of related data.
- Databases turn data into information.
- SQL is run on relational databases.

### Relational Model:
- The relational model of databases involves organizing data into multiple related tables.
- Data values are only stored a single time and then referenced from a different table, saving space on the database and preventing integrity errors.

### Relations Domains and Tuples (Tables, Columns, Rows)
- Data in databases are stored in tables.
- Tables in the SQL server have two part names, the database name and the table name. [schema].[table]
- A schema is a bucket used to collect similar tables under one name.
- Schemas can be used to manage security.
- Relations, domains and tuples are the core components of a relational database.
  - Relations are tables.
  - Domains are columns.
    - Storing single values in table columns helps to make the table more flexible (storing street name, house number, zip all in diff columns)
  - Tuples are rows.
    - Horizontal components of a table that are made of the value stored across every column
	-Each record acts as a single, connected, unit

### CRUD Tasks
- **C**reate: Inserting data into a database.
- **R**ead: Retrieving data from a database.
- **U**pdate: Modifying data in a database.
- **D**elete: Removing data from a database.

#### Some other operations include:
- Performing scheduled backups of the database.
- Maintain redundant copies of the database.
- Control and monitor user access and privileges.
- Create visual reports that incorporate graphs.
- Create data entry forms.

#### Normalization:
- Organizing data in a database by establishing relationships between tables in order to avoid redundancy and maintain data integrity.
- Optimized for data storage

#### Denormalization:
- Intentionally breaking the rules of normalization in order to optimize for data retrieval in a relational database.

### Keys in Databases
---
#### Surrogate Keys
- A unique identifier to represent the contents on a row in the logical design of a relational database; value is not derived from the content of the data itself.
  - Example: Identity, Sequence, UserID

#### Natural Keys
- A unique identifier for the row in the logical design of a relational database as described using data attributes that exist within the data set and also have meaning outside the context of the database.

#### Primary Keys
- A field or fields that physically maintain and identify uniqueness of a row in a table.

#### Foreign Key
- A key that points to a primary key and creates a relationship between two tables and maintains data integrity.

#### Relational Database Structure
- These are tables of entities
- There is more organization by connecting certain columns to a certain column in a different table.

---

## Retrieving Data

- The main purpose of a Relational Database Management System, or RDBMS, is not just to store the data, but also to facilitate the **retrieval** of the data.
- The `SELECT` statement.
	- A **Data Manipulation Language (DML)** statement used to read and modify the data.

Ex: `SELECT * FROM table` - This would select every single column from the table specified.

> If you only want a certain subset of the columns, just replace the `*` with the name of the column. Ex: `SELECT species FROM birds`

- The order of the table that is returned matches the order of the SELECT statement.

### Restricting the Result Set

**WHERE Clause** - Restricts the result set.

- Effectively evaluated as a Boolean: True, False, or Unknown.
- Used in the search condition of the Where clause.

> **Ex:** `SELECT book_id, title from Book WHERE book_id='3232'` - This will only select the entry where the predicate, in this case `book_id='3232'` evaluates to true.

The Where clause supports the Comparison Operators: `<, >, =, >=, <=, <>(Not equal to)`

### Useful Expressions With Select

##### `COUNT`
- Built-in DB Function that retrieves the number of rows in a Database function.

> **Ex:** `SELECT count(country) FROM medals WHERE country="Canada"`

##### `DISTINCT`

- Retrieves the unique values in a column.

> `SELECT DISTINCT country FROM medals WHERE medaltype=Gold` - This retrieves the unique countries that won gold.


##### `LIMIT`

- Limiting the number of rows that you retrieve from the database.

> `SELECT * FROM tablename LIMIT 10` - Returns just 10 rows.

### `OFFSET`

- This will offset the start of the returned data by the specified amount.

> **Ex:** `SELECT DISTINCT Title FROM FilmLocations WHERE ReleaseYear=2015 LIMIT 3 OFFSET 5;` - this returns the distinct names of the 6th, 7th, and 8th film that came out in 2015.

## Populating A Database

### Adding Rows to a Table

- Create a table using the `CREATE TABLE` statement.
- Populate table with data:
	- `INSERT` statement.
	- A DML statement used to insert rows.

The syntax for `INSERT` is as follows: `INSERT INTO [TableName] (ColumnName1, ColumnName2,...) VALUES (ValueCol1, ValueCol2, ...)`

### Updating and Deleting

##### `UPDATE`

The syntax for Update: `UPDATE [TableName] SET [ColumnName]=[Value] WHERE ...`

##### `DELETE`

`DELETE [TableName] WHERE ...`

> **Note:** If you don't speciy a WHERE clause, everything in the table will get deleted or modified.

## Relational Database Concepts

**Relational Models** - the most used data model for databases.

- Allows for data independence.
- Data is stored in tables.

#### Entity Relationship Model
- Used as a tool to design relational databases.
- Entities are objects that exist independently of any other entities in the database.
- Entities have attributes that characterize the entity.
	- **Properties of the entity**

##### Mapping Entity Diagrams to Table

- Entities become tables.
- Attributes get translated into columns.
- Common data types include *chars*, *numbers*, and *date/times*.

#### Primary Key
- A primary key uniquely identifies a specific row in a table.
- A **foreign key**, uniquely identifies the row in relation to another table.

### DDL vs DML

#### Data Definition Language (DDL)
- Define, change or drop database objects such as tables.
- **Common DDL:**
	- CREATE
	- ALTER
	- TRUNCATE
	- DROP

##### `CREATE` table

```sql
CREATE TABLE table_name
(
	column_name_1 datatype optional_params,
	column_name_2 datatype,
	...
	column_name_n datatype
)
```

###### Datatypes
- `CHAR(i)` - Character of i-length.
- `VARCHAR(i)` - Character of variable length, up to i-length.
- `BIGINT` - Integer data type that holds up to 19 digits.

###### Params
- `PRIMARY KEY` - Defines that this column entry will be the primary key.
- `NOT NULL` - This field can not be empty.

##### `ALTER` table
- Add or remove columns from a table.
- Modify the data type of columns.
- Add or remove keys.
- Add or remove constraints.

```sql
ALTER TABLE <table_name>
	ADD COLUMN <column_name_1> datatype
	...
	ALTER COLUMN <column_name> SET DATA TYPE datatype
	...
	DROP COLUMN <column_name_1>;
```

- Altering the data of an existing column can cause issues if the data type is not compatible.

##### `DROP` Table
- Use it to remove a table from the database.
- `DROP TABLE <table_name>;`

##### `TRUNCATE` Table
- The truncate table statement removes all the rows of data from a database without actually getting rid of the database.
- Adding `IMMEDIATE` tells the database to do this immediately.

```sql
TRNCATE TABLE <table_name>
	IMMEDIATE;
```

#### Data Manipulation Language (DML)
- Read and modify data
- CRUD operations

---

## Cloud Databases
- Built and accessed through a cloud database.
- Easy to use and access.
- Scalability, expand and shrink storage, PPU

##### Examples
- IBM Db2
- Databases for PostgreSQL
- Oracle Database Cloud Service
- Microsoft Azure SQL Database
- Amazon Relational Database Services (RDS)

### Database Service Instances

- DBaaS provides users with access to Database resources in cloud without setting up hardware and installing software.
- Database service instance holds data in data objects/tables.
- Once it is loaded, it can be queried through APIs.

