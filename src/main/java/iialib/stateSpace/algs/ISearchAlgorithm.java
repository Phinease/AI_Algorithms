package iialib.stateSpace.algs;

import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

public interface ISearchAlgorithm<S extends IState<O>, O extends IOperator<S>> {
    Solution<S, O> solve(Problem<S> p);
}
