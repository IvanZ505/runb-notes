Introduction to Discrete Structures 1
===

### Table of Contents
- [Propositional Logic](#propositional-logic)

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

**IMPLICATION**: -->

**BICONDITIONAL**: <-->


---

Truth Tables for the following propositional statements, where p,q,r are propositions.

1. (P ^ Q) v r

| p   | q   | (p ^ q) |
| --- | --- | ------- |
| T   | T   | T       |
| T   | F   | F       |
| F   | T   | F       |
| F   | F   | F       |


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


| p   | q   | p v q | p v ¬q | ¬p  |
| --- | --- | ----- | ------ | --- |
| T   | T   | T     | T      | F   |
| T   | F   | T     | T      | F   |
| F   | T   | T     | F      | T   |
| F   | F   | F     | T      | T   |


---

Is the following set of statements consistent?

	Statement 1: p ^ q
	Statement 2: p v ¬q 
	Statement 3: ¬q 
| p   | q   | p^q | p v ¬q | ¬q  |
| --- | --- | --- | ------ | --- |
| T   | T   | T   | T      | F   |
| T   | F   | F   | T      | T   |
| F   | T   | F   | F      | F   |
| F   | F   | F   | T      | T   |

Not consistent.

---

**Implications**:
- An implication is a compound proposition using propositions, p and q, stated as if p then q or p implies q.
- p is called the premise or sufficient condition for q.
- q is called the conclusion for necessary condition : p.
- This means that if p is true, q HAS to be true.
- However, if p is not true, q can STILL be true.

| p   | q   | p => q |
| --- | --- | ------ |
| T   | T   | T      |
| T   | F   | F      |
| F   | T   | T      |
| F   | F   | T      |

**Implication: Converse**
- Give an implication p, implies q, the converse is q implies p.
- If an implication is true, its converse does not need to be true.

| p   | q   | p => q | q => p |
| --- | --- | ------ | ------ |
| T   | T   | T      | T      |
| T   | F   | F      | F      |
| F   | T   | T      | T      |
| F   | F   | T      | T      |
|     |     |        |        |
- Let's consider the following truth table:

	- Example: Let x and y be real numbers with y not equal to zero.
         - p = "x is rational and y is rational"
         - ¬p = "x is not rational, or y is not rational."
         - q = "x/y is rational."
         - ¬q = "x/y is not rational."

| p   | q   | p => q | ¬p => ¬q |
| --- | --- | ------ | -------- |
| T   | T   | T      | T        |
| T   | F   | F      | T        |
| F   | T   | T      | F        |
| F   | F   | T      | T        |

**Implication: Inverse**
- Give an implication, p implies q, the inverse is not p implies not q.
- If an implication is true, its inverse need not be true.
- However, if the converse of an implication is true, than the inverse is true and vice versa.

| p   | q   | p => q | ¬p => ¬q |
| --- | --- | ------ | -------- |
| T   | T   | T      | T        |
| T   | F   | F      | T        |
| F   | T   | T      | F        |
| F   | F   | T      | T        |

**Implication: Contrapositive**
- Give an implication p implies q, the **contrapositive** is not q implies not p.
- If an implication is true, its contrapositive is true and vice versa.
- This can be used in prove by contraposition.

Recitation 1
---

Proposition Statements

1) p ^ (q v r)


| p   | q   | r   | q v r | p ^ (q v r) |
| --- | --- | --- | ----- | ----------- |
| F   | F   | F   | F     | F           |
| F   | F   | T   | T     | F           |
| F   | T   | F   | T     | F           |
| T   | F   | F   | F     | F           |
| F   | T   | T   | T     | F           |
| T   | F   | T   | T     | T           |
| T   | T   | F   | T     | T           |
| T   | T   | T   | T     | T           |

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

| p   | q   | r   | p ^ q | p ^ r | (p ^ q) v (p ^ r) |
| --- | --- | --- | ----- | ----- | ----------------- |
| T   | T   | T   | T     | T     | T                 |
| T   | T   | F   | T     | F     | T                 |
| T   | F   | T   | F     | T     | T                 |
| T   | F   | F   | F     | F     | F                 |
| F   | T   | T   | F     | F     | F                 |
| F   | T   | F   | F     | F     | F                 |
| F   | F   | T   | F     | F     | F                 |
| F   | F   | F   | F     | F     | F                 |

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

