package com.qa.main.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
	private static Logger LOGGER = LogManager.getLogger();

	private final Scanner scanner;

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() {
		
		Long longInput = null;
		do {
			String input = getString();
			try {
				longInput = Long.parseLong(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (longInput == null);
		return longInput;
	}

	public String getString() {
		return scanner.nextLine();
	}

	public Double getDouble() {
		
		Double doubleInput = null;
		do {
			String input = getString();
			try {
				doubleInput = Double.parseDouble(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (doubleInput == null);
		return doubleInput;
	}
	
	public Date getDate() {
		
		String sDate1 = "1996-04-04";
		Date dateInput = null;
		do{
			String input = getString();
			try {
		
			dateInput = (Date) new SimpleDateFormat("YYYY-MM-DD").parse(input);
		} catch (ParseException e) {
			LOGGER.info("Error - Please enter the date in the correct format");
			e.printStackTrace();
		}
		}while (dateInput == null);
		return dateInput;
		
		
	}


	
	/*
	 * public int getInt() { String input = getString(); int intInput = 0; do { try
	 * { intInput = String.parseInt(input); } catch (NumberFormatException nfe) {
	 * LOGGER.info("Error - Please enter a number"); } } while (intInput == 0);
	 * return intInput; }
	 */
}
