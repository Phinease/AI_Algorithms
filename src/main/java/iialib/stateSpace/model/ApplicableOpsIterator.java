package iialib.stateSpace.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements an iterator, that produces only operators from a given collectoin that are applicable on a given state
 *
 * @param <State>    Class of the state
 * @param <Operator> Class of the Operator
 */
public class ApplicableOpsIterator<State extends IState<Operator>, Operator extends IOperator<State>> implements Iterator<Operator> {

    // -------------------- Attributes ----------------------

    private final State state;
    private final Iterator<Operator> opsIt;
    private boolean hasNext;
    private Operator nextApplicableOperator;

    // -------------------- Constructor ----------------------
    public ApplicableOpsIterator(Collection<Operator> operators, State s) {
        opsIt = operators.iterator();
        state = s;
        findNextApplicable();
    }

    // -------------------- Methods from Iterator ----------------------
    @Override
    public Operator next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }
        return findNextApplicable();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    // -------------------- internal methods ----------------------
    private Operator findNextApplicable() {
        Operator prevApplicableOperator = nextApplicableOperator;
        hasNext = false;
        while (opsIt.hasNext()) {
            Operator op = opsIt.next();
            if (op.isApplicable(state)) {
                hasNext = true;
                nextApplicableOperator = op;
                break;
            }
        }
        return prevApplicableOperator;
    }


}
