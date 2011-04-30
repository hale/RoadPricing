package src;

public class DualCarriageways extends Road {

	public DualCarriageways(String name, int weight, int[] references) {
		super(name, weight, references);
		speedLimitPrivate = 60;
		speedLimitCommercial = 50;
	}

}
