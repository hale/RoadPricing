package src;
import java.util.ArrayList;


public abstract class Vehicle {
	// the vehicles registration number
	private String reg;
	// the charges this vehicle has accumulated
	private double charges;
	// the speeding tickets accumulated by this vehicle
	private ArrayList<Ticket> speedingTickets;
	
	public Vehicle(String reg, double charges) {
		this.reg = reg;
		this.charges = 0.0;
		speedingTickets = new ArrayList<Ticket>();
	}

	public void addSpeedingTicket(Ticket ticket) {
		speedingTickets.add(ticket);
	}

	public ArrayList<Ticket> getSpeedingTickets() {
		return speedingTickets;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public double getCharges() {
		return charges;
	}
	
	public void addCharge(double charge) {
		charges += charge;
	}

	public String getReg() {
		return reg;
	}
	
	public int getSpeedLimit(Road r) {
		return 0;
	}
	
}