Exercise: There are three students in a class (A, B, C) each can vote YES or NO on an issue. Create a truth table for the boolean function which takes as an input the votes and returns whether or not an even number of votes was casted.

(¬A ^ B ^ C) v (¬A ^ ¬B ^ ¬C) v (A ^ ¬B ^ C) v (A ^ B ^ ¬C)

or the better one:

¬((A ⊕ B ⊕ C) v (A ^ B ^ C))

	Why is this better?
	This is a better answer because with the ex-or you can just count the number of trues and falses and if the number of trues is even, then the result is true. 
	
	The ex-ors will return true if there are exactly 1 Yes. The other side will give a true if there are exactly 3 yes. Then, the negation outside cancels it out, making the statement return false, which is what we want.

| A   | B   | C   | A ^ B ^ ¬C | A ^ ¬B ^ C | ¬A ^ B ^ C | ¬A ^ ¬B ^ ¬C |
| --- | --- | --- | ---------- | ---------- | ---------- | ------------ |
| T   | T   | T   | F          | F          | F          | F            |
| T   | T   | F   | T          | F          | F          | F            |
| T   | F   | T   | F          | T          | F          | F            |
| T   | F   | F   | F          | F          | F          | F            |
| F   | T   | T   | F          | F          | T          | F            |
| F   | T   | F   | F          | F          | F          | F            |
| F   | F   | T   | F          | F          | F          | F            |
| F   | F   | F   | F          | F          | F          | T            |

----

Applications of Propositions
---

### Biconditional Implications: If and only if
- p <=> q is the bicondition implication between p and q.
- Biconditional implication is true only if an implication and it's converse are both true. (So, if p implies q and q also implies p)

| p   | q   | p <=> q |
| --- | --- | ------- |
| T   | T   | T       |
| T   | F   | F       |
| F   | T   | F       |
| F   | F   | T       |

#### Examples:

Convert the following statements to logical propositions.

1. Roads will be wet, if it rains.

	q => p

2. students will pass the exam if he studies tonight.

	q => p

3. you can only pass the exam if you study tonight. **hard**

	| p   | q   | Statement |
	| --- | --- | --------- |
	| T   | T   | T         |
	| T   | F   | F         |
	| F   | T   | T         |
	| F   | F   | T         |

	p => q


4. It is below freezing and snowing.

	p ^ q

5. It is either below freezing or snowing, but not both.

	p ⊕ q

6. I will go to class if I feel like it.

	p => q

	| p   | q   | statement |
	| --- | --- | --------- |
	| T   | T   | T         |
	| T   | F   | F         |
	| F   | T   | T         |
	| F   | F   | T         |

#### More complex example

Convert the following statement:

	You can access internet from campus only if you are a computer science major or you are not a freshman.

	p => q v ¬r

#### Even more examples

Are these system specifications consistent?
- When the system software is being upgraded (p), users can not access the file system (¬p). (p -> ¬q)


| p   | q   | r   | p -> ¬q | q -> r | ¬r -> ¬p |
| --- | --- | --- | ------- | ------ | -------- |
| T   | T   | T   | F       | T      | T        |
| T   | T   | F   | F       | F      | T        |
| T   | F   | T   | T       | T      | T        |
| T   | F   | F   | T       | T      | F        |
| F   | F   | F   | T       | T      | T        |
| F   | T   | T   | T       | T      | T        |
| F   | T   | F   | T       | F      | T        |
| F   | F   | T   | T       | T      | T        |


| p   | q   | p ^ q | p ^ ¬q | ¬q  |
| --- | --- | ----- | ------ | --- |
| T   | T   | T     | F      | F   |
| T   | F   | F     | T      | T   |
| F   | T   | F     | F      | F   |
| F   | F   | F     | F      | T   |

