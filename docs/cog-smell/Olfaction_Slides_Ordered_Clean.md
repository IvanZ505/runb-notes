# Smell Perception and Decision-making

## Slide 1
- Perceptual Decision-making
- Using information from the world to decide on a model of the world to use to decide how to use information from the world to decide on a model of the world.

## Slide 2
- Decisions Related to Olfaction
- Decisions a priori to detecting an odorant: Apply your model
- What am I likely to smell in this situation?
- What would be a priority to smell in this situation?
- Decisions a posteriori to detecting an odorant: Apply your model
- Did I smell something?
- Note that this is change or different detection task to spot a new odor “object” against an existing background.
- Perceptual decision-making: What did I smell?
- Brainstorm: What are the key perceptual dimensions of this decision?
- Response decision-making: How should I react to the new smell?

## Slide 3
- Models and Decision Making
- To make a decision, you have to define the question.
- Are you testing the null hypothesis that two things are the same?
- How precise does “same” need to be?
- What burden of proof do you need to meet?
- More likely than not?
- Five percent chance or less it’s just sampling error?
- Virtual certainty?
- The higher the stakes, the higher the burden.
- Advocating surgery requires stronger data than advocating for a multivitamin.
- There should not be a one-size-fits-all rule.
- Odor importance should factor into perceptual decision making.
- Are there two competing hypotheses you need to judge between?
- Is there pre-existing evidence that suggests one model is likely better than another, independent of any data you’ve gathered?

## Slide 4
- Models and Decision Making
- Olfactory perception is often statistical.
- Odorants are carried by physical plumes that distribute chaotically.
- Odorant deposition in the nose is statistical.
- Different odorants can have overlapping chemical components.
- Olfactory perception requires some degree of statistical decision making.

## Slide 5
- Models, Data, and Hypotheses
- Approaches to statistical decision making get philosophical quickly.
- Pragmatism: if the model works at predicting outcomes or suggesting new mechanisms, it wins.
- This means an abstruse machine learning algorithm is just as good as any other model if it achieves your goal.
- Frequentism: the probability of an outcome is objectively knowable with enough samples (or by covering an entire population), and differences in probability are thus also knowable.
- Note that the probability is of an outcome happening, not a hypothesis being true, so you cannot compare hypotheses with frequentist logic.
- Bayesianism: an assertion/hypothesis has a subjective probability based on prior knowledge that is updated when presented with new data.
- This allows comparisons of the relative likelihood of models if given both original subjective probabilities AND data.
- Note that information theory plays extremely nicely with Bayesian thinking.
- What approach the mind/brain uses is a complicated subject…
- Which one leads to scientific truth is….debatable.

## Slide 6
- Simple demonstration of Bayesian logic
- Imagine the case that you’ve tested positive for unusual disease X on a test with a 99% accuracy rate. What is the likelihood you have X?
#### Hint: It’s not 99%.

- Hint: This description does NOT include enough information to answer the question.

## Slide 7
- Simple demonstration of Bayesian logic
> Necessary facts:
- By 99% accuracy, let’s say that the errors are distributed as 0% failed detections and 1% false positives.
- Let’s specify that the overall incidence of disease X is 1 in 100,000.
- Let’s specify that the testing was universally done – you weren’t singled out for a test based on any known risk factor.
> Let’s game it out with 10 million people as a cartoon:
- 100 people have the disease and 9,999,900 don’t.
- Of the 9,999,900 who don’t, 1% get a false positive: that’s 99,999.
- Therefore, of all the people who get a positive test, 99,999 don’t have disease X and 100 do.
- If you have a positive test, you thus have a 100/(99,999+100) probability of having the disease: 0.000999 or 1 in a 1001 chance of actually having the disease.
- Or you could characterize it in terms of relative likelihood: Relative chance of it being a false alarm is 99,999/100 or 1000 to 1.

## Slide 8
- Simple demonstration of Bayesian logic
> Conclusions from our disease X discussion:
- Base rates matter TREMENDOUSLY
- Even a highly reliable piece of evidence that an event occurred is overwhelming likely to be incorrect if the underlying probability of the event is low.
- A frequentist model by definition doesn’t do this logic of relative likelihood of conclusions. However, it could look at the probability of developing the disease among people with a positive test and just measure it.
- Relative likelihood seems like a pretty compelling way to compare interpretations of data.
- Knowing the baseline probabilities of events is a prerequisite, but is it actually plausible in a research context?
- What if one of your hypotheses is the null hypothesis? Could you make an active argument that it is more likely than other hypotheses? (Yes!)

## Slide 9
- Simple demonstration of Bayesian logic
- Let’s do a grim analysis.
- If (let’s say) the base probability of a scientific discovery is 1% of experiments…
- …and you accept evidence with a 95% probability of being non-random and a 5% chance of being sampling error (e.g. p=0.05).
- Then for 1000 experiments performed…
- 10 are real discoveries and 50 are sampling error-based false alarms.
- Therefore a discovery with a p=0.05 is 5 times more likely to be a false alarm than a real discovery, just from sampling error alone.
- Notice that this is the ratio of error rate (5%) to base rate (1%).
- If the base rate is 50% and we use =0.05, then the likelihood of a significant result being a false alarm is only 1/10.
- So what is the real base rate for discovery?

## Slide 10
> Quick tangent:
- If you play a game with a 1/1000 chance of winning, but you play 1000 times, what is the probability that you win at least once?
- 1-(0.9991000) = 63%
- If you play a game with a 1/50 chance of winning, but you play 50 times, what is the probability that you win at least once?
- 1-(0.9850) = 63%
- If you publish papers with a 1/20 chance of erroneously rejecting the null hypothesis by mere chance, and you publish 20 papers, what is the probability you’ve erroneously rejected the null hypothesis at least once?
- 1-(0.9520) = 64%

## Slide 11
- Bayesian logic and Smell
- Remember that the decisions to be made in smell include whether an odor is present and what odor is present.
- The base rate of new odors arriving and the base rate of individual odors are necessary to optimally understand the olfactory world around you.
- Those base rates need to be learned. Perception is crippled if not informed by prior learning.

## Slide 12
- Information Theory

## Slide 13
- Information Theory & Statistics
> Imagine that X and Y have these values:
- Do you see a relationship you feel comfortable with?
- r2 = 0.07
- What if we add two more points?
- r2 = 0.99
- Why do these two points make the relationship compelling?

## Slide 14
- Information Theory & Statistics
- In the previous example, the original X and Y datasets have very little variance compared to the two points added later. The two last X points would be extremely improbable based on the rest of the X distribution, and the last two Y points would be extremely improbable based on the rest of the Y distribution.
- Because these values are improbable, they are more informative about the distribution than yet another 10 or 18 would be.
- Because the improbable X and improbable Y co-occurred, each is very informative about the other.
- We are now approaching information theory: the mathematical laws that link probability of an event to the information it could communicate.

## Slide 15
- Information Theory & Statistics
> Key principles of information theory for statistics:
- Not all values in a distribution are equally likely to be encountered a priori.
- For a given measured data point, only a subset of possible underlying distributions are likely for it to have come from.
- Data thus narrow the range of possible underlying realities, and improbable data are most helpful in this regard.
- Information is defined as degree of reduction in the uncertainty about the underlying reality provided by the data. Every twofold reduction in the range of possible realities is defined as 1 bit of information.
- The number of possible realities, weighted by their relative probabilities, is called entropy.

## Slide 16
- What the heck is entropy?
- Imagine that there is only one possible score on a test. Then observing a student’s score on the test doesn’t tell you anything about the student – it has no information because it hasn’t narrowed the range of possible test scores because the range of possible scores a priori was zero.
- Ergo, the number of possible realities contributes to the amount of possible information communicated.
- Now imagine that there was only one possible set of answers permitted on a test. Then observing the test score also doesn’t tell you anything about a student – it has no information because even though there is a nonzero range of possible scores, the answers given don’t reduce the range of possibilities of which one was actually given.
- Ergo, the range of possible data values received contributes to the amount of possible information communicated.
- Entropy is logarithm of the number of possible states the system can take, taking into account the probability of actually being in each one.

## Slide 17
- What the heck is entropy?
- In a system with high entropy, there are many possible realities and many possible data points received, and thus the information capacity is high.
- Remember that information is defined in terms of reducing the range of possible realities (messages) based on the data (signal) received. You need to have a lot of possible realities to be able to have a lot of information!

## Slide 18
- What the heck is entropy?

## Slide 19
- What the heck is entropy?

## Slide 20
- Information Theory & Statistics
- Remember: Information is defined as degree of reduction in the uncertainty about the underlying reality provided by the data. Every twofold reduction in the range of possible realities (i.e. entropy) is defined as 1 bit of information.
- Statistical models can be described in terms of their information value relative to the data, essentially how much information is lost if you replace the actual data points with your statistical model of the data.
- This approach lets you compare the goodness of fit between different candidate statistical models by seeing which loses the least information.
- It also allows you to seek relationships between variables based on the mutual information between them.

## Slide 21
- Information Theory & Statistics
- How does all this relate to smell?
- Knowing the statistical structure of odor space
- Familiarity with an odor mixture constitutes knowledge of the probabilities of relative odorant concentrations in that mixture.
- Familiarity with an environment or a food or a person constitutes knowledge of the probabilities of odors that occur around environment/food/person.
- High surprisal elements can be readily identified in familiar odor spaces (e.g. an off note in your milk suggesting its spoiled).
- Unfamiliar odor spaces feel deeply unfamiliar because you don’t understand the structure of the entropy within and between odors.
- Mutual information
- Learning what something smells like is using mutual information between the circumstance (e.g. visual appearance, location in space) and the odors experienced.

