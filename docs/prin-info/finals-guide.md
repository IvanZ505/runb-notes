# Finals Study Guide

### Functional Dependencies

#### Functional Dependency

#### Keys and Superkeys

### Rules About FD

#### Armstrong Axioms

#### Split-combine Rule

#### Closure of a Set

### Normal Forms

#### Lossless and Lossy Decomposition

- Lossless, no loss of data, so any decomposition into different parts, if joined again, would result in the exact same original Relation `R`.
- Lossy Decomposition: Joining the decompositions results in lost data. (The result is a superset)

#### Normal Form

##### Hierarchy of Normal Forms

##### Finding the Normal Form

##### BCNF Decompositions

##### Minimal Cover

##### 3NF Decomposition

### Transaction Management

#### ACID Properties

- **Atomicity:** All transactions should happen together as one, or it should just not happen at all.
- **Consistency:** The databases after transactions should go from one valid state to another.
- **Isolation:** Each concurrent transaction will execute as if it is the only one in the system.
- **Durability:** Once the transaction commits, the change must remain and persist.

#### Scheduling

- **Serial Scheduling:** The transactions are executed one after another (so there is no interleaving).
	- **Serializable Schedules:** 

#### Anomalies

- **Dirty Read:** Reading data that is still uncommitted by another transaction which can be rolled back.
- **Non-repeatable Read:** Reading the same row twice will result in different values because the another transaction has modified it.
- **Phantom Read:** The appearance and disappearance of entire rows from a set due to another transaction's insertion or deletion.

#### Lock Based Concurrency Control

#### Isolation Levels

### NoSQL Databases

#### Types

#### Key Value Databases

#### Consistent Hashing

#### Dissemination

#### CAP Theorem

#### BASE Properties

