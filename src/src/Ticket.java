package src;
/**
 * Represents a speeding ticket
 * @author phil989
 *
 */
public class Ticket {
	// identifies the vehicle that has received the fine
	private String reg;
	// the average speed of the vehicle between the two checkpoints
	private double averageSpeed;
	// the speed limit at this section
	private double speedLimit;
	// the road segment involved
	private String road;
	// the type of road
	private String roadType;
	
	public Ticket(String reg, double averageSpeed, double speedLimit,
			String road, String roadType) {
		this.reg = reg;
		this.averageSpeed = averageSpeed;
		this.speedLimit = speedLimit;
		this.road = road;
		this.roadType = roadType;
	}

	public String getReg() {
		return reg;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public double getSpeedLimit() {
		return speedLimit;
	}

	public String getRoad() {
		return road;
	}

	public String getRoadType() {
		return roadType;
	}
	

}
