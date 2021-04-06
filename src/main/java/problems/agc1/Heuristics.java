package problems.agc1;

import iialib.stateSpace.model.IHeuristic;

/**
 * Formalization of a specific abstract graph.
 *
 * @author Philippe Chatalic
 */


// ----------------------- Constants ---------------------------
public class Heuristics {

    public static IHeuristic<LNode> h1 = state -> switch (state) {
        case A, E -> 19;
        case B, M -> 16;
        case C, F, J -> 17;
        case D -> 15;
        case G -> 11;
        case H -> 6;
        case I -> 5;
        case K -> 10;
        case L, S -> 12;
        case N -> 8;
        case O -> 3;
        case P, R, T, U -> 0;
        case Q -> 4;
    };
}
