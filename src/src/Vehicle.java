package src;
import java.util.ArrayList;


public class Vehicle { 
	// the vehicle's type
	private VehicleType type;
	// the charges this vehicle has accumulated
	private double charges;
	// the speeding tickets accumulated by this vehicle
	private ArrayList<Ticket> speedingTickets;
	
	public Vehicle(VehicleType type, double charges) {
		this.type = type;
		this.charges = 0.0;
		speedingTickets = new ArrayList<Ticket>();
	}

	public void addSpeedingTicket(Ticket ticket) {
		speedingTickets.add(ticket);
	}

	public ArrayList<Ticket> getSpeedingTickets() {
		return speedingTickets;
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
	
}
