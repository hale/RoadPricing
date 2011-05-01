package src;

public class Motorway extends Road {
	
	public Motorway(int distance) {
		super(distance);
		speedLimitPrivate = 70;
		speedLimitCommercial = 60;
	}

}
