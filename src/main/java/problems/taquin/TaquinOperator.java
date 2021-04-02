package problems.taquin;

import java.util.Arrays;
import java.util.List;
import iialib.stateSpace.model.IOperatorWithCost;

public enum TaquinOperator implements IOperatorWithCost<TaquinState>{
	
	UP,DOWN,LEFT,RIGHT;

	public static List<TaquinOperator> ALL_OPS = Arrays.asList(TaquinOperator.values());

	@Override
	public String getName() {
		//TODO
		return "";
	}

	@Override
	public boolean isApplicable(TaquinState s) {
		// TODO
		return false;
	}

	@Override
	public TaquinState successor(TaquinState s) {
		// TODO
		return null;
	}


	@Override
	public double getCost() {
		return 1;
	}
	


}
