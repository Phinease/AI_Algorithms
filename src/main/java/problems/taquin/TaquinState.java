package problems.taquin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import iialib.stateSpace.model.ApplicableOpsIterator;
import iialib.stateSpace.model.IState;

public class TaquinState implements IState<TaquinOperator>{

	// ---------------------- Attributes ----------------------
	public static int ORDER = 3;


	// Attributes

	// ---------------------- Attributes ----------------------
	// TODO

	// ---------------------- Constructors ----------------------
	// TODO


	// ---------------------- Mothods from IState ----------------------

	@Override
	public Iterator<TaquinOperator> applicableOperators() {
		return null;
	}


}
