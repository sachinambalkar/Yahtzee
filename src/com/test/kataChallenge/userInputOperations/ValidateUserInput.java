package com.test.kataChallenge.userInputOperations;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.test.kataChallenge.common.Constants;



class ValidateUserInput {

	protected Object validate(String[] vals)
	{		
		List list=new ArrayList<Integer>();


		//Check for valid input//
		
		/*If user give total values More than or Less than 6
		 * then program will throw error*/
		if(vals.length!=Constants.totalDices)
		{
			return Constants.invalidInput; 
		}
		else
		{
			/*
			 * If value is Less than 0 or Greater than 6
			 * then program will throw error.
			 */
			try{
				int val;
				for(int itr=0;itr<Constants.totalDices;itr++)
				{
					val=Integer.parseInt(vals[itr]);
					if(val<Constants.diceMinValue||val>Constants.diceMaxValue)
					{					
						return Constants.invalidInput;
					}else
					{
						list.add(val);
					}
				}
			}catch(Exception e){
	
				Constants.LOGGER.log(Level.ALL,"Error occured @ validate", e);			
				return Constants.invalidInput;
			}
		}		
		return list;
	}
		
}
