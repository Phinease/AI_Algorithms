package problems.tsp.map;

import java.util.Set;
import java.util.SortedSet;

public abstract class AMap {
		
	// -------- Attributes --------------
	Set<String> towns;
	
	// -------- Getters  --------------
	public Set<String> getTowns() {
		return towns;
	}

	// -------- Constructor --------------
	AMap(Set<String> towns){
		this.towns = towns;	
	}
	
	// -------- Abstract Methods --------------

	// return the distance between to cities directly connected on the Map
	// return O for identical cities
	// return -1 for non connected cities
	public abstract double distance(String s1, String s2);
	
	// return true iff tows are different and directly connected on the Map
	public abstract boolean areConnected(String s1, String s2);

	
	// -------- OtherMethods --------------
	// To override if Roads have id labels
	public String  roadId(String s1, String s2) {
		return "";
	};
	
	/* Return the smallest distance among all existing roads on the map */
	public double minimalDistance(){
		double minDist = Double.MAX_VALUE;
		for (String t1 : towns)
			for (String t2 : towns)
				if(!t1.equals(t2) && areConnected(t1,t2))
						minDist = Math.min(minDist, this.distance(t1,t2));
		return  minDist;
	}

	
	/* Return the average distance for all existing roads connecting town*/
	public double shortestRoadDistanceFromTown(String town){
		double minDist = Double.MAX_VALUE;
		for (String otherTown : towns)
			if(town != otherTown && areConnected(town,otherTown))
					minDist = Math.min(minDist, distance(town,otherTown));
	return  minDist;
	}

	/* Return the smallest distance among all existing roads */
	public double averageRoadDistanceFromTown(String town){
		double minDist = Double.MAX_VALUE;
		int nbOfNeighbors=0;
		for (String otherTown : towns)
			if(town != otherTown && areConnected(town,otherTown)) {
				minDist = Math.min(minDist, distance(town,otherTown));
				nbOfNeighbors++;;
			}
	if (nbOfNeighbors > 0)	
		return  minDist/nbOfNeighbors;
	else
		return  nbOfNeighbors;
	}
	
	/* Check if a string correspond to name of a town of the map */
	public boolean checkTown(String town){
		return towns.contains(town);
	}


}
