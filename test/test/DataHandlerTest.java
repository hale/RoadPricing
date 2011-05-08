package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.DataHandler;

public class DataHandlerTest {
	private DataHandler dh = new DataHandler();;
	
	@Test
	public void testHoursToMins() {
		String input = "12:31";
		String expected = "751";
		String actual = dh.hoursToMins(input);
		assertEquals(expected, actual);
	
		input = "04:10";
		expected = "250";
		actual = dh.hoursToMins(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinsStandard() {
		String input = "925";
		String expected = "15:25";
		String actual = dh.minsToHours(input);
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void testMinsSmall() {
		String input = "5";
		String expected = "00:05";
		String actual = dh.minsToHours(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinsMedium() {
		String input = "50";
		String expected = "00:50";
		String actual = dh.minsToHours(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinsNormal() {
		String input = "300";
		String expected = "05:00";
		String actual = dh.minsToHours(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinsMax() {
		String input = "1440";
		String expected = "00:00";
		String actual = dh.minsToHours(input);
		assertEquals(expected, actual);
	}
}
