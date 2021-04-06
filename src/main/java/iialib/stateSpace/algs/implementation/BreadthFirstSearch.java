package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.ISearchAlgorithm;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

import java.util.*;

/**
 * Class implementing Breadth First Search in a state space (without statistics)
 *
 * @param <S> The class of States
 * @param <O> The class of Operators
 */
public class BreadthFirstSearch<S extends IState<O>, O extends IOperator<S>> implements ISearchAlgorithm<S, O> {

    // ----------------- Static attributes -----------------
    private static final String DESCRIPTION = "Breadth-First Search";

    // ----------------- Attributes -----------------
    /**
     * The problem being solved
     */
    private Problem<S> problem;

    // -----------------  Constructors -----------------
    public BreadthFirstSearch() {
        super();
    }

    private static <S extends IState<O>, O extends IOperator<S>> Solution<S, O> buildSolution(SSNode<S, O> node) {
        S s = node.getState();
        O op = node.getOperator();
        SSNode<S, O> ancestor = node.getAncestor();
        Solution<S, O> sol = new Solution<>(s);
        while (ancestor != null) {
            sol = new Solution<>(ancestor.getState(), op, sol);
            op = ancestor.getOperator();
            ancestor = ancestor.getAncestor();
        }
        return sol;
    }

    private static <S extends IState<O>, O extends IOperator<S>> boolean notContainsNodeWithSameState(Collection<SSNode<S, O>> collection, S state) {
        for (SSNode<S, O> node : collection)
            if (node.getState().equals(state))
                return false;
        return true;
    }

    // ----------------- Methods from  ISearchAlgorithm-----------------
    @Override
    public Solution<S, O> solve(Problem<S> p) {
        this.problem = p;
        System.out.println("----------------------------------------------------");
        System.out.println("Solving problem: " + problem);
        System.out.println("with algorithm: " + DESCRIPTION);
        System.out.println("----------------------------------------------------");
        Solution<S, O> sol = search(problem.getInitialState());
        System.out.println("----------------------------------------------------");
        System.out.println((sol != null) ? "Solution : " + sol : "FAILURE !");
        System.out.println("----------------------------------------------------");
        return sol;
    }

    private Solution<S, O> search(S s) {

        Solution<S, O> result = null;

        // Data structures initialization
        Set<SSNode<S, O>> developedNodes = new HashSet<>();
        LinkedList<SSNode<S, O>> frontier = new LinkedList<>();
        frontier.addLast(new SSNode<>(s, null, null));
        //
        while (!frontier.isEmpty()) {
            // Node Seelection - Frontier is managed as queue - The head node is selected
            SSNode<S, O> node = frontier.remove();
            developedNodes.add(node);
            S state = node.getState();
            // Test for terminations
            if (problem.isTerminal(state)) {
                result = buildSolution(node);
                break;
            } // Node expansion
            else {
                Iterator<O> it = state.applicableOperators();
                while (it.hasNext()) {
                    O operator = it.next();
                    S successor = operator.successor(state);

                    if (notContainsNodeWithSameState(developedNodes, successor) && notContainsNodeWithSameState(frontier, successor))
                        frontier.addLast(new SSNode<>(successor, operator, node));
                }
            }
        }
        return result;
    }
}
