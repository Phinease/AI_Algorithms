package iialib.stateSpace.algs;

import iialib.stateSpace.model.IOperatorWithCost;
import iialib.stateSpace.model.IState;

public class SolutionWithCost<S extends IState<O>, O extends IOperatorWithCost<S>> extends Solution<S, O> {

    // ------------ Constructors ------------
    public SolutionWithCost(S state, O operator, Solution<S, O> rest) {
        super(state, operator, rest);
    }

    public SolutionWithCost(S state) {
        super(state, null, null);
    }

    public SolutionWithCost(S state, O operator) {
        super(state, operator, null);
    }


    // ------------ Other Methods ------------

    /**
     * cost of the Solution path
     *
     * @return the total cost in the solution path
     */
    public double cost() {
        SolutionWithCost<S, O> rest = (SolutionWithCost<S, O>) this.getRest();
        if (rest == null)
            return 0;
        else
            return this.getOperator().getCost() + rest.cost();
    }


}
