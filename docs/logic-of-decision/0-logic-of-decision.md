# Logic of Decision

> Taught by Dr. Max Bialek ([Email](mailto:mbialek@rutgers.edu))

**Course Textbook:** Introduction to Decision Theory *2nd Ed.* (Martin Peterson)

### Course Breakdown



## Preferences and Utilities

---

### Some signs
- `A ≻ B` := "A is *preferable* to B"
- `A ~ B` := "A is *indifferent* between A and B"
- `A ≽ B` := "A is *at least* as good as B"

---

- There are properties that our preferences should satisfy:
	- **Completeness**: `x ≻ y` or `x ~ y` or `y ≻ x`
		- It's not that you are indifferent between them, as you can still make a choice between them. (No preference nor indifference)
		- If the preference is not complete, it is literally *impossible* to choose between them.
		- **Incomplete Preference**
	- **Asymmetry:** If `x ≻ y`, then `¬(y ≻ x)`
		- There are situations where you are guaranteed to lose money if you violate asymmetry.
			- Since you prefer apples to bananas, having a apple is worth more to you than having a banana. Etc etc... same story as before.
			- You'd be willing to trade the banana for the apple + some monetary amount... (because otherwise you would be indifferent)
			- **Money pump**
	- **Transitivity:** If `[(x ≻ y) ∧ (y ≻ z)] → x ≻ z`
		- You would also become a money pump if this is not upheld.
	- **Negative Transitivity:** `[¬(x ≻ y) ∧ ¬(y ≻ z)] → ¬(x ≻ z)`
		- It is true that we dont prefer `x` to `y`. 

> The utility for the agent is how valuable the agent finds that item to be.

### Ordinal Constraint

- The `u(x)` (utility) `>` `u(y)` iff. `x ≻ y`.
- `u(x) = u(y)` iff. `x ~ y`.

For the case of our class assignment, there are many different utility values (utils) that you can assign, but all that's important is the *order* of the items.

### Cardinal Constraint

- Suppose that there is a lottery (L), you can win `A` with a probability of `p` and win `B` with a probability of `1-p`.
- The *cardinal constraint* says that the `u(L)` (It is the utility of actually *playing the lottery*) = `p * u(A) + (1-p) + u(B)`
- If you have a cardinal utility function, you can *stretch it* and *shift it*, but certain things will be preserved.
	- `u' = c*u + d`
	- What is preserved is the **relative** distance between two things.

## Sept 11

### Von Neumann Morgenstern Utility Theorem

> [!NOTE] Axiom 1: Completeness
> `A ≻ B` or `A ~ B` or `B ≻ A`

> [!NOTE] Axiom 2: Transitivity
> If `A ≻ B` and `B ≻ C`, then `A ≻ C`

> [!NOTE] Axiom 3: Independence
> `A ≻ B` iff `ApC ≻ BpC`
> (*The `p` is the notation for the probability. So here it is basically symbolizing the lottery of Apples with Coconuts is preferable to the Banana and Coconut lottery.*)

> [!NOTE] Axiom 4: Continuity
> If `A ≻ B ≻ C`, then there exists some `p` and `q` such that `ApC` ≻ `B` ≻ `AqC`
> (*In this case, the probability of the lottery for `p` would have to be some degree larger than for `q`*)
> `u(ApC) = p * u(A) + (1-p) * u(C)`


---

**Theorem 5.2:** The preference relation `≻` satisfies vNM 1-4 iff there exists a function `u` that takes a lottery as its argument and returns a real number bewteen 0 and 1, which ahs the following properties:

- `A ≻ B` iff `u(A) > u(B)` (Ordinal Constraint)
- #todo huh what am i missing here?


---

## Sep 15 - Making Decisions

|     | S₁        | S₂        | ... |
| --- | --------- | --------- | --- |
| A₁  | O(A₁, S₁) | O(A₁, S₂) | ... |
| A₂  | O(A₂, S₁) | ...       | ... |
| ... | ...       | ...       | ... |

- Here, we have a table of *S* (states) and *A* (acts). Within each of these, we have a set of *O* (Outcomes)
- What we care isn't necessarily just the *outcomes* of these states and acts, but the actual **utilities**.

---

#### Example

```
Suppose you flip a coin and could bet on whether it lands on heads or tails.
```

The Decision matrix would like like as follows if you (*columns = coin lands on, rows = bet on*):

|     | H   | T   |
| --- | --- | --- |
| H   | $1  | -$1 |
| T   | -$1 | $1  |

However, if you had a scenario where:


|     | H   | T   |
| --- | --- | --- |
| B₁  | $1  | $1  |
| B₂  | -$1 | $1  |

