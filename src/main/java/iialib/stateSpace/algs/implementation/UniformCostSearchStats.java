package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.*;
import iialib.stateSpace.model.Problem;
import iialib.stateSpace.model.IOperatorWithCost;
import iialib.stateSpace.model.IState;


public class UniformCostSearchStats<S extends IState<O>, O extends IOperatorWithCost<S>>
			extends ASearchAlgorithmStats<S, O> {

	// ----------------- Static attributes -----------------
	private static final String  DESCRIPTION = "Uniform-Cost Search (UCS)";


	// -----------------  Constructors -----------------
	public UniformCostSearchStats() {
		super();
	}

	// ----------------- Methods from  ISearchAlgorithm-----------------
	public Solution<S, O> solve(Problem p) {
		//TODO
		//.......
		System.out.println("-----------------------------------------------------");
		System.out.println("Solving problem: " + p);
		System.out.println("with algorithm: " + DESCRIPTION);
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
