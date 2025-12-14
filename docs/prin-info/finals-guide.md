# Finals Study Guide

### Functional Dependencies

#### Functional Dependency
> A *functional dependency* is a constraint between two sets of attributes in a relation from a database. It is denoted as `X -> Y`, meaning that `X` determines the value of `Y`.

- Or, as the professor writes, we say `x` functionally determines `y` (denoted as `x->y` if and only if whenever two tuples (`s` and `t` ) agree on `x`, then `s` and `t` agree on `y`)

#### Keys and Superkeys

> Candidate keys are the minimal set off fields that uniquely identify a relation.

- Meanwhile, superkeys are a set of fields that will *contain* candidate keys.
- This means that every superkey is a candidate key.


### Rules About FD

##### Properties of Functional Dependencies

- **Reflexivity:** `x ⊆ y => y → x`
- **Augmentation:** `x->y => xz->yz` (∀z ⊆ R)
- **Transitivity:** If `x->y` and `y->z`, then `x->z`
- **Split Combine Rule:** `x->y` ^ `x->z` => `x->yz`
	- Doesn't work the other way around though.

#### Closure of a Set

> The closure of `X` is denoted as `X⁺`, which is the set of all attributes that can be functionally determined by `X` using functional dependencies.

$$X^+=\{A \in R \space | \space x \rightarrow A \}$$

### Normal Forms

#### Lossless and Lossy Decomposition

- Lossless, no loss of data, so any decomposition into different parts, if joined again, would result in the exact same original Relation `R`.
- Lossy Decomposition: Joining the decompositions results in lost data. (The result is a superset)

#### Normal Form

- 1NF: Every attribute must be atomic. This means attributes that contain several pieces of information are not allowed.
	- Assumed that every table designed is already in 1NF, and is not possible to check for.
- 2NF: All functional dependencies `x->y` is such that `y` is non-prime and `x` is a key.
- 3NF: The right hand side has to be **prime**. However, if the right side is *not* prime, then the left side *has to be* a superkey.
- BCNF: X Must be a superkey.

##### Hierarchy of Normal Forms

![](imgs/Pasted%20image%2020251212122542.png)

##### Finding the Normal Form
- Start with finding 2NF violations, then try 3NF, and then BCNF. If there are no violations for any of them, then it is in BCNF.

###### Special Cases
- `F = ∅` (Set of Functional Dependencies is empty)
	- There are no violations. (There can not be, there's literally no relations)
	- At least in BCNF.
- If every candidate key is a singleton. (There is only one field)
	- There is no 2NF violation, since it needs the RHS to be a proper subset of the candidate keys, which is impossible if the candidate keys themselves are only 1 field.
- If all attributes are prime.
	- There is no 3NF violation, as it requires the RHS to be not prime. (For a violation)
- If `R` only has 2 field.
	- Candidate key has to be one or the other field. (nontrivial)
	- This means the LHS is *always* a superkey!
	- **BCNF**

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

- S-locks (Obtained in order to read data)
	- If A transaction has a S-lock, another transaction can only get another S-lock, but can not get a X-lock.
- X-locks (Obtained in order to write data)
	- If a transaction has a X-lock, other transactions can not get a S-lock *or* a X-lock until the transaction releases the X-lock.

#### Isolation Levels

- Read uncommitted:
	- This allows for all anomalies to occur, which also means it uses no locks.
- Read committed:
	- Requires you to have the S-lock in order to read data, and release the S-lock after the read. 
	- This prevents dirty reads.
- Repeatable Read:
	- Requires you to have the S-lock in order to read data, but you only release the S-lock after the transaction commits.
	- This prevents unrepeatable reads.
- Serializable:
	- Requires you to have the X-lock in order to write, and also only releasing both when the transaction commits.
	- This prevents phantom reads.

### NoSQL Databases

- Relational Databases put a lot of emphasis on the consistency of data.
	- This means the entire database *must* remain consistent at all times (Except when processing a transaction) (ACID Property!)
- This can become a burden and comes at the cost of flexibility and scalability.
	- Since it has to comply with a rigid schema and all Integrity Constraints.
- RDBMSs are not very good at horizontal scaling. (Meaning adding more nodes to a cluster)
	- It incurs a lot of overhead for consistency, complexed queries and most modern applications only really need simple instructions.

#### Types

- Document based NoSQL databases like MongoDB.
- Key-value based NoSQL databases.

#### Key Value Databases

- Key value based databases store data as (key, value) pairs.
- Each key is unique and there is a hashmap or hash table that maps to each value.
	- Each key is hashed via a 
- Completely independent, with no referential integrity and *no relationships*.

#### Consistent Hashing

- **Consistent hashing** schemas are often used, which avoid having the remap each key to a new node when nodes are added or removed.
	- Using *mod* is an example of a non-consistent hashing method.\
- "Ring"-topology: a hashing method that puts servers on a point in a number range between 0 and 1.

![](imgs/Pasted%20image%2020251214153845.png)


- You would hash each key to a position on the ring, and store the actual key-value pair on the first server that appears clockwise of the hashed point on the ring.
- 1/n of the key-value pairs will end up being stored on each server (n being the number of servers)

#### Dissemination

#### CAP Theorem

#### BASE Properties

