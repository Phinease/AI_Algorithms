package problems.tsp.map;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Map2 extends AMap {
	
	/*
	 * A  example with 12 cities    
	 * 8280 nodes developed.
	 */
	
	public static enum Town {
		A,B,C,
		D,E,F,
		G,H,I,
		J,K,L
	};
				
	private static int[][] distance = 
	{	
		{   0,  -1,  -1, 374,  -1, 146,  -1,  -1, 140, 5, 22, 38},
		{  -1,   0, 160,  -1, 211,  -1, 101,  -1,  -1, 1,  2, 40},
		{  -1, 160,   0, 120,  -1,  -1, 138, 146,  -1, 3,  5,  7},
		{ 374,  -1, 120,   0,  -1,  -1,  -1,  -1,  -1, 2,  4,  8},
		{  -1, 211,  -1,  -1,   0,  -1,  -1,  -1,  99, 29,100, 1},
		{ 146,  -1,  -1,  -1,  -1,   0,  -1,  -1, 151,  1,  5, 7},
		{  -1, 101, 138,  -1,  -1,  -1,   0,  97,  -1,100, 2,  57},
		{  -1,  -1, 146,  -1,  -1,  -1,  97,   0,  80, 52, 74, 59},
		{ 140,  -1,  -1,  -1,  99, 151,  -1,  80,   0, 22, 11, 41},
		{   5,   1,  3,    2,  29,   1, 100,  52,  22,  0,  2, 10},
		{  22,  2,   5,    4, 100,   5,   2,  74,  11,  2,  0, 1},
		{  38, 40,   7,    8,   1,   7,  57,  59,  41, 10,  1, 0} 
	};

	// Use for parent Constructor
	static Set<String> set =
			EnumSet.allOf(Town.class)
						.stream()
						.map(t -> t.toString())
						.collect(Collectors.toSet()) ;
	
	//---------------------- Constructor ----------------------
	public Map2() {
		super(set);
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
