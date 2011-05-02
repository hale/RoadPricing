package src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
		writer = new TextWriter("Vehicles");
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Vehicle > entry : vehicles.entrySet()) {
			sb.append(entry.getKey()); // the reg
			sb.append(";");
			sb.append(entry.getValue().toString()); // the vehicle string representation
			//sb.append(System.getProperty("line.seperator")); // cross-platform \n
			writer.writeLine(sb.toString());
			sb = new StringBuilder();
		}
		writer.close();
		
	}
	
	public void writeSegmentData(LinkedList<String[]> sensorData) {
		writer = new TextWriter("SegmentData");
		String[] line = sensorData.pop();
		while (line != null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < line.length -1; i ++) {
				sb.append(line[i]);
				sb.append(";");
			}
			sb.deleteCharAt(sb.length()-1); // remove last semicolon
			writer.writeLine(sb.toString());
			line = sensorData.pop();
		}
		writer.close();
	}	
}

// hello i'm a lovely boy called phillip and i'm lovely