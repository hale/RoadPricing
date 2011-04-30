package src;

import java.util.LinkedList;

public class DataProcessor {
	DataHandler dh;
	LinkedList<String[]> vehicleData;
	LinkedList<String[]> sensorData;
	public DataProcessor() {
		dh = new DataHandler();
	}
	
	public static void main(String args){
		// load the data into memory
		DataProcessor dp = new DataProcessor();
		dp.vehicleData = dp.dh.loadVehicles();
		dp.sensorData = dp.dh.loadSegmentData();
		
		//process the data
		/*
		 * Basically, update the vehicles data with the information contained within sensorData.
		 * 
		 * We need to: 
		 * 
		 * So look at an entry in sensor data.  
		 * 
		 * look at the road type between the source and the destination.
		 * 
		 */
		  
		//write it to a file
		dp.dh.writeVehicles(dp.vehicleData);
		dp.dh.writeSegmentData(dp.sensorData);
		
	}

}
