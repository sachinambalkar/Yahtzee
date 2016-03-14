package com.test.kataChallenge.userInputOperations;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import com.test.kataChallenge.common.Constants;
import com.test.kataChallenge.score.CalculateUserScore;

public class UserInput 
{
   private	StringBuilder userInputOrginal,choice;
   private	StringBuilder userInputTemp;
   private ValidateUserInput validateUserInput;
   private Object object;
   int score=0;
   Scanner sc;
   private CalculateUserScore calculateUserScore;
   String []originalVals;
	/**
	 * This function will take input from user 
	 * and perform validation operation
	 */
	public void execute()
	{
		boolean continueLoop=true,wantToReroll=false;		
		sc=new Scanner(System.in);							
		while(continueLoop)
		{			
			System.out.print("\nEnter dices values (Eg. 1 2 3 4 5): ");
			userInputOrginal=new StringBuilder(sc.nextLine());			
			originalVals=userInputOrginal.toString().split(" ");					
			if(validateInput(originalVals)==Constants.validInput)
			{
				System.out.print("\nDo you want to REROLL(y/n) ? ");
				choice=new StringBuilder(sc.nextLine());
				wantToReroll=checkValidInput(choice);
				if(wantToReroll)
				{
					performRerollOperation(1,originalVals);
				}
				System.out.print("\nWant to continue (y/n) : ");
				choice=new StringBuilder(sc.nextLine());			
				continueLoop=checkValidInput(choice);				
			}						
		}
	}
	
	private void performRerollOperation(int totalAttempt,String[] originalUserInput){
		
		boolean rollAgain=false;				
		
		System.out.print("\nDices values : ");
		for(String str:originalUserInput){
			System.out.print(str+" ");
		}
		System.out.print("\nEnter INDEX of dices that you want to REROLL. => ");
		userInputTemp=new StringBuilder(sc.nextLine());
		String []indices=userInputTemp.toString().split(" ");
		int []index=new int[indices.length];
		int count=0;
		for(String string:indices){
			index[count++]=Integer.parseInt(string);			
		}
		
		System.out.print("Enter values for this indices : ");
		userInputTemp=new StringBuilder(sc.nextLine());
		String []values=userInputTemp.toString().split(" ");

		if(indices.length==values.length){
			for(int i=0;i<indices.length;i++){
				originalUserInput[index[i]-1]=values[i];					
			}
		}
		
		validateInput(originalUserInput);
		totalAttempt++;
		if(totalAttempt<=2)
		{
			System.out.print("\nDo you want to REROLL again(y/n) ?");
			StringBuilder userInput=new StringBuilder(sc.nextLine());
			rollAgain=checkValidInput(userInput);
			if(rollAgain)
			{				
				performRerollOperation(totalAttempt,originalUserInput);
			}			
		}
		else
		{
			System.out.println("You can not reroll again. Maximum limit(3) reached.");
		}
	}
	
	private boolean checkValidInput(StringBuilder userInput)
	{
		if((userInput.toString().trim().length()==1)&&
				userInput.toString().contains("y"))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 1. This function will validate user's input.
	 * 2. After validation it will call 'performScoreEvaluation' method
	 * 	  inside CalculateUserScore. While will perform the score calculation 
	 * 	   operation on user's input and gives output as score.
	 */
	public int validateInput(String []userInput)
	{
		try{
			calculateUserScore=new CalculateUserScore();
			validateUserInput= new ValidateUserInput();
			object= validateUserInput.validate(userInput);			
			if(object instanceof List)
			{				
				score=calculateUserScore.performScoreEvaluation((List)object);
				System.out.println("\nYour score is "+score);
			}
			else if(object instanceof Integer)
			{
				if((Integer)object==Constants.invalidInput)
				{
					System.out.println("Invalid input");
					return Constants.invalidInput;
				}
			}
			
		}catch(Exception e){
			Constants.LOGGER.log(Level.ALL,"Error occured@validateInput", e);			
			System.out.println("Invalid input");
			return Constants.invalidInput;			
		}
		return Constants.validInput;
	}
}
