# Midterm Study Guide

### Properties of Rational Preferences

- If any of these properties are violated, you are at risk of being a *money pump* (someone will scam u for your money)

#### Completeness

> A set of preferences is considered to be *complete* if there exists a ordering where every item is either preferred or indifferent to a different item.

In other words: `x ≻ y` or `x ~ y` or `y ≻ x`

#### Asymmetry

> The set of preferences *must be asymmetrical*! This means if `x ≻ y`, then you can **not** have `y ≻ x`.

#### Transitivity

> Transitivity states that if you prefer `x` to `y` and `y` to `z`, then that **also** means you prefer `x` to `z`. (It's like multiplication)

#### Negative Transitivity

> The opposite of transitivity ahaha. So, if `¬(x ≻ y)` and `¬(y ≻ z)`, then `¬(x ≻ z)`.

### Cardinal Constraints for Preferences

> The *cardinal constraints* say that your utility for a particular action can be stretched or shifted, but the *relative distance* between utilities of two different things will be preserved.

For example, check out the following example:

> Joel’s parents are trying to figure out how much they need to bribe him to eat his vegetables. They know they can bribe him to eat a whole serving of broccoli with just $1, but it takes $4 to get him to eat a serving of spinach. After making a number of dinner-time deals with Joel, his parents have determined further that he is indifferent between a serving of vegetables that is all peas and a serving that that is two-thirds broccoli and one-third spinach. Also, Joel is indifferent between a full serving of green beans compared a serving of vegetables that is equal parts broccoli and peas.

```
Here, we know a few things about the utilities of each vegetable.

u(Br) > u(Sp)
u(P) = 2/3 u(Br) + 1/3 u(Sp)
u(Gb) = 1/2 u(Br) + 1/2 u(P)

With this information, we can infer a few things...

Br ≻ Gb ≻ P ≻ Sp
And we can now make our table for cardinal utilities. 

Br | 1   | 1   | 
Gb | 5/6 | 1/2 | 
P  | 2/3 | 0   | 
Sp | 0   |     | 

If we give it very simple utilities of 1 and 0, u(P) would be 2/3 (Relatively)

Then u(Gb) would be 1/2 relatively if u(Br) was 1 and u(P) was 0.

We then find... whats halfway between 1 and 2/3? -> 5/6!
```

## Decision Making Strategies

### Dominance Reasoning

> Dominance relations are relationships defined by which of the options *has a higher utility*.

- There are **3** possibilities for dominance relations...
	1. **Strictly dominant:** All states for a certain option yield *better* utilities (per state) than the other option.
	2. **Weakly dominant:** All states for a certain option yield *the same or better* utilities (per state) than the other options.
	3. **Intransitive:** There is no preference between the options. (Some states yield better for one option, but other states yield better for a different)

The idea is that *you will never choose an act that is being dominated*.

### Maximin

> Maximin is the idea of *maximizing* the *minimum* utility of an option.

- In the table below, *maximin* would look across the rows at each of the acts and determine the *lowest utility of each*.
	- A₁ = 0, A₂ = 2, A₃ = 1
	- So maximin would say to choose Act 2.

|     | S₁  | S₂  | S₃  |
| --- | --- | --- | --- |
| A₁  | 0   | 3   | 2   |
| A₂  | 2   | 2   | 3   |
| A₃  | 1   | 1   | 2   |

#### Maximin Tiebreaking

- You can tiebreak by eliminating the options that didn't draw, and move to the *next minimum*.

### Minimax

> Minimax is the idea of *minimizing* the *maximum* (ahaha) **regret** that you will experience by NOT CHOOSING other options.

- You do this by calculating the regret for a certain state based on the *maximum utility* of the best action in that state.
	- Using the example again, we can calculate the regrets for S₁:
		- `Regret(A₁, S₁)`  = 2, `Regret(A₂, S₁)` = 0, `Regret(A₃, S₁)` = 1
- And then, you will choose the action with the lowest possible regret value across the states. 

|     | S₁  | S₂  | S₃  |
| --- | --- | --- | --- |
| A₁  | 0   | 3   | 2   |
| A₂  | 2   | 2   | 3   |
| A₃  | 1   | 1   | 2   |

### Expected Utility Theory

> Uses the actually *chance* of the event occurring to make a more *probable* EXPECTED utility value.

- It is quite simply calculated through multiplying the *probability* of each state by the *utility* of each state, and adding it all up together.

## Paradoxes

### Allais Paradox

> The Allais Paradox is a choice problem that presents preferences between two sets of lotteries to show a contradiction to Expected Utility Theory.

- In the *first set*, there is a certain outcome where you will be guaranteed money.
- In the *second set*, that guaranteed outcome is taken away.
- In this scenario, the majority of people will choose the outcome that is guaranteed in the first set, even with a higher payout for the outcome that is riskier. *However,* they will then choose the riskier option once the certainty is removed.
	- The paradox shows that the "sure thing" probability axiom makes people *risk averse*.

The utilities of these sets also leans toward the riskier outcomes, which is why it contradicts the expected utility theory.

### Ellsberg Paradox

> The Ellsberg Paradox is a choice problem that *also* contradicts Expected Utility Theory. It demonstrates *uncertain probabilities* affects decision making.

- The Ellsberg Paradox is set up with 4 gambles and 2 boxes of balls.

#### Gamble 1 & 2

- In the first set of gambles, you choose between two different stakes with: *A box with a guaranteed set of 30 Red balls and 60 white or red balls (unknown ratio).* 
	- Gamble 1: `$100` if you draw a red ball.
	- Gamble 2: `$100` if you draw a white ball.
	- Here, *most people* will choose the first gamble, with the guaranteed set of 30 red balls compared to the random ratio, which could be 0 white balls, or it could be 60.
- `EU(Gamble 1) = 1/3 * 100 = 100/3`
- `EU(Gamble 2) = (2/3 - p) * 100` (`p` is the probability of blue balls)
- If we calculate the ratios of these two, it would be: `200/3 - 100p - 100/3 = 100/3 - 100p`

#### Gamble 3 & 4

- This second set of gambles is where you see the contradiction.
- You choose between this same set of 30 red and 60 white or blue balls of unknown ratio. Except this time, the gambles are:
	- Gamble 3: `$100` for a red, and `$100` for a blue ball.
	- Gamble 4: `$100` for a blue, or `$100` for white.
	- HOWEVER, in this case, most people would prefer Gamble 4, where there is 60 balls that guarantee a favorable outcome.
- If we calculate the EU again...
- `EU(Gamble 1) = 1/3 * 100 + p * 100`
- `EU(Gamble 2) = 2/3 * 100`
- If we calculate the ratios again: `200/3 - 100/3 - 100p = 100/3 - 100p`...
	- This is the exact same ratio...

> Hence this is where the paradox appears. Despite the same exact ratios of expected utility for Gamble 1&2 vs 3&4, people change their choices to prefer a gamble with a known risk over a gamble with an ambiguous or unknown risk.


#### St Petersberg Game

> Another scenario where Expected Utility Theory fails. This one makes use of a theoretically infinitely occurring game.

- In the St. Petersberg Game, you flip a coin, and you will keep flipping it as long as it keeps landing on heads.
- Every time you flip it, the prize money doubles.
- In this sort of scenario, you would theoretically be willing to pay an infinite amount of money, as the Expected utility for this game is infinite.

#### Pasadena Paradox

> The Pasadena Paradox is a mathematically more complexed version of the St Petersberg Game. Where through a simple Riemann Rearrangement Theorem, you could chance the convergence of the harmonic series, and thus, the expected values.

- In this paradox, you flip a coin until you get heads. (`n = # of flips`)
	- If `n` is even, you will **PAY** `2^n/n`
	- If `n` is odd, you will get `2^n/n`
- You can see the values and expected values below:

| n    | 1   | 2    | 3    | ... |
| ---- | --- | ---- | ---- | --- |
| pay  | 2   | -2   | 8/3  | ... |
| prob | 1/2 | 1/4  | 1/8  | ... |
| EV   | 1   | -1/2 | +1/3 | ... |

- It can be seen that the EV alternates between positive and negative, which can be summed up in an *alternating harmonic series*.

$$EV=\sum_{n=1}^{\infty}{\frac{-1^{n+1}}{n}}$$

- This converges on `ln(2)`.
- However, just by rearranging the way you count the items in the series, you are able to get different convergences. (1 positive number, then 2 negative numbers, then 1 positive...)
	- Technically its equal, as all those numbers are in the harmonic series. (Infinite)

#### Two Envelope Paradox

> Simple one where you have 2 envelopes where either the money in Envelope A will be double the money in Envelope B, or vice versa.

|     | A+(p=1/2) | B+(1/2) |
| --- | --------- | ------- |
| A   | x         | x       |
| B   | x/2       | 2x      |

```
(A+/B+) are the chances of each envelope having the doubled amount.
```

- This paradox appears because of how the problem is being formulated.

|     | A+(p=1/2) | B+(1/2) |
| --- | --------- | ------- |
| A   | x         | 2x      |
| B   | 2x        | x       |

- In this solution... the EVs are now equal.

#### Newcomb's Problem

> A transparent ($1,000) and opaque box. An angel who can see into your soul and decide whether to put $0 or $1,000,000 into a opaque box. She'll only put it into it if she thinks you'll pick only 1 of the boxes.

- In this choice problem, the *intuitive choice* would be to choose just one box, and then pick the opaque box, as you would then get `$1,000,00`.
- However, isn't it also true that *once she makes the choice*, the probabilities are gone???
	- Doesn't that mean then that getting two boxes would be strictly dominant??

### Causal vs Evidential Decision Theory

- Causal decision theorists do not concern themselves with the probabilities given prior scenarios.
	- Causal decision theorists only concern themselves with whether the given action would be beneficial or less inconvenient to oneself.
- Evidential decision theorists account and will take the actions with the best news about the outcomes.

#### Relation to Newcomb's Problem

- In Newcomb’s problem, a predictor has likely already filled an opaque box based on predicting your choice; taking one box correlates with the million being there, taking two correlates with it being empty.
- *Evidential decision theory* one-boxes because one-boxing is strong evidence the million is present, raising `P(Million∣One-box)P(Million∣One-box)` and thus conditional expected utility.
- ​*Causal decision theory* two-boxes because your present act cannot causally affect the already set box; adding the transparent $1,000 causally dominates regardless of what’s in the opaque box.

## Probability Axioms and Dutch Book

### The Probability Axioms

1. `0 ≤ p(A) ≤ 1` (The probability of an event `A` occurring must be between 0 and 1)
2. If `E` is a tautology, then `p(E) = 1`.
3. If `A ∩ B = ∅`, then `p(A ∪ B) = p(A) + p(B)`

### The Dutch Book Theorem

> Your *degrees of belief* must satisfy the probability axioms or you will be vulnerable to Dutch books.

- The **Dutch Books** are a series of bets you would be willing to take where you are guaranteed to lose money.

```
"S" is the stake a player receives if event E occurs.

p is the "betting quotient" i.e. the player's degree of belief in E.

E: S - p * S
¬E: -p * S

EV[bet] = p*(S-p*S) + (1-p)(-p*S)
```

#### Violating Axiom 1

- You can violate Axiom 1 by simply setting your degree of belief to be *over 1* or *under 0* and updating the stake accordingly. Either way, you'll end up with a negative expected value.

#### Violating Axiom 2

- You can also violate Axiom 2 very easily by setting a single condition to be *greater than or less than 1*. Either way, you'll end up with a negative expected value.

#### Violating Axiom 3

- You violate Axiom 3 by setting the probability for the union of 2 different events to be greater than the their probabilities alone.

## Small Improvement Argument

> The Small Improvement Argument is a argument that 


## Probability Interpretations

### Classical Interpretation

> In a classical interpretation of probability, the probability of an event occurring is the # of favorable outcomes divided by the total number of outcomes.

**Example:** Rolling a dice with the probability of rolling a 2 being 1/6.

- The Pros: Works well for most gambling games.
- The Cons: Assumes all outcomes to be *equally likely*.

##### Equally Possible Possibility Space

- (How do you decide what counts as equally possible?)
	- f you see it in the sense of, "its possible to get two heads, 1 head, or no heads..." Doesn't that mean the `P(2 heads) = 1/3`?
	- Hm, but then if you draw up a table with all the possibilities, there is only 1 scenario where you get 1 head out of 4 possible, which means is it `P(2 heads) = 1/4`?

### Hypothetical infinite Frequentism

> The probability of an event occurring is the frequency of the event occurring given enough repetitions of the process. 

- **Theoretically**: Infinite # of events will eventually converges to the true probability
	- *Law of Large Numbers*: Explains why experiments should be repeatable and repeated

Cons: The reference class problem, it must go to inf to reach the true probability.

##### Reference Class Problem

- What groups do you include in the reference class for the actual probability and the calculations?
	- Individuals and events may belong to multiple different reference classes.
	- Choose too large and it includes irrelevant info, too small and the probability isn't accurate.

#### Actual Frequentism

> A finite set of events is used as the reference class...

- However, what if this is not enough?
- Too small and it yields extremely differing probabilities.
- Too big and you include irrelevant things too.

#### Hypothetical Frequentism

> The reference class is a hypothetical infinite series of repetitions of the stochastic process.

- The p(E) is the limiting relative frequencies *in the infinite hypothetical reference class*.
- However, you can also *structure* and *rearrange* the occurrences of a reference class to reconstruct any probability that you would want. (Think back to the Pasadena Paradox)

### Propensity Interpretation

> Each event has a certain *disposition to occurring*. (Physical tendency)

**Example:** Glass has a tendency to shatter, a die has the tendency to land on a number between 1-6.

- Problem: How are you supposed to measure this?
- They are physical magnitudes that **already exist and are possessed by the system**.

#### Humphrey's Paradox

> Challenges the Propensity Interpretation by arguing that there is a almost *backwards* approach to Propensity. (Bayes Theorem)

- Based on the probability axioms, If `p(H | F)` exists, `p(H|F) = p(F|H) P(H) / P(F)` must exist.
- However, Propensity Interpretation states that the probability is only affect by the setup of `p(H|F)`, and it doesn't make sense for the physical dispositions to go backwards in time.

### Bayesian Interpretation

> The Bayesian interpretation makes probability into your set of beliefs.

##### Problem of Priors

> A "prior" is a starting belief or guess on how likely something is to occur.

- The problem of priors is *how do you choose one*?
- There’s no single, universally agreed way to pick the “right” prior—should it be based on past data, symmetry, ignorance, or something else?

#### Subjective Bayesian

> Any prior (Or beliefs) that you have about the probability is a valid one.

- That is, any particular prior is *just as valid* as another. (Just don't assign zero prior probability to anything though)
	- Since anything that might depend on that would also be impossible.

#### Objective Bayesian

> All views are a little like the classical approach. (Choose a uniformed prior)

- Objective Bayesians assume this probability distribution is uniform: all possible outcomes are equally likely.

##### Box Example

- Suppose you have a box that could be 1-2ft. Prob. of the box would then be 1.5
	- Runs into a problem as if you tried to manufacture something for the 1.5 box, and its not exactly 1.5, ur fucked!
	- `E[A} = 2.25ft2`, `E[V] = 3.375ft3` 
- The problem of priors rears its head again... If you selected 1.5 as a *linear* probability, it's different than if you were to select a maximum entropy (Randomness) distribution.


