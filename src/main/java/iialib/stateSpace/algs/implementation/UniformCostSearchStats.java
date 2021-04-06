package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.ASearchAlgorithmStats;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.algs.SolutionWithCost;
import iialib.stateSpace.model.IOperatorWithCost;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class UniformCostSearchStats<S extends IState<O>, O extends IOperatorWithCost<S>>
			extends ASearchAlgorithmStats<S, O> {

	// ----------------- Static attributes -----------------
	private static final String DESCRIPTION = "Uniform-Cost Search (UCS)";


	// -----------------  Constructors -----------------
	public UniformCostSearchStats() {
		super();
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

	private static <S extends IState<O>, O extends IOperatorWithCost<S>> SSNode<S, O> getNodeIfExist(Collection<SSNode<S, O>> collection, S state) {
		for (SSNode<S, O> node : collection)
			if (node.getState().equals(state))
				return node;
		return null;
	}

	// ----------------- Methods from  ISearchAlgorithm-----------------
	public Solution<S, O> solve(Problem<S> p) {
		System.out.println("-----------------------------------------------------");
		System.out.println("Solving problem: " + p);
		System.out.println("with algorithm: " + DESCRIPTION);
		System.out.println("-----------------------------------------------------");

		resetStatistics();
		ArrayList<SSNode<S, O>> dejaDev = new ArrayList<>();
		ArrayList<SSNode<S, O>> frontiere = new ArrayList<>();
		// On met le G dans le variable F ici
		SortByF<S, O> comparator = new SortByF<>();

		SSNode<S, O> init = new SSNode<>(p.getInitialState(), null, null);
		init.setF(0);
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

				SSNode<S, O> node = getNodeIfExist(frontiere, successor);
				if (node == null) node = getNodeIfExist(dejaDev, successor);

				if (node == null) {
					node = new SSNode<>(successor, operator, currentnode);
					node.setF(node.getF() + operator.getCost());
					frontiere.add(node);
					increaseVisited();
				} else if (node.getF() > currentnode.getF() + operator.getCost()) {
					node.setAncestor(currentnode);
					node.setF(node.getF() + operator.getCost());
					if (removeNodeWithSameState(dejaDev, node.getState())) frontiere.add(node);
				}
			}
		}
		System.out.println("-----------------------------------------------------");
		System.out.println((sol != null) ? "Solution : " + sol + "\nCost : " + sol.cost() : "FAILURE !");
		System.out.println("-----------------------------------------------------");
		return sol;
	}

	private static <S extends IState<O>, O extends IOperatorWithCost<S>> boolean removeNodeWithSameState(Collection<SSNode<S, O>> collection, S state) {
		return collection.removeIf(node -> node.getState().equals(state));
	}
}
