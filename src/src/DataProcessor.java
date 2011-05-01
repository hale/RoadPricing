package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DataProcessor {
	DataHandler dh;
	HashMap<String, Vehicle> vehicleData;
	LinkedList<String[]> segmentData;
	public DataProcessor() {
		dh = new DataHandler();
	}
	
	public static void main(String args){
		// load the data into memory
		DataProcessor dp = new DataProcessor();
		dp.vehicleData = dp.dh.loadVehicles();
		dp.segmentData = dp.dh.loadSegmentData();
		
		// process the data
		/*
		 * look at the first line of the segment data. 
		 * find the vehicle from the list of vehicles with the same reg plate
		 * update the vehicle with the new charges, and speeding ticket(s) if applicable
		 * read the next line.
		 * 
		 * repeat until there are no more lines.
		 */
		
		String[] line = dp.segmentData.peek();
		while (line != null) {
			// parse the string[]
			String reg = line[0];
			String road = line[1];
			String start = line[2];
			String finish = line[3];
			
			Vehicle vehicle = dp.vehicleData.get(reg);
			
		}
		  
		//write it to a file
		dp.dh.writeVehicles(dp.vehicleData);
		dp.dh.writeSegmentData(dp.segmentData);
		//write the speeding tickets
		
	}

}
