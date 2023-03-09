Introduction to Discrete Structures 1
===

Propositional Logic
---
The Foundation for Writing Proofs:

Axioms
- Are statements that can be used without any proof.
- 
Propositions
- are a statement that can be either true or false.
- They can be verified using axioms.
- Propositions do  not contain variables that need to be defined.

Propositional Logic is what we use to determine the truth of a proposition.


Which of these are propositions?
1. Please do your homework - Not a proposition (It is a imperative)
2. Sky is blue - Proposition
3. If it rains, roads will be wet - Proposition
4. If pigs fly, then your account won't get hacked - Proposition
5. If all humans are mortal and all Greeks are human, then all Greeks are mortal. - Proposition
6. Are you interested in CS 205? - Not a Proposition

---

Atomic and Compound Propositions
- A single proposition may be represented as a propositional variable.
- An atomic proposition is a single proposition.
- A compound proposition is one that combines atomic propositions using logical operators. (Such as "and" or "^" in symbols)

---

Negation of a Proposition
1. n >= 1 ---> negation ---> n < 1
2. n >= 1 and n is prime ---> negation ---> n is less than 1 and is not prime

---

Three Logicians walk into a bar.

The bartender asks if they want a drink.

The first logician says "I dont know."

The second logician says "I dont know."

The third logician says "Yes."

---

**Logical Operators**:

**AND**: "^"

**Logical Operator: OR**: "v"

- Logical or is also called disjunction.


**Exclusive Or**: "⊕"

**NEGATION**: "¬"

- Ovserve either a proposition is true or false and swaps it.


---

Truth Tables for the following propositional statements, where p,q,r are propositions.

1. (P ^ Q) v r

| p | q | (p ^ q) |
|---|---|---------|  
| T | T |    T    |
| T | F |    F    |
| F | T |    F    |
| F | F |    F    |


---


Satisfiability
- A compound proposition is satisfiable if and only if there exists at least one assignment to the propositional variables that makes the entire proposition true.
- In a truth table this is a line that is true.
- For example, exclusive OR had two such assignments.


More Satisfiability
- p v negation p is always going to evaluate to True as either p itself is true, or the negation of p is true.
- p ^ negation p is always going to evaluate to False as a statement can not be both true and false.

Examples:
1. ¬p v ( p ^ q ) This is  satisfiable.
2. ( p v q ) ^ ¬p ^ ¬q ---> This is not satisfiable.


---

**Consistency**:
- A set of compound propositions are consistent if there exists truth assignments such that all propositions are satisfied at the same time.
- First, we will show how two compound propositions using the atomic propositions p and q, are consistent.
- Then we will introduce a third proposition to show when they are no longer consistent.


| p | q | p v q | p v ¬q | ¬p |
|---|---|-------|--------|----|
| T | T | T     | T      | F  |
| T | F | T     | T      | F  |
| F | T | T     | F      | T  |
| F | F | F     | T      | T  |


---

Is the following set of statements consistent?

	Statement 1: p ^ q
	Statement 2: p v ¬q 
	Statement 3: ¬q 
| p | q | p^q | p v ¬q | ¬q |
|---|---|-----|--------|----|
| T | T | T   | T      | F  |
| T | F | F   | T      | T  |
| F | T | F   | F      | F  |
| F | F | F   | T      | T  |

Not consistent.

---

**Implications**:
- An implication is a compound proposition using propositions, p and q, stated as if p then q or p implies q.
- p is called the premise or sufficient condition for q.
- q is called the conclusion mor necessary condition for q.

| p | q | p => q |
|---|---|--------|
| T | T | T      |
| T | F | F      |
| F | T | T      |
| F | F | T      |

**Implication: Converse**
- Give an implication p, implies q, the converse is q implies p.
- If an implication is true, its converse does not need to be true.
- Let's consider the following truth table:

	- Example: Let x and y be real numbers with y not equal to zero.
         - p = "x is rational and y is rational"
         - ¬p = "x is not rational, or y is not rational."
         - q = "x/y is rational."
         - ¬q = "x/y is not rational."

| p | q | p => q | ¬p => ¬q |
|---|---|--------|----------|
| T | T | T      | T        |
| T | F | F      | T        |
| F | T | T      | F        |
| F | F | T      | T        |

