# TravellingSalesmanProblem

The Traveling Salesman Problem (TSP) is a classical optimization problem in computer science and operations research.
The goal of the TSP is to find the shortest possible route that visits a given set of cities and returns to the starting point, where the distance between each pair of cities is known.
The problem is often referred to as a NP-hard problem, meaning that it is difficult to compute an optimal solution for large problem sizes. 
Various algorithms have been developed to solve the TSP, including heuristic and metaheuristic algorithms that can find near-optimal solutions in reasonable time. 
The TSP has applications in a wide range of fields, including logistics, transportation, and routing.

Solution for Travelling Salesman Problem using simulated annealing.
To engage with this application, it is necessary to use the @RestController

Input nodes are added through @RequestBody in POST request to "/api".

List of active nodes can be obtained through GET request to "/api".

Result is avaible through GET request to "/api/result".
