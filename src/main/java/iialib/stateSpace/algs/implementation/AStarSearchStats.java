package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.*;
import iialib.stateSpace.model.Problem;
import iialib.stateSpace.model.IHeuristic;
import iialib.stateSpace.model.IOperatorWithCost;
import iialib.stateSpace.model.IState;

public class AStarSearchStats<S extends IState<O>, O extends IOperatorWithCost<S>>
		extends AHeuristicSearchAlgorithmStats<S, O> {

	// ----------------- Static attributes -----------------
	private static final String DESCRIPTION = "A*";

	// -----------------  Constructors -----------------
	public AStarSearchStats() {
		super();
	}

	// ----------------- Methods from IHeuristicSearchAlgorithm -----------------
	@Override
	public Solution<S, O> solve(Problem<S> p, IHeuristic<S> h) {
		// TODO
		//...
		System.out.println("-----------------------------------------------------");
		System.out.println("Solving problem: " + p);
		System.out.println("with algorithm: " + DESCRIPTION + " and heurisitic " + h);
		System.out.println("-----------------------------------------------------");
		resetStatistics();

		SolutionWithCost<S, O> sol = null;  // TODO
		System.out.println("-----------------------------------------------------");
		System.out.println((sol != null) ?
				"Solution : " + sol + "\nCost : " + sol.cost()
				: "FAILURE !");
		System.out.println("-----------------------------------------------------");
		return sol;
	}


}