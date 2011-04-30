package src;
/**
 * The Road class represents an edge in the network.
 * 
 * Every road object contains references to the 
 * locations of its end sensors within that 
 * sensor's respective incidence collection. 
 * 
 * A road connects to sensors.
 * 
 * 
 * @author Philip Hale
 *
 */
public abstract class Road {
	private String name;
	// the locations of the end nodes
	private int[] references = new int[2];;
	// the weight of the road. 
	private int weight;
	// the speed limit of the road for private vehicles
	protected int speedLimitPrivate;
	// the speed limit of the road for commercial vehicles
	protected int speedLimitCommercial;
	
	public Road(String name, int weight, int[] references){
		this.name = name;
		this.references[0] = references[0];
		this.references[1] = references[1];
		this.weight = weight;
	}

	public void setSpeedLimitCommercial(int speedLimitCommercial) {
		this.speedLimitCommercial = speedLimitCommercial;
	}

	public int getSpeedLimitCommercial() {
		return speedLimitCommercial;
	}

	public void setSpeedLimitPrivate(int speedLimitPrivate) {
		this.speedLimitPrivate = speedLimitPrivate;
	}

	public int getSpeedLimitPrivate() {
		return speedLimitPrivate;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}
}