## Slide 22
- Information Theory, AIC, & Hypothesis Testing

## Slide 23
- Information Theory & Hypothesis Testing
- Likelihood is a measure of the goodness of fit of a model to a sample of data.
- Likelihood function for the probability of a coin landing heads-up (without prior knowledge of the coin’s fairness) given that we have observed HHT.
- Likelihood function of the probability of a coin landing heads-up (without prior knowledge of the coin’s fairness) given that we have observed HH.

## Slide 24
- Information Theory & Hypothesis Testing

## Slide 25
- Statistical Models and Decision Making
- All models are wrong…but some are less wrong than others.
- As a scientist, how do you decide which model to use?
- Choice among models can be informed by jointly considering…
- …how well the model fits the data (goodness of fit), and…
- …how many free parameters were included (with a “penalty” for more parameters).
> Common decision making calculations for this question include:
- Akaike information criterion (AIC)*
- Bayesian information criterion (BIC)*
- Likelihood ratio test
- Bayes factor
- built into Origin Pro’s Compare Models methods

## Slide 26
- Statistical Models and Decision Making
- All models are wrong…but some are less wrong than others.
- As a human experiencing the world, what model do you use?
- Is there likely to be single answer, where we use one decision-making model in all cases?
- For all smells?
- For all cognitive functions?
- What might determine our choice of model?
- How do we figure out what model is actually used by a human?
- Is asking sufficient or necessary?
- Is it a tractable question?

## Slide 27
- Statistical Models and Decision Making
- Akaike information criterion (AIC)
- Is based on information theory.
- Penalizes models by an appropriate amount for each free parameter added.
- Compares models to each other, not models to data.
- Essentially measures information lost by trading the data itself for a statistical model of the data.
- Lower is better.

## Slide 28
- Models, Data, and Hypotheses
- The model fitting process itself is based on model-data comparison and decision making
- You also need to decide between models.
- Then based on the models you need to decide what to believe.
- This is not easy.

## Slide 29
- Information Theory & Hypothesis Testing
- Let’s imagine the brain gets a noisy signal from the world that might be one messy input reflecting the presence of a single odor but it might be a combination of two somewhat similar odors…
- The next two slides demonstrate a statistical process of comparing the data to each potential model (1 distribution of odor-evoked activity vs 2 distributions of odor-evoked activity) and computing the relative likelihood.
- The mind seems to do something similar.

## Slide 30
- Distributional Hypotheses
- One Gaussian is more likely here because it’s more parsimonious than two, but it’s close.

## Slide 31
- Distributional Hypotheses
- Move the data means further apart (same random numbers) and the AIC quickly begins to indicate that two peaks are wildly more likely than one.

## Slide 32
- Information Theory & Hypothesis Testing
> A t-test implicitly considers two models:
- Model 1: The two datasets are best fit by two normal distributions with the same mean.
- Model 2: The two datasets are best fit by two normal distributions with different means.
- Instead of a t-test, you could fit both models to the data and use the AIC to decide the relative likelihood of each model given the data you’ve collected.
- Note that this logic does not assume equal variance (a t-test does).
- Note that you do not need to guess at the a priori probability of a difference (Bayesian approach) or choose an  value as an arbitrary cutoff (frequentist approach).
- Most importantly, you are using statistics to draw conclusions about the relative likelihood of hypotheses.
- This t-test alternative makes a statistical argument for a specific hypothesis, not an argument against the null hypothesis.

## Slide 33
- Mutual Information
- Mutual information tells you how much information you get about one variable by learning about another.
- It is inherently symmetrical – knowing one tells you about the other, and vice versa.
- If there is no relationship, the mutual information is 0.
- If there is a perfect one-to-one relationship, then the mutual information is equal to the entropy
- In this case knowing one value collapses the possible values of the other to a single possibility, so the information gained is the total available.
- In this case the entropy of the stimulus and the entropy of the response would be the same.

## Slide 34
- Mutual Information

## Slide 35
- Introduction to Multidimensional Data

## Slide 36
- Multidimensional Data
- NFL Team Wins, Regular Season
- 1 dimension (longitudinal)
- 1 dimension
- (cross-sectional)
- 2 dimensions
- (subset of data)
- 2 dimensions
- Multidimensional data is data for which you have two or more separate variables (i.e. measurements) for each individual data point, creating a matrix of numbers.
- Colloquially, we don’t usually call it multidimensional until we hit three dimensions.
- NB: This term is entirely unrelated to the form of the data within each dimension, so a measurement with two possible categories or four possible categories would be one-dimensional either way.

## Slide 37
- Multidimensional Data
- NFL Team Highest Playoff Round Won
- Adding another chart makes these four-dimensional data, because each instance is described by four variables: year, team, regular season wins, and highest playoff round won.
- It can be helpful to sketch out the dataset structure before you build it…
- NFL Team Wins, Regular Season

## Slide 38
- Multidimensional Data
- If you represented these data in Matlab, there would be 3 integer variables (Year, Regular Season Wins, Playoff Rounds Won) and 1 cell array where each cell is filled with character arrays known as strings (Team).
- The end result would be either 4 separate variables (if you built it that way) or a table or matrix with 4 dimensions.
- Typically you would combine variables from the same datapoints into one global structure rather than four separate variables.

## Slide 39
- Multidimensional Data
- It is totally okay to have some cells empty if you are missing data or had to exclude it for some reason. This screws up many “old fashioned” statistical models but lots of modern techniques are robust to missing data.
- Just make sure you understand what your preferred method requires.
- Matlab permits NaN values.

## Slide 40
- Multidimensional Data
- You typically don’t learn much beyond the X-Y Cartesian plane in basic math, and you typically don’t learn much beyond X-Y regression and correlation in basic stats.
- Extrapolating to 3-dimensions is pretty intuitive, and the key is to realize that the extrapolations to additional dimensions is exactly the same process as going from two to three.

## Slide 41
- Multidimensional Data
#### Exercise: Understanding N-dimensional space

- 1-D: picture a bunch of ping-pong balls clustered on a line.
- Imagine what a ball positioned at the midpoint of the cluster would look like.
- Imagine how you would describe how to move each ball to get it from its original location to the position of the midpoint ball. You would need distance to travel and a direction (+ or -).
- 2-D: picture the same bunch but now blurred off the line in both directions to form a cluster in X-Y space.
- Imagine what a ball positioned at the midpoint of the cluster would look like.
- Imagine how you would describe how to move each ball to get it from its original location to the position of the midpoint ball. You would need a distance and a direction along each axis (x, y).
- 3-D: picture the same bunch but now also blurred above and below the original line to form an X-Y-Z space.
- Imagine what a ball positioned at the midpoint of the cluster would look like.
- Imagine how you would describe how to move each ball to get it from its original location to the position of the midpoint ball. You would need a distance and a direction along each axis (x, y, z).
- 4-D: picture the same bunch of balls in X-Y-Z space but now the balls have hair of different lengths. Some balls have longer hair, and other balls have shorter hair.
- Imagine what a ball positioned at the midpoint of the cluster with average length hair would look like.
- Imagine how you would describe how to move each ball to get it from its original location to the position of the midpoint ball and how much you’d need to lengthen or shorten its hair to match the midpoint ball. You would need a distance and a direction along each axis, including the hair length axis (x, y, z, shorter hair-longer hair).
- N-D: picture any number of additional variables added to this scenario: ball hair color, ball size, ball temperature, ball rotation, etc. To describe how make any ball change into the ball of average position, hair length, size, etc., you just need a list of properties and how far and in what direction to change them.
- In each of these examples, you were intuiting the vector between each instance (single ball) in a population of balls in a multidimensional space and the centroid of that population.
- Spaces of more than 3 dimensions are called high-dimensional spaces or hyperspaces. You can totally picture them. (They are not like dusting crops).

## Slide 42
- Multidimensional Data
- Anything you want can be represented as a dimension in an N-dimensional space. When each position represents a possible state of your system, it’s called an N-dimensional state space.
- Measuring height, weight, blood pressure, pupil diameter, heart rate? Picture it in a 5-dimensional space.
- Categories are just dimensions with a limited number of values.
- Dimensions do not actually need to be orthogonal (perpendicular) for the space to work, though some methods require you to orthogonalize first.
- Time can be represented in its own dimension, or you can plot the state of your system as a trajectory through the space across time. Measuring the activity of 5 neurons over time? That’s a trajectory through a 5-dimensional space over time.
- Dimensions that loop back to the beginning (e.g. time of day or a cyclical process) can have the space itself be connected as a circle. This is called a phase space.

## Slide 43
- Multidimensional Data
- Why are N-dimensional representations useful to us?
- They allow highly complex datasets to be represented in a way that allows sophisticated mathematical techniques to be used to find patterns.
- Differences between points in multidimensional space can be quantified, so relatively simple equations can be used to find optimal dividing lines between groups or to develop multivariate regression lines. Dynamic systems can be best understood by the manifolds they trace out in state space.
- These concepts are so fundamental that virtually all statistics can be represented this way, but they are particularly central to both traditional multivariate statistics and more modern machine learning techniques.
- Note that these approaches are no longer exciting new techniques. They underpin lots and lots of the technology you use everyday.

## Slide 44
- Multidimensional Data
- What is the cost?
- As you increase the number of dimensions, the size of the state space goes up geometrically. To get equal data coverage of the possible spaces, you thus need geometrically more data with each metric you add. This is called the curse of dimensionality.
- This means it can be harder to get sound results.
- It also means the data points might be so different from each other that each point seems like its own cluster to an analysis algorithm.