**Implication: Inverse**
- Give an implication, p implies q, the inverse is not p implies not q.
- If an implication is true, its inverse need not be true.
- However, if the converse of an implication is true, than the inverse is true and vice versa.

| p | q | p => q | ¬p => ¬q |
|---|---|--------|----------|
| T | T | T      | T        |
| T | F | F      | T        |
| F | T | T      | F        |
| F | F | T      | T        |

Recitation 1
---

Proposition Statements

1) p ^ (q v r)


| p | q | r | q v r | p ^ (q v r) |
|---|---|---|-------|-------------|
| F | F | F | F     | F           |
| F | F | T | T     | F           |
| F | T | F | T     | F           |
| T | F | F | F     | F           |
| F | T | T | T     | F           |
| T | F | T | T     | T           |
| T | T | F | T     | T           |
| T | T | T | T     | T           |

Question: Given integer n, write all possible assigments from a(1) to a(n).

	For n=1:

	a(1) is: T/F

	For n=2:

	Write a(n-1) twice: <br>
	a(2) is: <br>
	T(from a(1)) - F
	F(from a(1))- F
	T(from a(1))- T
	F(from a(1))- T

2) (p ^ q) v (p ^ r)

| p | q | r | p ^ q | p ^ r | (p ^ q) v (p ^ r) |
|---|---|---|-------|-------|-------------------|
| T | T | T | T     | T     | T                 |
| T | T | F | T     | F     | T                 |
| T | F | T | F     | T     | T                 |
| T | F | F | F     | F     | F                 |
| F | T | T | F     | F     | F                 |
| F | T | F | F     | F     | F                 |
| F | F | T | F     | F     | F                 |
| F | F | F | F     | F     | F                 |

**Proposition hunt**:

	P: You get an A in finals.
	Q: You do every exercise in the textbook.
	R: You get an A in the class.

	a) You get A in class (R), but you do not do every exercise in textbook. (¬Q)
		R ^ ¬Q
	b) You get A on the finals, you do every exercise in textbook, and you get A in class.
		P ^ Q ^ R
	c) To get a A in class, it is necessary to get an A on finals.
		R -> P
	d) You get a A on final, but you don't do every exercise in the textbook, nevertheless, you get A in class.
		P ^ ¬Q ^ R

Applications of Propositions
---

### Biconditional Implications: If and only if
- p <=> q is the bicondition implication between p and q.
- Biconditional implication is true only if an implication and it's converse are both true. (So, if p implies q and q also implies p)

| p | q | p <=> q |
|---|---|---------|
| T | T | T       |
| T | F | F       |
| F | T | F       |
| F | F | T       |

#### Examples:

Convert the following statements to logical propositions.

1. Roads will be wet, if it rains.

	q => p

2. students will pass the exam if he studies tonight.

	q => p

3. you can only pass the exam if you study tonight. **hard**

	| p | q | Statement |
	|---|---|-----------|
	| T | T | T         |
	| T | F | F         |
	| F | T | T         |
	| F | F | T         |

	p => q


4. It is below freezing and snowing.

	p ^ q

5. It is either below freezing or snowing, but not both.

	p ⊕ q

6. I will go to class if I feel like it.

	p => q

	| p | q | statement |
	|---|---|-----------|
	| T | T | T         |
	| T | F | F         |
	| F | T | T         |
	| F | F | T         |

#### More complex example

Convert the following statement:

	You can access internet from campus only if you are a computer science major or you are not a freshman.

	p => q v ¬r

#### Even more examples

Are these system specifications consistent?
- When the system software is being upgraded (p), users can not access the file system (¬p). (p -> ¬q)


| p | q | r | p -> ¬q | q -> r | ¬r -> ¬p |
|---|---|---|---------|--------|----------|
| T | T | T | F       | T      | T        |
| T | T | F | F       | F      | T        |
| T | F | T | T       | T      | T        |
| T | F | F | T       | T      | F        |
| F | F | F | T       | T      | T        |
| F | T | T | T       | T      | T        |
| F | T | F | T       | F      | T        |
| F | F | T | T       | T      | T        |


