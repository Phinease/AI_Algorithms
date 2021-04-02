package problems.agc1;

import java.util.Set;

import iialib.stateSpace.algs.ASearchAlgorithmStats;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.model.Problem;


public class GraphTestNaiveDFS{

	public static void main(String[] args) {
		
		// -- Problems --
		Set<LNode> goal = Set.of(LNode.P , LNode.R , LNode.T , LNode.U );
		Problem<LNode> p = Problem.defineProblem(LNode.A, goal);

		/*

		ASearchAlgorithmStats<LNode,LEdge>  alg = new DepthFirstSearchNaiveStats<>();

		// This will loop since the state graph has cycle (=> StackOverflow)
		Solution<LNode,LEdge> s = alg.solve(p);

		*/
		
		
	}
    

}
