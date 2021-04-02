package problems.toBucharest;

import java.util.ArrayList;
import java.util.List;

import iialib.stateSpace.model.IOperatorWithCost;

public class OpRoad implements IOperatorWithCost<City>{

	
	// ------------ List with all operators -------------------
	public static final List<OpRoad> ALL_OPS = new ArrayList<OpRoad>();
	 
	// ------------ Attributes -------------------
    	
	City origin;
	City destination;
	String name;
	double cost;
	
	// ------------ Constructor -------------------
	// nb for enums it has to be private
	public OpRoad(City origin, City destination, String name , double cost) {
		this.origin = origin;
		this.destination = destination;
		this.name = name;
		this.cost = cost;
	}
	
	// ------------ Constructor -------------------
	
	
	// ------------ Methods form IOperator -------------------
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public double getCost() {
		return cost;
	}
	
	@Override
	public boolean isApplicable(City c) {
		return origin.equals(c);
	}
	@Override
	public City successor(City c) {
		return destination;
	}

	@Override
	public String toString() {
		return this.getName()+"("+this.cost+")";
	}
	
	
	
	

}