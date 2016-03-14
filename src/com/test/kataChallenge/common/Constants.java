package com.test.kataChallenge.common;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Constants 
{
	public static final int totalDices=5;
	public static final int diceMinValue=1;
	public static final int diceMaxValue=6;
	public static final int yahtzeeScore=50;
	public static final int invalidInput=-1;
	public static final int validInput=100;

	public static final String onePair="This is one pair...!!!";
	public static final String twoPair="This is two pair...!!!";
	public static final String threeOfaKind="This is Three of a Kind...!!!";
	public static final String fourOfaKind="This is Four of a Kind...!!!";
	public static final String fullHouse="This is Full house...!!!";
	public static final String fours="This is one pair...!!!";
	public static final String yahtzee="This is Yahtzee...!!!";
	


	
	
	public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	static{
		Handler fileHandler;
		try {
			fileHandler = new FileHandler("./Log_Report.log");
			LOGGER.addHandler(fileHandler);
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);
			LOGGER.finer("Log started.");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
