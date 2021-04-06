package problems.jugs;

import iialib.stateSpace.algs.ASearchAlgorithmStats;
import iialib.stateSpace.algs.implementation.BreadthFirstSearchStats;
import iialib.stateSpace.model.Problem;


public class TestJugs {
    public static void main(String[] args) {
        ASearchAlgorithmStats<JugState, JugOperator> algo = new BreadthFirstSearchStats<>();
        Problem<JugState> p = new Problem<>(new JugState(new int[]{5, 7}, 4)) {
            @Override
            public boolean isTerminal(JugState s) {
                int sum = 0;
                int[] jugs = s.getJugs();
                for (int jug : jugs) sum += jug;
                return sum == s.getAim();
            }
        };

        algo.solve(p);
    }
}