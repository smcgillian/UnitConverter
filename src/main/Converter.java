package main;

import java.util.Scanner;

public class Converter {
	
// Define final statics

	private static class menuSelections {
		static final int SEL_FTOC = 1;
		static final int SEL_ITOC = 2;
		static final int SEL_PTOK = 3;
		static final int SEL_FLTOML = 4;
		static final int SEL_QUIT = 5;
	}
	
// Strings
	// Menu
	private static final String menuText = "Please select an option:\n"
			+ "1. Fahrenheit to Celsius\n"
			+ "2. Inches to Centermetres\n"
			+ "3. Pounds to Kilos\n"
			+ "4. US Fluid Ounces to Mililiters\n"
			+ "5. Quit";	
	
	//input and output messages for conversion 
	private static final String MSG_GET_FTOC = "Input a value in Fahrenheit:";
	private static final String MSG_GET_ITOC = "Input a value in inches:";
	private static final String MSG_GET_PTOK = "Input a value in pounds:";
	private static final String MSG_GET_FLTOML = "Input a value in US fluid ounces:";

	private static final String MSG_RES_FTOC = "%f F is %f in C\n\n";
	private static final String MSG_RES_ITOC = "%f inches is %f in cm\n\n";
	private static final String MSG_RES_PTOK = "%f pounds is %f in kilos\n\n";
	private static final String MSG_RES_FLTOML = "%f US fluid ounces is %f in ml\n\n";
	
	private static final String MSG_PROGRAM_ENDED = "Program ended.";

//Properties
	private static Scanner scanner;

// Methods
	public static void main(String[] args) {
		Converter.run();
	}
	
	private static void run() {
		int menuSelection;
		Converter.scanner = new Scanner(System.in);
		
		while (true) {
			Converter.printMenu();
			menuSelection = Converter.getUserSelection();
			if (Converter.ifQuitSelection(menuSelection)) {
				break;
			}
			Converter.processSelection(menuSelection);
		}
		scanner.close();
		System.out.print(MSG_PROGRAM_ENDED);
	}
	
	private static void printMenu() {
		System.out.println(Converter.menuText);
	}
	
	private static int getUserSelection() {
		return Integer.parseInt(scanner.nextLine());
	}
	
	private static void processSelection(int selection) {
		printGetInputUnitMessage(selection);	
		printConverstionResult(selection, getUnitInput());
	}
	
	private static void printGetInputUnitMessage(int selection) {
		switch (selection) {
		case Converter.menuSelections.SEL_FTOC :
			System.out.println(MSG_GET_FTOC);
			break;
		case Converter.menuSelections.SEL_ITOC :
			System.out.println(MSG_GET_ITOC);
			break;
		case Converter.menuSelections.SEL_PTOK :
			System.out.println(MSG_GET_PTOK);
			break;
		case Converter.menuSelections.SEL_FLTOML :
			System.out.println(MSG_GET_FLTOML);
			break;
		}	
	}	
	
	private static void printConverstionResult(int selection, double input) {	
		switch (selection) {
		case Converter.menuSelections.SEL_FTOC :
			System.out.printf(MSG_RES_FTOC, input, UnitConverter.fahrenheitToCelsius(input));
			break;
		case Converter.menuSelections.SEL_ITOC :
			System.out.printf(MSG_RES_ITOC, input, UnitConverter.inchesToCentermetres(input));
			break;
		case Converter.menuSelections.SEL_PTOK :
			System.out.printf(MSG_RES_PTOK, input, UnitConverter.poundsToKilos(input));
			break;
		case Converter.menuSelections.SEL_FLTOML :
			System.out.printf(MSG_RES_FLTOML, input, UnitConverter.fluidOuncesToMililiters(input));
			break;
		}	
	}
	
	private static double getUnitInput() {
		return Double.parseDouble(scanner.nextLine());
	}
	
	private static boolean ifQuitSelection(int selection) {
		return (selection == Converter.menuSelections.SEL_QUIT);
	}
	
}
