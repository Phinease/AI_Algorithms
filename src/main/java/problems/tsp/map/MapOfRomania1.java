package problems.tsp.map;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MapOfRomania1 extends AMap {
	

	/*
	 * A simple example with 9 cities
	 * 275 nodes developed = 275
	 */
	
	public enum Town {
		Arad,Bucharest,Craiova, 
		Dobreta,Fagaras,Oradea,
		Pitesti,Riminiscu,Sibiu
	};
		
	// Road distances between cities (according to the towns order in the enum)
		// -1 means that there is no road directly connecting the towns
	private static double[][] distance = 
	{
		{   0,  -1,  -1, 374,  -1, 146,  -1,  -1, 140 },
		{  -1,   0, 160,  -1, 211,  -1, 101,  -1,  -1 },
		{  -1, 160,   0, 120,  -1,  -1, 138, 146,  -1 },
		{ 374,  -1, 120,   0,  -1,  -1,  -1,  -1,  -1 },
		{  -1, 211,  -1,  -1,   0,  -1,  -1,  -1,  99 },
		{ 146,  -1,  -1,  -1,  -1,   0,  -1,  -1, 151 },
		{  -1, 101, 138,  -1,  -1,  -1,   0,  97,  -1 },
		{  -1,  -1, 146,  -1,  -1,  -1,  97,   0,  80 },
		{ 140,  -1,  -1,  -1,  99, 151,  -1,  80,   0 }
			
	};

	static Set<String> set =
			EnumSet.allOf(Town.class)
						.stream()
						.map(t -> t.toString())
						.collect(Collectors.toSet()) ;
	
	//---------------------- Constructor ----------------------
	public MapOfRomania1() {
		super(set);
		// TODO Auto-generated constructor stub
	}

	
	//---------------------- Methods from AMAP ----------------------

	public boolean areConnected(String sa, String sb){
		int ta = Town.valueOf(sa).ordinal();
		int tb = Town.valueOf(sb).ordinal();
		return (distance[ta][tb] > 0);
	}

	public double distance(String sa, String sb){
		int ta = Town.valueOf(sa).ordinal();
		int tb = Town.valueOf(sb).ordinal();
		return (distance[ta][tb]);
	}
	
}
