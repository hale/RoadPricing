package src;

public class Vehicle { 
	// the vehicle's type
	private VehicleType type;
	// the charges this vehicle has accumulated
	private double charges;
	
	public Vehicle(VehicleType type, double charges) {
		this.type = type;
		this.charges = charges;
	}
	
	public double getCharges() {
		return charges;
	}
	
	/*
	 * Adds a charge based on how far and what type of road
	 */
	public void addCharge(double charge) {
		charges += charge;
	}
	
	public int getSpeedLimit(Road r) {
		return 0;
	}

	public VehicleType getType() {
		return type;
	}
	
	private String formatCharges() {
		String s = String.valueOf(charges);
		if (s.length() > 5) {
			s = s.substring(0, 5);
		}
		return s;
	}
	
	@Override
	public String toString() {
		return type + ";" + formatCharges();
	}
	
}
