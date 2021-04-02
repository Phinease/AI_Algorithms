package problems.toBucharest;

public class Road {
	 
	// ------------ Attributes -------------------
	 private City c1;
	 private City c2;
	 private String roadId;
	 private float distance;

	 // ------------ Constructors -------------------
		public Road(City c1, City c2, String roadId, int distance) {
			super();
			this.c1 = c1;
			this.c2 = c2;
			this.roadId = roadId;
			this.distance = distance;
		}


	 // ------------ Getters/Setters -------------------
		
		public City getC1() {
			return c1;
		}

		public City getC2() {
			return c2;
		}

		public String getRoadId() {
			return roadId;
		}

		public float getDistance() {
			return distance;
		}
		
	 // ------------ Other methods -------------------
	
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((c1 == null) ? 0 : c1.hashCode());
			result = prime * result + ((c2 == null) ? 0 : c2.hashCode());
			result = prime * result + Float.floatToIntBits(distance);
			result = prime * result + ((roadId == null) ? 0 : roadId.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Road other = (Road) obj;
			if (c1 != other.c1)
				return false;
			if (c2 != other.c2)
				return false;
			if (Float.floatToIntBits(distance) != Float.floatToIntBits(other.distance))
				return false;
			if (roadId == null) {
				if (other.roadId != null)
					return false;
			} else if (!roadId.equals(other.roadId))
				return false;
			return true;
		}


	
}

    
   

