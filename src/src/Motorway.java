package src;

public class Motorway extends Road {
	
	public Motorway(String name, int weight, int[] references) {
		super(name, weight, references);
		speedLimitPrivate = 70;
		speedLimitCommercial = 60;
	}

}
