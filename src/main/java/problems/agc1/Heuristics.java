package problems.agc1;

import iialib.stateSpace.model.IHeuristic;

/**
 * Formalization of a specific abstract graph.
 *
 * @author Philippe Chatalic
 */


// ----------------------- Constants ---------------------------
public class Heuristics {

    public static IHeuristic<LNode> h1 = state -> {
        switch (state) {
            case A:
            case E:
                return 19;
            case B:
            case M:
                return 16;
            case C:
            case F:
            case J:
                return 17;
            case D:
                return 15;
            case G:
                return 11;
            case H:
                return 6;
            case I:
                return 5;
            case K:
                return 10;
            case L:
            case S:
                return 12;
            case N:
                return 8;
            case O:
                return 3;
            case P:
            case R:
            case T:
            case U:
                return 0;
            case Q:
                return 4;
            default:
                throw new RuntimeException("invalide enum value");
        }
    };

}
