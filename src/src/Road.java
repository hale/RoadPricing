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

	public void setSpeedLimitCommercial(int speedLimitCommercial) {
		this.speedLimitCommercial = speedLimitCommercial;
	}

	public int getSpeedLimitCommercial() {
		return speedLimitCommercial;
	}

	public void setSpeedLimitPrivate(int speedLimitPrivate) {
		this.speedLimitPrivate = speedLimitPrivate;
	}

	public int getSpeedLimitPrivate() {
		return speedLimitPrivate;
	}

	public int getDistance() {
		return distance;
	}
}
