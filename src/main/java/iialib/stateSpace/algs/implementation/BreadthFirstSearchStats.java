package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.ASearchAlgorithmStats;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

import java.util.*;

public class BreadthFirstSearchStats<S extends IState<O>, O extends IOperator<S>> extends ASearchAlgorithmStats<S, O> {


    // -----------------  Static Atttributes -----------------
    private static final String DESCRIPTION = "Breadth-First Search (with statistics)";

    // -----------------  Attributes -----------------
    Problem<S> problem;

    // -----------------  Constructors -----------------
    public BreadthFirstSearchStats() {
        super();
    }

    private static <S extends IState<O>, O extends IOperator<S>> boolean containsNodeWithSameState(Collection<SSNode<S, O>> collection, S state) {
        for (SSNode<S, O> node : collection)
            if (node.getState().equals(state))
                return true;
        return false;
    }

    private static <S extends IState<O>, O extends IOperator<S>> Solution<S, O> buildSolution(SSNode<S, O> node) {
        S s = node.getState();
        O op = node.getOperator();
        SSNode<S, O> ancestor = node.getAncestor();
        Solution<S, O> sol = new Solution<S, O>(s);
        while (ancestor != null) {
            sol = new Solution<S, O>(ancestor.getState(), op, sol);
            op = ancestor.getOperator();
            ancestor = ancestor.getAncestor();
        }
        return sol;
    }

    @Override
    public Solution solve(Problem p) {
        return null;
    }

    private Solution<S, O> search(S s) {

        Solution<S, O> result = null;

        // Data Structure initialization
        Set<SSNode<S, O>> developedNodes = new HashSet<SSNode<S, O>>();
        LinkedList<SSNode<S, O>> frontier = new LinkedList<SSNode<S, O>>();
        frontier.addLast(new SSNode<>(s, null, null));
        this.increaseVisited();    // First created node

        while (!frontier.isEmpty()) {
            SSNode<S, O> node = frontier.remove();
            developedNodes.add(node);
            S state = node.getState();
            this.increaseDeveloped();
            //
            if (problem.isTerminal(state)) {
                result = buildSolution(node);
                break;
            } else {
                Iterator<O> it = state.applicableOperators();
                while (it.hasNext()) {
                    O operator = it.next();
                    S successor = operator.successor(state);
                    if (!containsNodeWithSameState(developedNodes, successor) && !containsNodeWithSameState(frontier, successor)) {
                        frontier.addLast(new SSNode<S, O>(successor, operator, node));
                        this.increaseVisited();   // New created node
                    }
                }
            }
        }
        return result;
    }


}
