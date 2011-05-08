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
	
	public LinkedList<String> loadSpeedingTickets() {
		System.out.println("    Speeding Tickets file prior to processing");
		reader = new TextReader("SpeedingTickets");
		LinkedList<String> list = new LinkedList<String>();
		String line = reader.readLine();
		while (line != null) {
			String[] lineSplit = line.split(";");
			lineSplit[6] = hoursToMins(lineSplit[6]);
			lineSplit[5] = hoursToMins(lineSplit[5]);
			line = lineSplit[0] + ";" + lineSplit[1] + ";" + lineSplit[2] + ";" + lineSplit[3] + ";" + lineSplit[4] + ";" + lineSplit[5] + ";" + lineSplit[6];
			list.add(line);
			System.out.println("\t" + line);
			line = reader.readLine();
		}
		reader.close();
		return list;
	}
	
	public HashMap<String, Vehicle> loadVehicles() {
		System.out.println("   Vehicles file prior to processing");
		reader = new TextReader("Vehicles");
		HashMap<String, Vehicle> vehicles = new HashMap<String, Vehicle>();
		String line = reader.readLine();
		while (line != null) {
			System.out.println("\t" + line);
			String[] data = line.split(";");
			String reg = data[0];
			String type = data[1];
			double charges = Double.parseDouble(data[2]);
			if (type.equals("COMMERCIAL")) {
				Vehicle vehicle = new Vehicle(VehicleType.COMMERCIAL, charges);
				vehicles.put(reg, vehicle);
			}
			else {  // else type is private car
				Vehicle vehicle = new Vehicle(VehicleType.PRIVATE, charges);
				vehicles.put(reg, vehicle);
			}
			line = reader.readLine();
		}
		reader.close();
		return vehicles;
	}
	
	public LinkedList<String[]> loadSegmentData() {
		System.out.println("   SegmentData file prior to processing");
		reader = new TextReader("SegmentData");
		LinkedList<String[]> list = new LinkedList<String[]>();
		String line = reader.readLine();
		while (line != null) {
			System.out.println("\t" + line);
			String[] lineSplit = line.split(";");
			lineSplit[2] = hoursToMins(lineSplit[2]);
			lineSplit[3] = hoursToMins(lineSplit[3]);
			list.add(lineSplit);			
			line = reader.readLine();
		}
		reader.close();
		return list;
	}
	
	/**
	 * The SegmentData file contains string representations of 
	 * times, such as "12:36" or "04:10".  The DataHandler class
	 * converts this into minutes past midnight.  Thus, "12:36"
	 * becomes "756" and "04:10" becomes "250".
	 * 
	 * @param hours
	 * @return the time in minutes.
	 */
	public String hoursToMins(String hours) {
		String[] hoursArray = hours.split(":");
		int[] hoursArrayInt = {Integer.parseInt(hoursArray[0]), Integer.parseInt(hoursArray[1])}; // [(H)H, MM]
		int mins = hoursArrayInt[1] + (60 * hoursArrayInt[0]); // MMM
		return new Integer(mins).toString();
	} 
	
	public String minsToHours(String minutes) {
		int minutesInt = Integer.parseInt(minutes);
		String hours = String.valueOf(minutesInt / 60);
		String mins = String.valueOf(minutesInt % 60);
				
		if (String.valueOf(hours).length() == 1) 
			hours =  "0" + hours;
		
		if (String.valueOf(mins).length() == 1) 
			mins = "0" + mins;
		
		if (hours.equals("24")) 
			hours = "00";
			
		return hours + ":" + mins;
		
	}
	
	// write methods
	public void writeVehicles(HashMap<String, Vehicle> vehicles) {
		System.out.println("   Vehicle file after processing");
		writer = new TextWriter("Vehicles");
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Vehicle > entry : vehicles.entrySet()) {
			sb.append(entry.getKey()); // the reg
			sb.append(";");
			sb.append(entry.getValue().toString()); // the vehicle string representation
			writer.writeLine(sb.toString());
			System.out.println("\t" + sb);
			sb = new StringBuilder();
		}
		writer.close();		
	}
	
	public void writeSegmentData(LinkedList<String[]> sensorData) {
		System.out.println("   SegmentData after processing");
		writer = new TextWriter("SegmentData");
		for (String[] line : sensorData) {
			line[2] = minsToHours(line[2]);
			line[3] = minsToHours(line[3]);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < line.length; i ++) {
				sb.append(line[i]);
				sb.append(";");
			}
			sb.deleteCharAt(sb.length()-1); // remove last semicolon
			writer.writeLine(sb.toString());
			System.out.println("\t" + sb);
		}
		writer.close();
	}	
	
	public void writeSpeedingTickets(LinkedList<String> list) {
		System.out.println("    SpeedingTickets after processing");
		writer = new TextWriter("SpeedingTickets");
		for (String str : list) {
			// 7
			String[] strSplit = str.split(";");
			strSplit[5] = minsToHours(strSplit[5]);
			strSplit[6] = minsToHours(strSplit[6]);
			String string = strSplit[0] + ";" + strSplit[1] + ";" + strSplit[2] + ";" + strSplit[3] + ";" + strSplit[4] + ";" + strSplit[5] + ";" + strSplit[6];
			writer.writeLine(string);
			System.out.println("\t" + string);
		}
		writer.close();
	}
}