### Logic Gates
- A logic gate is a big part of computer hardware design.

![Logic Gates](imgs/logic-gates.png)

#### todo  finish this

| p   | q   | s1  | s2  |
| --- | --- | --- | --- |
| 0   | 0   | 0   | 0   |
| 0   | 1   | 0   | 1   |
| 1   | 0   | 0   | 1   |
| 1   | 1   | 1   | 1   |

### Sensor network

Requirement: Assuming there is a 3-sensor network. If 2 or more of the sensors are true, then we must send TRUE to the control station.

Design a logic circuit that meets these requirements.

(¬p ^ q ^ r) v (p ^ ¬q ^ r) v (p ^ q ^ ¬r) v (p ^ q ^ r)

----

---


	There are many ways of saying p => q:
	- If p, then q
	- p implies q
	- p is sufficient for q
	- q is necessary for p
	- q whenever p
	- q if p
	- q when p
	- p only if q
	- q is a sufficient condition for p
	- p is a necessary condition for q
	- q unless ¬p

----
----

#### Convert the following statements to logical propositions.

- Roads will be wet, if it rains.

	q => p

- students will pass the exam if he studies tonight.

	q => p

- you can only pass the exam if you study tonight. (**hard**)

	p => q

- It is below freezing and snowing.

	p ^ q

- It is either below freezing or snowing, but not both.

	p ⊕(exclusive or) q

- I will go to class if I feel like it.

	p => q

----
----

### De Morgan's Laws

- ¬(p ^ q) = ¬p v ¬q
- ¬(p v  q) = ¬p ^ ¬q


### Quiz 1

Covers 3 things: Propositions, Propositional equivalences

### Propositional Equivalences

---
Definitions:

Tautology: A compound proposition that is always true, regardless of the truth values of the propositional variables it contains.

Contradiction: A compound proposition that is always false.

Contingency: A compound proposition that is neither a tautology nor a contradiction.

---

Precedence Rules of Logical Operators:

- **Operator precedence** is an ordering of logical operators designed to allow dropping of the parenthesis in logical expressions.
	1. ¬
	2. ^
	3. v
	4. =>, <=>
	5. ( )

- **Unparenthesized statements** associate the expression with the one with higher precedence.
  - For example, p ^ q v r is equivalent to (p ^ q) v r.
  - p v q ^ r is equivalent to p v (q ^ r).
- All operators are **right associative**. Which means you start putting the parenthesis around the ones furthest to the right.

---

Workshop:

Identify each of the following as tautology, contradiction or contingency.

1. p ^ q ^ ¬p

	Contradiction

2. (p ^ q) v ¬p

	Contingency

3. p => ¬p

	Contingency

| p   | p => ¬p |
| --- | ------- |
| T   | F       |
| F   | T       |

### Logical Equivalence (≡)
- Two compond propositions p and q are logically equivalent if p <=> q is a tautology.

Examples: 

#### p => and ¬p v q are logically equivalent.

| p   | q   | p => q | ¬p v q |
| --- | --- | ------ | ------ |
| T   | T   | T      | T      |
| T   | F   | F      | F      |
| F   | T   | T      | T      |
| F   | F   | T      | T      |

	Notice that these two have the same table.

	This means one can be substituted for the other one.

#### Find a logically equivalent implication to p v ¬q

	How to look at it...

	p => ¬q
	¬(¬p) => ¬q
	and then it becomes
	¬p => ¬q

	Which is the same as:

	q => p

#### Show that p v ¬p => q and q are logically equivalent

Talking way:

	p v ¬p => q
	p v ¬p is a Tautology
	True implies q is always q.

