package src;

public class DualRoad extends Road {

	public DualRoad(int distance) {
		super(distance);
		speedLimitPrivate = 60;
		speedLimitCommercial = 50;
	}
	
	@Override
	protected double chargePrivate() {
		double charge = 0.0;
		/*
		 * return 0.01 * distance;
		 */
		return charge;
	}
	
	@Override
	protected double chargeCommercial() {
		double charge = 0.0;
		/*
		 * if less than or equal to 10 miles: return 0.03 * distance;
		 * if more than 10 miles: return (0.02 * (distance - 10)) + 10*0.03;
		 */
		return charge;		
	}

}
