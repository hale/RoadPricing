package src;

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
		vehicleData = new HashMap<String, Vehicle>();
		segmentData = new LinkedList<String[]>();
	}
	
	public static void main(String args[]){
		System.out.println("1) Before the data processor is instantiated");
		dp = new DataProcessor();
		System.out.println("2) before the data is loaded");
		dp.loadData();	
		System.out.println("3) before the data is processed");
		dp.processData();
		System.out.println("4) before the data is written");
		dp.writeData();
		System.out.println("5) the last thing that should happen");
	}
	
	private void processData() {
		for (String[] line : dp.segmentData) {
			// parse the string[]
			String reg = line[0];
			String road = line[1];
			String start = line[2];
			String finish = line[3];
			
			Vehicle vehicle = dp.vehicleData.get(reg);
			VehicleType type = vehicle.getType();
			Road r = (Road) dp.nw.getRoad(road);
			
			double charge = r.chargeJourney(type);
			vehicle.addCharge(charge);
			dp.vehicleData.put(reg, vehicle);
			System.out.println(dp.segmentData.size());
			/* chargeJourney() is responsible for updating the 'charges' field
			 * of the vehicle object with the new charges the vehicle has incurred.
			 */
			
			
			// Speeding Tickets	
		
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
