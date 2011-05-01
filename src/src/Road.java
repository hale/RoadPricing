package src;

public abstract class Road { 
	private int distance;
	// the speed limit of the road for private vehicles
	protected int speedLimitPrivate;
	// the speed limit of the road for commercial vehicles
	protected int speedLimitCommercial;
	
	public Road(int distance){
		this.distance = distance;
	}

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
