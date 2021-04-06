package problems.jugs;

import iialib.stateSpace.model.IState;
import problems.tsp.TSPState;

import java.util.ArrayList;
import java.util.Arrays;
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

	public JugState(JugState s) {
		jugs = s.getJugs();
		capacities = s.getCapacities();
		aim = s.aim;
		size = s.size;
	}

	// ------------ getter / setters-------------------

	protected int[] getJugs() {
		int[] newJugs = new int[size];
		System.arraycopy(jugs, 0, newJugs, 0, size);
		return newJugs;
	}

	protected int[] getCapacities() {
		int[] newCapacities = new int[size];
		System.arraycopy(capacities, 0, newCapacities, 0, size);
		return newCapacities;
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
	    int difference = capacities[j2] - jugs[j2];
		jugs[j2] = Math.min(jugs[j1] + jugs[j2], capacities[j2]);
		jugs[j1] = Math.max(jugs[j1] - difference, 0);
	}

	// ------------ IState interface methods -----------------

	@Override
	public Iterator<JugOperator> applicableOperators() {
//		System.out.println("Applicable operators:");
		ArrayList<JugOperator> operators = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			JugOperator operator = new JugOperator(JugOperator.Action.FILL, i);
			if (operator.isApplicable(this)) {
				operators.add(operator);
//				System.out.println(operator);
			}

			operator = new JugOperator(JugOperator.Action.EMPTY, i);
			if (operator.isApplicable(this)) {
				operators.add(operator);
//				System.out.println(operator);
			}

			for (int j = 0; j < size; j++) {
				if (i == j) continue;
				operator = new JugOperator(JugOperator.Action.POUR, i, j);
				if (operator.isApplicable(this)) {
					operators.add(operator);
//					System.out.println(operator);
				}
			}
		}
//		System.out.println();
		return operators.iterator();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JugState)) {
			return false;
		}
		JugState et = (JugState) obj;
		int[] otherjugs = et.getJugs();
		for (int i = 0; i < size; i++) {
			if (otherjugs[i] != jugs[i]) return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder().append('\n');
		char[] alphabets = "ABCDEFGHIJK".toCharArray();
		for (int i = 0; i < size; i++) {
			stringBuilder.append(alphabets[i]).append('\t');
		}
		stringBuilder.append('\n');
		for (int i = 0; i < size; i++) {
			stringBuilder.append(jugs[i]).append('\t');
		}
		stringBuilder.append('\n');
		for (int i = 0; i < size; i++) {
			stringBuilder.append(capacities[i]).append('\t');
		}
		return stringBuilder.toString();
	}
}