## Slide 45
- What is Classification?

## Slide 46
- What is Classification?
- The general process of looking for structure in data (i.e. improbabilities/information) is called pattern recognition.
- Within pattern recognition, there are two general ways to do it: Classification and clustering
- If you know the category assignments for some instances, you can develop rules that allow you to categorize additional instances. This is classification, a.k.a. supervised learning
- Example: Study the features of spam and real email, then set up a statistical spam detector.
- Example: Study radiological images from patients who do or don’t turn out to have cancer, then use the algorithm to evaluate images from future patients.
- If you don’t have any a priori categories, you can look for categorical structure based on the non-randomness in the data. This is called clustering, which is a form of unsupervised learning.

## Slide 47
- What is Classification?
- In statistics, classification into categorical variables is done by logistic regression, where each instance (i.e. data point) includes values for multiple independent variables that are used as regressors to model the categorical dependent variable.
- Typically we think of having all the data and using the regression analysis to determine which independent variables predict the category (i.e. backwards inference), thereby giving us mechanistic insight.
- However, having completed an analysis you can also go forwards and use the model to predict the classification of new data points based on the measured values of the regressors.
- In machine learning, classification is done by supervised learning, where the classifier algorithm is “trained” on known data and then typically evaluated based on its ability to correctly classify new instances.
- It is sometimes, though not always, difficult to understand the logic adopted by the classifier, so machine learning approaches often yield little mechanistic insight, but...
- The emphasis on flexibility in learning algorithms usually produces better results.
- Notice that statistics and machine learning approaches are fundamentally doing the same thing – developing a useful classifier model for performing statistical inference – with different tools.

## Slide 48
- What is Classification?
- Probabilistic classifiers are a subset of classification algorithms that output not just a category assignment for each data instance but the probability of the instance belonging to each potential category.
- This is a probability distribution that adds to 1.
- The probabilistic classifier thus requires a decider downstream of it to assign each instance to a category.
- The highest-probability-wins decision rule is the most common decider, but...
- Each instance’s classification can have a confidence term associated with it, which can be super useful.
- Confidence estimates let you judge how to act on the outcome.
- Confidence estimates let you refine your classifier, including providing a basis for comparison between different algorithms that arrange categories differently.
- Confidence estimates can be analyzed to find the underlying rationale for categorization even in an otherwise opaque algorithm.
- Confidence estimates can allow you to flag individual results for human follow-up.
- The decider can have the option to abstain if the category is insufficiently certain.

## Slide 49
- What is Classification?
- A core feature of most modern classification algorithms is that each data instance is a multidimensional feature vector, where there are multiple measures associated with each instance to be categorized.
- Each subject might have as features (i.e. feature vector elements) sex, height, weight, age, race, S&D blood pressure, waist circumference, history of coronary artery disease, diabetes status at initial assessment, and diabetes status at 10 year follow-up.
- Subject data could be displayed in multidimensional space to observe the correlations and distributions.
- A classifier could be trained to find the patterns in the feature vector that predict diabetes status at the 10 year follow-up and thus both a) characterize the interactions among features that predict future risk and b) actually predict the chance of a new patient developing diabetes later, potentially including a confidence term on the prediction if an appropriate algorithm is selected.

## Slide 50
- What is Classification?
- Features can have any form
- They can be binary, categorical, ordinal, integer, real, even complex numbers.
- They can be numbers, video, audio, anything that can be represented on a computer.
- They need not be independent of each other (though some algorithms presume they are, these algorithms often work anyway).
- In practice, preprocessing of raw data to extract key features can be essential to providing the algorithm with the power it needs to solve the problem.
- You might add BMI as a feature calculated from height and weight.
- You often convert images into more abstract representations of objects and distances (but you might not).
- Not every algorithm can accommodate every data format.

## Slide 51
- What is Classification?
- The methods used for classification are diverse and reflect varied historical schools of thought.
- Fisher developed linear discriminant analysis, which is frequentist.
- Bayesian procedures allow you to assign prior probabilities among the categories, if their relative likelihoods are known.
- Selecting a method is often driven by convenience and experience, not necessarily deep insight or scientific principles.
- At the end of the day, all applicable methods can be tested and compared to see which works best for your dataset. Modern classification software (e.g. Matlab’s Classification Learner App) streamlines this process to allow you to compare many approaches with the click of a button.

## Slide 52
- What is Classification?
> Common supervised learning classification methods:
- Logistic Regression: Calculates a logistic function for assigning probability of category A vs B based on the conditional probabilities of each feature for each category. Two categories only (unless nested). Probabilistic.
- Naïve Bayes Classifiers: Combines conditional probabilities of each feature for each category with the marginal (non-conditional) probability of each category occurring. Any number of categories. Probabilistic.
- Support Vector Machine: A basic algorithm for finding the linear boundary that optimally separates two groups of X-Y datapoints that has now been extended to hyperspaces (N-dimensions) and highly nonlinear boundaries. Only two categories (unless nested). Non-probabilistic.
- Decision tree learning: Splits and conjunctions of features are recursively modeled to reach an optimum classification tree. Real-world use uses random forests, where many independent trees are generated using random subsets of the data and compared, and boosted trees, where multiple trees are generated but the optimization is changed each time to increasingly emphasize the previous misclassifications.
- K-nearest neighbors (KNN): For each datapoint, the closest k other points in multidimensional feature space get a “vote” on which category the datapoint should be applied to. This makes for local (as opposed to global) category rules.
- Helpful fact: KNN is a supervised learning/classification technique while “K-means clustering” is an unsupervised/clustering technique. They are very different things!

## Slide 53
- What is Classification?
- What about chi-square testing?
- First, nomenclature. Chi-square testing is a general category of testing distributions of categorical instances against distributions. Chi-square distributions are used for tests of goodness of fit (i.e. curve fitting), homogeneity, and independence.
- What you learned as the “chi-squared test” was more specifically Pearson’s chi-squared test (as opposed to, say, Yates’ chi-squared test). It tests the null hypothesis that the frequency of categorical outcomes in a given sample is consistent with a theoretical distribution.
- This kind of hypothesis testing is a separate question from whether instances can be categorized effectively by a given classifier, and can be downstream of a classifier. For instance, you could use a classifier to categorize your data points into variants 1, 2, 3 and then test whether an experimental manipulation made the distribution of these outcomes significantly different from the control case.


# neural coding and smell
## Slide 1
- Neural Representations & Computations

## Slide 2
- Neural Representation of Sensory Stimuli
- Anything in the world can be represented using anything else, though such representations are virtually always imperfect.
> Examples of representations:
- Words represent objects, actions, ideas, etc at some level of detail/abstraction
- A physical photo, digital photo, and written name might all represent the same person.
- Neurons firing action potentials, releasing neurotransmitter, making certain connections, expressing certain proteins, etc. might all represent an object, action, idea, etc.

## Slide 3
- Neural Representation of Sensory Stimuli
- Representations enable storage of information and transformation of information via computation.
- Equations are a way of using abstract, logical principles to understand relationships. When you put x=“three cats” into an equation and solve it, you are transforming a representation of three cats.
- Your brain is the machine that enables you to store and transform information about the world. We can study how it works to a) understand minds better, and b) figure out how to fix it when it breaks.

## Slide 4
- Neural Representation of Sensory Stimuli
- Given that…
- Sensory organs feed information to the brain
- Brain damage can disrupt sensory function
- Sensory activity drives neural activity in the brain
- You would expect that…
- A particular sensory stimulus could evoke a particular pattern of neural activity in the brain that corresponds to a particular perception of the stimulus

## Slide 5
- Neural Representation of Sensory Stimuli
- Neural representation of sensory stimulus: The pattern of neural activity that corresponds to a sensory stimulus.
- Neural encoding of a sensory stimulus: The process by which a sensory stimulus gets represented in the brain. This is highly variable across the senses.
- Which neurons respond to the stimulus might represent the location of a light in the visual field, or the frequency of a sound, or the identity of an odor. (These are just simple examples.)
- How the responding neurons act might represent the brightness of the light, or the intensity of the sound, or the concentration of the odor. (These are also just simple examples.)

## Slide 6
- Recording the activity of a neuron: Cartoon

## Slide 7
- Figure 1.30  Tuning curves of auditory neurons

## Slide 8
- Actual recordings of a hippocampal neuron
- Henze et al. 2000 J Neurophysiology

## Slide 9
- Respiration-coupled neuron
- Voltage
- (recorded from brain)
- Respiration
- (chest expansion)
- Butyl Acetate presentation
- Methyl Valerate presentation
- 15 Hz
- 160 Hz
- Raster plot (each dot is a spike,
- each line is 1 odor presentation)
- Summary histogram
- Actual recordings from the olfactory bulb
- McGann Lab, Rutgers

## Slide 10
- Voltage
- (recorded from brain)
- Uncoupled to respiration
- Isoamyl Acetate presentation
- Butyl Acetate presentation
- 10 Hz
- 70 Hz
- Actual recordings from the olfactory bulb
- McGann Lab, Rutgers
- Respiration
- (chest expansion)

## Slide 11
- Neural Representation of Sensory Stimuli
- Decoding of a neural representation: Figuring out what sensory stimulus is present (which the brain can’t know directly) from the pattern of neural activity the stimulus induces (which is all the brain knows).
- The brain/mind decodes neural activity to understand the world.
- Neuroscientists decode neural activity to figure out how the representation works.
- If you can decode a neural signal into the sensory stimuli that evoked it, then the information about those stimuli must be present.
- Watch the video of Jack Gallant’s talk where his lab decodes a movie from the pattern of activity in a person’s visual cortex

