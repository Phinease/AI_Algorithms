package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.ASearchAlgorithmStats;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearchCycleDetectStats<S extends IState<O>, O extends IOperator<S>>
        extends ASearchAlgorithmStats<S, O> {

    private final Stack<S> stack;
    private final ArrayList<S> dejaVu;
    public static final String DESCRIPTION = "Depth-First Search (with cyle detection)";


    public DepthFirstSearchCycleDetectStats() {
        stack = new Stack<>();
        dejaVu = new ArrayList<>();
    }

    @Override
    public Solution<S, O> solve(Problem<S> problem) {
        if (stack.empty()) stack.push(problem.getInitialState());

        S currentState = stack.pop();
        if (problem.isTerminal(currentState)) return new Solution<>(currentState);
        dejaVu.add(currentState);

        for (Iterator<O> it = currentState.applicableOperators(); it.hasNext(); ) {
            O o = it.next();
            S successor = o.successor(currentState);
            if (dejaVu.contains(successor)) continue;
            stack.push(successor);

            Solution<S, O> res = solve(problem);
            if (res != null) return new Solution<>(currentState, o, res);
        }

        return null;
    }

}
