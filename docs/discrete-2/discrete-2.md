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

## Probability


### Experiment
- An experiment is a process that results in an outcome that cannot be predicted in advance with uncertainty.

### Sample Space
- The set of all possible outcomes of the experiment are called the *sample space* for the experiment.
- Ex: For tossing a coin, the sample space is `S = { Heads, Tails }`.

### Event
- The subset of a sample space is called an event.
- The probability of some event `A` occurring is the cardinality of `A` over the cardinality of the sample space.

$$P(A) = \frac{n(A)}{n(S)}$$

- The probability of any event occurring must always be between 0 and 1. (As denoted by `0 ≤ P(A) ≤ 1`)
- `P(A) = 1` if `A = S`
- P(A) = 0 if `A = ∅`

## Mutually Exclusive
- The events `A` and `B` are said to be mutually exclusive if they have no outcomes in common.
	- Or in set terms, `∀x,y x∈A, x∉B y∈B, y∉A`
- In mutually exclusive events, the probabilities can be added together in the *addition rule.*

### The Addition Rule

If *A* and *B* are mutually exclusive events, then `P(A∪B) = P(A) + P(B)`. This rule can be generalized to cover the case where *A* and *B* are not mutually exclusive.

### Examples

- Toss a coin 3 times, what are the chances of getting 2 heads.

		First, find cardinality of the sample space. n(S) = 2³ = 8
		Next, define your A. (Let A be getting 2 heads.)
		Next, find the cardinality of A. (A = 3)
		P(A) = n(A)/n(S) = 3/8

- Toss a coin and roll a dice, what's the chance of getting head or an even number?

		First, find the cardinality of the sample space. n(S) = 2 * 6 = 12
		Next, define A. (Let A be a Head) A = {(H,1), (H,2), ... , (H,6)}
		Define B since we have B. (Let B be getting a even number) 
		B = {(H,2), (H,4), (H,6), (T,2), (T,4), (T,6)}
		A = 6, B = 6. Find A ∪ B... A ∪ B = 9.
		P(A ∪ B) = n(A ∪ B)/n(S) = 9/12

---

### The Axiom of Probability

