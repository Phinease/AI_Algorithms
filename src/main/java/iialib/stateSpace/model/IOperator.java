package iialib.stateSpace.model;

public interface IOperator<State> {

    /**
     * returns the name of the operator
     */
    String getName();

    /**
     * test if the operator is applicable on a state
     *
     * @param s the state on which the operator is tested
     * @return true if the operator is applicable on the state s
     */
    boolean isApplicable(State s);

    /**
     * computes the successor state of an operator on a state
     *
     * @param s the state on which the operator is applied
     * @return the successor of state state s
     */
    State successor(State s);

    @Override
    String toString();


}
