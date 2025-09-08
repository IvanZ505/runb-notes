# Smell Perception and Decision-making


## Perceptual Decision-making

- Using information from the world to decide on a model of the world to use to decide how to use information from the world to decide on a model of the world.

## Decisions Related to Olfaction

> Decisions a priori to detecting an odorant: Apply your model

- What am I likely to smell in this situation?
- - What would be a priority to smell in this situation?
- - Decisions a posteriori to detecting an odorant: Apply your model
- - Did I smell something?
- - Note that this is change or different detection task to spot a new odor “object” against an existing background.
- - Perceptual decision-making: What did I smell?
- - Brainstorm: What are the key perceptual dimensions of this decision?
- - Response decision-making: How should I react to the new smell?

## - Models and Decision Making

> - - To make a decision, you have to define the question.

- - Are you testing the null hypothesis that two things are the same?
- - How precise does “same” need to be?
- - What burden of proof do you need to meet?
- - More likely than not?
- - Five percent chance or less it’s just sampling error?
- - Virtual certainty?
- - The higher the stakes, the higher the burden.
- - Advocating surgery requires stronger data than advocating for a multivitamin.
- - There should not be a one-size-fits-all rule.
- - Odor importance should factor into perceptual decision making.
- - Are there two competing hypotheses you need to judge between?
- - Is there pre-existing evidence that suggests one model is likely better than another, independent of any data you’ve gathered?

## - Models and Decision Making

> - - Olfactory perception is often statistical.

- - Odorants are carried by physical plumes that distribute chaotically.
- - Odorant deposition in the nose is statistical.
- - Different odorants can have overlapping chemical components.
- - Olfactory perception requires some degree of statistical decision making.

## - Models, Data, and Hypotheses

> - - Approaches to statistical decision making get philosophical quickly.

- - Pragmatism: if the model works at predicting outcomes or suggesting new mechanisms, it wins.
- - This means an abstruse machine learning algorithm is just as good as any other model if it achieves your goal.
- - Frequentism: the probability of an outcome is objectively knowable with enough samples (or by covering an entire population), and differences in probability are thus also knowable.
- - Note that the probability is of an outcome happening, not a hypothesis being true, so you cannot compare hypotheses with frequentist logic.
- - Bayesianism: an assertion/hypothesis has a subjective probability based on prior knowledge that is updated when presented with new data.
- - This allows comparisons of the relative likelihood of models if given both original subjective probabilities AND data.
- - Note that information theory plays extremely nicely with Bayesian thinking.
- - What approach the mind/brain uses is a complicated subject…
- - Which one leads to scientific truth is….debatable.

## - Simple demonstration of Bayesian logic

> - - Imagine the case that you’ve tested positive for unusual disease X on a test with a 99% accuracy rate. What is the likelihood you have X?

- #### Hint: It’s not 99%.
- - Hint: This description does NOT include enough information to answer the question.

## - Simple demonstration of Bayesian logic

> > Necessary facts:

- - By 99% accuracy, let’s say that the errors are distributed as 0% failed detections and 1% false positives.
- - Let’s specify that the overall incidence of disease X is 1 in 100,000.
- - Let’s specify that the testing was universally done – you weren’t singled out for a test based on any known risk factor.
> Let’s game it out with 10 million people as a cartoon:
- - 100 people have the disease and 9,999,900 don’t.
- - Of the 9,999,900 who don’t, 1% get a false positive: that’s 99,999.
- - Therefore, of all the people who get a positive test, 99,999 don’t have disease X and 100 do.
- - If you have a positive test, you thus have a 100/(99,999+100) probability of having the disease: 0.000999 or 1 in a 1001 chance of actually having the disease.
- - Or you could characterize it in terms of relative likelihood: Relative chance of it being a false alarm is 99,999/100 or 1000 to 1.

## - Simple demonstration of Bayesian logic

> > Conclusions from our disease X discussion:

- - Base rates matter TREMENDOUSLY
- - Even a highly reliable piece of evidence that an event occurred is overwhelming likely to be incorrect if the underlying probability of the event is low.
- - A frequentist model by definition doesn’t do this logic of relative likelihood of conclusions. However, it could look at the probability of developing the disease among people with a positive test and just measure it.
- - Relative likelihood seems like a pretty compelling way to compare interpretations of data.
- - Knowing the baseline probabilities of events is a prerequisite, but is it actually plausible in a research context?
- - What if one of your hypotheses is the null hypothesis? Could you make an active argument that it is more likely than other hypotheses? (Yes!)

## - Simple demonstration of Bayesian logic

> - - Let’s do a grim analysis.

- - If (let’s say) the base probability of a scientific discovery is 1% of experiments…
- - …and you accept evidence with a 95% probability of being non-random and a 5% chance of being sampling error (e.g. p=0.05).
- - Then for 1000 experiments performed…
- - 10 are real discoveries and 50 are sampling error-based false alarms.
- - Therefore a discovery with a p=0.05 is 5 times more likely to be a false alarm than a real discovery, just from sampling error alone.
- - Notice that this is the ratio of error rate (5%) to base rate (1%).
- - If the base rate is 50% and we use =0.05, then the likelihood of a significant result being a false alarm is only 1/10.
- - So what is the real base rate for discovery?