## Slide 12
- Neural Representation of Sensory Stimuli
- Limitations of decoding approaches
- The fact that scientists can decode info from the neural activity doesn’t mean the brain is using that info or using it the same way.
- (The brain isn’t recording from itself with electrodes or fMRI.)
- Often we actually do the decoding using machine learning approaches that provide no insight into how the neurons are actually representing the world.
- In this case all we are proving is that the sensory information is “in there somewhere”, which we presumably already knew.
- Very rarely do we have a system in which we can reasonably expect to be observing every neuron involved in a neural representation or to know every possible stimulus the brain could be representing.
- Essentially all experiments are based on partial codes for things we already knew (i.e. what stimulus we presented). It will be amazing when we start finding things in the code that we didn’t already know were there.

## Slide 13
- Neural Representation of Sensory Stimuli
- A few comments on neural representations
- Different physical aspects of a stimulus are usually represented separately, using different coding mechanisms or different neurons.
- This enables parallel processing, where multiple aspects of the stimulus are being considered at once (instead of one after another, which would be slower).
- This enables specialization, where different circuits or coding mechanisms are optimized for different things (e.g. separate processing of shape and movement in the visual system).
- This can be thought of analysis of the stimulus, where the brain decomposes the stimulus into its constituent parts
- Literally! Sounds and images get decomposed in the mathematical sense into their frequency and phase information via Fourier analysis.
- Sensory representations build in other information than just the external stimulus, including cognitive, physiological, and emotional information.
- Sensory representations get combined somehow to make a model of the world.

## Slide 14
- What are the neural representations of odors?

## Slide 15
- Neural Representation of Odors
- What is being represented?
- The chemical structure of the stimulus?
- The response of odor receptors?
- The intensity of the stimulus (measured or computed?)
- The chemical statistics of the world?
- The implications for the organism?
- Expected odors given the spatiotemporal context?
- The difference between expected odors and actual odors?
- Stimulus timing? Sniffing?
- How can we discriminate these possibilities?
- Decoding
- Identifying odor chemical identity, concentration, etc.
- Odor information that narrows down the possibilities
- Experimental manipulation of representations


# smell plasticity v2
## Slide 1
- Changing Sensory Systems

## Slide 2
- Changing Sensory Systems
- WHY would you want a sensory system to change?
- To optimize sensory function for a particular environment or goal

## Slide 3
- Changing Sensory Systems
- WHY would you want a sensory system to change?
- To optimize sensory function for a particular environment or goal
- To more effectively link sensory input to attention, affect, motivated behavior, etc.

## Slide 4
- Changing Sensory Systems
- WHEN would you want a sensory system to change?
- Adaptive responses: Sensory changes to adjust to stimuli as they are encountered
#### Example: Pupillary responses


## Slide 5
- Changing Sensory Systems
- WHEN would you want a sensory system to change?
- Anticipatory responses: Sensory changes that occur when a stimulus is expected
#### Example: Priming based illusions

#### Example: Interpreting sound sources


## Slide 6
- Changing Sensory Systems
- Fassnidge et al. 2018
- Image of a jumping power line thing where you image the sound of the thump of it hitting the groud

## Slide 7
- Changing Sensory Systems
- WHEN would you want a sensory system to change?
- Ongoing responses: Sensory changes that last indefinitely
#### Example: Recognition based illusions


## Slide 8
- Changing Sensory Systems
#### Twitter: @markysumm


## Slide 9
- Changing Sensory Systems
- Sensory dynamics have a cognitive component in so far as they apply pre-existing, learned information about the world to better interpret sensory input OR couple sensory input to behavior.

## Slide 10
- Changing Sensory Systems
- If sensory dynamics have a cognitive component, that means that…
- We should see beliefs about the world reflected in sensory processing, maybe even beliefs that are incorrect.
- Cognitive dysfunction might be expected to manifest in particular forms of sensory dysfunction.

## Slide 11
- Odor Representations Change

## Slide 12
- What if an Odor Becomes Common in the Environment?

## Slide 13
- Week-long intermittent odor exposure alters OSN selectivity
- For OMP-Heterozygous Mice
- Kass et al. 2013 Journal of Neuroscience
- This is a change in
- neural representations based on learned natural statistics of odors.
- Why could that be useful?

## Slide 14
- Learning: What if an Odor Selectively Predicts a Shock?

## Slide 15
- Discriminative fear conditioning yields odor-specific fear and odor-specific increases in OSN output
- Kass, Rosenthal et al. Science 2013
- This is a change in
- neural representations based on learned odor-shock contingencies.
- Why could that be useful?


# smell plasticity pt2
## Slide 1
- What if the Mouse THINKS an Odor Predicts a Shock?

## Slide 2
- Rosenthal et al. In Preparation
- Single-odor conditioning yields generalization in OSNs
- This is a change in
- neural representations based on inferred odor-shock contingencies.
- Why could that be useful?

## Slide 3
- Single-odor conditioning yields generalization in PG cells
- Kass et al. 2017 in Neurobiology of Learning and Memory
- This is a change in
- neural representations caused by learning that occurs during first inhalation. contingencies.
- Why might that timing matter?

## Slide 4
- How Could the Bulb Know?

## Slide 5
- “On the finer structure
- of the olfactory bulb”
- Camillo Golgi,1875

## Slide 6
- CBL Amygdala inactivation “ungates” OSN output
- Fast and McGann 2017 J Neuroscience

## Slide 7
- Footshock evokes activity throughout the olfactory bulb
- Perkins et al. In Progress

## Slide 8
- How does information get from the PG cells to the OSNs?

## Slide 9
- GABAergic presynaptic inhibition works through N-type calcium channels

## Slide 10
- Circuit-Level Mechanisms Shaping Odor Representations

## Slide 11
- Glutamate release evokes GABA(B)-mediated presynaptic inhibition of transmitter release

## Slide 12
- Glutamate release evokes GABA(B)-mediated presynaptic inhibition of transmitter release

## Slide 13
- GABA(B) receptors mediate suppression of presynaptic calcium influx

## Slide 14
- GABAergic presynaptic inhibition works through N-type calcium channels

## Slide 15
- Feedback presynaptic inhibition of input to the olfactory bulb

## Slide 16
- What is the Functional Organization of this Inhibition?

## Slide 17
- Potential circuit organizations
- Axon-specific feedback inhibition
- Does the feedback only affect the neurons that are firing?
- Whole-glomerulus feedback inhibition
- Are all of the inputs to a glomerulus modulated together?

## Slide 18
- Intraglomerular, heterosynaptic inhibition of transmitter release

## Slide 19
- Potential circuit organizations
- Axon-specific feedback inhibition
- Does the feedback only affect the neurons that are firing?
- Whole-glomerulus feedback inhibition
- Are all of the inputs to a glomerulus modulated together?
- Center-surround organization
- Does activity in a glomerulus inhibit input to neighboring glomeruli?

## Slide 20
- Mixture experiments give no evidence of interglomerular presynaptic inhibition in vivo

## Slide 21
- Predictions for role in shaping odor representations
- Blocking GABAB receptors will increase the magnitude of input to the olfactory bulb.
- Blocking GABAB receptors will not change the pattern of response among glomeruli.

## Slide 22
- CGP reverses action of baclofen in vivo

## Slide 23
- Blockade of GABA(B) receptors in vivo greatly increases odorant-evoked transmitter release

## Slide 24
- CGP causes a proportional increase in input

## Slide 25
- Potential Functions of Presynaptic Inhibition

## Slide 26
- Potential Functions of Presynaptic Inhibition

## Slide 27
- What Does This Plasticity Accomplish?

## Slide 28
- Odor exposure improves odor discrimination
- Kass et al. 2016 Chem Senses
- BEFORE
- Exposure
- AFTER
- Exposure

## Slide 29
- Kass et al. 2017 in Neurobiology of Learning and Memory
- Generalizing conditioning makes odor representations more similar

## Slide 30
- Discriminative fear conditioning makes odor representations more different
- Kass et al. 2013 Science

## Slide 31
- Mouse olfactory plasticity: Summary
- Changes in odor representations can manifest as modest differences in odor perception.
- Discriminative conditioning causes odor representations to become more different.
- Generalizing conditioning causes odor representations to become more similar.
- These changes happen as early as the olfactory nerve terminals.

## Slide 32
- What if Humans Experience Odor-Cued Aversive Conditioning?

## Slide 33
- Olfactory perception is altered by odor-cued aversive conditioning
- Enantiomer pairs become more discriminable if they differentially predict a mild shock (Li et al. 2008).
- Detection thresholds are reduced for odorants that predict a mild shock (Åhs et al. 2013).
- Effects can be long-lasting (Parma et al. 2015).
- Alterations have been reported in epithelial (Cavazzana et al. 2018) and cortical (Li et al. 2008) physiology in humans after odor-cued aversive conditioning.
- Human olfaction and aversive conditioning

## Slide 34
- Mouse odor representations are transformed after discriminative aversive conditioning to become more different, and are transformed after generalizing fear conditioning to become more similar.
- Unfortunately, we can’t get the mice to tell us about odor similarity when they are scared of the odors.
- However, there is a subpopulation of humans who tend to generalize fear when others discriminate…
- Human olfaction and aversive conditioning

## Slide 35
- Anxiety disorders like PTSD and Generalized Anxiety Disorder have been linked to inappropriate generalization, where stimuli resembling a threat-related cue become able to evoke inappropriate fear or anxiety responses.
- In discriminative aversive conditioning paradigms, anxious people tend to inappropriately generalize fear to non-threatening CS- stimuli (Gazendam et al. 2013; reviewed in Lissek et al., 2005).
- Aversive Learning, Generalization, and Anxiety

