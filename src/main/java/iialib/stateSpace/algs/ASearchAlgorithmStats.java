package iialib.stateSpace.algs;

import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;
import iialib.stateSpace.model.Problem;

public abstract class ASearchAlgorithmStats<S extends IState<O>, O extends IOperator<S>> extends SearchStats implements ISearchAlgorithm<S, O> {

    private int numberOfVisitedStates = 0;
    private int numberOfDevelopedStates = 0;

    public void resetStatistics() {
        numberOfVisitedStates = 0;
        numberOfDevelopedStates = 0;
    }

    public int getNumberOfVisitedStates() {
        return numberOfVisitedStates;
    }

    public int getNumberOfDevelopedStates() {
        return numberOfDevelopedStates;
    }

    public void increaseVisited() {
        numberOfVisitedStates++;
    }

    public void increaseDeveloped() {
        numberOfDevelopedStates++;
    }

    public String statistics() {
        return "Number of visited States " + numberOfVisitedStates + "\n" +
                "Number of developed States " + numberOfDevelopedStates + "\n";
    }

    public abstract Solution<S, O> solve(Problem<S> problem);
}
