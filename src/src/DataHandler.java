package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import simpleIO.TextReader;
import simpleIO.TextWriter;

public class DataHandler {
	TextReader reader;
	TextWriter writer;
		
	//load methods
	public HashMap<String, Vehicle> loadVehicles() {
		reader = new TextReader("Vehicles");
		HashMap<String, Vehicle> vehicles = new HashMap<String, Vehicle>();
		String line = reader.readLine();
		while (line != null) {
			String[] data = line.split(";");
			String reg = data[0];
			String type = data[1];
			double charges = Double.parseDouble(data[2]);
			if (type.equals("commercial")) {
				Vehicle vehicle = new Vehicle(VehicleType.COMMERCIAL, charges);
				vehicles.put(reg, vehicle);
			}
			else {  // else type is private car
				Vehicle vehicle = new Vehicle(VehicleType.PRIVATE, charges);
				vehicles.put(reg, vehicle);
			}
			line = reader.readLine();
		}
		return vehicles;
	}
	
	public LinkedList<String[]> loadSegmentData() {
		reader = new TextReader("SegmentData");
		LinkedList<String[]> list = new LinkedList<String[]>();
		String line = reader.readLine();
		while (line != null) {
			list.offer(line.split(";"));			
			line = reader.readLine();
		}
		reader.close();
		return list;
	}
	
	// write methods
	public void writeVehicles(HashMap<String, Vehicle> vehicles) {
		
	}
	
	public void writeSegmentData(LinkedList<String[]> sensorData) {
		
	}	
}

