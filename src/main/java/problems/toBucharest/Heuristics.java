package problems.toBucharest;

import iialib.stateSpace.model.IHeuristic;


// Constants ----------------------------------------------------------
public class Heuristics {
	
	public static double flightDistanceToBucharest(City s)  {		
			switch(s) {
				case Arad 			: return 366;
				case Brasov 		: return 254;
				case Bucharest 		: return 0;
				case Craiova 		: return 160;
				case Dobreta 		: return 242;
				case Eforie 		: return 161;
				case Fagaras 		: return 176;
				case Giurgiu		: return 77;
				case Harsova		: return 151;
				case Iasi			: return 226;
				case Lugoj			: return 244;
				case Mehadia		: return 241;
				case Neamt			: return 234;
				case Oradea			: return 380;
				case Pitesti		: return 100;
				case RamnicuValcea 	: return 193;
				case Sibiu			: return 253;
				case Timisoara 		: return 329;
				case Urziceni		: return 80;
				case Vaslui			: return 199;
				default /* Zerind */: return 374; 
			}
						
	}
	
	public static IHeuristic<City> h = new IHeuristic<>(){
		@Override
		public double apply(City c) {
			return  flightDistanceToBucharest(c); 		
		}
		@Override
		public String toString() {
			return  "flight Distance To Bucharest"; 		
		}
	};
	
}