1. Let *S* be the sample space. Then, P(S) = 1.
2. Let any event `A`, `0 ≤ P(A) ≤ 1`
3. If A and B are mutually exclusive events, then P(A ∪ B) = P(A) + P(B).  
More generally, if A1, A2, . . . are mutually exclusive events, then  
P(A1 ∪ A2 ∪ · · ·) = P(A1) + P(A2) + · · *([Addition Rule](../cog-decision/probability#addition-rule))*

### Probability of NOT Problems

- The sample space `S` is just `A ∪ A'`

$$n(S) = \frac{n(A) + n(A')}{n(S)}$$

- So, `1 = P(A) + P(A')`

#### Example

- Toss a coin 8 times, what's the chance to get 5 heads.

		n(S) = 2⁸
		Let A be getting 5 heads. n(A) = ₈C₅
		P(A) = (₈C₅)/2⁸

---

**More practice**

Six hundred paving stones were examined for cracks, and 15 were found to be cracked. The same 600 stones were examined for discoloration and 27 were found to be discolored. A total of 562 stones were neither. One of these 600 stones was selected at random.

	a. Find the prboability that it is cracked, discolored , or both. P(A ∪ B)
	n(A) = 15, n(B) = 27, n(A∪B) = 38
	P(A∪B) = 38/600
	b. Find the probability that it is both cracked and discolored. P(A∩B)
	n(A) + n(B) - n(A∩B) = n(A∩B) = 15 + 27 - 38 = 4
	P(A∩B) = 4/600
	c. Find the probability that it is cracked but not discolored.
	n(A) = 15, n(A∩B) = 4
	P(A∩B') = 15-4/600

### Conditional Probability
- Finding the probability of an event `A`, knowing that the event `B` has already occurred. 

**Formal Definition:** Let `A` and `B` be events with `P(B) ≠ 0`. The conditional probability of `A` *given* `B` is:

$$P(A|B) = \frac{P(A ∩ B)}{P(B)} = \frac{P(A and B)}{P(A)}$$

#### Example
- Toss a coin 3 times, given that we get 2 heads, what is the chance that we got heads on our second toss?
	- P(B) = probability of getting 2 heads. 3
	- P(A|B) = P(A∩B)/P(B) = n(A∩B)/n(B) = 2/3

### Independence
- Two events `A` and `B` are **independent** if the probability of each event remains the same whether or not the pother occurs.
	- *In symbols*: If P(A) ≠ 0 and P(B) ≠ 0, then `A` and `B` are independent if `P(B|A)=P(B)`, or equivalently, `P(A|B)=P(A)`.
- That means, neither event has an impact on the other.

### More Practice
- Of people that bought new vehicle, 12% bought hybrid vehicle, 5% bought hybrid truck. Given that a person bought a hybrid vehicle, what is the probability that it was a truck.
	- 5/12 (TODO: Find out why)

- A system contains 2 components A and B that need to function for the system to work. The probability that component A fails is 0.08 and that B fails is 0.05. They operate independently. What is the probability that the system will work?
	- A' = 0.92, B' = 0.95
	- P(System functions) = P(A functions and B functions) = P(A'∩B')
	- Since they are independent, 0.92 ✕ 0.95 = **0.874**

#todo go to mathematical ideas book, they have good stuff on conditional probability

## Bayes Theorem

- You know you are using [**Bayes Theorem**](../cog-decision/probability#bayes-theorem), if you are given P(B|A) and are asked to find P(A|B).

Because we are given P(A|B)... $$P(B|A) = \frac{P(A∩B)}{P(A)}, P(A∩B) = P(A|B)*P(A)$$

Then, plug it into P(A|B)... $$P(B|A) = \frac{P(A∩B)}{P(B)}= \frac{P(A|B)*P(A)}{P(B)}$$
**This is the basics of Bayes Theorem**

#todo draw a chart for bayes theorem and try the questions

---

### Practice Problems

47. Find the probability that the first card is a jack and the second card is a face card. (No replacement)

		A - Jack card
		B - Face card
		P(A ∩ B) = P(A) * P(B | A) (Since it is asking "and" it is A∩B)
		P(A) = n(A)/n(S) = 12/52
		P(B | A) = n(B-1)/n(S-1) = 11/51
		4/52 * 11/51

46. No face cards.

		A - No face card on first draw
		B - No face card on second draw
		P(A ∩ B) = P(A) * P(B | A)
		P(A) = n(A)/n(S) = 40/52
		P(B | A) = 39/51
		P(A ∩ B) = 40/52 * 39/51

67. 3 men, 3 women are getting interview. Probability of all women get interview first.

		A = woman go first, B = woman go second, C = Woman go third
		P(A and B and C) = P(A) * P(B | A) * P(C | (A and B)) = 3/6 * 2/5 * 1/4

---

## Odds

- If all outcomes in a sample space are equally likely, `a` of them are favorable to the event `E`, and the remaining outcomes are unfavorable to `E`, then the **odds in favor of `E`** are *a to b*, and the **odds against `E`** are *b to a*.
	- Ex: # of girls to # of boys in the class is 2 to 5. (2+5 is our sample space)
	- `P(Girl) = 2/7`
	- The odds against Girls are going to be 5 to 2.

**More Examples:**

- 30% chance to have rain. (A)
	- This means there's a 70% chance of no rain. (A')
	- So, the odds in favor of A is going to be 30 to 70, or 3 to 7. (*3 is favorable, 7 is not*)
	- Odds against A will be 7 to 3.

---

## Bayes Theorem Cont.

### Bayes' Rule

**Special Case:** Let A and B be events with P(A) ≠ 0, P(¬A) ≠ 0, and P(B) ≠ 0. Then... $$P(A|B) = \frac{P(B|A)*P(A)}{P(B|A)*P(A) + P(B|¬A)*P(¬A)}$$

Example Practice:

	P(D) = 0.005
	P(+ | D) = 0.99
	P(+ | ¬D) = 0.01
	P(D | +) = (P(+|D) * P(D))/(P(+|D) * P(D) + P(+ | ¬D) * P(¬D)) = (0.99 * 0.005)/(0.99 * 0.005 + 0.01 * 0.995)

Another One: 2.25 Math Ideas

	P(S) = 0.45, P(M) = 0.35, P(L) = 0.2
	P(F | S) = 0.1, P(F | M) = 0.12, P(F | L) = 0.15
	P(F) = P(F|S) * P(S) + P(F | M) * P(M) + P(F | L) * P(L) = 0.45 * 0.1 + 0.35 * 0.12 + 0.2 * 0.15

Page 85 (William Navidi)

### Random Variable
- A function that assigns a numerical value to each outcome in a sample space.

> In real life, the probabilities of things that should be set, such as tossing a coin, are actually slightly skewed. (Not exactly 50/50) However, the more you toss, the more that total probability should approach 0.5.

#### Discrete Random Variable
- The domain of these are the discrete set of numbers.
- *Discrete*: There is a gap between every set of numbers.
	- Counting numbers, natural numbers

> **Formal Definition:** A random variable is **discrete** if its possible values form a discrete set. This  means that if the possible values are arranged in order... (William Navidi)

#### Continuous Random Variable
- The domain of these are a continuous set of numbers.
- *Continuous*: There is no gap between the numbers.
	- Real numbers

#### Example
- Toss a coin 10 times. X: # of heads.
	- Your X can get a value from 0-10. ← This is a random variable.

### Probability Mass Function
- The **probability mass function** of a discrete random variable `X` is the function `p(x)=P(X = x)`. The probability mass function is sometimes called the **probability distribution**.

Find the probability mass function of the number of heads when tossing a coin 3 times.

	Let X: # of heads, This means X can take the values of {0, 1, ,2, 3}
	So, to find the probability mass function, calculate the probalities for each of the random variables.
	P(X=0) = 1/8, P(X=1) = 3/8, P(X=2) = 3/8, P(X=3) = 1/8
	Then, draw it into a table.

| x   | P(X=x) |     |
| :-- | :----- | --- |
| 0   | 1/8    |     |
| 1   | 3/8    |     |
| 2   | 3/8    |     |
| 3   | 1/8    |     |

$$\sum_{x=0}^{S}P(X=x_{i})=1$$

---

For questions like "*probability of more than 2 heads...*"

- Using the PMF, P(X ≥ 2) = P(X=2) + P(X=3) + ...

For questions like "*probability of less than 2 heads...*"

- P(X ≤ 2) = P(X=2) + P(X=1) + P(X=0)

---

#### Summary

Let X be a discrete random variable. Then...

- The probability mass function of `X` is the function `p(X) = P(X=x)`
- The cumulative distribution function of X is the function `F(X)=P(X≤x)`
	- The sum of the Probability mass function up to and including the value of x.
- $F(x)=\sum_{t≤x}p(t)=\sum_{t≤x}P(X=t)$
- ??? Navidi book

---

##### Practice

Computer chips often contains surface imperfections. The PMF of the number of defects X is presented in the following table.

| x    | 0   | 1   | 2    | 3   | 4    |     |
| :--- | :-- | :-- | :--- | :-- | :--- | --- |
| p(X) | 0.4 | 0.3 | 0.15 | 0.1 | 0.05 |     |

1. Find P(X≤2)
	- P(X=0) + P(X=1) + P(X=2) = 0.85
2. Find P(X>1)
	- P(X>1) = 1 - P(X≤1) = 1 - 0.7 = 0.3

William Navidi Book 112 #7 #todo try it

## Expected Value

Let `X` be a discrete random variable with probability mass function given by `p(x) = P(X = x)`. The mean of `X` is given by:

$$\mu_{x}= \sum_{x}x*P(X=x)$$
where the sum is over all possible values of X.

- The mean of `X` is sometimes called the expectation, or *expected value* of `X` and may be denoted as `E(X)` or by μ.

> **This can also be referred to:** A long term average of Discrete Random Variable `X`.

- This is typically used in gambling to show that when gambling, when you gamble a lot, you will always lose money.

> **Problem Solving For E(X)**:

- Define the sample space
- Define the Random variable.
- Determine the values of the random variable.
- Find the probability mass function for each.
- Substitute all values in E(x) formula.

##### Example

Find the expected number of boys for a three child family. Assume girls and boys are equally likely.

	n(S) = 2⁸
	Let X = # of boys
	X = 0,1,2,3
	x|P(X)
	0|1/8
	1|3/8
	2|3/8
	3|1/8
	E(X) = 0(1/8) + 1(3/8) + 2(3/8) + 3(1/8) = 1.5

A player pays $3 to play the following game. he tosses three fair coins and receives back "payoffs" of $1 if he tosses no heads, $2 for one head, $3 for two heads, and $4 for three heads. Find the player's expected net winnings for this game.

	n(S) = 2⁸
	What I pay: (Loss value) -$3
	What I earn: Whatever I get back from the coin toss.
	Let X = The net winning value
	X = 0, 1, 2, 3
	x|P(X=x)
	-$2|1/8
	-$1|3/8
	+$0|3/8
	+$1|1/8
	E(X) = -2(1/8) + -1(3/8) + 0(3/8) + 1(1/8) = -4/8 = -$0.5

> **Note**: Define your Random variable as whatever the question is asking, in this case, *net earnings*, but use the P(X) from the heads or tails that corresponds.

### Variance

Let X be a discrete random variable with probability mass function `p(x) = P(X=x)`. Then...

- The variance in `X` is given by:
$$\sigma_{x}^{2}=\sum\limits_{x}(x-μ_x)^2P(X=x)$$
- An alternate formula is given by:
$$\sigma_{x}^{2}=\sum\limits_{x}x^{2}P(X=x)-μ_{x}^{2}$$
- Then, you can simplify it even more using expected value...
	- Since, $E(x)= \sum_{x}x*P(X=x)$, then, $E(x^2)= \sum_{x}x^{2}*P(X=x)$...
- So the equation can just become:
$$\sigma_{x}^{2}=E(x^{2})-E(x)^2$$

##### Example

Rolling single fair dice. Even number means u receive as much money as there are spots up, odd means you pay that amount.

	Find the epxected net winnings of this game.
	n(S) = 6
	Let x be the net winnings.
	x | P(X=x)

A certain game involves tossing 3 fair coins, and it pays 10¢ for 3 heads, 5¢ for 2 heads, and 3¢ for 1 head. Is 5¢ a fair price to pay to play this game? That is, does the 5¢ cost to play make the game fair?

