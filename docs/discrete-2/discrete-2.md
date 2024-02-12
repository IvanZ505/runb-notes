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

**Official Definition:** When a task consists of *k* tasks, each with a possible outcome of nₖ, the total possible outcomes is `n₁ ✕ n₂✕ n₃ ✕ ... ✕ nₖ`

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

> `0!` is going to equal 1. This is the agreement otherwise everything else is going to become 0.

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

### Arrangement of `n` objects Containing Lookalikes

- The number of **distinguishable arranements** of *n* objects, where one or more subsets consist of look-alikes (say `n₁` are of one kind, `n₂` are of another kind, ... and `nₖ` are of yet another kind), is given by:

$$\frac{n!}{n₁!*n₂!*...*nₖ!}$$

**Example**

	Determine the number of distinguishable arrangements of the letters in each word.
	ATTRACT (n = 7)
	The problem with this question is:
	- If you swap the First T with the Second T, you still have the same word.
	- Same thing happens if you swap the first A with the second A.
	Solution:
	Put the number of letters that repeat on the bottom using the distinguishable arragenements definiton.
	n = 7 → 2 As, 3 Ts, 1R, 1C
	This means our distinguishable arrangements would be:

$$\frac{7!}{3!*2!*1!*1!}$$

---

### Combination Permutation

The number of **permutations**, or *arrangements*, of *n* distinct things taken *r* at a time, where `r ≤ n`, can be calculated as follows.


$$_nP_r=\frac{n!}{(n-r)!}$$
> Whenever we want to count how many ways we want to pick *r* items out of *n* items.

---

The number of **combinations**, or *subsets*, of *n* distinct things taken r at a time, where `r ≤ n`, can be calculated as follows.

$$_nC_{r}=\frac{_nP_r}{r!}=\frac{n!}{r!(n-r)!}$$

#### When to Use Permutations vs Combinations

![](imgs/perms-vs-combs.png)

**Example**

- In how many different ways can you choose 5 diamonds?
	- `₁₆C₅`
- In how many ways can you choose 5 black cards?
	- `₂₆C₅`
- In the lottery, you select 5 distinct numbers from 1-47 and one MEGA number from 1-27. How many different sets of 6 numbers can you select. **Lottery numbers are always selection!!!**
	- Multiple task problem, `₄₇C₅ ✕ 27`
- How many of the possible 5-card hands from a standard 52-card deck will consist of the following cards?
	- four clubs and one non-club: `₁₃C₅ ✕ 39`
	- two red cards, two clubs, and a spade: `₂₆C₂ ✕ ₂₆C₂ ✕ 13 (or ₁₃C₁)`

---

### Grouping `n` Elements

To divide *n* elements into *k* groups of *n₁*, *n₂*, *n₃*, ..., *nₖ* (**All Different Sizes**, if an *n₁*): 

$$_{n}C_{n₁}*(_{n-n₁}C_n₂)*...$$

To divide *n* elements into *k* groups at size *r*:

$$\frac{_nC_{r}*(_{n-r}C_r)*...}{k!}$$

---

### Pascal's Triangle

![](imgs/pascals-triangle.png)

	(a+b) = a + b
	(a+b)² = a²+2ab + b²

So, the for `a¹⁹`:

- `(a+b)¹⁹ = ₁₉C₀a¹⁹ + ₁₉C₁a¹⁸b + ₁₉C₂a¹⁷b² + ... + ₁₉C₀b¹⁹`

---
### Counting Problems Involving "NOT" and "OR"

**Number of Outcomes**: Getting Head **OR** Rolling an even number:

	A = Getting H
	B = Getting even num
	This question can be defined as: n(A ∪ B)
	n(A∪B) = n(A) + n(B) - n(A∩B)
	S = {(H,1), (H,2), (H,3), (H,4),..., (H,6), (T,1), (T, 2), ..., (T,6)}
	A = {(H,1), (H,2), ..., (H,6)}
	B = {(H,2), (H,4), (H,6), (T,2), (T,4), (T,6)}
#### How to Solve

1. Define our set
2. Step 2, draw / list the sample space (so you know the *total* outcomes) **S**
3. List elements in each set and find its cardinality
4. Use the formula to find the value

---

#### Practice for "OR"

- If a single card is drawn from deck, how many different ways can we draw a heart or a ten.
	- A - Heart, B - 10
	- n(A) = 13 (13 hearts in the deck),  n(B) = 4 (there are 4 tens in the deck)
	- n(A∩B) = 1, there is 1 ten that is heart.
	- n(A∪B) = n(A) + n(B) - n(A∩B) = 13 + 4 - 1 = **16**
- An ace or a red card.
	- A - Ace, B - Red card
	- n(A) = 4, n(B) = 26
	- n(A∩B) = 2
	- n(A∪B) = n(A) + n(B) - n(A∩B) = 4 + 26 - 2

![](imgs/practice-10-4.png)

- How many ways can we have a woman or a Democrat man
	- A - Woman, B - Democrat Man
	- n(A) = 9, n(B) = 8
	-  n(A∩B) = 0
	- n(A∪B) = n(A) + n(B) - n(A∩B) = 9 + 8

---

**Number of Outcomes**: Tossing a coin 3 times and getting no heads. (*Same as:* Getting Tails on all 3 tosses)

	Draw out sample space. (I can't draw here rip)
	Let A be Getting Heads.
	A' = Not getting heads.
	n(A') = n(S) - n(A) = 8 - 7 = 1

#### Practice for "NOT"

- If you toss seven fair coins, in how many ways can you obtain at least two head. (**two or more heads**)
	- n(S) = 2⁷
	- Trying to show 2 or more is like n(2H ∪ 3H ∪ 4H ...)
	- **Instead**, go the other route and figure out the outcomes where you get no heads or 1 head.
		- A - No heads, B - 1 head
	- A ∪ B = n(A) + n(B) = 1 + 7 = 8
	- Then, just find the complement of that.
		- 2⁷ - 8