## > Quick tangent:

> - - If you play a game with a 1/1000 chance of winning, but you play 1000 times, what is the probability that you win at least once?

- - 1-(0.9991000) = 63%
- - If you play a game with a 1/50 chance of winning, but you play 50 times, what is the probability that you win at least once?
- - 1-(0.9850) = 63%
- - If you publish papers with a 1/20 chance of erroneously rejecting the null hypothesis by mere chance, and you publish 20 papers, what is the probability you’ve erroneously rejected the null hypothesis at least once?
- - 1-(0.9520) = 64%

# Information Theory and Smell

## - Bayesian logic and Smell

> - - Remember that the decisions to be made in smell include whether an odor is present and what odor is present.

- - The base rate of new odors arriving and the base rate of individual odors are necessary to optimally understand the olfactory world around you.
- - Those base rates need to be learned. Perception is crippled if not informed by prior learning.

## - Information Theory


## - Information Theory & Statistics

> > Imagine that X and Y have these values:

- - Do you see a relationship you feel comfortable with?
- - r2 = 0.07
- - What if we add two more points?
- - r2 = 0.99
- - Why do these two points make the relationship compelling?

## - Information Theory & Statistics

> - - In the previous example, the original X and Y datasets have very little variance compared to the two points added later. The two last X points would be extremely improbable based on the rest of the X distribution, and the last two Y points would be extremely improbable based on the rest of the Y distribution.

- - Because these values are improbable, they are more informative about the distribution than yet another 10 or 18 would be.
- - Because the improbable X and improbable Y co-occurred, each is very informative about the other.
- - We are now approaching information theory: the mathematical laws that link probability of an event to the information it could communicate.

## - Information Theory & Statistics

> > Key principles of information theory for statistics:

- - Not all values in a distribution are equally likely to be encountered a priori.
- - For a given measured data point, only a subset of possible underlying distributions are likely for it to have come from.
- - Data thus narrow the range of possible underlying realities, and improbable data are most helpful in this regard.
- - Information is defined as degree of reduction in the uncertainty about the underlying reality provided by the data. Every twofold reduction in the range of possible realities is defined as 1 bit of information.
- - The number of possible realities, weighted by their relative probabilities, is called entropy.

## - What the heck is entropy?

> - - Imagine that there is only one possible score on a test. Then observing a student’s score on the test doesn’t tell you anything about the student – it has no information because it hasn’t narrowed the range of possible test scores because the range of possible scores a priori was zero.

- - Ergo, the number of possible realities contributes to the amount of possible information communicated.
- - Now imagine that there was only one possible set of answers permitted on a test. Then observing the test score also doesn’t tell you anything about a student – it has no information because even though there is a nonzero range of possible scores, the answers given don’t reduce the range of possibilities of which one was actually given.
- - Ergo, the range of possible data values received contributes to the amount of possible information communicated.
- - Entropy is logarithm of the number of possible states the system can take, taking into account the probability of actually being in each one.

## - What the heck is entropy?

> - - In a system with high entropy, there are many possible realities and many possible data points received, and thus the information capacity is high.

- - Remember that information is defined in terms of reducing the range of possible realities (messages) based on the data (signal) received. You need to have a lot of possible realities to be able to have a lot of information!

## - What the heck is entropy?


## - What the heck is entropy?


## - Information Theory & Statistics

> - - Remember: Information is defined as degree of reduction in the uncertainty about the underlying reality provided by the data. Every twofold reduction in the range of possible realities (i.e. entropy) is defined as 1 bit of information.

- - Statistical models can be described in terms of their information value relative to the data, essentially how much information is lost if you replace the actual data points with your statistical model of the data.
- - This approach lets you compare the goodness of fit between different candidate statistical models by seeing which loses the least information.
- - It also allows you to seek relationships between variables based on the mutual information between them.

## - Information Theory & Statistics

> - - How does all this relate to smell?

- - Knowing the statistical structure of odor space
- - Familiarity with an odor mixture constitutes knowledge of the probabilities of relative odorant concentrations in that mixture.
- - Familiarity with an environment or a food or a person constitutes knowledge of the probabilities of odors that occur around environment/food/person.
- - High surprisal elements can be readily identified in familiar odor spaces (e.g. an off note in your milk suggesting its spoiled).
- - Unfamiliar odor spaces feel deeply unfamiliar because you don’t understand the structure of the entropy within and between odors.
- - Mutual information
- - Learning what something smells like is using mutual information between the circumstance (e.g. visual appearance, location in space) and the odors experienced.

## - Information Theory, AIC, & Hypothesis Testing


## - Information Theory & Hypothesis Testing

> - - Likelihood is a measure of the goodness of fit of a model to a sample of data.

- - Likelihood function for the probability of a coin landing heads-up (without prior knowledge of the coin’s fairness) given that we have observed HHT.
- - Likelihood function of the probability of a coin landing heads-up (without prior knowledge of the coin’s fairness) given that we have observed HH.

