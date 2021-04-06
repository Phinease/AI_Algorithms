package problems.tsp;

import iialib.stateSpace.model.ApplicableOpsIterator;
import iialib.stateSpace.model.IState;
import problems.tsp.map.AMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TSPState implements IState<TSPOperator> {

    // Data from the map
    public static AMap MAP;


    // --- State Attributes -----
    /**
     * the last reached town
     */
    private final String currentTown;

    /**
     * the list of cities remaining to be visited
     */
    private final Set<String> toBeVisited;


    // --- Constructors -----
    public TSPState(Set<String> set, String town) {
        this.toBeVisited = new HashSet<>(set);
        this.currentTown = town;
    }

    // --- Static Setters -----
    public static void setMap(AMap m) {
        MAP = m;
        initializeOperators();
    }

    public static void initializeOperators() {
        if (MAP == null)
            throw new NullPointerException("MAP has not been initialized - Cannot initialize Operators)");
        else {
            TSPOperator.ALL_OPS = new HashSet<>();
            Set<String> towns = MAP.getTowns();
            for (String t1 : towns)
                for (String t2 : towns)
                    if (MAP.areConnected(t1, t2))
                        TSPOperator.ALL_OPS.add(new TSPOperator(t1, t2, MAP.roadId(t1, t2), MAP.distance(t1, t2)));


        }

    }

    // --- Getters  -----
    public Set<String> getToBeVisited() {
        return toBeVisited;
    }


    // ---------------------- Methods form IState ----------------------

    public String getCurrentTown() {
        return currentTown;
    }

    @Override
    public String toString() {
        return "Current : " + currentTown + " / toVisit : " + toBeVisited;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TSPState)) {
            return false;
        }
        TSPState et = (TSPState) obj;
        if (this.getToBeVisited().size() != et.getToBeVisited().size()) {
            return false;
        }
        if (!this.currentTown.equals(et.currentTown)) {
            return false;
        }
        for (String ville : this.getToBeVisited()) {
            if (!et.getToBeVisited().contains(ville)) {
                return false;
            }
        }
        for (String ville : et.getToBeVisited()) {
            if (!this.getToBeVisited().contains(ville)) {
                return false;
            }
        }
        return true;
    }

    // ---------------------- Other Methods ----------------------

    @Override
    public Iterator<TSPOperator> applicableOperators() {
        return new ApplicableOpsIterator<>(TSPOperator.ALL_OPS, this);
    }


}
