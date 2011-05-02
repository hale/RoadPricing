package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DataProcessor {
	private DataHandler dh;
	private Network nw;
	private HashMap<String, Vehicle> vehicleData;
	private LinkedList<String[]> segmentData;
	private static DataProcessor dp;
	
	public DataProcessor() {
		dh = new DataHandler();
		nw = new Network();
	}
	
	public static void main(String args){
		dp = new DataProcessor();
		dp.loadData();	
		// process the data
		/*
		 * look at the first line of the segment data. 
		 * find the vehicle from the list of vehicles with the same reg plate
		 * update the vehicle with the new charges, and speeding ticket(s) if applicable
		 * read the next line.
		 * 
		 * repeat until there are no more lines.
		 */
		dp.processData();
		dp.writeData();
		
		
	}
	
	private void processData() {
		String[] line = dp.segmentData.peek();
		while (line != null) {
			// parse the string[]
			String reg = line[0];
			String road = line[1];
			String start = line[2];
			String finish = line[3];
			
			Vehicle vehicle = dp.vehicleData.get(reg);
			VehicleType type = vehicle.getType();
			Road r = (Road) dp.nw.getRoad(road);
			
			r.chargeJourney(type);
			/*
			 * Charge Journey detail:
			 * 
			 * chargeJourney() is responsible for updating the 'charges' field
			 * of the vehicle object with the new charges the vehicle has incurred.
			 * 
			 * Given: a road segment 
			 *        a vehicle
			 */
			
			// if neccessary, write speeding tickets
			
		}
	}
	
	private void loadData() {
		// load the data into memory
		dp.vehicleData = dp.dh.loadVehicles();
		dp.segmentData = dp.dh.loadSegmentData();
	}
	
	private void writeData() {
		dp.dh.writeVehicles(dp.vehicleData);
		dp.dh.writeSegmentData(dp.segmentData);
		// write the speeding tickets file
	}
	
}
