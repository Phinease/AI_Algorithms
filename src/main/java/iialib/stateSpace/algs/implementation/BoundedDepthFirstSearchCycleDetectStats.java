package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.algs.ASearchAlgorithmStats;
import iialib.stateSpace.algs.Solution;
import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class BoundedDepthFirstSearchCycleDetectStats<S extends IState<O>, O extends IOperator<S>>
        extends ASearchAlgorithmStats<S, O> {

    public static final String DESCRIPTION = "Bounded Depth-First Search (with cyle detection)";
    private final int maxDepth;
    private int depth;

    public BoundedDepthFirstSearchCycleDetectStats(int maxDepth) {
        this.maxDepth = maxDepth;
        depth = maxDepth;
    }

    @Override
    public Solution<S, O> solve(Problem<S> p) {
        Stack<S> stack= new Stack<>();
        ArrayList<S> dejaVu= new ArrayList<>();

        if (stack.empty()) stack.push(p.getInitialState());

        S currentState = stack.pop();
        if (p.isTerminal(currentState)) return new Solution<>(currentState);
        if (depth == 0) {
            depth = maxDepth;
            return null;
        }

        dejaVu.add(currentState);

        for (Iterator<O> it = currentState.applicableOperators(); it.hasNext(); ) {
            O o = it.next();
            S successor = o.successor(currentState);
            if (dejaVu.contains(successor)) continue;
            stack.push(successor);
            depth -= 1;

            Solution<S, O> res = solve(p);
            if (res != null) return new Solution<>(currentState, o, res);
        }

        return null;
    }

}
