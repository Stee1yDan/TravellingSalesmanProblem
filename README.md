# TravellingSalesmanProblem

The Traveling Salesman Problem (TSP) is a classical optimization problem in computer science and operations research.
The goal of the TSP is to find the shortest possible route that visits a given set of cities and returns to the starting point, where the distance between each pair of cities is known.
The problem is often referred to as a NP-hard problem, meaning that it is difficult to compute an optimal solution for large problem sizes. 
Various algorithms have been developed to solve the TSP, including heuristic and metaheuristic algorithms that can find near-optimal solutions in reasonable time. 
The TSP has applications in a wide range of fields, including logistics, transportation, and routing.

![lead_large](https://github.com/Stee1yDan/TravellingSalesmanProblem/assets/125751951/a558b476-88bc-416c-9437-939f646a4cdc)

## Simulated Annealing
Simulated annealing is a probabilistic optimization algorithm that starts with an initial solution and iteratively improves it by randomly choosing a solution from the neighboring set and deciding whether to accept or reject it. The probability of accepting a new solution is determined by a temperature parameter that is gradually decreased during the optimization process.

The simulated annealing algorithm is designed in such a way that it is capable of escaping from local optima and finding global optima. This ability makes it particularly useful for solving problems that are difficult to solve using traditional optimization methods.

## RestController
To engage with this application, it is necessary to use the @RestController

Input nodes are added through @RequestBody in POST request to "/api".

List of active nodes can be obtained through GET request to "/api".

Result is avaible through GET request to "/api/result".
