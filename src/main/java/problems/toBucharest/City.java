package problems.toBucharest;

import iialib.stateSpace.model.ApplicableOpsIterator;
import iialib.stateSpace.model.IState;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public enum City implements IState<OpRoad> {

	/* ---- Some cities of Romania ----- */
	Arad("Arad"), 
	Brasov("Brasov"), 
	Bucharest("Bucharest"), 
	Craiova("Craiova"), 
	Dobreta("Dobreta"), 
	Eforie("Eforie"),
	Fagaras("Fagaras"), 
	Giurgiu("Giurgiu"), 
	Harsova("Harsova"), 
	Iasi("Iasi"), 
	Lugoj("Lugoj"), 
	Mehadia("Mehadia"),
	Neamt("Neamt"), 
	Oradea("Oradea"), 
	Pitesti("Pitesti"), 
	RamnicuValcea("Râmnicu Vâlcea"), 
	Sibiu("Sibiu"),
	Timisoara("Timisoara"), 
	Urziceni("Urziceni"), 
	Vaslui("Vaslui"), 
	Zerind("Zerind");

	// ---------- Attributes ------------
	/**
	 * the node label
	 */
	private String name;

	// ---------- Constructors ------------

	City(String l) {
		this.name = l;
	}

	// ---------- Methods from IState ------------

	@Override
	public Iterator<OpRoad> applicableOperators() {
		return new ApplicableOpsIterator<City, OpRoad>(OpRoad.ALL_OPS, this);
	}

	@Override
	public String toString() {
		return this.name;
	}

	// ------------ initialization of the set of Operators form a set of
	// roads-------------------

	public static void initializeOperators(Set<Road> s) {
		OpRoad.ALL_OPS.clear();
		for (Road r : s) {
			City c1 = r.getC1();
			City c2 = r.getC2();
			String id = r.getRoadId();
			float dist = r.getDistance();
			// Since Roads are bi-directional - two operators are created for each direction
			OpRoad.ALL_OPS.add(new OpRoad(c1, c2, id, dist));
			OpRoad.ALL_OPS.add(new OpRoad(c2, c1, id + "R", dist));
		}
	}

	// Constants ----------------------------------------------------------
	/* A set of known roads of Romania */
	public static Set<Road> romaniaRoads = new HashSet<Road>() {{
			// Reminder : Roads are non oriented
			add(new Road(Arad, Brasov, "DN7", 130));
			add(new Road(Arad, Sibiu, "DN79", 140));
			add(new Road(Arad, Timisoara, "A1", 118));
			add(new Road(Arad, Zerind, "DN79", 75));
			//
			add(new Road(Brasov, RamnicuValcea, "DN73", 200));
			//
			add(new Road(Bucharest, Fagaras, "DN1", 211));
			add(new Road(Bucharest, Giurgiu, "DN5", 90));
			add(new Road(Bucharest, Pitesti, "A1", 101));
			add(new Road(Bucharest, Urziceni, "DN2", 85));
			//
			add(new Road(Craiova, Dobreta, "DN6", 120));
			add(new Road(Craiova, Pitesti, "DN65", 138));
			add(new Road(Craiova, RamnicuValcea, "DN65", 146));
			//
			add(new Road(Dobreta, Mehadia, "DN6", 75));
			//
			add(new Road(Eforie, Harsova, "DN2", 86));
			//
			add(new Road(Fagaras, Sibiu, "DN1", 99));
			//
			add(new Road(Harsova, Urziceni, "DN2A", 98));
			//
			add(new Road(Iasi, Neamt, "DN28", 87));
			add(new Road(Iasi, Vaslui, "DN24", 92));
			//
			add(new Road(Lugoj, Timisoara, "DJ592", 111));
			add(new Road(Lugoj, Mehadia, "DN6", 70));
			//
			add(new Road(Oradea, Sibiu, "DN76", 151));
			add(new Road(Oradea, Zerind, "DN79", 71));
			//
			add(new Road(Pitesti, RamnicuValcea, "DN7", 97));
			//
			add(new Road(RamnicuValcea, Sibiu, "DN7", 80));
			//
			add(new Road(Urziceni, Vaslui, "DN2", 42));
		}
		
		private static final long serialVersionUID = 1L;

	};

}
