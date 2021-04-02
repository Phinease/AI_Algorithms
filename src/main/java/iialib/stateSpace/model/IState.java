package iialib.stateSpace.model;

import java.util.Iterator;

public interface IState<Operator> {

    /**
     * Returns an iterator on the applicable operators on the state
     *
     * @return the iterator
     */
    Iterator<Operator> applicableOperators();

    @Override
    boolean equals(Object obj);

    @Override
    String toString();

    // NB Think also about overriding the hashCode() method if you plan to use classes using hashCodes
}
