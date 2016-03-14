package com.test.kataChallenge.common;


import java.util.Scanner;

import com.test.kataChallenge.userInputOperations.UserInput;


public class Main 
{
		public static void main(String args[])
		{
			System.out.println("\tWelcome to Yehtzee");
			UserInput userInput=new UserInput();
			userInput.execute();
		}
}