## - Information Theory & Hypothesis Testing


## - Statistical Models and Decision Making

> - - All models are wrong…but some are less wrong than others.

- - As a scientist, how do you decide which model to use?
- - Choice among models can be informed by jointly considering…
- - …how well the model fits the data (goodness of fit), and…
- - …how many free parameters were included (with a “penalty” for more parameters).
> Common decision making calculations for this question include:
- - Akaike information criterion (AIC)*
- - Bayesian information criterion (BIC)*
- - Likelihood ratio test
- - Bayes factor
- - built into Origin Pro’s Compare Models methods

## - Statistical Models and Decision Making

> - - All models are wrong…but some are less wrong than others.

- - As a human experiencing the world, what model do you use?
- - Is there likely to be single answer, where we use one decision-making model in all cases?
- - For all smells?
- - For all cognitive functions?
- - What might determine our choice of model?
- - How do we figure out what model is actually used by a human?
- - Is asking sufficient or necessary?
- - Is it a tractable question?

## - Statistical Models and Decision Making

> - - Akaike information criterion (AIC)

- - Is based on information theory.
- - Penalizes models by an appropriate amount for each free parameter added.
- - Compares models to each other, not models to data.
- - Essentially measures information lost by trading the data itself for a statistical model of the data.
- - Lower is better.

## - Models, Data, and Hypotheses

> - - The model fitting process itself is based on model-data comparison and decision making

- - You also need to decide between models.
- - Then based on the models you need to decide what to believe.
- - This is not easy.

## - Information Theory & Hypothesis Testing

> - - Let’s imagine the brain gets a noisy signal from the world that might be one messy input reflecting the presence of a single odor but it might be a combination of two somewhat similar odors…

- - The next two slides demonstrate a statistical process of comparing the data to each potential model (1 distribution of odor-evoked activity vs 2 distributions of odor-evoked activity) and computing the relative likelihood.
- - The mind seems to do something similar.

## - Distributional Hypotheses

> - - One Gaussian is more likely here because it’s more parsimonious than two, but it’s close.



## - Distributional Hypotheses

> - - Move the data means further apart (same random numbers) and the AIC quickly begins to indicate that two peaks are wildly more likely than one.



## - Information Theory & Hypothesis Testing

> > A t-test implicitly considers two models:

- - Model 1: The two datasets are best fit by two normal distributions with the same mean.
- - Model 2: The two datasets are best fit by two normal distributions with different means.
- - Instead of a t-test, you could fit both models to the data and use the AIC to decide the relative likelihood of each model given the data you’ve collected.
- - Note that this logic does not assume equal variance (a t-test does).
- - Note that you do not need to guess at the a priori probability of a difference (Bayesian approach) or choose an  value as an arbitrary cutoff (frequentist approach).
- - Most importantly, you are using statistics to draw conclusions about the relative likelihood of hypotheses.
- - This t-test alternative makes a statistical argument for a specific hypothesis, not an argument against the null hypothesis.

## - Mutual Information

> - - Mutual information tells you how much information you get about one variable by learning about another.

- - It is inherently symmetrical – knowing one tells you about the other, and vice versa.
- - If there is no relationship, the mutual information is 0.
- - If there is a perfect one-to-one relationship, then the mutual information is equal to the entropy
- - In this case knowing one value collapses the possible values of the other to a single possibility, so the information gained is the total available.
- - In this case the entropy of the stimulus and the entropy of the response would be the same.

# Multidimensional Data

## - Mutual Information


## - Introduction to Multidimensional Data


## - Multidimensional Data

> - - NFL Team Wins, Regular Season

- - 1 dimension (longitudinal)
- - 1 dimension
- - (cross-sectional)
- - 2 dimensions
- - (subset of data)
- - 2 dimensions
- - Multidimensional data is data for which you have two or more separate variables (i.e. measurements) for each individual data point, creating a matrix of numbers.
- - Colloquially, we don’t usually call it multidimensional until we hit three dimensions.
- - NB: This term is entirely unrelated to the form of the data within each dimension, so a measurement with two possible categories or four possible categories would be one-dimensional either way.

## - Multidimensional Data

> - - NFL Team Highest Playoff Round Won

- - Adding another chart makes these four-dimensional data, because each instance is described by four variables: year, team, regular season wins, and highest playoff round won.
- - It can be helpful to sketch out the dataset structure before you build it…
- - NFL Team Wins, Regular Season

## - Multidimensional Data

> - - If you represented these data in Matlab, there would be 3 integer variables (Year, Regular Season Wins, Playoff Rounds Won) and 1 cell array where each cell is filled with character arrays known as strings (Team).

- - The end result would be either 4 separate variables (if you built it that way) or a table or matrix with 4 dimensions.
- - Typically you would combine variables from the same datapoints into one global structure rather than four separate variables.

## - Multidimensional Data

> - - It is totally okay to have some cells empty if you are missing data or had to exclude it for some reason. This screws up many “old fashioned” statistical models but lots of modern techniques are robust to missing data.

