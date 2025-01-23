# Design and Analysis of Computer Algorithms

## Introduction

> The [Course site](https;//sites.google.com/views/rutgers-cs344-s25)

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