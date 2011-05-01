package src;

public class DualRoad extends Road {

	public DualRoad(int distance) {
		super(distance);
		speedLimitPrivate = 60;
		speedLimitCommercial = 50;
	}

}
