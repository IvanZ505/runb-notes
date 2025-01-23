# Discrete Structures I: Finals Review

## Finals Notes

**DECEMBER 20TH, 2023 FROM 8-11PM**

### Exam Breakdown

- **30%** - Multiple choice questions from before the midterm, including topics such as **Foundations of Logic and Proofs**, **Sets, Functions and Sequences**.
- **70%** - Will be on everything after the midterm, including **Modeling Computations**, **Boolean Functions**, **Number Theory**, and **Relations**. **Also includes Induction!!!**

### What is Allow
- One cheat sheet, double sided...
- Nothing else :(

### Important Topics (TAs showed)
- Prepositions, axioms, quantifiers, compound propositions, truth tables, Russell's paradox
- Cardinality, equivalence relations, partitions, countable and uncountable  sets
- 1-1 and onto functions, domain and range
- **Induction**
- **Grammar** (4 Types of grammar)


---

## Foundations of Logic and Proofs

### Propositional Logic
- **Axioms:** Statements that are assumed to be true.
- **Propositions:** Statements that are either true or false.
  - Propositions are divided into either **atomic** or **compound** propositions.

### Logical Connectives

(In order of precedence)

| Name          | Symbol | Meaning        |
| ------------- | ------ | -------------- |
| Negation      | ¬      | Not            |
| Conjunction   | ∧      | And            |
| Disjunction   | v      | Or             |
| Implication   | →      | Implies        |
| Biconditional | ⟺      | if and only if |

    As a general rule, (∧, v) are associative and commutative, while (→, ⟺) are not.

### Logic Gates
![](imgs/logic-gates.png)

### Consistency and Satisfiability
- **Consistency:** A set of propositions is consistent if there exists an assignment of truth values to the propositions that makes all of them true.
- **Satisfiability:** A set of propositions is satisfiable if there exists an assignment of truth values to the propositions that makes at least one of them true.

### Propositional Equivalences
- **Tautology:** A compound proposition that is always true, regardless of the truth values of the propositions it contains.
- **Contradiction:** A compound proposition that is always false.
- **Contingency:** A statement that's neither a contradiction or a tautology.

### Logical Equivalences
- **Logical Equivalence:** Two compound propositions are logically equivalent if they have the same truth values for all possible truth values of their propositional variables.

![Logical Equivalences](imgs/logical-equivalences.png)

### Predicates
- A predicate is a proposition whose truth depends on the value of one or more variables.
  - Example: *Let P(x) denote `x>0` and the domain ℤ.*
    - P(1) is true, P(0) is false.
- You can add multiple variables to a predicate.
  - Example: *Let Q(x,y) denote `x+y=0` and the domain ℤ.*
    - Q(1,-1) is true, Q(1,1) is false.

### Quantifiers
- Quantifiers express the truth of a proposition over a domain.

- **Universal Quantifier: (∀)** For *all* x, P(x) is true in the domain.
- **Existential Quantifier: (∃)** There *exists* an x such that P(x) is true in the domain.

*Side node*: Uniqueness Quantifier (∃!) means there exists exactly one.

    DeMorgan's Law applies to quantifiers as well.

#### Nested Quantifiers
- Nested quantifiers are quantifiers that are nested inside each other.
  - Example: *Let P(x,y) denote `x+y=0` and the domain ℤ.*
    - ∀x∃yP(x,y) basically can be written as ∀x Q(x) where Q(x) is ∃yP(x,y).

#### Quantifiers with Restrictive Domains:
- Using an abbreviated notation, we can still express a condition the variable must satisfy to be included in the quantifier.

#### Quantifiers Precdence:
- Quantifiers have higher logical precedence than logical connectives.

#### Rules of Inference
![](imgs/rules-of-inference.png)


## Sets, Functions and Sequences

### Sets

> A set is just a list of numbers grouped together. **A smaller list** of this set that still contains the set is called a **proper subset** of the set. Otherwise, any set that is smaller than, or equal to, the original set can still be considered a **subset** of the set.

#### Ordered Pairs
- An ordered pair is a pair of objects in a specific order.
- For example:
  - `(1, 2)` is an ordered pair.
  - `(2, 1)` is a different ordered pair.

**Combining the two:**

- You can have a set of ordered pairs as such: A = {(1,2), (2,3), (3,4)}

#### Cartesian Product
- The cartesian product of two sets, denoted by `A x B` is the set of all ordered pair combinations between the two sets.

**Example:**

	A = {(1, 2, 3, 4} and B = {9, 8, 7, 6}
	Then, A x B = {(1,9), (1,8), (1,7), (1,6), (2,9), (2,8), ...}

#### Set Builder Notation vs Set Roster Notation
- Set roster notation is a way to describe a set by listing the elements of the set. `{0, 2, 4, ...}` -> The ... means that the set goes on forever.
- Set builder notation is a way to describe a set by listing the properties that its members must satisfy.
- For example, the set of all even integers can be described as `{x | x = 2k for some k ∈ ℤ}`.

#### Set Operations
- Unions (⋃) : Is basically a massive "or" sign. It's the set of all elements that are in either set.
- Intersection (⋂) : Is basically a massive "and" sign. It's the set of all elements that are in both sets.

![Set Operations](imgs/set-operations-venn-diagrams.png)

### The Size and Cardinality of a Set

**For any set**:
- The set can be finite (n number of elements)
- Countably infinite (it can be ennumerated) : ℕ, ℕ⁺, ℤ, ℚ
- Uncountably infinite (it can not be ennumerated) : ℝ, ℝ⁺, ℝ-ℚ (set of Irrational numbers)

## Induction

Mathematical induction requires multiple steps as a proof. 

1. Establishing a single case of the proof working using numbers. (**base case**)
2. Then establish that case as a *abstract variable* `k`.
3. Next, prove that `k+1` holds true. If this holds true, then by mathematical induction, your proof is true.

**Differences between Strong and Weak Induction**
- The steps above only work for **weak induction.**
- For strong induction, you establish that every single case from the base case to `k` is true. Then, you can use this to prove `k+1`.

## Modeling Computations

### Grammar

There are **4 types of grammar**:
- **Type 0: Unrestricted (Turing Machines)**
	- Know how to make a symbol table
- Type 1: Context Sensitive
- **Context-free Grammar**
	- S → ASA, A→SA... blah blah blah... that thing
- FSA

#### Phase-Structure Grammar

A *phase-structure grammar* `G=(V, T, S, P)` consists of a vocabulary `V`, a subset `T` of `V`, consisting of terminal symbols, a start symbol `S` from `V`, and a finite set of productions, `P`. The set `V-T` is denoted by `N`. Elements of `N` are called *nonterminal symbols*. Every production in `P` must contain at least one nonterminal symbol.

**Example:** Construct a phase structure grammar {0ⁿ1²ⁿ | n ≥ 0}

	V = {0 ,1}
	T = {0 ,1}
	S = {S}
	P = {S → 0S11 | λ}

### Regular Expressions
- (\*) → 0 or more repetitions of the letter preceding.
- ( | ) → OR sign

**Example:** Create a Regex expression that accepts all octal numbers that are divisible by 8.

	(1-7)\*0

### DFA, NFA
- NFAs are usually for your head because it is really hard for a computer to work through all the different possible paths.

### Turing Machines


## Boolean Functions

Boolean Operators:
- Boolean sum (+)

| +   | 0   | 1   |
| --- | --- | --- |
| 0   | 0   | 1   |
| 1   | 1   | 1   |
- Boolean Product (.)

| .   | 0   | 1   |
| --- | --- | --- |
| 0   | 0   | 0   |
| 1   | 0   | 1   |
- Complement (bar ~)

| ~   | 0   | 1   |
| --- | --- | --- |
|     | 1   | 0   |

### Boolean Expressions and Functions

- Let `B = {0, 1}. Then, Bⁿ = {(x₁, x₂, x₃, ..., xₙ) | xᵢ ∈ B for 1 ≤ i ≤ n}` is the set of all possible n-tuples of 0s and 1s.
    
- The variable `x` is called a _boolean variable_ if it assumes values only from **B**. That is, if its possible values are 0 and 1.
    
    - A function that maps _Bⁿ to B_ is called a _Boolean function of degree n_.

## Number Theory

Number theory is the mathematics devoted to the study of the set of integers and their properties.

### Divisibility Of Integers

Divisbility is noted by `a | b` which means that `a` divides `b`. This means that `b = ak` for some integer `k`.

Additive Inverse:

- For any a, there exists a b such that a + b = 0 (mod m).
- In this case, the b is the additive inverse of a.

Multiplicative Inverse:

- For any 𝑎 relatively prime to 𝑚 where gcd(𝑎, 𝑚) = 1, there exists a 𝑏 such that 𝑎𝑏 = 1 (𝑚𝑜𝑑 𝑚)
- In this case, the b is called the multiplicative inverse of a and vice versa.


### Congruence Classes

Let `a` and `b` be integers and `m` a positive integer. We say that `a` is congruent to `b` modulo `m` if `m | (a-b)`. We write `a ≡ b (mod m)`.

This means, `a` and `b` have the same remainder when divided by `m`.

> This can be used to find the modulus of an extremely large number!

**Example**:

    (8)⁸ % 7 = (1)⁸ % 7 = 1

## Relations

Relations are defined on a *non-empty set* **A** to *non-empty set* **B** such that the relation from **A** to **B** is a subset of Cartesian Product of **A** and **B**.

#### Matrix Representation of A relation

- We are able to use a “boolean” table (_M_) where the rows are labeled with the elements of the first set (A in our case) and the columns are labeled with the elements of the second set (B). A in position _i, j_ of the matrix means that the element _i_ ϵ A is related to element _j_ ϵ B. In the case of our example… 

![](imgs/relations-matrix.png)

#### Cardinality of Relations

The cardinality of a relationship is total number of possible relations is defined as the **power set** of the **cartesian product**. 

> *Hint:* The cartesian product results in a cardinality of |A| \* |B|
> Then, the power-set of that has a cardinality of 2ⁿ.

