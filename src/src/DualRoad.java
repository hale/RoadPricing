package src;

public class DualRoad extends Road {

	public DualRoad(int distance) {
		super(distance);
		speedLimitPrivate = 60;
		speedLimitCommercial = 50;
	}
	
	@Override
	protected double chargePrivate() {
		double charge;
		/*
		 * return 0.01 * distance;
		 */
		charge = 0.01 * distance;
		return charge;
	}
	
	@Override
	protected double chargeCommercial() {
		double charge;
		/*
		 * if less than or equal to 10 miles: return 0.03 * distance;
		 * if more than 10 miles: return (0.02 * (distance - 10)) + 10*0.03;
		 */
		if (distance <= 10) {
			charge = 0.03 * distance; // 3p per mile for the first 10 miles.
		}
		else { // (distance > 10)
			charge = 10 * 0.03; //first 10 miles cost 3p
			charge += 0.02 * (distance - 10); // 2p thereafter
		}
		return charge;		
	}

}