- - Just make sure you understand what your preferred method requires.
- - Matlab permits NaN values.

## - Multidimensional Data

> - - You typically don’t learn much beyond the X-Y Cartesian plane in basic math, and you typically don’t learn much beyond X-Y regression and correlation in basic stats.

- - Extrapolating to 3-dimensions is pretty intuitive, and the key is to realize that the extrapolations to additional dimensions is exactly the same process as going from two to three.

## - Multidimensional Data

> - #### Exercise: Understanding N-dimensional space

- - 1-D: picture a bunch of ping-pong balls clustered on a line.
- - Imagine what a ball positioned at the midpoint of the cluster would look like.
- - Imagine how you would describe how to move each ball to get it from its original location to the position of the midpoint ball. You would need distance to travel and a direction (+ or -).
- - 2-D: picture the same bunch but now blurred off the line in both directions to form a cluster in X-Y space.
- - Imagine what a ball positioned at the midpoint of the cluster would look like.
- - Imagine how you would describe how to move each ball to get it from its original location to the position of the midpoint ball. You would need a distance and a direction along each axis (x, y).
- - 3-D: picture the same bunch but now also blurred above and below the original line to form an X-Y-Z space.
- - Imagine what a ball positioned at the midpoint of the cluster would look like.
- - Imagine how you would describe how to move each ball to get it from its original location to the position of the midpoint ball. You would need a distance and a direction along each axis (x, y, z).
- - 4-D: picture the same bunch of balls in X-Y-Z space but now the balls have hair of different lengths. Some balls have longer hair, and other balls have shorter hair.
- - Imagine what a ball positioned at the midpoint of the cluster with average length hair would look like.
- - Imagine how you would describe how to move each ball to get it from its original location to the position of the midpoint ball and how much you’d need to lengthen or shorten its hair to match the midpoint ball. You would need a distance and a direction along each axis, including the hair length axis (x, y, z, shorter hair-longer hair).
- - N-D: picture any number of additional variables added to this scenario: ball hair color, ball size, ball temperature, ball rotation, etc. To describe how make any ball change into the ball of average position, hair length, size, etc., you just need a list of properties and how far and in what direction to change them.
- - In each of these examples, you were intuiting the vector between each instance (single ball) in a population of balls in a multidimensional space and the centroid of that population.
- - Spaces of more than 3 dimensions are called high-dimensional spaces or hyperspaces. You can totally picture them. (They are not like dusting crops).

## - Multidimensional Data

> - - Anything you want can be represented as a dimension in an N-dimensional space. When each position represents a possible state of your system, it’s called an N-dimensional state space.

- - Measuring height, weight, blood pressure, pupil diameter, heart rate? Picture it in a 5-dimensional space.
- - Categories are just dimensions with a limited number of values.
- - Dimensions do not actually need to be orthogonal (perpendicular) for the space to work, though some methods require you to orthogonalize first.
- - Time can be represented in its own dimension, or you can plot the state of your system as a trajectory through the space across time. Measuring the activity of 5 neurons over time? That’s a trajectory through a 5-dimensional space over time.
- - Dimensions that loop back to the beginning (e.g. time of day or a cyclical process) can have the space itself be connected as a circle. This is called a phase space.

## - Multidimensional Data

> - - Why are N-dimensional representations useful to us?

- - They allow highly complex datasets to be represented in a way that allows sophisticated mathematical techniques to be used to find patterns.
- - Differences between points in multidimensional space can be quantified, so relatively simple equations can be used to find optimal dividing lines between groups or to develop multivariate regression lines. Dynamic systems can be best understood by the manifolds they trace out in state space.
- - These concepts are so fundamental that virtually all statistics can be represented this way, but they are particularly central to both traditional multivariate statistics and more modern machine learning techniques.
- - Note that these approaches are no longer exciting new techniques. They underpin lots and lots of the technology you use everyday.

# Classification and Pattern Recognition

## - Multidimensional Data

> - - What is the cost?

- - As you increase the number of dimensions, the size of the state space goes up geometrically. To get equal data coverage of the possible spaces, you thus need geometrically more data with each metric you add. This is called the curse of dimensionality.
- - This means it can be harder to get sound results.
- - It also means the data points might be so different from each other that each point seems like its own cluster to an analysis algorithm.

## - What is Classification?


## - What is Classification?

> - - The general process of looking for structure in data (i.e. improbabilities/information) is called pattern recognition.

- - Within pattern recognition, there are two general ways to do it: Classification and clustering
- - If you know the category assignments for some instances, you can develop rules that allow you to categorize additional instances. This is classification, a.k.a. supervised learning
- - Example: Study the features of spam and real email, then set up a statistical spam detector.
- - Example: Study radiological images from patients who do or don’t turn out to have cancer, then use the algorithm to evaluate images from future patients.
- - If you don’t have any a priori categories, you can look for categorical structure based on the non-randomness in the data. This is called clustering, which is a form of unsupervised learning.

## - What is Classification?

> - - In statistics, classification into categorical variables is done by logistic regression, where each instance (i.e. data point) includes values for multiple independent variables that are used as regressors to model the categorical dependent variable.