## Slide 36
#### Hypothesis

- During aversive discriminative conditioning paradigms in which typical people exhibit learned improvements in their ability to discriminate between similar odorants...
- …highly anxious people will show increased but generalized fear/arousal and no improvement in sensory discrimination.
- Aversive Learning, Generalization, and Anxiety

## Slide 37
- Participants were head-fixed, asked to breathe normally, and received odors through a delivery port positioned in front of the nose.
- Participants were asked to discriminate hexanal from heptanal in a forced choice triangle task. This was hard for most.
- Technical Details
- 6 triangles prior to conditioning and 6 more after conditioning.
- Odorant presentations were 6 sec long separated by 10 sec.
- Odorant concentrations were selected to be isointense.
- Keypress reaction time was measured and outliers with very long reaction times were excluded.
- Assessment of Perceptual Change: Odor Discrimination Task

## Slide 38
- Odors
- Hexanal and Heptanal were counterbalanced across participants for which one predicted the shock (CS+) and which did not (CS-).
- 8 CS+ trials  and 8 CS- trials (6 sec) presented in pseudorandom order with 45-75 sec intertrial interval
- Shocks
- CS+ presentations co-terminated with a 200 msec wrist shock.
- Shock intensity was determined prior to the experiment by increasing shock level until the participant reported it was “uncomfortable but not painful”.
- All participants received these calibration shocks regardless of experimental group.
- Skin Conductance – a measure of autonomic arousal
- Skin conductance was measured from electrodes on the fingers.
- Resting skin conductance levels (SCLs) and stimulus-evoked skin conductance responses (SCRs) were quantified.
- Human olfaction and aversive conditioning

## Slide 39
- Anxiety Assessment
- State & Trait Anxiety Inventory (STAI) (Spielberger et. al 1983)
- State anxiety refers to how someone feels at the time of participation while trait anxiety refers to how a person feels in general.
- 20 statements such as “I worry too much over something that really doesn’t matter”, “I feel at ease” or “I feel nervous”.
- 4 Point scale 1. Almost Never, 2- Sometimes, 3 – Often, 4-Almost always . Higher scores indicate greater anxiety symptoms
- Anxiety Groups
- High Trait Anxiety (HTA): STAI Trait score ≥ 48
- Normal Trait Anxiety (NTA): STAI Trait score < 48
- This cutoff is an effective means of screening for preclinical anxiety in college students (Sarkın & Gülleroğlu, 2019).
- Human olfaction and aversive conditioning

## Slide 40
- 208 Rutgers undergraduates participated
- 159 scored as Normal Trait Anxiety
- 49 scored as High Trait Anxiety
> There were no differences in:
- Age (p=0.62)
- M/F sex ratio (p=0.64)
- Resting skin conductance level (p=0.85)
> Shock perception was not significantly different:
- Same shock voltage selected (p=0.85)
- Skin conductance response to shock (p=0.10)
- Both groups were equal on baseline odor discrimination (p=0.95).
- Human olfaction and aversive conditioning

## Slide 41
- Discrimination Learning
- Aversive learning causes increased odor-evoked SCRs

## Slide 42
- Discrimination Learning
- NTA subjects exhibit physiological discrimination

## Slide 43
- Discrimination Learning
- Aversive learning causes increased odor-evoked SCRs

## Slide 44
- Discrimination Learning
- HTA subjects don’t exhibit physiological discrimination

## Slide 45
- Discrimination Learning
- Perceptual improvement after aversive learning in NTAs
- Perceptual improvement in NTA individuals replicates work from the Gottfried, Lundstrom, and Li labs (among others) with a new pair of odorants.
- There was no correlation between perceptual improvement and physiological discrimination.
- There was no correlation between perceptual improvement and shock intensity selected.

## Slide 46
- HTA participants were similar to NTA participants prior to conditioning.
- HTA participants did not improve their discrimination.
- Perceptual effects of aversive conditioning

## Slide 47
- Learning-induced perceptual plasticity is absent in this task in individuals with preclinical levels of trait anxiety.
- HTA participants exhibited blunted learned arousal responses, even though their unlearned responses to shock were the same as the NTAs. This is consistent with prior clinical literature (Naveteur & Baque 1987; Naveteur et al. 2005).
- The increased skin conductance responses that were exhibited by the HTA participants were comparable between CS+ and CS- showing that they generalized between the odors.
- Human olfaction and aversive conditioning

## Slide 48
- Perceptual discrimination → Differences in arousal in NTA participants
- OR
- Differences in arousal in NTA participants → Perceptual discrimination
- What if we reversed the differential arousal responses?
- Human olfaction and aversive conditioning

## Slide 49
- The Extinction group received the initial aversive conditioning block (16 trials) followed by a longer extinction (32 trials) block in which no shocks were presented for either odor. This Extinction group was compared to an odor alone control group.
- We expected extinction training would reduce CS+-evoked SCRs and end the physiological discrimination between the odors.
- We hypothesized that it would also reverse the perceptual improvement.
- N.B. This analysis is necessarily restricted to the participants who actually exhibited clear discrimination between CS+ and CS- after the initial training. That implicitly removes all the HTAs.
- Extinction learning

## Slide 50
- Reversal of Differential Response to CS+ and CS-
- Reversal of
- Aversive Learning
- Extinction learning: physiological effects
- Extinguished participants exhibited modest odor-evoked SCRs that were nearly identical for the CS+ and CS- odors.
- They were thus similar to HTA participants.

## Slide 51
- Discrimination Learning
- Perceptual performance after extinction

## Slide 52
- These results are consistent with the mouse data, which suggested that discriminative fear learning would make early neural odor representations more different, and thus more perceptually discriminable, but generalized fear learning would not.
- The extinction group retained some perceptual gains despite the reduced SCR amplitude and loss of differential SCR to the CS+ and CS- odors.
- This demonstrates that the differential arousal is not causal to the perceptual discrimination boost. (See Ross and Fletcher 2018 for mouse amygdala inactivation.)
- This suggests that the abnormal learned SCR responses in HTA subjects is not the cause of their deficit in perceptual plasticity.
- Anxiety and Perceptual Plasticity

## Slide 53
- In this task it was initially difficult to know which of two similar olfactory cues actually predicted the physically uncomfortable outcome, but typical participants quickly learned to tell the odors apart.
- This perceptual plasticity may have enabled NTA participants to partially limit their physiological arousal by the odorant that did not predict a shock.
- The absence of perceptual learning in highly anxious participants may thus contribute to their inability to limit their arousal to actually threat-predictive stimuli and not generalize to similar stimuli that predict no such threat.
- Anxiety and Perceptual Plasticity

## Slide 54
- People with high trait anxiety may inhabit a sensory world in which more stimuli are perceived as potentially threatening and thus they feel anxious more of the time.
- Anxiety and Perceptual Plasticity

## Slide 55
- Conclusions
- “Cognitive dysfunction might be expected to manifest in particular forms of sensory dysfunction.”
- The absence of aversive learning-induced perceptual plasticity in highly trait anxious participants is a sensory dysfunction.
- It is a specific dysfunction, that we predicted from the tendency toward overgeneralization in anxious individuals.
- Cognitive dysfunction really can have sensory consequences.

## Slide 56
- It was already known that aversive conditioning could induce long-lasting plasticity in olfactory perception (Parma et al. 2015).
- These data add the finding that even when the odor-shock contingency is no longer true (i.e. after extinction), the perceptual improvement can persist.
- Our current sensory abilities partially reflect our past histories.
- Changes in the olfactory system are consistent with cognitive processing.
- Conclusions

## Slide 57
- Change is a hallmark of mammalian olfaction


# clinical assessment slides

## Slide 2
- Announcements
- Class will be VIRTUAL and ASYNCHRONOUS next week (as I mentioned the first day).
- I will be at a conference on clinical adoption of human smell assessment, so I will upload a presentation about what I learn.
- Thank you for your submissions for the 2nd topical response.
- There will be one more due during the last week of the semester.
- If you were one of the 2 unexcused non-submissions, please talk to me.

## Slide 3
- Today’s Plan
- Overview of clinical olfaction
- Key facts about olfactory loss epidemiology
- Summary of common assessment methods
- In-Class Laboratory Session in Groups
- Be a participant in a real chemosensory experiment (optional)
- Help figure out the logistics of the new chemesthetic testing apparatus
- Self-guided testing of your olfactory identification scores
- Student-led data collection on lateralization thresholds and adaptation rates

## Slide 4
- Overview of Clinical Olfaction

## Slide 5
#### Terminology: Clinical Disorders

> As defined in the 2023 position paper on olfactory dysfunction (Whitcroft et al. 2023 in Rhinology):
#### Normosmia: Quantitatively normal olfactory function

#### Hyposmia: Quantitatively reduced olfactory function

- Anosmia: Quantitatively reduced olfaction to the extent that the sense of smell is not useful in daily life
- Specific anosmia: Quantitatively reduced ability to smell a specific odor despite preserved ability to smell the vast majority of other odors.
- Hyperosmia: Quantitatively increased ability to smell odors (>90th percentile of scores in an olfactory test)

## Slide 6
#### Terminology: Clinical Disorders (cont.)

