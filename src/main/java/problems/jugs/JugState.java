package problems.jugs;

import iialib.stateSpace.model.IState;

import java.util.ArrayList;
import java.util.Iterator;

public class JugState implements IState<JugOperator> {

	private final int size;
	private final int[] jugs;
	private final int[] capacities;
	private final int aim;

	// ------------ Constructors -------------------

	public JugState(int[] capacities, int aim) {
		jugs = new int[capacities.length];
		this.size = jugs.length;
		this.capacities = capacities;
		this.aim = aim;
	}

	public JugState(int[] capacities, int[] jugs, int aim) {
		this.jugs = jugs;
		this.capacities = capacities;
		this.size = jugs.length;
		this.aim = aim;
	}

	public JugState(JugState s) {
		this.jugs = s.jugs.clone();
		this.capacities = s.capacities.clone();
		this.aim = s.aim;
		this.size = s.size;
	}

	// ------------ getter / setters-------------------

	protected int[] getJugs() {
		return jugs;
	}

	protected int[] getCapacities() {
		return capacities;
	}

	protected int getAim() {
		return aim;
	}

	protected void empty(int index) {
		jugs[index] = 0;
	}

	protected void fill(int index) {
		jugs[index] = capacities[index];
	}

	protected void pour(int j1, int j2) {
		jugs[j1] = 0;
		jugs[j2] = Math.min(jugs[j1] + jugs[j2], capacities[j2]);
	}

	// ------------ IState interface methods -----------------

	@Override
	public Iterator<JugOperator> applicableOperators() {
		ArrayList<JugOperator> operators = new ArrayList<>();
		for (int i = 0; i < size; i++) {

		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO
		return false;
	}

	@Override
	public String toString() {
		// TODO
		return "";
	}


}