- - Typically we think of having all the data and using the regression analysis to determine which independent variables predict the category (i.e. backwards inference), thereby giving us mechanistic insight.
- - However, having completed an analysis you can also go forwards and use the model to predict the classification of new data points based on the measured values of the regressors.
- - In machine learning, classification is done by supervised learning, where the classifier algorithm is “trained” on known data and then typically evaluated based on its ability to correctly classify new instances.
- - It is sometimes, though not always, difficult to understand the logic adopted by the classifier, so machine learning approaches often yield little mechanistic insight, but...
- - The emphasis on flexibility in learning algorithms usually produces better results.
- - Notice that statistics and machine learning approaches are fundamentally doing the same thing – developing a useful classifier model for performing statistical inference – with different tools.

## - What is Classification?

> - - Probabilistic classifiers are a subset of classification algorithms that output not just a category assignment for each data instance but the probability of the instance belonging to each potential category.

- - This is a probability distribution that adds to 1.
- - The probabilistic classifier thus requires a decider downstream of it to assign each instance to a category.
- - The highest-probability-wins decision rule is the most common decider, but...
- - Each instance’s classification can have a confidence term associated with it, which can be super useful.
- - Confidence estimates let you judge how to act on the outcome.
- - Confidence estimates let you refine your classifier, including providing a basis for comparison between different algorithms that arrange categories differently.
- - Confidence estimates can be analyzed to find the underlying rationale for categorization even in an otherwise opaque algorithm.
- - Confidence estimates can allow you to flag individual results for human follow-up.
- - The decider can have the option to abstain if the category is insufficiently certain.

## - What is Classification?

> - - A core feature of most modern classification algorithms is that each data instance is a multidimensional feature vector, where there are multiple measures associated with each instance to be categorized.

- - Each subject might have as features (i.e. feature vector elements) sex, height, weight, age, race, S&D blood pressure, waist circumference, history of coronary artery disease, diabetes status at initial assessment, and diabetes status at 10 year follow-up.
- - Subject data could be displayed in multidimensional space to observe the correlations and distributions.
- - A classifier could be trained to find the patterns in the feature vector that predict diabetes status at the 10 year follow-up and thus both a) characterize the interactions among features that predict future risk and b) actually predict the chance of a new patient developing diabetes later, potentially including a confidence term on the prediction if an appropriate algorithm is selected.

## - What is Classification?

> - - Features can have any form

- - They can be binary, categorical, ordinal, integer, real, even complex numbers.
- - They can be numbers, video, audio, anything that can be represented on a computer.
- - They need not be independent of each other (though some algorithms presume they are, these algorithms often work anyway).
- - In practice, preprocessing of raw data to extract key features can be essential to providing the algorithm with the power it needs to solve the problem.
- - You might add BMI as a feature calculated from height and weight.
- - You often convert images into more abstract representations of objects and distances (but you might not).
- - Not every algorithm can accommodate every data format.

## - What is Classification?

> - - The methods used for classification are diverse and reflect varied historical schools of thought.

- - Fisher developed linear discriminant analysis, which is frequentist.
- - Bayesian procedures allow you to assign prior probabilities among the categories, if their relative likelihoods are known.
- - Selecting a method is often driven by convenience and experience, not necessarily deep insight or scientific principles.
- - At the end of the day, all applicable methods can be tested and compared to see which works best for your dataset. Modern classification software (e.g. Matlab’s Classification Learner App) streamlines this process to allow you to compare many approaches with the click of a button.

## - What is Classification?

> > Common supervised learning classification methods:

- - Logistic Regression: Calculates a logistic function for assigning probability of category A vs B based on the conditional probabilities of each feature for each category. Two categories only (unless nested). Probabilistic.
- - Naïve Bayes Classifiers: Combines conditional probabilities of each feature for each category with the marginal (non-conditional) probability of each category occurring. Any number of categories. Probabilistic.
- - Support Vector Machine: A basic algorithm for finding the linear boundary that optimally separates two groups of X-Y datapoints that has now been extended to hyperspaces (N-dimensions) and highly nonlinear boundaries. Only two categories (unless nested). Non-probabilistic.
- - Decision tree learning: Splits and conjunctions of features are recursively modeled to reach an optimum classification tree. Real-world use uses random forests, where many independent trees are generated using random subsets of the data and compared, and boosted trees, where multiple trees are generated but the optimization is changed each time to increasingly emphasize the previous misclassifications.
- - K-nearest neighbors (KNN): For each datapoint, the closest k other points in multidimensional feature space get a “vote” on which category the datapoint should be applied to. This makes for local (as opposed to global) category rules.
- - Helpful fact: KNN is a supervised learning/classification technique while “K-means clustering” is an unsupervised/clustering technique. They are very different things!

# Neural Coding and Smell

## - What is Classification?

> - - What about chi-square testing?

