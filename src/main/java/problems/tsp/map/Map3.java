package problems.tsp.map;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Map3 extends AMap {
	
	/*
	 * A hard  example with 14 cities    
	 * 191596 nodes developed.
	 */
	
	//---------------------- Static attributes ----------------------
	public static enum Town {
		A,B,C,
		D,E,F,
		G,H,I,
		J,K,L,
		M,N
	};
		
	// Road distances between cities (according to the towns order in the enum)
	// -1 means that there is no road directly connecting the towns
	private static final int[][] distance =
		{
			{   0,  -1,  -1, 374,  -1, 146,  -1,  -1, 140, 5, 22, 38,  2, 70},
			{  -1,   0, 160,  -1, 211,  -1, 101,  -1,  -1, 1,  2, 40, 25, 33},
			{  -1, 160,   0, 120,  -1,  -1, 138, 146,  -1, 3,  5,  7,  9, 15},
			{ 374,  -1, 120,   0,  -1,  -1,  -1,  -1,  -1, 2,  4,  8, 16, 35},
			{  -1, 211,  -1,  -1,   0,  -1,  -1,  -1,  99, 29,100, 1, 24, 10},
			{ 146,  -1,  -1,  -1,  -1,   0,  -1,  -1, 151,  1,  5, 7,  9, 104},
			{  -1, 101, 138,  -1,  -1,  -1,   0,  97,  -1,100, 2,  57, 21, 3},
			{  -1,  -1, 146,  -1,  -1,  -1,  97,   0,  80, 52, 74, 59, 35, 1},
			{ 140,  -1,  -1,  -1,  99, 151,  -1,  80,   0, 22, 11, 41,  5, 6},
			{   5,   1,  3,    2,  29,   1, 100,  52,  22,  0,  2, 10, 20, 7},
			{  22,  2,   5,    4, 100,   5,   2,  74,  11,  2,  0, 1,   7, 8},
			{  38, 40,   7,    8,   1,   7,  57,  59,  41, 10,  1, 0,  36, 244},
			{   2, 25,   9,   16,  24,   9,  21,  35,   5, 20,  7, 36,  0, 100},
			{  70, 33,  15,   35,  10, 104,   3,   1,   6,  7,  8, 244, 100, 0}
		};	
	
	static Set<String> set =
			EnumSet.allOf(Town.class)
						.stream()
						.map(Enum::toString)
						.collect(Collectors.toSet()) ;

	
	//---------------------- Constructor ----------------------
	public Map3() {
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
