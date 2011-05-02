package src;

public abstract class Road { 
	// the distance of this road in miles;
	protected int distance;
	// the speed limit of the road for private vehicles
	protected int speedLimitPrivate;
	// the speed limit of the road for commercial vehicles
	protected int speedLimitCommercial;
	
	public Road(int distance){
		this.distance = distance;
	}
	
	/*
	 * @return the charge in pounds for this road segment.
	 */
	public double chargeJourney(VehicleType type) {
		if (type == VehicleType.COMMERCIAL) {
			return chargeCommercial();
		}
		else { // (type == VehicleType.PRIVATE)
			return chargePrivate();
		}
	}
	
	abstract double chargeCommercial();
	
	abstract double chargePrivate();

	public int getSpeedLimitCommercial() {
		return speedLimitCommercial;
	}

	public int getSpeedLimitPrivate() {
		return speedLimitPrivate;
	}

	public int getDistance() {
		return distance;
	}
}