- - First, nomenclature. Chi-square testing is a general category of testing distributions of categorical instances against distributions. Chi-square distributions are used for tests of goodness of fit (i.e. curve fitting), homogeneity, and independence.
- - What you learned as the “chi-squared test” was more specifically Pearson’s chi-squared test (as opposed to, say, Yates’ chi-squared test). It tests the null hypothesis that the frequency of categorical outcomes in a given sample is consistent with a theoretical distribution.
- - This kind of hypothesis testing is a separate question from whether instances can be categorized effectively by a given classifier, and can be downstream of a classifier. For instance, you could use a classifier to categorize your data points into variants 1, 2, 3 and then test whether an experimental manipulation made the distribution of these outcomes significantly different from the control case.
- # neural coding and smell

## - Neural Representations & Computations


## - Neural Representation of Sensory Stimuli

> - - Anything in the world can be represented using anything else, though such representations are virtually always imperfect.

> Examples of representations:
- - Words represent objects, actions, ideas, etc at some level of detail/abstraction
- - A physical photo, digital photo, and written name might all represent the same person.
- - Neurons firing action potentials, releasing neurotransmitter, making certain connections, expressing certain proteins, etc. might all represent an object, action, idea, etc.

## - Neural Representation of Sensory Stimuli

> - - Representations enable storage of information and transformation of information via computation.

- - Equations are a way of using abstract, logical principles to understand relationships. When you put x=“three cats” into an equation and solve it, you are transforming a representation of three cats.
- - Your brain is the machine that enables you to store and transform information about the world. We can study how it works to a) understand minds better, and b) figure out how to fix it when it breaks.

## - Neural Representation of Sensory Stimuli

> - - Given that…

- - Sensory organs feed information to the brain
- - Brain damage can disrupt sensory function
- - Sensory activity drives neural activity in the brain
- - You would expect that…
- - A particular sensory stimulus could evoke a particular pattern of neural activity in the brain that corresponds to a particular perception of the stimulus

## - Neural Representation of Sensory Stimuli

> - - Neural representation of sensory stimulus: The pattern of neural activity that corresponds to a sensory stimulus.

- - Neural encoding of a sensory stimulus: The process by which a sensory stimulus gets represented in the brain. This is highly variable across the senses.
- - Which neurons respond to the stimulus might represent the location of a light in the visual field, or the frequency of a sound, or the identity of an odor. (These are just simple examples.)
- - How the responding neurons act might represent the brightness of the light, or the intensity of the sound, or the concentration of the odor. (These are also just simple examples.)

## - Recording the activity of a neuron: Cartoon


## - Figure 1.30  Tuning curves of auditory neurons


## - Actual recordings of a hippocampal neuron

> - - Henze et al. 2000 J Neurophysiology



## - Respiration-coupled neuron

> - - Voltage

- - (recorded from brain)
- - Respiration
- - (chest expansion)
- - Butyl Acetate presentation
- - Methyl Valerate presentation
- - 15 Hz
- - 160 Hz
- - Raster plot (each dot is a spike,
- - each line is 1 odor presentation)
- - Summary histogram
- - Actual recordings from the olfactory bulb
- - McGann Lab, Rutgers

## - Voltage

> - - (recorded from brain)

- - Uncoupled to respiration
- - Isoamyl Acetate presentation
- - Butyl Acetate presentation
- - 10 Hz
- - 70 Hz
- - Actual recordings from the olfactory bulb
- - McGann Lab, Rutgers
- - Respiration
- - (chest expansion)

## - Neural Representation of Sensory Stimuli

> - - Decoding of a neural representation: Figuring out what sensory stimulus is present (which the brain can’t know directly) from the pattern of neural activity the stimulus induces (which is all the brain knows).

- - The brain/mind decodes neural activity to understand the world.
- - Neuroscientists decode neural activity to figure out how the representation works.
- - If you can decode a neural signal into the sensory stimuli that evoked it, then the information about those stimuli must be present.
- - Watch the video of Jack Gallant’s talk where his lab decodes a movie from the pattern of activity in a person’s visual cortex

## - Neural Representation of Sensory Stimuli

> - - Limitations of decoding approaches

- - The fact that scientists can decode info from the neural activity doesn’t mean the brain is using that info or using it the same way.
- - (The brain isn’t recording from itself with electrodes or fMRI.)
- - Often we actually do the decoding using machine learning approaches that provide no insight into how the neurons are actually representing the world.
- - In this case all we are proving is that the sensory information is “in there somewhere”, which we presumably already knew.
- - Very rarely do we have a system in which we can reasonably expect to be observing every neuron involved in a neural representation or to know every possible stimulus the brain could be representing.
- - Essentially all experiments are based on partial codes for things we already knew (i.e. what stimulus we presented). It will be amazing when we start finding things in the code that we didn’t already know were there.

## - Neural Representation of Sensory Stimuli

> - - A few comments on neural representations

- - Different physical aspects of a stimulus are usually represented separately, using different coding mechanisms or different neurons.
- - This enables parallel processing, where multiple aspects of the stimulus are being considered at once (instead of one after another, which would be slower).
- - This enables specialization, where different circuits or coding mechanisms are optimized for different things (e.g. separate processing of shape and movement in the visual system).
- - This can be thought of analysis of the stimulus, where the brain decomposes the stimulus into its constituent parts
- - Literally! Sounds and images get decomposed in the mathematical sense into their frequency and phase information via Fourier analysis.
- - Sensory representations build in other information than just the external stimulus, including cognitive, physiological, and emotional information.
- - Sensory representations get combined somehow to make a model of the world.

