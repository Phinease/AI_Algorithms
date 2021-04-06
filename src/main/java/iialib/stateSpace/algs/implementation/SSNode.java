package iialib.stateSpace.algs.implementation;

import iialib.stateSpace.model.IOperator;
import iialib.stateSpace.model.IState;

public class SSNode<S extends IState<O>, O extends IOperator<S>> {

	// -------------- Attributes -------------------
	private S state;
	private O operator;
	private SSNode<S, O> ancestor;
	private double g;
	private double f;

	// -------------- Constructors -------------------
	public SSNode() {
		state = null;
		operator = null; 
		ancestor = null;
	}

	public SSNode(S state, O operator, SSNode<S, O> ancestor) {
		this.state = state;
		this.operator = operator;
		this.ancestor = ancestor;
	}

	// -------------- Getters / Setters -------------------
	public S getState() {
		return state;
	}

	public O getOperator() {
		return operator;
	}

	public SSNode<S, O> getAncestor() {
		return ancestor;
	}

	public void setState(S state) {
		this.state = state;
	}

	public void setOperator(O operator) {
		this.operator = operator;
	}

	public void setAncestor(SSNode<S, O> ancestor) {
		this.ancestor = ancestor;
	}

	public boolean hasSameState(SSNode<S, O> n) {
		return state.equals(n.state);
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	// -------------- Other Methods -------------------

	public String toString() {
		return "Node(" + state + "," + operator + "," + ((ancestor==null)?"null":"par("+ ancestor.state)+")" + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ancestor == null) ? 0 : ancestor.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SSNode<S,O> other = (SSNode<S,O>) obj;		
		if (ancestor == null) {
			if (other.ancestor != null)
				return false;
		} else if (!ancestor.equals(other.ancestor))
			return false;
		return (this.state == other.state) && (this.operator == other.operator);
	}
	

}
