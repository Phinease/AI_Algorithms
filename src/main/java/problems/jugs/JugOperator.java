package problems.jugs;

import iialib.stateSpace.model.IOperator;

public class JugOperator implements IOperator<JugState> {
    enum Action {FILL, EMPTY, POUR}
    private final Action action;
    private final int jug1;
    private int jug2;

    // ------------ Constructor -------------------

    JugOperator(Action action, int j) {
        assert (action != Action.POUR);
        this.action = action;
        jug1 = j;
    }

    JugOperator(Action action, int j1, int j2) {
        assert (action == Action.POUR);
        this.action = action;
        jug1 = j1;
        jug2 = j2;
    }

    // ------------ Methods from IOperator interface -------------------

    @Override
    public String getName() {
        return action.toString() + switch (action) {
            case POUR -> "(" + jug1 + " -> " + jug2 + ")";
            case EMPTY, FILL -> "(" + jug1 + ")";
        };
    }

    @Override
    public boolean isApplicable(JugState s) {
        return switch (action) {
            case FILL -> s.getCapacities()[jug1] != s.getJugs()[jug1];
            case EMPTY -> s.getJugs()[jug1] > 0;
            case POUR -> (s.getJugs()[jug1] > 0) && (s.getJugs()[jug2] != s.getCapacities()[jug2]);
        };
    }

    @Override
    public JugState successor(JugState state) {
        JugState succesor = new JugState(state);
        switch (action) {
            case POUR -> succesor.pour(jug1, jug2);
            case EMPTY -> succesor.empty(jug1);
            case FILL -> succesor.fill(jug1);
        }
        return succesor;
    }

    @Override
    public String toString() {
        return getName();
    }
}
