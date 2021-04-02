package iialib.stateSpace.model;

import java.util.Set;

public abstract class Problem<State extends IState<?>> {

    // -------- Constructors --------
    /**
     * the intial state
     */
    private final State initialState;
    /**
     * a readable description of the problem
     */
    private final String description;

    // ---------------- Constructors ----------------
    public Problem(State s) {
        initialState = s;
        description = "no description for this problem";
    }

    public Problem(State s, String d) {
        initialState = s;
        description = d;
    }

    // -------- static functional Constructors --------
    //  Constructor for a goal reduced to a single state
    public static <State extends IState<?>> Problem<State> defineProblem(State initState, State goalState) {
        String desc = "Problem: from " + initState + " to : " + goalState;

        return new Problem<State>(initState, desc) {

            public boolean isTerminal(State aState) {
                return goalState.equals(aState);
            }
        };
    }

	// Constructor for a goal described as a set of States
    public static <State extends IState<?>> Problem<State> defineProblem(State initState, Set<State> terminalStates) {
        String desc = "Problem : from " + initState + "\n"
                + "to goal :      " + terminalStates;

        return new Problem<State>(initState, desc) {

            public boolean isTerminal(State aState) {
                return terminalStates.contains(aState);
            }
        };
    }

    // ------------Other methods ------------

    // ---------------- Getters ----------------
    public State getInitialState() {
        return initialState;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

    public abstract boolean isTerminal(State s);


}
