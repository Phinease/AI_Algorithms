package iialib.stateSpace.algs;

import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;

import java.util.ArrayList;
import java.util.List;

public class Solution<S extends IState<O>, O extends IOperator<S>> {

    /**
     * First state on the solution path
     */
    private final S state;
    /**
     * Operator to the next state on the solution path (or null if last element)
     */
    private final O operator;
    /**
     * rest of the solution path (or null if last element)
     */
    private final Solution<S, O> rest;

    // ------------ Constructors ------------
    public Solution(S state, O operator, Solution<S, O> rest) {
        super();
        this.state = state;
        this.operator = operator;
        this.rest = rest;
    }

    public Solution(S state) {
        this(state, null, null);
    }

    public Solution(S state, O operator) {
        this(state, operator, null);
    }


    // ------------ Getters / Setters ------------
    public S getState() {
        return state;
    }


    public O getOperator() {
        return operator;
    }


    public Solution<S, O> getRest() {
        return rest;
    }


    // ------------ Other Methods ------------

    /**
     * length of the Solution path
     *
     * @return the number of states in the solution path
     */
    public int length() {
        int length = 0;
        Solution<S, O> s = this;
        while (s != null) {
            length++;
            s = s.rest;
        }
        return length;
    }

    /**
     * extract the sequence of states corresponding to the solution path
     *
     * @return a sequence of states
     */
    public List<S> statePath() {
        ArrayList<S> result = new ArrayList<S>();
        Solution<S, O> s = this;
        while (s != null) {
            result.add(s.state);
            s = s.rest;
        }
        return result;
    }

    /**
     * extract the sequence of operators applied on the solution path
     *
     * @return a sequence of operators
     */
    public List<O> opSequence() {
        ArrayList<O> result = new ArrayList<O>();
        Solution<S, O> s = this;
        while (s != null) {
            if (s.rest != null)
                result.add(s.operator);
            s = s.rest;
        }
        return result;
    }

    public String toString() {
        String s = "";
        Solution<S, O> sol = this;
        while (sol != null) {
            s = s + sol.state;
            if (sol.operator != null)
                s = s + " - " + sol.operator + " -> ";
            sol = sol.rest;
        }
        return s;
    }

}
