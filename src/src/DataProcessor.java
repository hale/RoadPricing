package src;

import java.util.HashMap;
import java.util.LinkedList;

public class DataProcessor {
	private DataHandler dh;
	private Network nw;
	private HashMap<String, Vehicle> vehicleData;
	private LinkedList<String[]> segmentData;
	private LinkedList<String> speedingTickets;
	private static DataProcessor dp;
	
	public DataProcessor() {
		dh = new DataHandler();
		nw = new Network();
		vehicleData = new HashMap<String, Vehicle>();
		segmentData = new LinkedList<String[]>();
		speedingTickets = new LinkedList<String>();
	}
	
	public static void main(String args[]){
		//System.out.println("1) Before the data processor is instantiated");
		dp = new DataProcessor();
		//System.out.println("2) before the data is loaded");
		dp.loadData();	
		//System.out.println("3) before the data is processed");
		dp.processData();
		//System.out.println("4) before the data is written");
		dp.writeData();
		//System.out.println("5) the last thing that should happen");
	}
	
	private void loadData() {
		// load the data into memory
		dp.vehicleData = dp.dh.loadVehicles();
		dp.segmentData = dp.dh.loadSegmentData();
		dp.speedingTickets = dp.dh.loadSpeedingTickets();
	}
	
	private void processData() {
		for (String[] line : dp.segmentData) {
			// parse the string[]
			String reg = line[0];
			String road = line[1];
			int start = Integer.parseInt(line[2]);
			int finish = Integer.parseInt(line[3]);
			
			
			// load to memory
			Vehicle vehicle = dp.vehicleData.get(reg);
			VehicleType type = vehicle.getType();
			Road r = (Road) dp.nw.getRoad(road);
			
			// update charges
			double charge = r.chargeJourney(type);
			vehicle.addCharge(charge);
			dp.vehicleData.put(reg, vehicle);	
			
			// speeding tickets
			int duration = finish - start;
			double averageSpeed = r.averageSpeed(duration);
			String roadType;
			if (r instanceof Motorway) {
				roadType = "Motorway";
			} else if (r instanceof DualRoad) {
				roadType = "Dual Carriageway";
			} else {
				roadType = "Other Road";
			}
			if (r.checkSpeed(type, averageSpeed)) {
				String ticket = reg + ";" + averageSpeed + ";" + roadType + ";" + r.getSpeedLimit(type) + ";" + road + ";" + start + ";" + finish;
				speedingTickets.add(ticket);
			}
		}		
	}
	
	private void writeData() {
		dp.dh.writeVehicles(dp.vehicleData);
		dp.dh.writeSegmentData(dp.segmentData);
		dp.dh.writeSpeedingTickets(dp.speedingTickets);
	}
	
}
