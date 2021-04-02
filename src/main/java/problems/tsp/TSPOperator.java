package problems.tsp;

import java.util.HashSet;
import java.util.Set;

import iialib.stateSpace.model.IOperatorWithCost;

public class TSPOperator implements IOperatorWithCost<TSPState> {
	
	public static Set<TSPOperator> ALL_OPS;
	
	String currentTown;
	String nextTown;
	String name;
	double cost;

	//----------------------- Constructor ---------------------------------
	TSPOperator(String current,String next, String id, double distance) {
		this.currentTown = current;
		this.nextTown = next;
		this.cost = distance;
		this.name = id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "next : "+ nextTown;
	}

	@Override
	public boolean isApplicable(TSPState s) {
		return (s.getToBeVisited().contains(nextTown) 
				&&
				TSPState.MAP.areConnected(s.getCurrentTown(),nextTown));
		
	}

	@Override
	public TSPState successor(TSPState s) {
		Set<String> remaining = new HashSet<String>();
		for(String town : s.getToBeVisited())
				if(!town.equals(nextTown))
					remaining.add(town);
		return new TSPState(remaining,nextTown);
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return this.cost;
	}
		
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
	
	
	

}