The Proof Way:

	p v ¬p => q ≡ q
	r ≡ p v ¬p
	r => q
	(Math Stuff)
	¬r v q

	Now Take r
	¬r ≡ ¬(p v ¬q)

	(De Morgan's Law)
	≡ ¬p ^ ¬(¬p)
	≡ ¬p ^ p which is F

	Go back to ¬r v q
	Replace ¬r with F.

	F v q which is just q.

## Important MEMORIZE
![Logical Equivalences](imgs/logical-equivalences.png)

Find the negations of the following statements using DeMorgan's Law and/or logical equivalences.

- If it rains roads will be wet.

		p => q
		¬(p => q) ≡ ¬(¬p v q)
		≡ ¬(¬p) ^ ¬q
		≡ p ^ ¬q
		≡ q => p

- You can take CS 205 only if you are a junior

		p => q
		¬(p => q) ≡ ¬(¬p v q)
		≡ ¬(¬p) ^ ¬q
		≡ p ^ ¬q
		≡ q => p

### Proving Propositional Equivalences using Rules

- A method of proof where result is obtained by applying known equivalences.

Show ¬(p => q) and p ^ ¬q are logically equivalent.

	¬(p => q) ≡ ¬(¬p v q)
	≡ ¬(¬p) ^ ¬q
	≡ p ^ ¬q

### Fermats Last Theorem

- While a^2 + b^2 = c^2 can give you infinitely many combinations of a, b, c, you can not find any integers a, b, c such that a^n + b^n = c^n for any n > 5.

----

## Predicates

### What are Predicates and why do we Need them?

---

**When do propositions fail?**

If I say:
- All candy made with chocolates is delicious.
- M&Ms are made with chocolate.

Does it follow that M&M's are delicious?

We are unable to model this relationship with propositions, hence the need for predicates.

---

- A **predicate** is a proposition that depends on some state of its propositional variables.

- Statements involving variables, such as ` x < 2` and `x + y = z` are often found in mathematical assertions, in computer programs and in system specifications. The statements are neither true nor false when the values of the variables aren't specified.

- The statement "x is less than 2" has two parts. First, the variable x is the subject of the statement. The second part, the predicate "is less than 2" refers to the property that the subject of our statement can have. The predicate "is less than 2" can be denoted by P(x), where **P** denotes the predicate and x the variable.

- As you can tell, `P(x)` looks like a function.

#### Propositional Functions
- Propositional functions become propositions (and have truth values) when their variables are each replaced by a value form the domain (or bound by a quantifier).
- The statement `P(x)` is said to be the value of the propositional function *P* at *x*.

**Example**:

Let P(x) denote `x > 0` and the domain (usually denoted with `U`) be integers. Then:

- P(-3) is *false*
- P(0) is *false*
- P(3) is *true*

----

Predicate logic includes:
- Variables : x, y, z, these are the subjects of the statement.
- Predicate : A property that the variables can have. (x is greater than 3)
- Quantifiers : 

Example: Every computer connected to the university network is functioning properly

*is expressed as*

if n is a computer AND n is connected to university network, then n is functioning properly.

P(n) ^ Q(n) => R(n)

	Notation:
	- P(x) is a predicate that involves the propositional variable x.
	- P(x,y) is a predicate that involves the propositional variables x and y.
	- In general, P(x1, x2, ...., xn) is a predicate that involves the propositional variables x1, x2, ...., xn.

---

#### Workshops for Predicates

1. Let P(x) : x >= 3. What are the values of P(4), P(-1), P(10).

	P(4) = T
	P(-1) = F
	P(10) = T

2. Let P(x, y) : "x is a city in state y". Give two examples where P(x,y) is true and false.

	True: P(Chicago, Illinois), P(New York, New York)
	False: P(Chicago, New York), P(New York, Illinois)
	
3. Let `x + y = z` be denoted by *R(x, y, z)* and *U* (for all three variables) be the integers. Find these truth values.

	P(2, -1, 5) is *false*
	P(3, 4, 7) is *true*
	P(x, 3, z) is **not a proposition** because it does not have a singular true or false value.

---

### Compound Expressions
- Connectives from propositional logic carry over to predicate logic.
- So, `P(x)` denotes "x > 0," find these truth values.

	P(3) v P(-1) --> T v F --> T
	P(3) ^ P(-1_ --> T ^ F --> F
	
- Expressions with variables are not propositions and therefore do not have truth values. Ex: `P(3) ^ P(y)`



There are **preconditions** and **post-conditions**.

- Preconditions are the conditions that must be met before the predicate is evaluated.
- Postconditions are the conditions that are evaluated after the predicate is evaluated.

---

Useful domains for predicates:

`N`: The set of natural numbers {0, 1, 2, 3, ...}

`Z`: The set of integers {..., -2, -1, 0, 1, 2, ...}

`Q`: The set of rational numbers {m/n where m and n are integers}

`R`: The set of real numbers

----

Workshop:


	Precondition: Assert(x=a, y=b)
	x=x+y
	y=y-x
	x=x-y
	Postcondition: Assert(x=?, y=?)
	x = 2a+b
	y = -a
	
| x    | y   |
| ---- | --- |
| a+b  | b   |
| a+b  | -a  |
| 2a+b | -a  |

Let the precondition for the code by (x>=0) && y>=0. WHat is a post conditions for the following code?

```Java

int f(int x, int y) {
	int r = 1;
	while(y>1) {
		if(y%2==1) {
			r = x *r;
		} 
		x = x*x;
		y = y/2;
}	
	return r*x;
}

```

| x   | y   | r   |
| --- | --- | --- |
| 2   | 3   | 1   |
| 4   | 1   | 2   |

return 8

## Quantifiers

**Quantifiers** express the truth of a proposition over a domain.

There are two types of quantifiers:
- **Universal Quantifier (∀)**: Expresses the truth of a predicate over an entire domain.

  - A predicate P(x) is true for all x in X.
- **Existential Quantifier (∃)**: Expresses the truth of a predicate for at least one instance.
  - There exists some x, such that P(x) is true. ∃xP(x)
  
| Universal Quantifier                                                   | Existential Quantifier                                                     |
| ---------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| ∀                                                                      | ∃                                                                          |
| "for all"                                                              | "for some"                                                                 |
| When **TRUE**: When P(x) is true for every `x` in the domain.          | When **TRUE**: There is an `x` (any `x`) in the domain where P(x) is true. |
| When **FALSE**: When there is a `x` in the domain where P(x) is false. | When **FALSE**: When P(x) is false for every `x` in the domain.            |
| ∀xP(x) ≡ P(x1) ^ P(x2) ^ ... ^ P(xn) | ∃xP(x) ≡ P(x1) v P(x2) v ... v P(xn) |

---	

### The Uniqueness Quantifier (∃!)
- This quantifier says that there is uniquely **1** value in the domain for which P(x) is true.

---

### DeMorgan's Law for Quantifiers

#### ¬∃xP(x) ≡ ∀x¬P(x)
- True when P(x) is *FALSE* for every `x`.
- *FALSE* when there is an `x` for which P(x) is *TRUE*.

#### ¬∀xP(x) ≡ ∃x¬P(x)
- *TRUE* when there is an `x` for which P(x) is *FALSE*.
- *FALSE* when P(x) is *TRUE* for every `x`.

---

Workshop

	Someone knows more than two other people.

	Use the negation.

	P(x, y) = "x does not know y"


Consider the following predicates:

	P(x) : x is a baby
	Q(x) : x is logical
	R(x) : x can manage a lion
	S(x) : x is despised

Assume that the domain consists of all people. Express each of the following using quantifiers and logical connectives.

1. All babies are illogical

	P(x) => ~Q(x)

2. Nobody is despised who can manage a lion

	~S(x) => R(x)
	
### Nested Quantifiers

#### Every real number has an additive inverse...

∀x∃y : (x + y = 0)

*Is this true?*

	Doamin: All real #s. *Reasoning + Proof*
	(You can not prove this for EVERY real number cus they are not exhaustive.)

	Instead...
	x = {0, 1, 2} - This means you are saying for all `x` in your set that x + y =0.

#### Example:

Let `P(x, y)` denote "xy = yx". Assume the domain is the real numbers.

Is `∀x∀y P(x, y)` true?

	What does this statement actually mean?
	- For all real numbers x, all real numbers y, when multiplied by x, would be equal to y * x. (xy = yx)

	This is TRUE, cus commutative property of multiplication. (Not formal proof)

Is `∀y∀x P(x, y)` true?

	What does this statement mean?
	- For all real numbers y, all real numbers x, when multiplied by y, would be equal to x * y. (yx = xy)

#### Example 2:

Let `Q(x, y)` denote `"x + y = 5"`. Assume that the domain is all real numbers.

1. Is `∀x∃y Q(x, y)` true?

		What is this saying?
		- For all real numbers (x), there exists some y such that x + y = 5.

		This is TRUE.

2. Is `∃y∀x Q(x, y)` true?

		What is this saying?
		- This is slightly different. This is saying that there exists some value (y) such that for ALL real numbers (x) x + y = 5.

		This is FALSE.

#### Translating Nested Quantifiers

Translate "The sum of two positive integers is always positive" into a logical expression.

	Let P(x, y) be x + y > 0 in ∈ ℤ⁺.
	∀x∀y P(x, y)

### Rules of Inference


![Rules of Inference](imgs/rules-of-inference.png)

---

**Arguments**: a sequence of propositions (p₁, p₂, ...)

	(p₁ ^ p₂ ^ ... ^ pₙ) → q ----> Where q is the conclusions.

**Valid Argument**: The premises imply the conclusion.

**Modus Ponens** :

	Given p → q, if p is true, then q is true.

	As a Tautology: ((p → q) ^ p) → q

**Modus Tollens** :

	Given p → q, if ¬q, then ¬p.

	As a Tautology: ((p → q) ^ ¬q) → ¬p


**Hypothetical Syllogism** :

	Given p → q and q → r, p → r.

	((p → q) ^ (q → r)) → (p → r)

**Disjunctive Syllogism** :

	Given p v q, if ¬p, then q.

	((p v q) ^ ¬p) → q

**Addition**:

	Given p, then p v q is true. (Makes sense cus p is always true.)

**Simplification** :

	Given p ^ q, then q (or p) both work.

**Conjunction** :

	Given that p is true and q is true, then p ^ q is also true.

**Resolution** :

	Given ¬p v r and p v q, then q v r.


## Introduction to Proofs

### What are proofs?
- A mathematical proof of a proposition is a chain of logical deductions leading to the proposition from a base set of axioms.

#### Lemmas
- Lemmas are a simple statement that can be shown to be true in just a few steps (like helper functions). Lemma’s are used to simplify the steps in the proof.

Simple Lemma. If n2 is even, then n is even.

#### Theorem
- Theorems are a major statement that can be shown to be true. Lemmas may be used in proving the theorem.

#### Corollary
- Corollary is a result that can be established directly from a theorem that has been proved.

---

**Types of Proofs**

- Proof by evidence
- Proof by picture
- Geometric proof
- Proof by experiment
- Direct Proofs
- Proof by contraposition
- Proof by contradiction
- Inductive Proofs

---

### Direct Proofs

- In a direct proof, we assume the premise (P) is true and use logic and the rules of inference to show that the conclusion (Q) follows.

---

Necessary Definitions for Direct Proofs

**Definition 1:** 

- The integer n is even if there exists an integer k such that n = 2k, and n is odd if there exists an integer k such that n = 2k + 1. (Note that every integer is either even or odd, and no integer is both even and odd.) Two integers have the same parity when both are even or both are odd; they have opposite parity when one is even and the other is odd.

---

#### Example of Direct Proof:
- Give a direct proof of the theorem, If n is an odd integer, then n² is odd.

		We assume n is odd.
		Then, by definition, n = 2k + 1 for ∃k ∈ ℤ.
		So, to show that n² is odd, we just have to square both sides. (n² = (2k + 1)²)
		That becomes n² = 4k² + 4k + 1
		Then, you make make that into n² = 2(2k² + 2k) + 1
		And because 2k² + 2k is still just k (k is any number in ℤ)...
		2(2k² + 2k) + 1 ≡ 2k + 1, which is the def. of being odd.
		n² is odd.

### Proof By contraposition

(Reminder) : p → q ≡ ¬q → ¬p
- In a proof by contraposition, of (p → q), we assume the negation of the conclusion (¬q) to be true. Then, following logic and rules of inference, we show that the negation of the premise (¬p) follows.

#### Example of Proof by Contraposition:
- Let y ≠ 0. If x/y is irrational, then either x is irrational or y is irrational.

		1. Take the opposite of the conclusion (¬q)
		2. ¬q is x is rational and y is rational.
		3. Now prove ¬p
		4. if you have ∃ p₁, p₂, q₁, q₂ ∈ ℤ such that q₁, q₂ ≠ 0
		5. x = p₁/q₁ and y = p₂/q₂
		6. Then, x/y = p₁q₂/p₂q₁ and since p₂q₁ ≠ 0, x/y is rational.

### Proof By Contradiction

- In a proof by contradiction, you instead assume the opposite of the premise. (¬p). By showing a contradiction when trying to prove ¬p, you have proven p.

## Sets
- A *set* is an unordered collection of objects, called *elements* or *members* of the set. A set is said to *contain* it's elements.

---
We write a ∈ A to show that a is an element of the set A.

The notation a ∌ A denotes that a is not an element of A.

---

### Set as Mathematical Numbers
- Much of discrete math is devoted to the study of discrete structures, used to represent discrete objects.
- Many important discrete structures are built using **sets**, which are a collection of objects.
- Among the discrete structures built from sets are combinations, unordered collections of objects used extensively in counting;
- **Relations** are sets of ordered pairs that represent relationships between objects; graphs, sets of
vertices and edges that connect vertices;
- Finite state machines, used to model computing machines are represented by a set of states.

---

#### Subset of Set
- A is a subset of B, which means that A ∈ B, but ¬∀a ∈ B.

#### Set Equality
- Two sets are said to be equal if they have the same elements. That is, ∀a ∈ A, a ∈ B and vice cersa.

#### The Size and Cardinality of a Set
- Let *S* be a set. If there are exactly *n* distinct elements in *S* where *n* is a nonnegative integer, we say that *S* is a *finite set* and that *n* is the *cardinality* of S. The cardinality is denoted by `|S|`.

#### Power Set of a Set
- Given a set *S* the *power set* of *S* is the set of all subsets of the set *S*. The power set of *S* is denoted by `P(S)`.

**Power sets** are of size 2ⁿ where n is the size of the set.

	Example:
	If the set A = {1}
	Then the P(A) = {Φ, 1}
	Then P(P(A)) = {Φ, {1}, {Φ} {{1}}}

#### Cartesian product of Two Sets (Cross product)
- Cartesian product of two sets A × B is the set of all pairs in the form (a, b) where a is an element of A and b is an element of B.
- Defining some relation between A and B.

Example:

	Given 3 sets, P(rofessors) = {p1, p2}, S(tudents)={s1, s2, s3} and C(ourses) = {c1, c2, c3}
	Find P x S and S x C

	P x S :
	P x S = {{p1, s1}, {p1, s2}, {p1, s3}, {p2, s1}, {p2, s2}, {p2, s3}}

	S x C:
	S x C = {{s1, c1}, ..., {s3, c3}}

### Proofs Involving Sets

- In order to prove the set `A = B`:
  - You must prove ∀x ∈ A ↔ x ∈ B.

Prove (A ∩ B)̄ ⊆ Ā ∪ B̄

	x ∈ A ∩ B → x ∈ U - (A ∩ B)
	→ x ∉ A or x ∉ B
	→ x ∈ Ā or x ∈ B̄
	→ x ∈ Ā ∪ B̄

Question: Show that (A ∩ B) ∪ A = A

So, you need to prove x ∈ (A ∩ B) ∪ A.

	(A ∩ B) ∪ A → (A ∩ B) or x ∈ A
	→ (x ∈ A and x ∈ B) or x ∈ A.
	→ (p and q) or p = P
	P is the statement x ∈ A.

## Functions

The formal definition of a function:
- Let X and Y be non-empty sets. A function f from X to Y is an assignment of **exactly one** element of Y to each element of X. We write f(x) = y if y is the unique element of Y assigned by the function f to element x of X. We write f : X → Y to indicate a function from X to Y.