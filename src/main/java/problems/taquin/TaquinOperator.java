package problems.taquin;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import iialib.stateSpace.model.IOperatorWithCost;

public enum TaquinOperator implements IOperatorWithCost<TaquinState>{
	UP,DOWN,LEFT,RIGHT;
	public static List<TaquinOperator> ALL_OPS = Arrays.asList(TaquinOperator.values());

	@Override
	public String getName() {
		return this.name();
	}

	@Override
	public boolean isApplicable(TaquinState s) {
		Point moveCase = s.getEmptyCase();
		switch (this) {
			case UP -> moveCase.x += 1;
			case DOWN -> moveCase.x -= 1;
			case LEFT -> moveCase.y -= 1;
			case RIGHT -> moveCase.y += 1;
		}

		if (moveCase.x < 0 || moveCase.x > TaquinState.ORDER - 1) return false;
		return moveCase.y >= 0 && moveCase.y <= TaquinState.ORDER - 1;
	}

	@Override
	public TaquinState successor(TaquinState s) {
		Point emptyCase = s.getEmptyCase();
		Point moveCase = (Point) emptyCase.clone();
		switch (this) {
			case UP -> moveCase.x += 1;
			case DOWN -> moveCase.x -= 1;
			case LEFT -> moveCase.y -= 1;
			case RIGHT -> moveCase.y += 1;
		}

		int[][] newBoard = s.getBoard();
		newBoard[emptyCase.x][emptyCase.y] = newBoard[moveCase.x][moveCase.y];
		newBoard[moveCase.x][moveCase.y] = 0;

		return new TaquinState(newBoard, moveCase);
	}


	@Override
	public double getCost() {
		return 1;
	}
}
