# RL-MDP
Apply value iteration, policy iteration and Q learning to develop policies for agents to reach goal state. Two ’Maze Solving Problem’ with different state size (8X8 and 15X15) to investigate how the complexity increases when increasing state size.



## Background
#### MDP planing algorithm1. Value Iteration Value iteration (sometimes called a ’backward function’) is a planning algorithm that computes an optimal MDP policy to model sequential decision making. If we knew the true value of each state, our decision would be simple: always choose the action that maximizes expected utility based on Bellman’s equation.2. Policy Iteration Policy iteration is another type of planning algorithm that starts with a policy and iteratively tries to improve it in order to converge. It tries to computes the optimal policy via a two step process. Step one is the inner value iteration which is performed first followed by step two which the policy iteration. The policy iteration is performed until it converges to the best possible solution and then this two step process is repeated until it completely converges.#### Reinforcement Learning algorithmQ-Learning (learning algorithm of choice) Q-Learning is a reinforcement learning method which tries to find an optimal action/selection policy for an MDP. It starts by learning an action-value function that gives an expected utility by taking that action when in a particular state and following an optimal policy from that point onward. The main advantage of this algorithm is that it is able to make a comparison between the expected utilities for the available actions without even requiring a model of the environment. BURLAP has a function called QLearing which is used for this purpose in the analysis section


## Dependencies
All calulation are performed in Burlap, no external data source used. 
Java 1.8 was used.

The two problem studies are in:

* myHardGridWorldLauncher.java
* mySuperLargeMaze.java


## Results
#####  Value iteration VS Policy iterationAlthough the rewards for each algorithm varies, the optimal policy in value iteration and policy iteration are the same. This could be due to 2 reasons:1. The grid world is relatively sparse, there are a few “bottleneck points” (highlighted in green frame in the image below) that limited the solutions variability.2. There is discount factor γ is relatively high (at 0.90 *). Both of the two algorithms are trying to find the policy that optimize the global total rewards.

![Image](Images/Image2.png?raw=true "Image")
#####  MDP vs Reinforcement Learning algorithmMarkov decision process and reinforcement learning algorithm are very different. This is due to the difference in the nature of MDP and RL.MDP is using a model to create a planer to direct the future action, where as RL is learning from many transitions then come up with a policy.


#####  Total RewardsThe rewards in MDP was greater than that in Q-learning. It could be due to the fact that Q- learning as a reinforcement learning algorithms doesn’t take model as an input, but takes samples instead. So instead of of computing a policy, reinforcement learning computes a policy, which bring in more unpredictability to the policy.#####  Time Elapsed by algorithmsPolicy iteration > Value iteration > Q-learningThis is not as expected. Because Policy iteration is supposed to be able to over come the inefficiency in value iteration that the max of utility rarely changes when it converged.#####  Time elapsed by problemIf there are on average a constant number of next states with non-zero probability then the cost per iteration is linear in the number of states and linear in the number of actions. The 15X15 maze problem has almost 4X of the total states as in the 8X8 maze. So as expected, the overall time taken is 4 times as that in 8X8 problem.#####  Convergence ( #of iterations)All the three algorithms in each dataset converged at iteration 9. There is not too much difference in convergence. Policy iteration takes more time in each iteration than Value iteration.

![Image](Images/Image1.png?raw=true "Image")

*To simplify the problem, all comparisons were performed on discount factor (γ) = 0.9 and the only reward is obtained when exiting from the top right corner. 






