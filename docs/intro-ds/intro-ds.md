# Intro to Data Science

Taught by: [Yongfeng Zhang](mailto:)

## What is Data Science?

- Data is growing, but its not only massive data, but also massive models and massive computation. (e.g. LLMs)
- Data contains value and knowledge.

### Data Science and Data Mining
- To extract the knowledge data needs to be:
	- Stored (*Database systems*)
	- Managed (*Data Management for Data Science*)
	- And **Analyzed** <- this class (*Data Science and Data Mining*)

### What is Data Mining?
- Given a lot of data
- *Discover patterns and models that are:*
	- **Valid:** Hold on new data with some certainty
	- **Useful:** Should help us learn something from data.
	- **Unexpected:** Non-obvious to us
	- **Understandable:** Humans should be able to interpret the pattern.

> In this class, we not only work with this *Big Data*, but we make predictions and analysis from the data.

### Why Data "Science"
- Brahe collected a lot of data about planetary motion. (Time and position about how planets circle around the sun.)
- Then, Kepler, student of Brahe, analyzed Brahe's data and discovered the rules behind how planets orbit the sun.

Due to the massive amount of data out there, it is almost impossible to manually analyze the data. This is why we need algorithms.
#### The Flow of Data Science

> Data Collection (almost automatic) -> Data analytics (What?) -> Data interpretation

### Data Mining Tasks

#### Descriptive Methods
- Find human-interpretable patterns that describe the data.
	- **Example:** Clustering

#### Predictive Methods
- Use some variable to predict unknown or future values of other variables.
	- **Example:** Recommender systems, Computational Advertising, etc.

### This Class
- This class overlaps with machine learning, statistics, artificial intelligence, databases but more stress on:
	- **Scalability:** (big data and big models)
	- **Algorithms**
	- **Computing Architectures**
	- Automation for handling **large data**

## Frequent Itemset Mining & Association Rules

> Understand whole process

### Association Rule Discovery

***Supermarket shelf management example*** - Market-basket model:

- *Goal:* Identify items that are bought together by sufficiently many customers.
- *Approach:* Process the sales data collected with barcode scanners to find dependencies among items.
- *A classic Rule:* If someone buys diaper and milk. then he/she is likely to buy beer.
	- Don't be surprised if you find six-packs next to diapers!

#### The Market-Basket Model
- A large set of *items*
	- e.g. things sold in a supermarket.
- A **large set** of *baskets*
- Each basket is a *small subset of items*
	- e.g. the things one customer buys on one day
- Want to discover ***association rules***...
	- People who bought `{x,y,z}` tend to buy `{v,w}`
	- e.g. Milk -> Coke / Diaper, Milk -> Beer

#### Applications

##### 1
- Baskets = sentences, Items = documents containing those sentences.
	- Items that appear together too often could represent plagiarism.
	- Notice items do not have to be "in" baskets
		- You only need to know each item belongs to which basket(s)

##### 2
- Baskets = patients, Items = drugs and side-effects
	- Has been used to detect combinations of drugs that result in particular side-effects
	- *But requires extension:* Absence of an item needs to be observed as well as presence.

##### 3 - Bipartite Graph
- Finding communities in graphs (e.g. twitter)
- Baskets = nodes, Items = outgoing neighbors
	- Searching for complete bipartite subgraphs $K_12$.

### Frequent Itemsets
- **Simplest question:** Find *sets of items* that appear together "*frequently*" in baskets.
- **Support:** for itemset *I*: Number of baskets containing all items in *I*.
	- Often expressed as a fraction of the total number of baskets.
- Given a *support threshold* `s`, then sets of items that appear in at least `s` baskets are called *frequent itemsets*.

#### Example
- Items = {milk, coke, pepsi, beer, juice}
- **Support threshold** = 3 baskets

#todo find the baskets

- Frequent itemsets: {m}, {c}, {b}, {j}, {m,b}, {b,c}

### Confidence and Interest

#### Example

## Association Rules

