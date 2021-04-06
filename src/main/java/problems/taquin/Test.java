package problems.taquin;

import iialib.stateSpace.algs.IHeuristicSearchAlgorithm;
import iialib.stateSpace.algs.implementation.AStarSearchStats;
import iialib.stateSpace.model.Problem;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		// Beware when testing to start from which it is possible
		// to reach the desired goal state

		// The state space is made of two disjoint connected components

		IHeuristicSearchAlgorithm<TaquinState, TaquinOperator> aStar = new AStarSearchStats<>();

		Problem<TaquinState> p = new Problem<>(new TaquinState(), "test") {
			@Override
			public boolean isTerminal(TaquinState s) {
				return Arrays.deepEquals(s.getBoard(), TaquinState.terminal);
			}
		};

		aStar.solve(p, Heuristics.manhattanDistance(new TaquinState(TaquinState.terminal)));
		aStar.solve(p, Heuristics.nbOfUnmatchedTiles(new TaquinState(TaquinState.terminal)));


	}


}