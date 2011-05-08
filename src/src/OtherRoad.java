package src;

public class OtherRoad extends Road {

	public OtherRoad(int distance) {
		super(distance);
		speedLimitPrivate = 50;
		speedLimitCommercial = 50;
	}
	
	@Override
	protected double chargePrivate() {
		double charge;
		/*
		 * return 0.0
		 * 
		 * (free)
		 */
		charge = 0;
		return charge;
	}
	
	@Override
	protected double chargeCommercial() {
		double charge;
		/*
		 * return 0.05 * distance
		 */
		charge = 0.05 * distance;
		return charge;		
	}
}