## - What are the neural representations of odors?


# Smell Plasticity Part 1

## - Neural Representation of Odors

> - - What is being represented?

- - The chemical structure of the stimulus?
- - The response of odor receptors?
- - The intensity of the stimulus (measured or computed?)
- - The chemical statistics of the world?
- - The implications for the organism?
- - Expected odors given the spatiotemporal context?
- - The difference between expected odors and actual odors?
- - Stimulus timing? Sniffing?
- - How can we discriminate these possibilities?
- - Decoding
- - Identifying odor chemical identity, concentration, etc.
- - Odor information that narrows down the possibilities
- - Experimental manipulation of representations

### Rosenthal et al. In Preparation

> Single-odor conditioning yields generalization in OSNs

- This is a change in
- neural representations based on inferred odor-shock contingencies.
- Why could that be useful?

## Single-odor conditioning yields generalization in PG cells

> Kass et al. 2017 in Neurobiology of Learning and Memory

- This is a change in neural representations caused by learning that occurs during first inhalation. contingencies.

## - CBL Amygdala inactivation “ungates” OSN output

> - - Fast and McGann 2017 J Neuroscience



## - Footshock evokes activity throughout the olfactory bulb

> - - Perkins et al. In Progress



## - How does information get from the PG cells to the OSNs?


## - GABAergic presynaptic inhibition works through N-type calcium channels


## - Circuit-Level Mechanisms Shaping Odor Representations


## - Glutamate release evokes GABA(B)-mediated presynaptic inhibition of transmitter release


## - Glutamate release evokes GABA(B)-mediated presynaptic inhibition of transmitter release


## - GABA(B) receptors mediate suppression of presynaptic calcium influx


## - GABAergic presynaptic inhibition works through N-type calcium channels


## - Feedback presynaptic inhibition of input to the olfactory bulb


## - What is the Functional Organization of this Inhibition?


## - Potential circuit organizations

> - - Axon-specific feedback inhibition

- - Does the feedback only affect the neurons that are firing?
- - Whole-glomerulus feedback inhibition
- - Are all of the inputs to a glomerulus modulated together?

## - Intraglomerular, heterosynaptic inhibition of transmitter release


## - Potential circuit organizations

> - - Axon-specific feedback inhibition

- - Does the feedback only affect the neurons that are firing?
- - Whole-glomerulus feedback inhibition
- - Are all of the inputs to a glomerulus modulated together?
- - Center-surround organization
- - Does activity in a glomerulus inhibit input to neighboring glomeruli?

## - Mixture experiments give no evidence of interglomerular presynaptic inhibition in vivo


## - Predictions for role in shaping odor representations

> - - Blocking GABAB receptors will increase the magnitude of input to the olfactory bulb.

- - Blocking GABAB receptors will not change the pattern of response among glomeruli.

## - CGP reverses action of baclofen in vivo


## - Blockade of GABA(B) receptors in vivo greatly increases odorant-evoked transmitter release


## - CGP causes a proportional increase in input


## - Potential Functions of Presynaptic Inhibition


## - Potential Functions of Presynaptic Inhibition


## - What Does This Plasticity Accomplish?


## - Odor exposure improves odor discrimination

> - - Kass et al. 2016 Chem Senses

- - BEFORE
- - Exposure
- - AFTER
- - Exposure

## - Kass et al. 2017 in Neurobiology of Learning and Memory

> - - Generalizing conditioning makes odor representations more similar



## - Discriminative fear conditioning makes odor representations more different

> - - Kass et al. 2013 Science



## - Mouse olfactory plasticity: Summary

> - - Changes in odor representations can manifest as modest differences in odor perception.

- - Discriminative conditioning causes odor representations to become more different.
- - Generalizing conditioning causes odor representations to become more similar.
- - These changes happen as early as the olfactory nerve terminals.

## - What if Humans Experience Odor-Cued Aversive Conditioning?


## - Olfactory perception is altered by odor-cued aversive conditioning

> - - Enantiomer pairs become more discriminable if they differentially predict a mild shock (Li et al. 2008).

- - Detection thresholds are reduced for odorants that predict a mild shock (Åhs et al. 2013).
- - Effects can be long-lasting (Parma et al. 2015).
- - Alterations have been reported in epithelial (Cavazzana et al. 2018) and cortical (Li et al. 2008) physiology in humans after odor-cued aversive conditioning.
- - Human olfaction and aversive conditioning

## - Mouse odor representations are transformed after discriminative aversive conditioning to become more different, and are transformed after generalizing fear conditioning to become more similar.

> - - Unfortunately, we can’t get the mice to tell us about odor similarity when they are scared of the odors.

- - However, there is a subpopulation of humans who tend to generalize fear when others discriminate…
- - Human olfaction and aversive conditioning

# Clinical Assessment of Smell

