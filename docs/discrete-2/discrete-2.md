# Intro to Discrete Structures 2

Instructor: Dr. Samaneh G. Hamidi (sg1538@cs.rutgers.edu)
- Office Hours: #266 Hill Center (Monday 11:10-11:40am and Tuesday 11:30-12:30pm)

## Topics
- Set Theory: Symbols and Terminology, Venn Diagrams and subsets, Set operations  
- Counting: Binomial coefficients, Permutations, Combinations, Partitions  
- Recurrence relations and generating functions  
- Discrete probability:  
	- Random experiments, sample spaces, events, probability measures
	- Conditional probability, Bayes' Theorem, Independence
	- Random Variables
	- Expectation, variance, standard deviation
	- Binomial, Bernoulli, Poisson and Geometric distributions; law of large numbers
- Some Topics from Graph Theory: Paths, Components, Connectivity, Euler Paths, Hamiltonian Paths, Planar Graphs, Trees

## Grading
- **Exams** (42%)  *3 exams*
- **Finals** (32%)
- **Quizzes** (20%)
- **Class Participation** (6%)

## Set Theory

### Set

> [Discrete 1 Notes on Sets](../discrete-1/discrete-1#Sets)

A **set** is a collection of items / objects that have at least a property in common.

> Example: Set of all cars made in 2023.

- The notation of a set is a pair of brackets `{}`.
- Typically, we use a uppercase letter to define your set. (e.g. `A = {a, b, c, d}`)
- There are three different ways to describe your set:
	- Statement form: `{I is the set of integers that lies between -1 and 5}`
	- Roster form: `I = {0, 1, 2, 3, 4}`
	- Set-builder form: `I = {x : x ∈ 𝕀, -1 < x < 5}`

#### Review of Sets of Numbers

`ℕ` : Natural Numbers : `{1, 2, 3, 4, 5, ...}`

`𝕎` : Whole Numbers : `{0, 1, 2, 3, ...}`

`ℤ` : Integers : `{..., -2, -1, 0, 1, 2, ...}`

`ℚ` : Rational Numbers : `{x | x = a/b, a,b ∈ ℤ and b ≠ 0}`
	⤷ Irrational numbers **do not** have a set notation, but just means any number that is irrational.

`ℝ` : Real Numbers : `{ x | -∞ < x < +∞}`

---

> Between 2 Integers, is there more rational numbers or irrational numbers?

### Cardinality

The **total number of elements** in a set is called the **cardinal number** or **cardinality** of the set. (*Repetitions of a number DO NOT increase the cardinality of the set*)

This is denoted by `n(A)` or `|A|`

### Empty Set

The **empty set** is the set with *no elements*. (The cardinality of the empty set is 0)

The **empty set is denoted by ϕ** and is always a subset of another set.

### Subset

A set `A` is a subset of a set `B` iff `∀a ∈ A, a ∈ B`.

The symbol for a subset is `⊆` for a subset that is equal to.

### Ordered Pairs

An **ordered pair (a, b)** is a pair of numbers where the order matters.

Ex: (1, 3) ≠ (3, 1)

### Power Set

The **power set** of A, `P(A)`, is the set of all subsets of A.

	A = {-1, 0, 5}
	P(A) = { {-1}, ,{0}, {5}, {-1, 0}, {0, 5}, {-1, 5}, A, ϕ}

#### Cardinality of Power Set

**Theorem**: If `n(A) = i, then `n(P(A)) = 2ⁱ`

> This means that if the cardinality of A is 3, then the cardinality of P(A) is 8.

---

### Venn Diagram

The Venn diagram is how you geometrically represent a set. The outer box represents the universal set, denoted by `U`. The circles inside represent the different sets.

### Set Operations

**Base Sets A and B**:

![](imgs/set-operations-1.png)

#### Complement set

`A' = A^c = {x | x ∈ U but x ∉ A}`

![](imgs/set-operations-complement.png)
#### Union

`A ∪ B = {x | x ∈ A OR x ∈ B}`

![](imgs/set-operations-union.png)
#### Intersection

`A ∩ B = {x | x ∈ A AND x ∈ B}`

#### Difference

`A - B = {x | x ∈ A but x ∉ B}`

#### Cartesian Product

`A x B = {(x, y) | x ∈ A, y ∈ B}`

> **Note:** `A x B` ≠ `B x A`

	A = {-1, 0, 5}, B = {-1,  2} **Find cartesian product**
	AxB = {(-1, -1), (-1, 2), (0, -1), (0, 2), (5, -1), (5, 2)}

**Theorem:** If `n(A)=k` and `n(B)=m`, then the cartesian product will have a cardinality of `k*m`

---

#### Practice

	Let U = {a, b, c, d, e, f, g}, X = {a, c, e, g}, Y = {a, b, c}, Z = {b, c, d, e ,f}
	X' = {b, d, f} Y' = {d, e, f, g}
	X' ∩ Y' = {d, f}

	(Y ∩ X')' ∪ Z' = {a, c, d, e, f, g}

---

#### DeMorgan's Laws For Sets
- For any set `A` and `B` where `A,B ⊆ U,`
	- `(A∪B)' = A' ∩ B'` and `(A ∩ B)' = A' ∪ B'`

---

## Counting

**There are multiple ways of counting:**

1. Counting by listing
2.  Multiplication / Fundamental principle of counting
3. Permutation & Combinations

### To List out Possible Combinations


**Use a tree method:**

![](imgs/A-probability-tree-indicating-the-16-possible-outcomes-of-a-sequence-of-four-coin-tosses.png)

---

### Sample Space

The set of all possible outcomes `S` .

---

### Fundamental Principle of Counting

> When you multiply all the choices for each option together to get your total number of possible outcomes.

**Official Definition:** When a task consists of *k* ...

#### Practice

Mathematical Ideas 10.1 pg. 539

	N = {Alan,, Bill, Cathy, David, Evelyn}
	No more than 1 can hold more than 1 office. List and count all ways club could elect each group of officers.
	1. A president and a treasurer
		(5) for president * (4) for treasurer left = 20.
	2. A president and a treasurer if the president must be female.
		(2) for fem. president * (4) for treasurer left = 8

---

	4 digit # --> Possibilities 9 ✕ 10 ✕ 10 ✕ 10 = 9000
	WIthout repeating any --> 9 ✕ 9 ✕ 8 ✕ 7
	Odd number and greater than 4000 --> 6 ✕ 10 ✕ 10 ✕ 5

---

	In how many different ways can you place 5 people in 5 chairs?
	Use FPC, 5 ✕ 4 ✕ 3 ✕ 2 ✕ 1.. This is also...

### Factorials

> **For any counting number *n***, the quantity *n factorial* is defined as follows:
> `n! = n*(n-1)*(n-2)*...*2*1`
> $$n! = n*(n-1)*(n-2)*...*2*1$$

Evaluate the following without a calculator:

$$\frac{5!}{9!} = \frac{5!}{9 * 8 * 7 * 6 * 5!} = \frac{1}{9 * 8 * 7 * 6}$$

---

#### Practice

MI 10.2

	42. From the same set of people as the president problem... Schedule one member to work in the office each dday for 5 different days, assuming each member may work more than 1 day.
	5⁵

---

	62. Listing phone numbers
	Raj keeps the phone numbers for his seven closest friends (3M, 4F) in his digital phone memory. How many ways can he list them in the following conditions?
	a) men are listed before women
	3 ✕ 2 ✕ 1 ✕ 4 ✕ 3 ✕ 2 ✕ 1 = 3! ✕ 4!
#### Important Practice

	b) all  men are listed together...
	**For these questions, wrap the group together and treat it as just 1 item.**
	So ||| --> 3 men --> | (just 1) + |||| (4 women) --> 5!
	However, we must also consider that the 3 men can also swap with one another. Their swaps have 3! permutations.
	This means, in total, we have 5! ✕ 3!

#HW 62c