> As defined in the 2023 position paper on olfactory dysfunction (Whitcroft et al. 2023 in Rhinology):
- Olfactory intolerance: Qualitative olfactory dysfunction where individuals, without odor distortion, complain of a subjectively enhanced sense of smell and are intolerant of everyday odors.
- Parosmia: Qualitative dysfunction in the presence of an odorant (i.e. distorted perception of an odor stimulus)
- Phantosmia: Qualitative dysfunction in the absence of an odorant (i.e. an odorant is perceived without concurrent stimulus, an “olfactory hallucination”)

## Slide 7
- Epidemiology
- Olfactory dysfunction is common, but there is disagreement on prevalence numbers because a) different clinical populations produce different results, and b) different groups use different assessment methods and criteria
- The largest population studies use self-report, which is usually a severe undercount compared to objective laboratory testing.
- Many people who report taste dysfunction have actually lost retronasal smell.
- A reasonable consensus number based on meta-analysis of published work would be that: 22% of the general population has an olfactory dysfunction.
- It definitely becomes more likely with aging.
- Loss of smell in older adults is correlated with cognitive decline and increased mortality risk.
- The risk of smell loss may be greater in men and in smokers, but there is disagreement across studies.

## Slide 8
- Epidemiology
- Olfactory dysfunction is a significant predictor of all-cause five-year mortality in older adults (i.e. the chance of dying for any reason within 5 years of testing).
- 1.68 hazard ratio (Gopinath et al.)
- Similar results from Devanand et al. in the US.
- Similar results from the NSAHP study in the US.
- Olfactory dysfunction also correlates with a general cognitive decline in multiple studies.
- It may be the “canary in the coal mine” for aging-related neural dysfunction.

## Slide 9
- Types of dysfunction by mechanism
- Conductive dysfunction: Resulting from blockage of odorant transmission to the olfactory neuroepithelium
- i.e. odor can’t get to the right place in the nose
- Sensorineural dysfunction: Resulting from damage/loss of the olfactory neuroepithelium or nerve
- i.e. OSNs or olfactory nerve don’t respond to the odor
- Central dysfunction: Resulting from damage/loss of the olfactory processing pathways of the central nervous system
- i.e. olfactory nerve sends signals but the brain doesn’t understand

## Slide 10
- Types of dysfunction by mechanism
> There has been an attempt to organize olfactory loss by location of problem:
- Conductive dysfunction: Resulting from blockage of odorant transmission to the olfactory neuroepithelium
- i.e. odor can’t get to the right place in the nose
- Sensorineural dysfunction: Resulting from damage/loss of the olfactory neuroepithelium or nerve
- i.e. OSNs or olfactory nerve don’t respond to the odor
- Central dysfunction: Resulting from damage/loss of the olfactory processing pathways of the central nervous system
- i.e. olfactory nerve sends signals but the brain doesn’t understand
- However, in practice it’s rarely so simple and well defined.

## Slide 11
- Common causes of smell loss
- Post infectious olfactory dysfunction (PIOD)
- COVID-19-associated PIOD (C19OD)
- Non-COVID-19-associated PIOD (such as chronic rhinosinusitis)
- Olfactory dysfunction secondary to sinonasal disease
- Post-traumatic olfactory dysfunction (PTOD) (such as head injury or concussion)
- Olfactory dysfunction associated with neurological disease
- Olfactory dysfunction associated with exposure to drugs/ toxins
- Congenital olfactory dysfunction
- Olfactory dysfunction associated with aging (presbyosmia)
- Other possible causes: iatrogenic - complications (e.g., sinonasal and skull base surgery), iatrogenic - consequence (e.g., laryngectomy), tumours, multiple systemic co-morbidities
- Idiopathic olfactory dysfunction (no clear reason)

## Slide 12
- Clinical Assessment Flow Chart

## Slide 13
- Clinical Assessment
- Patient history
- Specific impairment description: smell vs taste, type of impairment (e.g. anosmia vs parosmia), previous treatments, etc.
- Onset (sudden vs gradual), circumstances
- Duration
- Fluctuation
- Sinonasal symptoms (e.g. allergy, chronic rhinosinusitis): nasal obstruction, runny nose, postnasal drip, facial pain, sneezing, itching
- Non-sinonasal symptoms: COVID-19, anything else
- Specific impairments and quality of life
- Medical history (head injuries, upper respiratory infections, sinus surgery, neurological disease)
- Current medications
- Allergies, smoking, toxins and occupational exposure, family history of smell loss or neurodegenerative disease like Alzheimer’s or Parkinsons

## Slide 14
- Clinical Assessment
- Clinical examination
- Nasal endoscopy to visualize the olfactory cleft
- Does it look right?
- Are there polyps, discharge, scars, etc?
- Any evidence of tumors?
- Neurological testing where appropriate

## Slide 15
- Clinical Assessment
- Olfactory testing
- Subjective testing
- Likert scales, SNOT-22 reporting for chronic rhinosinusitis, Questionnaire of Olfactory Disorders
- Not recommended when better options are available

## Slide 16
- Clinical Assessment
- Olfactory testing
- Psychophysical testing
- Threshold:  Determining the lowest odor concentration the patient can perceive
- usually tested vs a blank control stimulus
- Usually viable even in patients with cognitive problems
- Discrimination: Measuring the patient’s ability to tell easily detectable odors apart
- Requires some memory function to compare across stimuli
- Identification: Measuring patient’s ability to recognize odors
- almost always administered as a multiple-choice test
- Requires adaptation to the local culture and foods (e.g. wintergreen, Vaporub)
- Taste testing is sometimes helpful to distinguish patient symptoms between olfactory dysfunction and gustatory dysfunction, especially since COVID-19 impacts both.

## Slide 17
- Clinical Assessment
- Physiological testing and medical imaging
- EEG (from the head) and EOG (from the inside of the nose) can be used to detect odor-evoked physiological signals, even in cases where the patient can’t communicate
- fMRI is usually reserved for research purposes and can’t usually visualize the olfactory bulb, just the cortex
- CT scans of the nose are common to check for inflammation
- Structural MRI is often useful to check for congenital abnormalities and potential neurological problems.

## Slide 18
- Psychophysical Testing
- Psychophysics is the branch of psychology that tries to quantitatively relate the physical stimulus and the percept of the stimulus.
- A threshold in psychophysics is the stimulus magnitude that is detectable 50% of the time
- It is defined statistically by extrapolating the test results from near-threshold stimuli
- For smell there is a noticeable distinction between the detection threshold, where you can just barely detect the odor, and the recognition threshold, where the odor is strong enough to recognize it

## Slide 19
- Psychophysical Testing
- Psychophysics is the branch of psychology that tries to quantitatively relate the physical stimulus and the percept of the stimulus.
- A threshold in psychophysics is the stimulus magnitude that is detectable 50% of the time
- It is defined statistically by extrapolating the test results from near-threshold stimuli
- For smell there is a noticeable distinction between the detection threshold, where you can just barely detect the odor, and the recognition threshold, where the odor is strong enough to recognize it

## Slide 20
#### Psychophysics: Measuring Thresholds

- If this ‘all or nothing’ perception were a true depiction of threshold, then threshold would be easy to define…but perception DOES NOT WORK LIKE THIS.

## Slide 21
#### Psychophysics: Measuring Thresholds

- Thresholds
- Sensory thresholds are not all-or-none.  When you get close to the limit of what you can detect, sometimes you detect the stimulus and sometimes you don’t.  We therefore define thresholds statistically.
- Detection threshold: Minimum amount of stimulation necessary for a person to detect a stimulus 50% of the time. NOTE: The generic term “threshold” almost always refers to absolute threshold.
- Recognition threshold:  The minimum amount of stimulation necessary for a person to identify a stimulus correctly 50% of the time.

## Slide 22
- Threshold as defined statistically

## Slide 23
#### Psychophysics: Measuring Thresholds

> Psychophysical methods for threshold measurement:
- Method of constant stimuli: Many stimuli, ranging from rarely to almost always perceivable, are presented one at a time.  (Disadvantage:  needs many, many trials.)
- Method of limits: The magnitude of a single stimulus or the difference between two stimuli is varied incrementally until the participant responds differently

## Slide 24
- Threshold as defined using the method of limits
- The stimulus starts out strong and is weakened until the patient can’t detect it anymore (typically using a forced choice task).
- Then the stimulus starts out weak and gets strengthened until it becomes detectable.
- This process is repeated 6-12 times.
- The average reversal point is considered the threshold.

## Slide 25
- Threshold as defined using the method of limits – real data from an olfactory clinic

## Slide 26
- Smell Testing
- We’re going to demonstrate smell threshold testing using the method of limits and the Snap N Sniff set, which is a cousin of the popular Sniffin’ Sticks system that is popular in Europe.

## Slide 27
- Student Laboratory Time

## Slide 28
- Laboratory Demonstrations
- There are 7 laboratory stations set up.
- Two are collecting data related to taste sensation and vaping/Zyn use (or non-vaping control) for you to watch or volunteer to participate. They will run continuously today as a demonstration.
- 5 are pilot studies for YOU to conduct in groups, which I will assign. You need to report your data from these tests to the class at the end!
- At the end of the class, I will ask someone from each group to briefly show their results to the class.
- Each of you is invited to write about your results or experience as your third topical response.

## Slide 29
- Laboratory Demonstrations
- Stations 1 and 2: Taste testing
- Be a participant – complete the questionnaire and take the test
- Be an observer – come watch the experiment being conducted
#### Station 3: Smell identification testing

- Administer the snap n sniff identification test on each other while completing the actual multiple choice questionnaire

## Slide 30
- Laboratory Demonstrations
#### Station 4: Trigeminal/chemesthetic lateralization testing

