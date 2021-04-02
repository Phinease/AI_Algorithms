package problems.tsp;

import java.util.Set;

import problems.tsp.map.AMap;
import problems.tsp.map.MapOfRomania1;
import problems.tsp.map.Map2;
import problems.tsp.map.Map3;

import iialib.stateSpace.algs.IHeuristicSearchAlgorithm;
import iialib.stateSpace.algs.implementation.AStarSearchStats;
import iialib.stateSpace.model.IHeuristic;
import iialib.stateSpace.model.Problem;

public class RunTSP {

	public static void main(String[] args ) {
		
		AMap map1 = new MapOfRomania1();
		AMap map2 = new Map2();
		AMap map3 = new Map3();
	
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("---------------------- Results for Map 1 ---------------------------------");
		System.out.println("--------------------------------------------------------------------------");
				
		compareHeuristics(map1);
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("---------------------- Results for Map 2 ---------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		
		compareHeuristics(map2);
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("---------------------- Results for Map 3 ---------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		
		compareHeuristics(map3);
	
	}
	
	
	public static <M extends AMap>void compareHeuristics(M map) {
		
		TSPState.setMap(map);
	
		Set<String> allTowns =  map.getTowns();
		String start = allTowns.iterator().next(); 
			// The set is supposed to be not empty... and a cycle must pass by each town
			// Let's take the first one returned bue the operator
			// This city is present in all maps 
			// Otherwise pick any element of allTowns
		
		TSPState init = new TSPState(allTowns,start);
		
		Problem<TSPState> p = new Problem<TSPState>(init,"cycle begining at "+start) {
			public boolean isTerminal(TSPState s) {
				return (s.getCurrentTown().equals(start) && s.getToBeVisited().isEmpty());
			}
		};
		
			
		IHeuristic<TSPState> minDist	= new IHeuristic<TSPState>(){
			public double apply(TSPState s) {
				return map.minimalDistance();
			}	

			@Override
			public String toString() {
				return  "minDistance"; 		
			}
		};
		
		IHeuristic<TSPState> minConnectedDist = new IHeuristic<TSPState>(){
			public double  apply(TSPState s) {
				return map.shortestRoadDistanceFromTown(s.getCurrentTown());
			}
			@Override
			public String toString() {
				return  "minimal distance of connected roads"; 		
			}
		};	

		IHeuristic<TSPState> avConnectedDist = new IHeuristic<TSPState>(){
			public double  apply(TSPState s) {
				return map.averageRoadDistanceFromTown(s.getCurrentTown());
			}
			@Override
			public String toString() {
				return  "average distance of connected roads"; 		
			}
		};	
		
		IHeuristicSearchAlgorithm<TSPState,TSPOperator> aStar = new AStarSearchStats<TSPState,TSPOperator>();		
		
		aStar.solve(p,minDist);
		aStar.solve(p,minConnectedDist);
		aStar.solve(p,avConnectedDist);
		
	}
		
		
	

}
