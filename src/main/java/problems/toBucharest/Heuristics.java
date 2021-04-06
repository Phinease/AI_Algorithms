package problems.toBucharest;

import iialib.stateSpace.model.IHeuristic;


// Constants ----------------------------------------------------------
public class Heuristics {
	
	public static double flightDistanceToBucharest(City s)  {
		return switch (s) {
			case Arad -> 366;
			case Brasov -> 254;
			case Bucharest -> 0;
			case Craiova -> 160;
			case Dobreta -> 242;
			case Eforie -> 161;
			case Fagaras -> 176;
			case Giurgiu -> 77;
			case Harsova -> 151;
			case Iasi -> 226;
			case Lugoj -> 244;
			case Mehadia -> 241;
			case Neamt -> 234;
			case Oradea -> 380;
			case Pitesti -> 100;
			case RamnicuValcea -> 193;
			case Sibiu -> 253;
			case Timisoara -> 329;
			case Urziceni -> 80;
			case Vaslui -> 199;
			case Zerind -> 374;
		};
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