- Help us figure out the best way to test for the “feel” of eucalyptol in your nose by testing your ability to lateralize the stimulus.
- In theory, you can feel which nostril a trigeminal-activating odor came in, but not which nostril a purely olfactory odor came in.
- Help us figure out the best procedure to test for trigeminal lateralization using a brand-new head-positioning system by being a subject.

## Slide 31
- Laboratory Demonstrations
#### Station 5: Lateralization thresholds

- In theory, there must be some concentration of eucalyptol that you can’t feel well enough to lateralize it and some concentration at which you can. We call the concentration where you first become able to lateralize the odor the lateralization threshold.
- Different individuals likely have different lateralization thresholds.
- Your job is to design and perform a pilot experiment that lets you figure out what the lateralization threshold is for several members of your group. You have three concentrations of eucalyptol in your bottles to work with.

## Slide 32
- Laboratory Demonstrations
- Station 6 and 7: Trigeminal adaptation
- When we test trigeminal lateralization, we have to decide on the rate at which we present the eucalyptol. However, nobody knows how fast is too fast.
- Your mission is to figure out the fastest rate people can get sniffs of eucalyptol without becoming adapted to it.
- We suggest starting with each person scoring the intensity of the feeling of eucalyptol in their nose.
- Then deliver single small squeezes of eucalyptol repeatedly every 15 sec., 30 sec, or 60 sec.
- Then re-test the perceived intensity of the feeling of eucalyptol.
- If you are careful, you should be able to run multiple people through this paradigm at once.


# AChemS post meeting report posted
## Slide 1
- AChemS report
- Cognitive Science 417: Advanced Topics in Cognitive Science: Perception
- Spring 2025
- John McGann

## Slide 2
- Announcements
- There will be a quiz posted by tomorrow morning, to be completed by May 7.

## Slide 3
- Today’s Plan
- Presentation of content from the clinical olfaction workshop at the Association for Chemoreception Sciences (AChemS) Annual Meeting in Florida.
- Final testing of our class-made vanilla extract
- Closing remarks

## Slide 4
- Snippets from the AChemS Conference
- There’s a classic idea that odorants can be metabolized by protective/immune system enzymes in the nose, such that what we actually smell is a combination of the external odor and its metabolites.
- For instance, ester odors (like the ones used in my mouse studies) can be broken down by carboxylesterase enzymes in the nose into an organic acid and an alcohol.
- This can in theory happen in tens of milliseconds.
- Many fruity esters decompose into phenylacetic acid, which smells distinctly of honey.
- Matt Wachowiak gave a compelling talk using optical imaging of mouse glomeruli showing that this is likely happening for real.
- His data suggested that the external odor response is sniff-locked (it comes and goes) while the metabolic signal is slower and later.
- We discussed the implications over lunch with students.

## Slide 5
- Snippets from the AChemS Conference
- Somebody let me show you their really nice endoscopic image of the human nose…

## Slide 6
- Patient-Centered Discovery and Implementation Research in Chemosensory HealthAChemS Pre-meeting Workshop2025

## Slide 7
- Patient-Centered Research
- Traditional medical research and therapeutic approaches are sometimes criticized as being disease-centered.
- They think of the patient as the bearer of the disease that is the actual object of study.
- They (allegedly) treat patients as somewhat interchangeable, rather than individual.
- They normally do not involve patients in the study beyond the data collection. Patients who participate in research usually don’t play a role in study design, analysis, interpretation, or outcome dissemination.
- Patients who participate in research are often not informed of the outcome of the study.

## Slide 8
- Patient-Centered Research
- Patient Centered Research is an alternative model that focuses on understanding and incorporating the perspectives, experiences, and needs of patients throughout the research process. This involves actively involving patients in research design, data collection, and interpretation, ensuring that research questions and findings align with what matters most to those affected by the research.
- Patients are viewed as research partners, not research subjects.
- Can be as simple as asking patients whether they felt better after treatment, not merely assessing their symptoms.
- Study design and interpretations can incorporate the lived experience of patients in designing questionnaires, assessments, and timing.
- Patients are potentially more effective than clinicians in interpreting failures of compliance (e.g. not taking their meds) and retention (e.g. dropping out of the study).
- Patients often have a different perspective on their own health than clinicians do.
- Patients should be given an appropriately non-technical description of the study outcomes.
- Presentations of study outcomes can productively include patient voices at conferences, maybe in publications.

## Slide 9
- Patient-Centered Research
- Patient Reported Outcomes (PROs) are a key part of patient-centered research that emphasize the experiences and opinions of the patient as a valuable piece of data.
- Questions like “How much did X treatment improve your Y symptoms…not at all/slightly/moderately/very much/completely”.
- Data can be qualitative.
- PROs can be analyzed in conjunction with clinical assessments, and they sometimes disagree.
- PROs can be designed to better capture the real-life impact of disease and disability.
- “How many days did you need to call in sick to work?”
- “How did your disease affect your overall quality of life?”
- In practice this approach may be more effective than traditional approaches for defining the economic and human costs of disease.

## Slide 10
- Workshop Overview

## Slide 11
- Workshop Overview

## Slide 12
- Workshop Overview
> Notable things:
- There is a complete absence of federal researchers despite the 2024 establishment of the National Center for Smell and Taste Research.
- The Consensus Round Table is meant to produce a published paper with the attendees as authors.
- What do you think is the ideal way to handle the lunch break?

## Slide 13
- “Anosmia” by A.E. Stallings
- Without it, what is lemon, what is mint? –Coffee and chocolate, caffeinated brown.Ghosted by a sense that takes no hint,I feel let down.
- It’s hardly tragedy that I can’t tellThe milk’s gone off, eggs rotten. It’s no jokeWith other things though – no internal bellThat signals smoke
- (The toast burned or the house on fire). SweetI have, and bitter, I have sour and salt,But without smell, no flavour is complete.There’s no … gestalt.
- It’s something I’d predict of old, old age,This weaning from the welter of the worldThe better, perhaps, to leave it. I’m no sage,I’d rather the impearled
- Jasmine flowers – fragrance of the stars –Light up the brain’s grey matter, and the hurtOf memory, the human musk of oursIn an unwashed shirt.
- ‘To have a nose for’– isn’t it a skill,A wry intelligence, a kind of knack?What thought trails do I lose, untraceable,What wisdom lack?
- I miss the laundry scent they call ‘unscented’.Like a depression, it makes it hard to write.What is is less, less there, half uninvented,And I, not quite.
- But there are days I almost have a whiff:I slice a lemon open for the crispSun-saturated redolence, and sniffAnd stand in the eclipse.
- Published in the London Review of Books, 2025

## Slide 14
- Dr. Claire Murphy
- Gave a clinical talk on patient-centered research in chemosensory health to demonstrate the approach and frame our field’s lack of success in developing needed therapies.
- Talked about data from the USA Smell and Taste Patient Survey: Integrating the Patient’s Voice
- Majority of patients over 40 rated nasal and oral steoirds as not effective or slightly effective
- All treatments that were rated at all effective were notably skewed towards younger adults
- Least bad treatment based on patient reports: platelet rich plasma PRP (29 patients – 62% said it was at least slightly effective)
- Patient perspective on study design and experience
- Odor identification is not perceived by patients as a good assessment of normalcy, and that threshold or intensity might be a better metric
- Patients were frustrated by smell training when it didn’t work
- Many patients want to know about smell function, loss etiology, ask for clinical trials to participate in
- Patients expressed frustration about lack of healthcare provider knowledge about smell and taste disorders
- The concern: chemosensory health is connected to long-term overall health
- Wang et al 2022 increased risk of Alzheimer’s 1 year after COVID
- JNP article by Leslie Kay 2022 predicting a looming wave of dementia caused by COVID-related smell loss
- Multiple studies suggest that having Excellent olfactory function predicts not developing Alzheimer’s and cognitive impairment (Beaver Dam, Columbia study)

## Slide 15
- Duncan Boak, 5th Sense
- Founder of the 5th Sense charity, speaking by Zoom from the UK.
- The 5th Sense is a patient support and advocacy group for people who have lost their sense of smell.
- He summarized their activities including patient-oriented and research-oriented components
- In response to patient demand, they circulate a newsletter about chemosensory research including disseminating new findings and advertising new studies.
- They consult to contribute the patient perspective on research design and community engagement projects
- NIHR grants in the UK require patient and public involvement on biomedical research projects and 5th Sense helps with that.
- They aspire to grow their own funding base so they can issue their own research support

## Slide 16
- Caroline Bigo-Rablet and Claire Martin
- Representatives from anosmie.org, visiting from France.
- Their organization created the covidanosmie.fr app which provides assistance with a smell training protocol for post-COVID smell loss
- 500,000 downloads
- Shared their views on patients in chemosensory studies
- Patients report both very positive and very negative experiences as study participants.
- Scientists need to do better at keeping patients continuously engaged and informed about the science using language that matches their level of understanding.
- Patients often want to share their experience and be useful to others who might suffer the same problem someday.
- They emphasized the importance of patients being viewed as active partners in biomedical research.

## Slide 17
- Pam Silberman
- Co-founder of STANA in 2021 (www.thestana.org)
- Smell and Taste Association of North America
- STANA is the first chemosensory patient advocacy organization in the US.
- She has been a patient rep for most of the major chemosensory clinical research centers, including National Smell and Taste Center, Monell, NIDCD, and GCCR
- She reports that the experience of patients who experience chemosensory loss can be negative
- Patients have experienced stigma from primary care physicians (e.g. treated like their smell loss was unimportant or that their parosmia was somehow not real).
- She emphasized the need to respect and value patient contributions
- Clearly defining roles for patient advocates in studies and advocacy collaborations
- Paying patients and advocates for their time at the same rate clinicians are paid
- Ensuring participants can access the results of any study

