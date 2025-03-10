# Probability

## Notation

- The probability of an event can only be between 0 and 1.
- The probability of an impossible event is 0.
- The probability of a certain event is 1.
- he probability of an event *not* happening is 1 minus the probability it does happen.

## Independence and Dependence

**Independence**

- When events are independent if the outcome of one doesn't affect the probability of another.
	- E.g. coin tosses, throwing dice, dealing cards with replacement.

**Dependence**

- Two events are dependent if the outcome of one does affect the probability of ;the other.
	- E.g. studying and passing exam, rain and speeding, dealing cards without replacements.
## Fairness

**Unbiased**

- Outcomes are equally likely.
- E.g. Flipping normal coin, spinning roulette wheel, drawing from shuffled deck of cards.

**Fair** = Unbiased + Independent

## Coins

- Fair coins: Pr(H) = 1/2, Pr(T) = 1/2

## Multiplication Rule
- If A and B are independent of one another, you can get the probability of both events occurring through `A ✕ B`.
## Disjunction
- Expression for disjunction ("or") is "V"

## Addition Rule
- If A and B are mutually exclusive (cannot happen simultaneously), then:

`P(A v B) = P(A) + P(B)`

`P((H₁ & H₂) v )`

> For info on mutual exclusivity, see [Discrete 2](../discrete-2/discrete-2.md#mutually-exclusive).

---

### Example

What is the probability of rolling a 6 with two dice?
- Can't get total of 6 if one of dice lands on 6.
- 5 ways to get total of 6. (*Dont count 3,3 twice*)

		Each way to get 6 has a possibility of `1/36` (1/6 * 1/6)
		With 5 total ways, you add all 5 possibilities together, giving you a total probability of `5/36`

---

## Gambler's Fallacy

> "I have four daughters. I have two sisters and both of them have two daughters. Should be due for a boy, right?!?!"

This is an example of the *Gambler's Fallacy*, which is the misconstruing of chance based on the unlikelihood of the results previously.

> For more on [Gambler's fallacy](../cog-sci/10-the-rational-mind.md#Gambler's-Fallacy).

---

## Bayes Theorem

### Conditional Probability
- Most authors use the vertical stroke `"|"` for "conditional on". For example, "P(A|B)". 

> [Discrete 2 Section on Conditional Probability](../discrete-2/discrete-2.md#conditional-probability)

The probability of A conditional on B is by definition equal to the probability of A and B, divided by the probability of B:

`P(A|B) = P(A and B)/P(B)`

From this, we know that:

`P(B|A) = P(B and A)/P(A)`

From rearranging this equation, we have: `P(B and A) = P(A) * P(B|A)`. 

But we also know that `P(A and B) = P(B and A)`. Hence: `P(A and B) = P(A) * P(B|A)`

Then, substituting this back into the first theorem...

**Bayes Theorem**: P(A|B) = P(A) * P(B|A)/P(B)

$$P(A|B) = \frac{P(A) * P(B|A)}{P(B)}$$

#### Difference Between "A given B" and "A and B"
- For "A and B", you are still looking at the whole set.
- For "A given B", you are restricting the set to only the set where B is true.

#### Conditional On
- Means something like:
	- "given that..."
	- "were the world to be such that..."
	- "hypothetically assuming this is the case..."

> If A and B are independent, then:
> P(A|B) = P(A)
> P(B|A) = P(B)
> If they are independent, then the probabilities of each does not affect each other.

### Revisiting the Multiplication Rule

**Whether A and B are independent or not:**

`P(A & B) = P(A) * P(B|A)`

> If A and B are independent, then:
> P(B|A) = P(B)


### Revisiting the Addition Rule

**Whether A and B are mutually exclusive or not:**

`P(A V B) = P(A) + P(B) - P(A & B)`

- We subtract P(A & B) to avoid double counting

---

**Bayes Theorem tells us how to calculate the probability of the hypothesis conditional on the evidence.**

- For ease of memory, instead of using *A* or *B*, use *h* for the hypothesis.

`P(h|e) = P(h).P(e|h)/P(e)`

$$P(h|e) = \frac{P(h).P(e|h)}{P(e)}$$

- `P(h|e)` is the **posterior probability** of hypothesis **h**. It is the probability of **h** after considering the evidence **e**.
- `P(h)` is the prior probability of the hypothesis h. It is the probability of h before considering the evidence e.
- `P(e|h)` is the likelihood probability of the evidence **e** on the assumption that the hypothesis **h** is true.
- `P(e)` is the probability of the evidence **e**. It is the probability of **e** in the absence of any assumption about the truth of **h**.

`P(e|h)` states how likely the evidence **e** is considered to be when the truth of the hypothesis **h** is not assumed.

- If the evidence is considered extremely likely whether we assume a hypothesis or not, the hypothesis is not highly supported if the evidence is confirmed.
- If the evidence is considered very unlikely unless the hypothesis is assumed, then the hypothesis can be considered highly confirmed.

**Example:**

- Suppose a new theory of gravitation predicts that heavy objects fall to the ground.
- This would not be highly confirmed by the observation of the fall of a stone since the stone would be expected to fall even when we do not assume the truth of the new theory.
- However, if the new theory were to predict some small variation of gravity with temperature, then if it is highly supported by the discovery of such evidence, since gaining that evidence would be considered unlikely when we do not assume the truth of the new theory.

It is also a theorem that:

`P(e) = P(e|h) * P(h) + P (e | ¬ h) * P(¬ h)`

- This is dividing the probability of the evidence being true into two **mutually exclusive** quadrants. *the hypothesis can't be both true and not true.*

