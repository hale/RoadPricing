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
	
	public boolean checkSpeed(VehicleType type, double averageSpeed) {
		if (type == VehicleType.COMMERCIAL) {
			return checkSpeedCommercial(averageSpeed);
		}
		else { // (type == VehicleType.Private)
			return checkSpeedPrivate(averageSpeed);
		}
	}
	
	private boolean checkSpeedCommercial(double averageSpeed) {
		int averageInt = new Double((Math.floor(averageSpeed))).intValue();
		if (averageInt > speedLimitCommercial) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkSpeedPrivate(double averageSpeed) {
		int averageInt = new Double((Math.floor(averageSpeed))).intValue();
		if (averageInt > speedLimitPrivate) {
			return true;
		} else {
			return false;
		}
	}
	
	public double averageSpeed(int duration) {
		double durationHours = (double) duration / 60;
		double average = distance / durationHours;
		return average;
	}
	
	public int getSpeedLimit(VehicleType type) {
		if (type == VehicleType.COMMERCIAL) {
			return getSpeedLimitCommercial();
		} else {
			return getSpeedLimitPrivate();
		}
	}

	private int getSpeedLimitCommercial() {
		return speedLimitCommercial;
	}

	private int getSpeedLimitPrivate() {
		return speedLimitPrivate;
	}

	public int getDistance() {
		return distance;
	}
}