## - Anxiety disorders like PTSD and Generalized Anxiety Disorder have been linked to inappropriate generalization, where stimuli resembling a threat-related cue become able to evoke inappropriate fear or anxiety responses.

> - - In discriminative aversive conditioning paradigms, anxious people tend to inappropriately generalize fear to non-threatening CS- stimuli (Gazendam et al. 2013; reviewed in Lissek et al., 2005).

- - Aversive Learning, Generalization, and Anxiety

## #### Hypothesis

> - - During aversive discriminative conditioning paradigms in which typical people exhibit learned improvements in their ability to discriminate between similar odorants...

- - …highly anxious people will show increased but generalized fear/arousal and no improvement in sensory discrimination.
- - Aversive Learning, Generalization, and Anxiety

## - Participants were head-fixed, asked to breathe normally, and received odors through a delivery port positioned in front of the nose.

> - - Participants were asked to discriminate hexanal from heptanal in a forced choice triangle task. This was hard for most.

- - Technical Details
- - 6 triangles prior to conditioning and 6 more after conditioning.
- - Odorant presentations were 6 sec long separated by 10 sec.
- - Odorant concentrations were selected to be isointense.
- - Keypress reaction time was measured and outliers with very long reaction times were excluded.
- - Assessment of Perceptual Change: Odor Discrimination Task

## - Odors

> - - Hexanal and Heptanal were counterbalanced across participants for which one predicted the shock (CS+) and which did not (CS-).

- - 8 CS+ trials  and 8 CS- trials (6 sec) presented in pseudorandom order with 45-75 sec intertrial interval
- - Shocks
- - CS+ presentations co-terminated with a 200 msec wrist shock.
- - Shock intensity was determined prior to the experiment by increasing shock level until the participant reported it was “uncomfortable but not painful”.
- - All participants received these calibration shocks regardless of experimental group.
- - Skin Conductance – a measure of autonomic arousal
- - Skin conductance was measured from electrodes on the fingers.
- - Resting skin conductance levels (SCLs) and stimulus-evoked skin conductance responses (SCRs) were quantified.
- - Human olfaction and aversive conditioning

## - Anxiety Assessment

> - - State & Trait Anxiety Inventory (STAI) (Spielberger et. al 1983)

- - State anxiety refers to how someone feels at the time of participation while trait anxiety refers to how a person feels in general.
- - 20 statements such as “I worry too much over something that really doesn’t matter”, “I feel at ease” or “I feel nervous”.
- - 4 Point scale 1. Almost Never, 2- Sometimes, 3 – Often, 4-Almost always . Higher scores indicate greater anxiety symptoms
- - Anxiety Groups
- - High Trait Anxiety (HTA): STAI Trait score ≥ 48
- - Normal Trait Anxiety (NTA): STAI Trait score < 48
- - This cutoff is an effective means of screening for preclinical anxiety in college students (Sarkın & Gülleroğlu, 2019).
- - Human olfaction and aversive conditioning

## - 208 Rutgers undergraduates participated

> - - 159 scored as Normal Trait Anxiety

- - 49 scored as High Trait Anxiety
> There were no differences in:
- - Age (p=0.62)
- - M/F sex ratio (p=0.64)
- - Resting skin conductance level (p=0.85)
> Shock perception was not significantly different:
- - Same shock voltage selected (p=0.85)
- - Skin conductance response to shock (p=0.10)
- - Both groups were equal on baseline odor discrimination (p=0.95).
- - Human olfaction and aversive conditioning

# ACHEMS

## - Discrimination Learning

> - - Aversive learning causes increased odor-evoked SCRs



## - Discrimination Learning

> - - NTA subjects exhibit physiological discrimination



## - Discrimination Learning

> - - Aversive learning causes increased odor-evoked SCRs



## - Discrimination Learning

> - - HTA subjects don’t exhibit physiological discrimination



## - Discrimination Learning

> - - Perceptual improvement after aversive learning in NTAs

- - Perceptual improvement in NTA individuals replicates work from the Gottfried, Lundstrom, and Li labs (among others) with a new pair of odorants.
- - There was no correlation between perceptual improvement and physiological discrimination.
- - There was no correlation between perceptual improvement and shock intensity selected.

## - HTA participants were similar to NTA participants prior to conditioning.

> - - HTA participants did not improve their discrimination.

- - Perceptual effects of aversive conditioning

## - Learning-induced perceptual plasticity is absent in this task in individuals with preclinical levels of trait anxiety.

> - - HTA participants exhibited blunted learned arousal responses, even though their unlearned responses to shock were the same as the NTAs. This is consistent with prior clinical literature (Naveteur & Baque 1987; Naveteur et al. 2005).

- - The increased skin conductance responses that were exhibited by the HTA participants were comparable between CS+ and CS- showing that they generalized between the odors.
- - Human olfaction and aversive conditioning

## - Perceptual discrimination → Differences in arousal in NTA participants

> - - OR

- - Differences in arousal in NTA participants → Perceptual discrimination
- - What if we reversed the differential arousal responses?
- - Human olfaction and aversive conditioning
