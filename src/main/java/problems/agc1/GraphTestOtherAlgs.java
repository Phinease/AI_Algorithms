package problems.agc1;

import java.util.Set;

import iialib.stateSpace.algs.AHeuristicSearchAlgorithmStats;
import iialib.stateSpace.algs.SolutionWithCost;
import iialib.stateSpace.algs.implementation.*;
import iialib.stateSpace.model.Problem;

public class GraphTestOtherAlgs{

	public static void main(String[] args) {
		
		// Defining a problem as an anonymous Object this implemented abstract methods
		Set<LNode> goal = Set.of(LNode.P , LNode.R , LNode.T , LNode.U );
		Problem<LNode> p = Problem.defineProblem(LNode.A, goal);
				

		// -- Testing non informed search Algorithms --
		/*
		ASearchAlgorithmStats<LNode,LEdge> alg1 = new DepthFirstSearchCycleDetectStats<>();

		Solution<LNode,LEdge> s1 = alg1.solve(p);
		System.out.println();
	   
		
		ASearchAlgorithmStats<LNode,LEdge> alg2 = new BoundedDepthFirstSearchCycleDetectStats<>(12);

		Solution<LNode,LEdge> s2= alg2.solve(p);
		System.out.println();

		
		ASearchAlgorithmStats<LNode,LEdge> alg3 = new BoundedDepthFirstSearchCycleDetectStats<>(8);

		Solution<LNode,LEdge> s3= alg3.solve(p);
		System.out.println();
	
		
		ASearchAlgorithmStats<LNode,LEdge> alg4 = new BoundedDepthFirstSearchCycleDetectStats<>(3);

		Solution<LNode,LEdge> s4= alg4.solve(p);
		System.out.println();
		*/

		/*
		ASearchAlgorithmStats<LNode,LEdge> bfs = new BreadthFirstSearchStats<>();

		Solution<LNode,LEdge> s5= bfs.solve(p);
		System.out.println();
		*/

		/*
		IterativeDeepeningSearchStats<LNode,LEdge> alg6 = new IterativeDeepeningSearchStats<>(100);

		Solution<LNode,LEdge> s6= alg6.solve(p);
		System.out.println();
		*/

		/*
		UniformCostSearchStats<LNode,LEdge> alg7 = new UniformCostSearchStats();
		*/

		/*
		SolutionWithCost<LNode,LEdge> bestSol7= (SolutionWithCost<LNode, LEdge>) alg7.solve(p);
		System.out.println();

		AHeuristicSearchAlgorithmStats<LNode,LEdge> alg8 = new BestFirstSearchStats<>();
		SolutionWithCost<LNode,LEdge> bestSol8= (SolutionWithCost<LNode, LEdge>) alg9.solve(p,Heuristics.h1);
		System.out.println();
		*/

		AHeuristicSearchAlgorithmStats<LNode,LEdge> aStar= new AStarSearchStats<>();
		SolutionWithCost<LNode,LEdge> bestSol9= (SolutionWithCost<LNode, LEdge>) aStar.solve(p,Heuristics.h1);
		System.out.println();




	}
    

}
