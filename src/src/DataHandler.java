package src;

import java.util.LinkedList;

import simpleIO.TextReader;
import simpleIO.TextWriter;

public class DataHandler {
	TextReader reader;
	TextWriter writer;

	public LinkedList<String[]> loadVehicles() {
		return loadData("Vehicles");
	}
	
	public LinkedList<String[]> loadSegmentData() {
		return loadData("SegmentData");
	}
	
	public void writeVehicles(LinkedList<String[]> vehicles) {
		writeData(vehicles, "Vehicles");
	}
	
	public void writeSegmentData(LinkedList<String[]> sensors) {
		writeData(sensors, "SegmentData");
	}
	
	private void writeData(LinkedList<String[]> data, String filename) {
		writer = new TextWriter(filename);
		String[] datum = data.poll();
		while (datum != null) {
			String line = null;
			for (int i = 0; i < datum.length; i++) {
				line += datum[i];
			}
			writer.writeLine(line);
			datum = data.poll();
		}
		writer.close();
	}
		
	private LinkedList<String[]> loadData(String filename) {
		reader = new TextReader(filename);
		LinkedList<String[]> list = new LinkedList<String[]>();
		String line = reader.readLine();
		while (line != null) {
			list.offer(line.split(";"));			
			line = reader.readLine();
		}
		reader.close();
		return list;
	}
	
	
}

