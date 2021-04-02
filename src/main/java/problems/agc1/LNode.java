package problems.agc1;

import iialib.stateSpace.model.ApplicableOpsIterator;
import iialib.stateSpace.model.IState;

import java.util.Iterator;

/**
 * Formalization of a specific abstract graph.
 *
 * @author Philippe Chatalic
 */

// Constants ----------------------------------------------------------
public enum LNode implements IState<LEdge> {

    /* States correspond to Graph Nodes*/
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    H("H"),
    I("I"),
    J("J"),
    K("K"),
    L("L"),
    M("M"),
    N("N"),
    O("O"),
    P("P"),
    Q("Q"),
    R("R"),
    S("S"),
    T("T"),
    U("U");

    // ---------- Attributes ------------
    /**
     * the node label
     */
    private final String name;

    // ---------- Constructors ------------


    LNode(String l) {
        this.name = l;
    }

    @Override
    public Iterator<LEdge> applicableOperators() {
        return new ApplicableOpsIterator<>(LEdge.ALL_OPS, this);
    }

    @Override
    public String toString() {
        return this.name;
    }


}

    
   

