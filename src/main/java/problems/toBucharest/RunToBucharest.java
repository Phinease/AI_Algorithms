package problems.toBucharest;

import iialib.stateSpace.algs.IHeuristicSearchAlgorithm;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.algs.implementation.*;

import iialib.stateSpace.model.Problem;

public class RunToBucharest{

	public static void main(String[] args) {
		
		// Defining a problem as an anonymous Object this implemented abstract methods
		City.initializeOperators(City.romaniaRoads);
		Problem<City> p = Problem.defineProblem(City.Arad, City.Bucharest);
				

		// -- Testing non informed search Algorithms --
		IHeuristicSearchAlgorithm<City,OpRoad> aStar = new AStarSearchStats<>();

		Solution<City,OpRoad> sol = aStar.solve(p,Heuristics.h);
		System.out.println(sol);
	   
	/*	
		ASearchAlgorithmStats<City,OpRoad> alg2 = new BoundedDepthFirstSearchCycleDetectStats<>(12);

		Solution<City,OpRoad> s2= alg2.solve(p);
		System.out.println();

		
		ASearchAlgorithmStats<City,OpRoad> alg3 = new BoundedDepthFirstSearchCycleDetectStats<>(8);

		Solution<City,LEdOpRoadge> s3= alg3.solve(p);
		System.out.println();
	
		
		ASearchAlgorithmStats<City,OpRoad> alg4 = new BoundedDepthFirstSearchCycleDetectStats<>(3);

		Solution<City,OpRoad> s4= alg4.solve(p);
		System.out.println();


		ASearchAlgorithmStats<City,OpRoad> alg5 = new BreadthFirstSearchStats<>();

		Solution<City,LEOpRoaddge> s5= alg5.solve(p);
		System.out.println();

		
		IterativeDeepeningSearchStats<City,OpRoad> alg6 = new IterativeDeepeningSearchStats<>(100);

		Solution<City,OpRoad> s6= alg6.solve(p);
		System.out.println();

		UniformCostSearch<City,OpRoad> alg7 = new UniformCostSearch();

		SolutionWithCost<City,OpRoad> bestSol= (SolutionWithCost<City, OpRoad>) alg7.solve(p);
		System.out.println();

		AStarSearch<City,LEdge> alg8 = new AStarSearch<>(Heuristics.h1);
		SolutionWithCost<City,OpRoad> bestSol2= (SolutionWithCost<City, OpRoad>) alg8.solve(p);
		System.out.println();

		BestFirstSearch<City,OpRoad> alg9 = new BestFirstSearch<>(Heuristics.h1);
		SolutionWithCost<City,OpRoad> bestSol3= (SolutionWithCost<City, OpRoad>) alg9.solve(p);
		System.out.println();
*/
		
	}
    

}
