package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.ASearchAlgorithmStats;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearchNaiveStats<S extends IState<O>, O extends IOperator<S>>
        extends ASearchAlgorithmStats<S, O> {

    private final Stack<S> stack;
    private static final String DESCRIPTION = "Naive Depth-First search";

    public DepthFirstSearchNaiveStats() {
        stack = new Stack<>();
    }

    @Override
    public Solution<S, O> solve(Problem<S> problem) {
        if (stack.empty()) stack.push(problem.getInitialState());

        S currentState = stack.pop();
        if (problem.isTerminal(currentState)) return new Solution<>(currentState);

        for (Iterator<O> it = currentState.applicableOperators(); it.hasNext(); ) {
            O o = it.next();
            stack.push(o.successor(currentState));

            Solution<S, O> res = solve(problem);
            if (res != null) return new Solution<>(currentState, o, res);
        }

        return null;
    }

}
