package problems.graph;

import iialib.stateSpace.model.IState;

import java.util.Iterator;

public class GraphState implements IState<GraphOperator> {
    @Override
    public Iterator<GraphOperator> applicableOperators() {
        return null;
    }
}
