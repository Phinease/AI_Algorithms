package problems.taquin;

import iialib.stateSpace.model.IState;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TaquinState implements IState<TaquinOperator> {

	// ---------------------- Attributes ----------------------
	public static int ORDER = 3;

	public static final int[][] initial = {
			{2, 8, 3},
			{1, 6, 4},
			{7, 0, 5}};

	public static final int[][] terminal = {
			{1, 2, 3},
			{8, 0, 4},
			{7, 6, 5}};

	private final int[][] board;
	private final Point emptyCase;

	// ---------------------- Constructors ----------------------
	public TaquinState() {
		board = initial;
		emptyCase = new Point(2, 1);
	}

	public TaquinState(int[][] board) {
		this.board = new int[ORDER][ORDER];
		for (int i = 0; i < ORDER; i++) System.arraycopy(board[i], 0, this.board[i], 0, ORDER);
		for (int i = 0; i < ORDER; i++) {
			for (int j = 0; j < ORDER; j++) {
				if (board[i][j] == 0) {
					emptyCase = new Point(i, j);
					return;
				}
			}
		}
		System.out.println("No empty case!");
		emptyCase = new Point(-1, -1);
	}

	public TaquinState(int[][] board, Point emptyCase) {
		this.board = board;
		this.emptyCase = emptyCase;
	}

	// ---------------------- Getter / Setter ----------------------
	public Point getEmptyCase() {
		return (Point) emptyCase.clone();
	}

	public int[][] getBoard() {
		int[][] newBoard = new int[ORDER][ORDER];
		for (int i = 0; i < ORDER; i++) System.arraycopy(board[i], 0, newBoard[i], 0, ORDER);
		return newBoard;
	}

	// ---------------------- Methods from IState ----------------------
	@Override
	public Iterator<TaquinOperator> applicableOperators() {
		ArrayList<TaquinOperator> applicables = new ArrayList<>();
		for (TaquinOperator operator : TaquinOperator.ALL_OPS) {
			if (operator.isApplicable(this)) applicables.add(operator);
		}

		return applicables.iterator();
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder().append('\n');
		for (int j = 0; j < TaquinState.ORDER; j++) {
			for (int k = 0; k < TaquinState.ORDER; k++) {
				out.append(board[j][k]).append('\t');
			}
			out.append('\n');
		}
		return out.toString();
	}
}