- You would always choose B₁, as in *every single outcome*, B₁ is superior or equal to B₂.
- **We call this dominance reasoning.**
	- This one is *weak dominance*.

|     | H   | T   |
| --- | --- | --- |
| B₁  | $2  | $2  |
| B₂  | $1  | $1  |

- However, in this scenario, while you would *still* prefer `B₁`, this case is a **strict dominance**, as ***every*** state is superior.

> [!NOTE] Dominance Reasoning
> Act `A` dominates Act `B` iff. for all states `S`, `u(A, S) ` ≥ `u(B, S)`, and there exists a state `T` s.t. `u(A, T)` ≥ `u(B, T)`.\
> \
> The rule is that you would *never choose* a act that was being dominated. (They *ought to rule it out as a possible solution*)


- **Weak dominance**: At least one state where the utilities are equal.
- **Strict dominance**: All states are superior.
- *Intransitive*: There is no preference (indifferent) between two acts.
	- This would occur if there is an equal number of states that have superior utilities.

|     | S₁  | S₂  | S₃  |
| --- | --- | --- | --- |
| A₁  | 0   | 3   | 2   |
| A₂  | 2   | 2   | 3   |
| A₃  | 1   | 1   | 2   |

- Given this scenario, we would be *intransitive* between `A₁` and `A₃`, as `S₃` is equal and `u(A₁, S₁)` <= `u(A₃, S₁)` and `u(A₁, S₂)` >= `u(A₃, S₂)`.


> [!NOTE] Maximin
> **Maximizing** the minimum utility. (Risk averse)\
> \
> It tells you to look at every single act, and choose the act with the highest *minimum* utility.\
> So, *in the previous scenario:*

|     | S₁  | S₂  | S₃  | min(A) |
| --- | --- | --- | --- | ------ |
| A₁  | 0   | 3   | 2   | 0      |
| A₂  | 2   | 2   | 3   | 2      |
| A₃  | 1   | 1   | 2   | 1      |

- In a *lexical maximin* scenario, you will continue to look for the mins in order to break ties.

---

#### Example

|     | S₁  | S₂   |
| --- | --- | ---- |
| A₁  | -1  | 1    |
| A₂  | -2  | 1000 |

- In this scenario, *dominance reasoning* tells us absolutely nothing.
- However, *maximin* would say that `A₁` is better.

> [!NOTE] Minimax
> *Minimize* the maximum **regret**. (It is also pessimistic, like maximin)\
> \
> `regret(A, S) = Max(S) - u(A, S)` (U can build a regret table, *which is entirely positive*, there should also be a 0 in each col.)

- Now, in the case of *minimax*, it would say that `A₂` is better.
	- There isn't really a tie-breaking procedure for minimax though.

#### Ordinal vs Cardinal Utilities

- Cardinal information has a lot more information than ordinal utilities.


---

## Sept 18


#### Example

> However, what is a case where the reasonings *fail to keep in line with our intuitions.*

|     | S₁  | S₂  | S₃  | ... | S₁₀₀ |
| --- | --- | --- | --- | --- | ---- |
| A₁  | 100 | 0   | 0   | ... | 0    |
| A₂  | 0   | 99  | 99  | ... | 99   |

- **Dominance reasoning says:** The two actions are equal, as in *some cases*, A₁ is superior, and A₂ is superior in other cases.
- **Maximin reasoning says:** A₁ is superior, as the *minimums* for both would be zero, but after lexical maximin, A₁ would have a minima of 100 vs A₂ with 99.
- **Minimax reasoning says:** A₁ is superior *again*, as the *minimum* maximum regret is 99 (even though it is possible to be experienced way more often)

> **Now if we knew some things about the probability...**

|     | S₁  | S₁₋₁₀₀ |
| --- | --- | ------ |
| A₁  |     |        |
| A₂  |     |        |

> [!NOTE] Expected Utility
> The expected utility of an Act A:
> $$\sum_{i=1}^{n}{u(A, S_i) * p(S_i|A)}$$

⤷ If we were to use expected utility to calculate the utlities of each act:

- **A₁**: $EU(A_1)=100 * \frac{1}{100}+0*\frac{99}{100} = 1$
- **A₂**: $EU(A_2)=0*\frac{1}{100}+99*\frac{99}{100}= 98.01$

> Keep in mind that this assumes all the states are *equally likely*.



#### HW

18. Relations: A_2 strictly dominates A_1, A_3 weakly dominates A_1, A_2 and A_3 are intransitive
- Dominance: A_2 v A_3 ≻ A_1
- Maximin: A_2 is preferred
- Minimax: A_2 is preferred (Minimum regret of 3)
- MEU: A_3 is preferred, highest EU value (3.5 EU vs 1.6EU(A_2))

19. Relations: They are all intransitive with one another.
- 