package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.*;
import iialib.stateSpace.model.*;

import java.util.*;

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
		System.out.println("-----------------------------------------------------");
		System.out.println("Solving problem: " + p);
		System.out.println("with algorithm: " + DESCRIPTION + " and heurisitic " + h);
		System.out.println("-----------------------------------------------------");
		resetStatistics();
		ArrayList<SSNode<S, O>> dejaDev = new ArrayList<>();
		ArrayList<SSNode<S, O>> frontiere = new ArrayList<>();

		SortByF<S, O> comparator = new SortByF<>();

		SSNode<S, O> init = new SSNode<>(p.getInitialState(), null, null);
		init.setG(0);
		init.setF(h.apply(init.getState()));
		frontiere.add(init);
		increaseVisited();
		SolutionWithCost<S, O> sol = null;

		while (!frontiere.isEmpty()) {
			frontiere.sort(comparator);
			SSNode<S, O> currentnode = frontiere.get(0);
			increaseDeveloped();

			if(p.isTerminal(currentnode.getState())) {
				sol = buildSolution(currentnode);
				break;
			}

			frontiere.remove(0);
			dejaDev.add(currentnode);

			S currentstate = currentnode.getState();
			for (Iterator<O> it = currentstate.applicableOperators(); it.hasNext(); ) {
				O operator = it.next();
				S successor = operator.successor(currentstate);
				SSNode<S, O> node = getNodeIfExist(frontiere, successor);
				if (node == null) node = getNodeIfExist(dejaDev, successor);

				if (node == null) {
					node = new SSNode<>(successor, operator, currentnode);
					node.setG(currentnode.getG() + operator.getCost());
					node.setF(node.getG() + h.apply(successor));
					frontiere.add(node);
					increaseVisited();
				} else if (node.getG() > currentnode.getG() + operator.getCost()){
					node.setAncestor(currentnode);
					node.setG(currentnode.getG() + operator.getCost());
					node.setF(node.getG() + h.apply(successor));
					if(removeNodeWithSameState(dejaDev, successor)) frontiere.add(node);
					increaseVisited();
				}
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

	private static <S extends IState<O>, O extends IOperatorWithCost<S>> boolean removeNodeWithSameState(Collection<SSNode<S, O>> collection, S state) {
		return collection.removeIf(node -> node.getState().equals(state));
	}

	private static <S extends IState<O>, O extends IOperatorWithCost<S>> SSNode<S, O> getNodeIfExist(Collection<SSNode<S, O>> collection, S state) {
		for (SSNode<S, O> node : collection)
			if (node.getState().equals(state))
				return node;
		return null;
	}
}

