package problems.taquin;

import iialib.stateSpace.model.IHeuristic;

import java.awt.*;


// Constants ----------------------------------------------------------


public class Heuristics {
	/**
	 * returns a heuristic corresponding to t
	 * @param goal	the goal state
	 * @return the heuristic with respect to the goal state
	 */
	public static IHeuristic<TaquinState> nbOfUnmatchedTiles(TaquinState goal){

		return new IHeuristic<>() {
			@Override
			public double apply(TaquinState state) {
				double nbUnmatched = 0.;
				int[][] currentBoard = state.getBoard();
				int[][] terminalBoard = goal.getBoard();

				for (int i = 0; i < TaquinState.ORDER; i++) {
					for (int j = 0; j < TaquinState.ORDER; j++) {
						if (currentBoard[i][j] != terminalBoard[i][j]) nbUnmatched += 1;
					}
				}
				return nbUnmatched;
			}
			@Override
			public String toString() {
				return  "number of misplaced tiles wrt goal"; 		
			}
			};
	}
	
	
	
	public static IHeuristic<TaquinState> manhattanDistance(TaquinState goal) {

		return new IHeuristic<>() {
			@Override
			public double apply(TaquinState state) {
				double distances = 0.;
				int[][] currentBoard = state.getBoard();
				int[][] terminalBoard = goal.getBoard();

				for (int i = 0; i < TaquinState.ORDER * TaquinState.ORDER - 1; i++) {
					Point p1 = null;
					Point p2 = null;

					for (int j = 0; j < TaquinState.ORDER; j++) {
						for (int k = 0; k < TaquinState.ORDER; k++) {
							if (currentBoard[j][k] == i + 1) p1 = new Point(j, k);
							if (terminalBoard[j][k] == i + 1) p2 = new Point(j, k);
						}
					}

					assert p1 != null && p2 != null;
					distances += Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
				}
				return distances;
			}

			@Override
			public String toString() {
				return "Manhattan distance wrt goal";
			}
		};

	}
	
	
	
	
	
}