## Slide 18
- Summaries
- Roxana Chicas (Emory)
- Lessons learned from studies on heat-related health problems in agricultural work on how to serve underrepresented groups in biomedical research
- Provide real value – free health screening data including bloodwork, health education resources and pipelines to care
- Lower barriers to participation: provide transportation, early and late hours, bilingual staff, compensate time well, collaborate with community groups
- Eric Holbrook (Harvard/Mass Eye & Ear)
- Patient care requires commitment to serving the population, including accessibility, clinical infrastructure, central database of patient data, real time spent on medical history (telemedicine) to guide limited in-office evaluation.
- Biopsies are valuable but all varieties take up time and space.
- Holbrook et al. 2016 Office-based olfactory mucosa biopsies. Int Forum Allergy Rhinol

## Slide 19
- Summaries
- Dani Reed (Monell)
- Told her experience as a researcher who needed to learn the lessons of patient centered research
- First did human work at Twins Days in Twinsburg, OH, which was an unusual vibe and operates on a volunteer basis
- Now better understands the importance of financial compensation for patient engagement
- Panel Discussion led by Jonathan Overdevest (Columbia Med) and Jane Leland (STANA)
- Emphasized the importance of progress on therapies and diagnostics
- Discussed ways to better incorporate the patient experience into biomedical research and public appreciation more broadly
- I suggested leaning on Rachel Herz to better emphasize clinical loss realities in the Wolfe et al. Sensation and Perception textbook
- I suggested patient groups develop outreach materials appropriate for a college classroom, including matchmaking patient guest speakers and clinical guest speakers (they were overjoyed to hear about this course)

## Slide 20
- Summaries
- Brian Lin (stand-in for Bob Datta from Harvard)
- Noted that the first therapy for smell loss was vitamin A in 1962.
- Argued that our progress is blocked by the absence of in vitro models of smell loss to screen potential drugs against, nor animal models to test candidate molecules in.
- Argued for the use of modern 3D organoid in vitro models.
- Noted that existing models typically either represent acute recoverable injuries (not the goal) or chronic non-recoverable injury (not the goal)
- Called for models that exhibit a therapeutic window (a time when they will be effective after injury), mentioned ciliopathies, OMP-DTA models, and accelerated aging models as candidates.
- Linda Barlow (Colorado)
- Taste loss can occur during some ear infections, COVID-19, congenital
- Disparate causes imply different etiologies and thus qualitatively different patient experiences
- Presented data from organoids from circumvallate papillae on tongue

## Slide 21
- Dr. Jen Douglas (UPenn)
- Trained as ENT clinician scientist, Asst Prof of Otolaryngology
- Described how medicine advances according to the PDSA cycle (Plan, Do, Study, Act). Then observed we’re not even in that cycle.
- Noted that smell and taste testing should be fast, cheap, reliable, easy, accessible to the people who need it, matched to the patient and testing time point, and coupled to disease management and referrals for additional care. (Who, What, When, Where, Why)
- Tests exist and cost from $2 to $500 per test material.
- Testing should demonstrate value to an insurance company or health management administrator.
- Explored what the obstacles are to smell testing and care…

## Slide 22
- Dr. Jen Douglas, cont.
> She taught us about the revenue cycle in modern medicine:
- A patient is scheduled for a visit or procedure based on the reason they need care (e.g. preliminary diagnosis). This reason is documented by the ICD-10 code to justify the provision of care to the payer (insurance company, benefits manager, etc).
- ICD-10 is International Classification of Disease
- ICD-10 is created by the World Health Organization
- The specific procedures or tests conducted as part of the visit are documented by a CPT code, which documents what was done.
- CPT is Current Procedural Terminology
- CPT codes are owned by the American Medical Association
- The office then files for reimbursement (i.e. payment) from the payer based on the amounts associated with the particular ICD-10 code and CPT code connected to the patient care.

## Slide 23
- Dr. Jen Douglas, cont.
- There are ICD-10 codes related to chemosensory loss under code R43.
- R43.0 Anosmia
- R43.1 Parosmia
- R43.2 Parageusia
- R43.8 Other disturbances of smell and taste
- R43.9 Unspecified disturbances of smell and taste
- These could be refined and elaborated but at least they exist.

## Slide 24
- Dr. Jen Douglas, cont.
> There are not CPT codes for chemosensory dysfunction testing (not “diagnostic testing”) or therapy, and COVID is not an approved reason for testing. The only options are:
- 92700 – unlisted ENT service or procedure. This is typically not reimbursed (paid for) at all by insurance. Even if it’s one of the few recognized tests.
- 96312 – cognitive assessment & neuropsychological testing (e.g. for Parkinson’s or Alzheimer’s). This is typically paid at about $133, which is less than cost for a clinical visit and sometimes less than the test materials. It’s also truly only allowed for neurological issues.
- 30100/31237 intranasal biopsy/debridement. This is usually reimbursed at about $260.
- In the absence of an appropriate CPT code, smell and taste testing and therapy cannot be paid for by the medical system, no matter how important or well done.

## Slide 25
- Dr. Jen Douglas, cont.
- Getting a CPT code is very difficult and expensive. It would be granted by the American Medical Association, but it requires…
- Huge amounts of money to pay for the process ($1 million+)
- Years of work by paid consultants and lawyers
- A strong economic or medical justification why it improves the system to have the medical system include the proposed test or therapy.
- Does it save the system money to diagnose early?
- Does it address an urgent medical need?
- Clear evidence of practicality: are there clinically established and FDA-approved tests and therapies to be paid for?
- Alignment: will Medicare/Medicaid cover it? Private insurance companies?
- It is probably beyond the ability of any small or medium sized organization to get the CPT codes established to cover smell and taste testing.
- It may be that we need a pharma or biotech company to develop a test or therapy with a large enough market to make it worth their while to pay the cost of getting a CPT code created for everyone’s use.
- This should clearly be a long-term goal of patient advocacy organizations.

## Slide 26
- Dr. Jen Douglas, cont.
- Where in the medical ecosystem should smell live?
- Primary care has a well-defined role in screening and preventative care.
- They see fewer patients and have more time per patient than a specialist.
- Douglas advocates that PCPs should ask about taste and smell every visit and become able to administer or order testing.
- Otolaryngology/Rhinology specialty has a well-defined role in the sinonasal system and olfactory cleft.
- They typically see 60 patients per day with an unlimited patient panel.

## Slide 27
- Susan Coldwell (UW Dentistry)
- Not a clinician but teaches taste and smell to dental students
- In their polling very few people who report taste/smell problems have actually reported it to their healthcare providers.
- Even COVID patients reported discussing it only 1/3 of the time.
- She advocates that PCPs should ask about taste and smell, noting that there are 3 questions from the official National Health Interview Survey that could be repurposed unchanged.
> She thinks that dentists should be asking and evaluating taste function, but don’t because of:
- Lack of education, absence of clinical protocols, availability of testing materials, lack of reimbursement (payment)
- Oral medicine specialty training (beyond dentristry) includes taste complaints but it’s recently recognized and there’s only 6 residency programs in the US
- Limited treatments for taste loss exist, notably nerve repair for taste loss due to peripheral nerve injury (often caused by the dentist themselves).
- Clonazepam is prescribed for burning mouth syndrome.

## Slide 28
- Patricia Lucas
- Patricia Lucas, CEO of Ahersla Health
- Developer of the SCENTinel test.
- Their smell test is a Class II exempt medical device in the FDA’s classification, meaning it has moderate/high risk for safety and effectiveness.
- Multiple routes to FDA approval
- As a test for olfactory loss only it’s straightforward
> If it were for olfactory loss associated with Parkinson’s then the classification changes and they need to either:
- be compared to another device (510k premarket notification) to get approval, or
- Be a do novo product, which then requires full filing based on clinical data, non-clinical product testing, performance testing data, and benefit-risk assessment.
- The FDA cares a lot about a treatment’s medical effectiveness, cost effectiveness, and real-life impact on patients (e.g. relieving anxiety about eating spoiled food).
- All FDA routes are extremely expensive and slow.

## Slide 29
- Rick Geoffrion, Cyrano Therapeutics
- They make a nasal spray to deliver theophilin to the mucosa.
- Theophilin is a cAMP degradation inhibitor that should boost odor transduction. Not a new drug.
- Developing a reliable source for the drug (APA – active pharmaceutical agent) was challenging.
- Clinical manufacturing controls (CMC) are very challenging and require work on things like shelf life studies.
- They were able to skip phase 1 studies because they were repurposing a previously approved drug under 505(b)(2) law.
- They developed a proprietary low-cost sprayer to hit the olfactory epithelium directly instead of systemically (many side effects)
- It took a year to develop the sprayer
- Pre-clinical toxicology requires studies on rats and dogs to establish dosing and safety profile. Took 2 years.
- The FDA did NOT want laboratory smell testing, they wanted patient self-report outcomes and evidence of “clinical meaningfulness” not just demonstrable symptom improvement.
- Total cost of bringing an olfactory therapeutic to market: $40-100 million.

## Slide 30
- Patient Centered Research
- One goal of the pre-meeting was to develop new ideas and prioritize among possible short and long-term goals for the field.
- This was assessed using the six thinking hats group discussion structure.
- A paper will be written with all participants as authors.

## Slide 31
- Patient Centered Outcomes
- Brainstorm: What would a Patient Centered Chemosensory Scale include?

## Slide 32
- Closing Remarks
