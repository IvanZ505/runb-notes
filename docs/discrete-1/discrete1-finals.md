# Discrete Structures I: Finals Review

## Finals Notes

**DECEMBER 20TH, 2023 FROM 8-11PM**

### Exam Breakdown

- **30%** - Multiple choice questions from before the midterm, including topics such as **Foundations of Logic and Proofs**, **Sets, Functions and Sequences**, and **Induction**.
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

## Induction

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

## Number Theory

## Relations
