package problems.graph;

import iialib.stateSpace.model.IOperator;

public class GraphOperator implements IOperator<GraphState> {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isApplicable(GraphState s) {
        return false;
    }

    @Override
    public GraphState successor(GraphState s) {
        return null;
    }
}