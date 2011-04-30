package src;

public class AllOtherRoads extends Road {

	public AllOtherRoads(String name, int weight, int[] references) {
		super(name, weight, references);
		speedLimitPrivate = 50;
		speedLimitCommercial = 50;
	}

}
