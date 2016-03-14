package com.test.kataChallenge.score;
import java.util.Iterator;
import java.util.Map;

import com.test.kataChallenge.common.Constants;



class CheckRule 
{
	/**
	 * @param map : Map will have KEY as user's dice score
	 *              and VALUE as occurrence of that score.
	 * @return : Return score value based on the rules given.
	 */
	protected int checkRule(Map<Integer, Integer> map)
	{
		boolean onePair=false,twoPair=false,threeOfaKind=false,pairOfFour=false;				
		int scoreOnePair=0,scoreTwoPair=0,scoreThreeOfaKind=0;			
		Iterator iterator=map.entrySet().iterator();
		Map.Entry mapEntry;
		int mapValue,mapKey;
		while(iterator.hasNext())
		{
			mapEntry=(Map.Entry)iterator.next();
			mapValue=(Integer)mapEntry.getValue();
			mapKey=(Integer)mapEntry.getKey();
			if(mapValue==5)
			{						
				System.out.print(Constants.yahtzee);
				return Constants.yahtzeeScore;
			}
			else if(mapValue==2)
			{					
				if(threeOfaKind)
				{
					System.out.print(Constants.fullHouse);
					return scoreThreeOfaKind+mapKey*2;							
				}
				else if(onePair)
				{
					twoPair=true;				
					scoreTwoPair=scoreOnePair+mapKey*2;					
				}
				else
				{
					onePair=true;
					scoreOnePair=mapKey*2;
				}				
				if(mapKey==4){
					pairOfFour=true;
				}
			}
			else if(mapValue==3)
			{
				if(onePair)
				{				
					System.out.print(Constants.fullHouse);
					return scoreOnePair+mapKey*3;										
				}
				else
				{
					threeOfaKind=true;
					scoreThreeOfaKind=mapKey*3;
				}
			}
			else if(mapValue==4)
			{			
				System.out.print(Constants.fourOfaKind);
				return mapKey*4;				
			}			
		}		
		if(threeOfaKind)
		{
			System.out.print(Constants.threeOfaKind);
			return scoreThreeOfaKind;
		}else if(twoPair)
		{
			if(pairOfFour){
				System.out.print(Constants.fours);
				return 8;
			}
			System.out.print(Constants.twoPair);
			return scoreTwoPair;
		}else if(onePair)
		{
			System.out.print(Constants.onePair);
			return scoreOnePair;
		}
		return 0;
	}
}
