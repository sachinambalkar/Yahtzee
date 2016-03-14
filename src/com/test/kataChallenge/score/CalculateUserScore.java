package com.test.kataChallenge.score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class CalculateUserScore
{		
	/**
	 * 1. This function will takes the user's input from list and
	 *    store it in Map. 
	 * 2. Map will have KEY as user's one dice score
	 *    and VALUE as occurrence of that score.  
	 * 3. If straight appears then will directly return score of all dices.
	 *    Else apply rule on this MAP Values to find out Pair, Two Pair,
	 *    Three of a kind, Four of a kind, Full House. For this program will
	 *    call 'checkRule' method inside 'CheckRule' class. 
	 * 		 
	 * 
	 * @param list => user's input stored in List.
	 * @return => Score
	 */
	public int performScoreEvaluation(List<Integer> list)
	{		
		boolean straightRule=true,firstLoop=true;;
		Iterator<Integer> iterator=list.iterator();
		int value,oldValue=-1,mapValue;
		Map<Integer, Integer> map=new HashMap<Integer,Integer>();
		while(iterator.hasNext())
		{			
			value=iterator.next();
			if(firstLoop)
			{
				oldValue=value;
				firstLoop=false;
			}
			else
			{
				if(straightRule){
					if(value<oldValue||value==oldValue){
						straightRule=false;
					}else{
						oldValue=value;
					}
				}
			}			
			if(map.containsKey(value))
			{
				mapValue=map.get(value);
				map.put(value,++mapValue);
			}else
			{
				map.put(value,1);
			}
		}							
		if(straightRule)
		{
			int score=0;
			Iterator itr=map.entrySet().iterator();
			while(itr.hasNext())
			{
				Map.Entry mapEntry=(Map.Entry)itr.next();
				score=score+(Integer)mapEntry.getKey();
			}
			System.out.print("This is Straight..!!!");
			return score;			
		}			
		return (new CheckRule()).checkRule(map);
	}
}
