package src;

public class Motorway extends Road {
	
	public Motorway(int distance) {
		super(distance);
		speedLimitPrivate = 70;
		speedLimitCommercial = 60;
	}
	
	@Override
	protected double chargePrivate() {
		double charge = 0.0;
		/*
		 * RE: distance;
		 * 
		 * If less than or equal to 5 miles, return 0.0;
		 * if less than or equal to 15 miles, return 0.02 * (distance - 5);
		 * if more than 10 miles, return (0.01 * (distance - 15)) + 0.02 * (distance - 5);  
		 */
		return charge;
	}
	
	@Override
	protected double chargeCommercial() {
		double charge = 0.0;
		/*
		 * RE: distance;
		 * 
		 * return 0.02 * distance;
		 */
		return charge;
	}

}
