package src;

public class Motorway extends Road {
	
	public Motorway(int distance) {
		super(distance);
		speedLimitPrivate = 70;
		speedLimitCommercial = 60;
	}
	
	// methods to calculate charges
	
	@Override
	protected double chargePrivate() {
		double charge;
		/*
		 * RE: distance;
		 * 
		 * If less than or equal to 5 miles, return 0.0;
		 * if less than or equal to 15 miles, return 0.02 * (distance - 5);
		 * if more than 15 miles, return (0.01 * (distance - 15)) + 0.02 * (distance - 5);  
		 */
		if (distance <= 5) {
			charge = 0;
		}
		else if (distance <= 15) {
			charge = 0.02 * (distance - 5);
		}
		else {
			charge = 0.02 * (distance - 5);
			charge += 0.01 * (distance - 15);
		}
		return charge;
	}
	
	@Override
	protected double chargeCommercial() {
		double charge;
		/*
		 * RE: distance;
		 * 
		 * return 0.02 * distance;
		 */
		charge = 0.02 * distance;
		return charge;
	}	
}
