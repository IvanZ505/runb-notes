# Design and Analysis of Computer Algorithms

## Introduction

> The [Course site](https://sites.google.com/views/rutgers-cs344-s25)

- Textbook - *Algorithm Design*

#### Grading

- `1000` total points plus bonuses.
	- Homework: `300` points.
	- Midterms: `200 x 2` points plus bonuses.
	- Final: `300` points plus bonuses.
- A curve may be applied depending on the grades.


#### Homework Policy

- Each homework assignment can be done in groups of at most three students.
- Please submit only one copy per group and mention the names and NetIs of all members of the group.
- **Must be written in LaTeX!**
- Grading only counts for completion!!!

#### Exam Policy

- Three exams, midterms are in class.
- All exams are closed book.
- Exam questions will come from lectures homework assignments and exercises in our textbook.
- There will be bonus problems and the max score will be around 130%.

### Why Algorithms

- Cus they interesting.
- Algorithms and the ideas behind them are useful for real-life scenarios.
- They are important (for other courses, research, job interviews, ...)

#### Problem Solving

- Solve many problems.
- *Pattern recognition*.

### First Example: Stable Matching

> The 2012 Nobel Prize in Economics was awarded to Lloyd Shapley and Alvin Roth, for "*the theory of stable allocations and the practice of market design.*"

#### Matching

- There are `n` students applying for jobs/internships. There are `n` positions. Find a bijection (perfect matching) between students and positions.
- Notable examples: the National Resident Matching Program (NRMP) matches U.S. med schools to students.


#### Quiz

> How many perfect matchings are there between `n` students and `n` jobs?

Ans: `n!` - `100 * 99 * 98 * ...`


#### Preference

- Not every matching is good.
- Both sides will have a preference: for example: in job markets, students have preferred jobs, and jobs have preferred students.
- It seems bad if a student and a job are not matched together, but they prefer each other to their current match.
- We will formalize this idea:

#### Notation

- Following the textbook notation, there is:
	- A set $M = {M_1, M_2, ..., M_n}$ of `n` men, and
	- A set $W = {W_1, W_2, ..., W_n}$ of `n` women.
- A perfect matching can be viewed as a bijection $f: M \rightarrow W$. It's inverse is $f^{-1}: W \rightarrow M$. 
- Every person will have their own preferences:
	- Each man `m` ranks all women using a total order $\succ_m$  on `W`. ($w\succ_m w'$ means that `m` prefers `w` to `w'`)
	- Every woman `w` ranks all men using a total order $\succ_w$ on `M`.

#### Stability

> Given a perfect matching $f: M \rightarrow W$, an *unstable* pair is a pair of man `m` and woman `w` who **are not matched together, but prefer each other to their current match;** that is:

$$w \succ_{m} f(m) ; m \succ_{w}f^{-1}(w)$$

- A preference even if they are not matched together. This is an *unstable match.*
	- They must both be unhappy to be an unstable match.
- A perfect matching is *stable* if it has no unstable pairs.

##### Do Stable Matchings Always Exist?

- A priori, it seems unclear whether stable matchings always exist in every instance.
- **Every instance** admits at least *one stable matching.*


#### Gale-Shapley Algorithm

> The Gale-Shapley Algorithm will help find a stable matching and prove that every instance will admit at least one stable matching.


```pseudocode
Initially all m ∈ M and w ∈ W are free  

**while** (there is a free man m who has not proposed to every woman) 
**do**
	Let w be the highest-ranked woman in m’s 
	preference list to whom m has not yet proposed  
	**if** w is free **then**  
		(m, w) become engaged  
	**else** // (w is currently engaged to m′)  
		**if** w prefers m′ to m **then**  
			m remains free  
		**else** // (w prefers m to m′)  
			(m, w) become engaged  
			m′ becomes free  
		end if  
	end if  
end while  
Output the engaged pairs

```

##### Observation

**Lemma:** Gale-Shapley Algorithm outputs a perfect matching.

**Proof:** First, no person can be simultaneously matched with multiple partners at any time. Therefore, we only need to show that there are `n` engaged pairs at the end. Prove by contradiction and suppose that there are at most `n-1` engaged pairs at the end. Then there must be $m \in M$ and $w \in W$ who are free at the end. `m` must have proposed to `w` and therefore `w` must be engaged after that. This contradicts with `w` being free at the end.

---

**Fact:** Once $w \in W$ is engaged, her matches can only get better and better.

---

##### Theorem

> Gale_Shapley outputs a *stable* matching.

- **Proof**:

We need to prove that output matching is stable. Prove by contraction, and suppose that:

- *(m, w)* are matched and *(m', w')* are matched;
- *(m, w')* is an unstable pair: `m` prefers `w'` to `w` and `w'` prefers `m` to `m'`.

Since `m` prefers `w'` to `w` we know `m` must have proposed to `w''`. Therefore, after that, according to the preference of `w'`, her partner must be at least as good as `m`. Therefore, `w'` must prefer `m'` to `m`, leading to a contradiction.

#### Men-Optimality of Gale-Shapley

- **Question:** When there are multiple stable matchings, which one will gale-Shapley pick?
- **Definition:** We call `w` a *valid partner* of `m` (and `m` a *valid partner* of `w`) if (`m,m`) are matched in at least one stable matching.

> In Gale-Shapley, every $m \in M$ is matched with his best valid partner (according to `m`).

#### Women-Pessimality of Gale-Shapley

- **Theorem:** In Gale-Shapley, every $w \in W$ is matched with her worst valid partner (according to `w`).

> **Summary:** Stable matchings always exist, and can be found by the Gale-Shapley algorithm. It is optimal for the proposing side amog all stable matchings.

## Running Time Analysis

### Time Efficiency of an Algorithm

- An algorithm takes an input, *performs some operations*, and then gives an output.
- Even if two algorithms achieve the same function, one of them can be **faster** than the other.
- How do we compare these algorithms and answer which one is faster?

#### Worst-case Analysis

- We will focus on the *worst-case* analysis of running time:
	- For each input size *n*, what is the maximum possible running time *`T(n)`*?
- In other words, `T(n)` is a guarantee that as long as the input size is `n`, the running time will be at **most** `T(n)`.

> You can also define a "average-case" running time. However, worst-case analysis is more widely accepted and captures reality pretty well. **Exception, the simplex algorithm**

#### Focusing on Large Inputs

- We will focus on the situation when the inputs are large: How fast does the running time `T(n)` grow as a function of the input size `n` when $n \rightarrow \infty$?
- For most (if not all) algorithms covered in this course, their performance in the limit ($n \rightarrow \infty$) can usually capture their performance for smaller `n` too.

#### Ignoring the Constant

- We will often ignore the constants in the running time: 
	- $T(n) = f(n)$ and $T(n) = 10f(n)$ are considered to be similar.
	- The exact constants usually depend on the exact implementation.

### Different Running Times

![](imgs/diff-runtimes.png)

### Assumptions Before Introducing Big O Notation

- Fix an algorithm. Let $T(n)$ be its worst-case running time when the input size is `n`.
- We are interested in the behavior of functions when $n \rightarrow \infty$, and we assume that the functions `f(n)`, `g(n)`, ... are positive (b.c. they are running time.)

### Big O Notation

- We define `O(n)` as the class of functions `g(n)` that satisfy:

$$\limsup_{n \rightarrow \infty} \frac{g(n)}{f(n)} < +\infty. \quad ($\limsup_{n \rightarrow \infty} \frac{g(n)}{f(n)} := \lim_{n\to\infty}\sup_{n' \geq n} \{\frac{g(n')}{f(n')}\})$$ 

- In other words, `O(f(n))` is the class of functions `g(n)` where there is a constant $c \in \mathbb{R}^{+}$ and a number $N\in \mathbb{N}$, so that as long as $n \geq N$, we have $g(n) \leq c*f(n)$.
- In other words, `O(f(n))` is the class of functions `g(n)` where there is a constant $c \in \mathbb{R}^+$, so that for all sufficiently large `n` we have $g(n) \leq c * f(n)$.

> Intuitively, this means $f(n) \in O(g(n))$ means that `f(n)` (ultimately) grows at most as fast as `g(n)`, ignoring the constant.

##### Example

If $f(n)=3n^{2} + 100 n + 7$ and $g(n)=n^2$, then we can write $f(n) \in Og(gn(n))$, or $3n^{2}+100n+7 \in O(n^2)$.

- For example, `O(n)` is the class of functions that grow at most linearly, and `O(n^2)` is the class of functions that grow at most quadratically.
- We will say, for example, an algorithm runs in `O(n)` (or `O(n^2)`, etc...) time to characterize/classify its running time.

### The Notations

#### $\Omega$

> Define $\Omega (f(n))$ as the class of functions $g(n)$ that satisfy $f(n) \in O(g(n))$ (grows at least as fast (bad) as `f(n)`)

#### $\omicron$

> Define $\omicron(f(n))$ as the class of functions `g(n)` that satisfy $\lim_{n\to\infty}\frac{g(n)}{f(n)} = 0$ (grows strictly slower than `f(n)`).

#### $\omega$

> Define $\omega(f(n))$ as the class of functions `g(n)` that satisfy $f(n) \in \omicron(g(n))$ (grows strictly faster than `f(n)`).

#### $\theta$

> Define $\theta(f(n))$ as the class of functions `g(n)` that satisfy $g(n) \in O(f(n))$ and $f(n) \in O(g(n))$ (same growth rate as `f(n)`).

---

##### A Note on `O` and $\theta$

- Many people use `O(f(n))` to refer to $\theta(f(n))$.
- For example, "*sorting `n` numbers via pairwise comparisons must take at least $O(n \log{n})$ time.*" is generally understandable but inaccurate.
	- As Professor Wang says, **please try to use these notations accurately**!!!


### Common Running Times

- For every function `f(n)` above `g(n)` in the list below, we have `f(n) = o(g(n))`.
	- $1$ (constant)
	- $\log_2 \log_2 n$ (double logarithmic)
	- $\log_2 n$ (logarithmic)
	- $\log_{2}^c n$ for a constant c > 1 (polylogarithmic)
	- $n^c$ for a constant c > 0 (polynomial)
	- $a^n$ for a constant a > 1 (exponential)
	- $n!$ (factorial)

### Polynomial Time

> A running time `T(n)` is called *polynomial time* if $T(n) = O(n^c)$.

- Polynomial time is an important concept and is quite robust across different computing models. For example, (a bit informally), polynomial time on a Turing machine is the same as polynomial time in any common programming language.
- If the input size doubles, a polynomial-time algorithm only becomes a constant ($2^c$) times slower (in terms of upper bounds $O(n^c)$). Some people use the word "efficient" to refer to polynomial time.

## Binary Search

**Problem:** We are given `n` integers in weakly increasing order $a_1 \leq a_2 \leq ... \leq a_n$ (stored in an array) and a query $q \in \mathbb{Z}$. Decide whether there is a number $a_i$ in the array that is equal to `q`.

```pseudocode
l = 1, r = n  
while l ≤ r do  
	Let m be ⌊(l + r)/2⌋  
	if am = q then  
		Return “Yes”  
	else if am < q then  
		l ← m + 1  
	else (am > q)  
		r ← m − 1  
	end if  
end while  
Return “No”
```

> The running time is $O(\log n)$. 

## Sorting

### Divide and Conquer

##### Quiz: A Tiling Problem

![](imgs/tiling-prob.png)

- In order to solve this problem, we need to break it down into quadrants.
- When `n=1`, a single tile is enough. If `n>1`, we must divide the grid into four quadrants, putting a tile in the center touching the three quadrants without an "X" and recurse.

![](imgs/tiling-prob-sol.png)

##### Quiz: Fast Exponentiation

> Suppose we need to compute $a^n \mod p$, the remainder after dividing $a^n$ by `p`, for positive integers `a`,`n`,`p`. Can we do it in $O(\log n)$ time (if `a` and `p` are constants)?

Answer:

- If `n` is even, then:
	- $a^n \mod p = (a^{n/2}\mod p)^2 \mod p$.
- If `n` is odd, then:
	- $a^n \mod p = ((a^{\frac{n-1}{2}} \mod p)^2 * a) \mod p$

#### Fast Exponentiation

```pseudo
procedure Exp(a,n,p)       > Compute a^n mod p
	if n <= 1 then
		return a^n mod p
	endif
	b <- Exp (a, [n/2], p)
	if `n` is even then
		Return b^2 mod p
	else
		return b^2 *a mod p
	endif
end procedure
```

#### Sorting in $O(n \log n)$ Time
- We need to sort `n` distinct numberes in increasing order.
- We have seen in a previous lecture that any comparison-based sorting algorithm must take $\Omega(n \log n)$ time in the worst case.
- In this lecture, we will present *two* comparison-based sorting algorithms that run in $n \log n)$ time. Hence their running times are optimal up to constatns.

### Mergesort

> Mergesort involves sorting the first half, then the second half, and then merging the two halves to get a sorted array.

```pseudo
procedure Mergesort(l, r)
	if l >= r then
		Return
	endif
	m <- [(l + r)/2]       > `m` is the midpoint
	Mergesort(l, m)
	Mergesort(m+1, r)
	Merge the two sorted lists. (a_l, ..., a_m) and (a_m+1, ..., a_r)
end procedure
```

#### Merging
- To merge two sorted lists, we can view the two lists as stacks/queues and pop the smaller element each time.

##### Example
- The list are `(4,7,9,10)` and `(2,3,8,15)`. We first compare `4` and `2` and pop the smaller one, `2` from the second list. Next we compare `4` and `3` and. pop the smaller one, `3` from the second list...

#### Time Complexity

Let `T(n)` be the worst-case time complexity to mergesort `n` numbers. We (roughly) have the *recurrence relation*:

$$T(n) = 2T(n/2) + O(n)$$

This solves to $T(n)=O(n\log n)$.

It is important to know how to solve recurrence relations. We will provide a pictorial illustration and a formal proof this time.

![](imgs/mergesort-pics.png)

##### Time Complexity Proof

More formally, we have (for all `n > 1` and a constant `c`)

$$T(n) \leq T(n/2) + T(n/2) + cn$$

- and $T(1) \leq c$ and $T(2) \leq c$ and $T(3) \leq c$.
- We postulate that $T(n) \leq 3cn\ln n$ for all `n >= 2` and prove it by *strong induction*.

![](imgs/mergesort-time-proof.png)

### Quicksort

```pseudo
procedure Quicksort(l, r)
	if l >= r then
		Return
	end if
	Find the median `p` in (a_l, ... , a_r) where p is the "pivot"
	Rearrange (a_l, ..., a_r) and put the number smaller than `p` left to `p` and the numbers larger than `p` right of `p`.
	Let `m` be the index of `p` after the rearrangement.
	Quicksort(l, m-1)
	Quicksort(m+1, r)
end procedure
```

Assume for now we can find the median in linear time.

![](imgs/quicksort-pics.png)

### Median of Medians

- In general, how to find the `k`-th largest element in a set of size `n`?
- This can be done in `O(n)` time using an algorithm called *median of medians*.
- The running time of *quicksort* is hence:
	- $T(n) = 2T(n/2) + O(n)$
- which solves to $T(n) = O(n \log n)$

```pseudo
procedure MoM((a_1, ..., a_n), k)        > Find the k-th smallest
	if n <=10 then
		Brute force and return the solution
	end if
	Divide `a` into `n/5` groups of 5 numbers.
	Let `M` be the medians of each group.           > |M| = n/5
	Find the median of `M` using MoM(M, |M|/2), call it `b` and let its rank in `a` be `k'`.
	If k' >= k then
		Remove everything larger than `b` in `a`
		Return MoM(a', k)
	else
		Remove everything smaller than `b` in `a`, get `a'`
		Return MoM(a', k-k')
	end if
end procedure
```

##### Quiz: Rank of `b`

- Show that the rank of `b` is between `0.3n` and `0.7n`. In other words, $o.3n <=k'<=0.7n$.

Answer: `k' >= 0.3n` because in half the `0.2n` groups, at least 3 elements are smaller than `b`.

`k' <= 0.7n` because in half the `0.2n` groups, at least 3 elements are larger than `b`.

#### Time Complexity of MoM

- Finding the median of meidans takes $T(0.2n)$ time.
- The rank of `b` is between 0.3n and 0.7n, and so recursion takes at most $T(0n.7n)$ time.
- The time complexity isL $T(n) = T(0.2n) + T(0.7n) + O(n)$.

##### Mathematical Induction

![](imgs/math-induction.png)

##### Strong Induction

![](imgs/strong-induction.png)

#### Comments on Quicksort

- We can find the median in linear time and use that as the pivot, but in practice, people usually use a *uniformly random element from the current range* as the pivot.
- Random-pivot quicksort can guarantee a running time of $O(n\log n)$ in *expectation*, but the worst-case time will be $\Theta(n^2)$. In practice it is likely faster than median-pivot quicksort due to its smaller time complexity constant.
- Alternatively, we can do this: run random-pivot quicksort and count thenumber of steps, if ti takes too long then fall back to median-pivot quicksort.
	- This method guarantees a worst-case running time of $O(n \log n$) while having a small time complexity constant.

#### Running time of Random Pivot Quicksort

The expected number of comparisons is:

$$\sum_{i=1}^{n}\sum_{i+1}^{n}Pr[i \text{ and } j \text{ are compared }] = \sum_{i=1}^{n}\sum_{i+1}^{n} \frac{2}{j-i+1}$$

$$= 2n \sum_{t=2}^{n} \frac{1}{t}=O(n \log n)$$

> Hence the expected running time of random-pivot quicksort is $O(n \log n)$.

---

##### Example

- Given an array of `n` distinct integers, find the `k`-th smallest one.

> This can be done in $O(n)$ time via *median of medians*.

### Stooge Sort

- Stooge sort is an interesting way to sort `n` numbers.
- The algorithm is very simple. For simplicity, we add to the array at most two $+\infty$'s so that now `n` is a multiple of 3.

## Dynamic Programming

- Talk about dynamic programming introduction
- Some examples
- Longest increasing subsequence.

### Number Pyramid

