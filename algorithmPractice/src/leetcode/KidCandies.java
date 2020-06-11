package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidCandies 
{
	private static List<Integer> candies;
	private static List<Boolean> answer;
	
	public static void main(String[] args) 
	{
		candies = new ArrayList<Integer>();
		answer = new ArrayList<Boolean>();
		
		// Add candies to our list.
		candies.add(2);
		candies.add(3);
		candies.add(5);
		candies.add(1);
		candies.add(3);
		
		// Call function.
		answer = kidswithCandies(candies, 3);
		
		System.out.println(answer);
	}
	
	// Define method.
	public static List<Boolean> kidswithCandies(List<Integer> list, int candies)
	{
		List<Boolean> tempBooleans = new ArrayList<Boolean>();
		int max = 0;
		
		// Find the max.
		for (int i = 0; i < list.size(); i++)
			if(max < list.get(i))
				max = list.get(i);
		
		
		// Fill our temp booleans list.
		for (int i = 0; i < list.size(); i++)
			if((list.get(i) + candies) >= max)
				tempBooleans.add(true);
			else
				tempBooleans.add(false);
		
		// Finally return the temp boolean list.
		return tempBooleans;
	}

}











