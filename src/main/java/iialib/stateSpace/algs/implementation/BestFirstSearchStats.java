package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.AHeuristicSearchAlgorithmStats;
import iialib.stateSpace.model.Problem;
import iialib.stateSpace.model.IHeuristic;
import iialib.stateSpace.model.IOperatorWithCost;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.algs.SolutionWithCost;

public class BestFirstSearchStats<S extends IState<O>, O extends IOperatorWithCost<S>> extends AHeuristicSearchAlgorithmStats<S, O> {

	// ----------------- Static attributes -----------------
	private static final String  DESCRIPTION = "Best First Search (BFS)";

	// ----------------- Attributes -----------------

	// ----------------- Constructors-----------------
	public BestFirstSearchStats() {
		super();
	}

	// ----------------- Methods from IHeuristicSearchAlgorithm -----------------
	@Override
	public Solution<S, O> solve(Problem<S> p, IHeuristic<S> h) {
		// TODO
		//...
		System.out.println("-----------------------------------------------------");
		System.out.println("Solving problem: " + p);
		System.out.println("with algorithm: " + this.DESCRIPTION + " and heurisitic " + h);
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
