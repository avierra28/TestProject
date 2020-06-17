package java2novice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicateChar 
{

	public static void main(String[] args) 
	{
		// Declare string.
		String str1 = new String("This is an example and test string.");
		
		// Pass function.
		findDuplicates(str1);
	
	}
	public static void findDuplicates(String str)
	{
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		List<Integer> myList = new ArrayList<Integer>();
		StringBuilder myBuilder = new StringBuilder(str);
		
		System.out.println(myBuilder);
		
		// Begin double for loop.
		for (int i = 0; i < myBuilder.length(); i++)
		{
			int holder = 1;
			
			for (int j = i + 1; j < myBuilder.length(); j++)
			{
				if(myBuilder.charAt(i) == myBuilder.charAt(j))
				{
					// If equal
					holder++;
					myBuilder.deleteCharAt(j);
					j--;
				}
			}
			
			// Add this to our map.
			myList.add(holder);
			hashMap.put(myBuilder.charAt(i), myList.get(i));
		}
		
		System.out.println(hashMap);
	}

}

















