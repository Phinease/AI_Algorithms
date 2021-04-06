package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.AHeuristicSearchAlgorithmStats;
import iialib.stateSpace.model.Problem;
import iialib.stateSpace.model.IHeuristic;
import iialib.stateSpace.model.IOperatorWithCost;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.algs.SolutionWithCost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BestFirstSearchStats<S extends IState<O>, O extends IOperatorWithCost<S>> extends AHeuristicSearchAlgorithmStats<S, O> {

	// ----------------- Static attributes -----------------
	private static final String DESCRIPTION = "Best First Search (BFS)";

	// ----------------- Attributes -----------------

	// ----------------- Constructors-----------------
	public BestFirstSearchStats() {
		super();
	}

	// ----------------- Methods from IHeuristicSearchAlgorithm -----------------
	@Override
	public Solution<S, O> solve(Problem<S> p, IHeuristic<S> h) {
		System.out.println("-----------------------------------------------------");
		System.out.println("Solving problem: " + p);
		System.out.println("with algorithm: " + DESCRIPTION + " and heuristic " + h);
		System.out.println("-----------------------------------------------------");

		resetStatistics();
		ArrayList<SSNode<S, O>> dejaDev = new ArrayList<>();
		ArrayList<SSNode<S, O>> frontiere = new ArrayList<>();
		SortByF<S, O> comparator = new SortByF<>();

		SSNode<S, O> init = new SSNode<>(p.getInitialState(), null, null);
		init.setF(h.apply(init.getState()));
		frontiere.add(init);
		increaseVisited();

		SolutionWithCost<S, O> sol = null;

		while (!frontiere.isEmpty()) {
			frontiere.sort(comparator);
			SSNode<S, O> currentnode = frontiere.get(0);
			S currentstate = currentnode.getState();
			increaseDeveloped();

			if (p.isTerminal(currentnode.getState())) {
				sol = buildSolution(currentnode);
				break;
			}

			frontiere.remove(0);
			dejaDev.add(currentnode);

			for (Iterator<O> it = currentstate.applicableOperators(); it.hasNext(); ) {
				O operator = it.next();
				S successor = operator.successor(currentstate);

				if (containsState(dejaDev, successor)) continue;
				SSNode<S, O> node = new SSNode<>(successor, operator, currentnode);
				node.setF(h.apply(successor));
				frontiere.add(node);
				increaseVisited();
			}
		}

		System.out.println("-----------------------------------------------------");
		System.out.println((sol != null) ? "Solution : " + sol + "\nCost : " + sol.cost() : "FAILURE !");
		System.out.println(statistics());
		System.out.println("-----------------------------------------------------");
		return sol;
	}

	private static <S extends IState<O>, O extends IOperatorWithCost<S>> SolutionWithCost<S, O> buildSolution(SSNode<S, O> node) {
		S s = node.getState();
		O op = node.getOperator();
		SSNode<S, O> ancestor = node.getAncestor();
		SolutionWithCost<S, O> sol = new SolutionWithCost<>(s);
		while (ancestor != null) {
			sol = new SolutionWithCost<>(ancestor.getState(), op, sol);
			op = ancestor.getOperator();
			ancestor = ancestor.getAncestor();
		}
		return sol;
	}

	private static <S extends IState<O>, O extends IOperatorWithCost<S>> boolean containsState(Collection<SSNode<S, O>> collection, S state) {
		for (SSNode<S, O> node : collection)
			if (node.getState().equals(state))
				return true;
		return false;
	}
}
