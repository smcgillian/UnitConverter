package main;


// Due to the integral nature of the literals in the conversion equations 
// they have not been separated out to a constant section.

public class UnitConverter {

	// Keeping with good coding practice utility functions defined as static, access no members.
	static public double fahrenheitToCelsius(double fahrenheit) {
		return ( (fahrenheit - 32) / 9) * 5;
	}
	
	static public double inchesToCentermetres(double inches) {
		return inches * 2.54;
	}
	
	static public double poundsToKilos(double pounds) {
		return pounds / 2.2046226218;
	}
	
	static public double fluidOuncesToMililiters(double floz) {
		return floz / 0.033814;
	}
}
