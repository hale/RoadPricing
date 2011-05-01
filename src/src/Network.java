package src;

import java.util.Arrays;
import java.util.HashMap;

/**
 * This class is responsible for interacting with and creating a road network.
 * @author phil989
 *
 */
public class Network {
	private HashMap<String, Road> roads;
	
	public Network() {
		loadNetwork();
	}
	
	/*
	 * It is important that the string keys are in 
	 * alphabetical order.
	 */
	private void loadNetwork() {		
		roads.put("AB", new Motorway(24));
		roads.put("BC", new Motorway(17));
		roads.put("CE", new Motorway(23));
		
		roads.put("BF", new OtherRoad(20));
		roads.put("FG", new OtherRoad(29));
		roads.put("CG", new OtherRoad(17));
		roads.put("DE", new OtherRoad(15));
		
		roads.put("CD", new DualRoad(17));
		roads.put("GH", new DualRoad(24));
		roads.put("EH", new DualRoad(17));		
	}
	
	/*
	 * The string parameter is sorted so that getting
	 * "BA" or "AB" will return the same road.
	 * 
	 * @param road The string identifier of the road.
	 * @return The road for a given string identifier.
	 */
	public Road getRoad(String road) {
		char[] roadChar = road.toCharArray();
		Arrays.sort(roadChar);
		road = new String(roadChar);
		return roads.get(road);
	}

}
