package src;

import java.util.ArrayList;
import java.util.LinkedList;

import simpleIO.TextReader;
import simpleIO.TextWriter;

public class DataHandler {
	TextReader reader;
	TextWriter writer;
		
	//load methods
	public ArrayList<Vehicle> loadVehicles() {
		reader = new TextReader("Vehicles");
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		String line = reader.readLine();
		while (line != null) {
			String[] data = line.split(";");
			String reg = data[0];
			String type = data[1];
			double charges = Double.parseDouble(data[2]);
			if (type.equals("commercial")) {
				Commercial commercial = new Commercial(reg, charges);
				vehicles.add(commercial);
			}
			else {  // else type is private car
				Private privateCar = new Private(reg, charges);
				vehicles.add(privateCar);
			}
			line = reader.readLine();
		}
		return vehicles;
	}
	
	/**
	 * Loads the text file into memory, and passes the resulting queue 
	 * back to the caller.
	 * @return
	 */
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
	public void writeVehicles(ArrayList<Vehicle> vehicles) {
		
	}
	
	public void writeSegmentData(LinkedList<String[]> sensorData) {
		
	}	
}

