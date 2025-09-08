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
	- What is preserved is the relative distance between two things.