# Clustering

> Given a set of points, with a notion of distance between points, group the points into some number of **clusters**
## BFR Algorithm

- **BFR** is a variant of `k`-means designed to handle *very large* (disk-resident) data sets.
- **Assumes** that clusters are *normally distributed* around a centroid in a Euclidean space.
	- Standard deviations in different dimensions may vary.
		- Clusters are axis-aligned ecllipses.
- **Efficient way to summarize clusters** (memory required O(Clusters) and not O(data))

---

### BFR Algorithm
- Points are read from disk ne main-memory-full at a time.
- Most points from previous memory loads are summarized by *simple statistics*.
- To begin, from the initial load we select the initial `k` centroids by some sensible approach:
	- Take `k` random points: pick a random point, and then `k-1` more points, each as far from the previously selected points as possible.
	- Take a small random sample and cluster optimally.
	- Now we have the initial `k` centroids and statistics.

### Three Classes of Points
- 3 sets of points which we keep track of:
	- **Discard set (DS):**
		- Points close enough to a centroid to be summarized.
	- **Compression set (CS):**
		- Groups of points that are close together, but not close to any existing centroid.
	- **Retained set (RS):**
		- Isolated points waiting to be assigned to a compression set.

![](imgs/actual/bfr-galaxies-pic.png)

#### Summarizing Sets of Points

For each cluster, the **discard set (DS)** is *summarized* by:

- The number of points, `N`
- The vector `SUM`, whose `i`-th component is the sum of the coordinates of the points in the `i`-th dimension.
- The vector `SUMSQ`: `i`-th component = sum of squares of coordinates in `i`-th dimension.

##### Close Enough?
1. How do we decide if a point is "close enough" to a cluster that we will add the point to that cluster?
2. How do we decide whether two *compressed sets (CS)* deserve to be combined into one?

#### How close is Close Enough?

**BFR suggests two ways:**

- The **Mahalanobis distance** is less than a threshold.
- High *likelihood* of the point belong to currently nearest centroid.

### Mahalanobis Distance
- **normalized Euclidean distance from centroid**
- For point $(x_{1}, ..., x_{d})$ and centroid $c_{1},...,c_{d}$
	- Normalize in each dimension: $y_{i}=(c_{i}-c_{i})/\sigma_{i}$
	- Take sum of the squares of the $y_{i}$
	- Take the square root.

> σᵢ is the standard deviation of points in the cluster in the i-th dimension

$$d(x,c)=\sqrt{\sum_{i=1}^{d}(\frac{x_{i}-c_{i}}{\sigma_i})^2}$$

---

- If clusters are normally distributed in `d` dimensions, then after transformation, for points within one standard deviation, `M-Dis = √d`
- Accept a point for a cluster if its M-Dis is < some threshold... e.g. 2 standard deviations.
	- 95% of points within 2σ.

## CURE Algorithm

##### Problem with BFR/k-means:
- Assumes clusters are normally distributed in each dimension
- Axes are fixed - ellipses at an angle are NOT ok.

### Starting CURE

2 Pass algorithm.

##### Pass 1

0. Pick a random sample of points that fit in main memory.
1. **Initial clusters:**
	1. Cluster these points hierarchically - group nearest points/clusters.
2. **Pick representative points:**
	1. For each cluster, pick a sample of points, *as dispersed as possible*
	2. From the sample, pick representatives by moving them (say) 20% toward the centroid of the cluster.

##### Pass 2
- Now, rescan the whole dataset and visit each point `p` in the data set.
- Place it in the "closest cluster"
	- Normal definition of "*closest*":
		- Find the closest representative to `p` and assign it to representative's cluster.

