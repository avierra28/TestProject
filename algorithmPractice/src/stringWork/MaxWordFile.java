package stringWork;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MaxWordFile 
{
	private static Scanner scanner;
	
	public static void main(String[] args) 
	{
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		String str1 = "";
		
		// Get file.
		try 
		{
			File myFile = new File("/Users/tonyvierra/git2/My-Repository/algorithmPractice/src/java2novice/MaxWordFile.txt");
			// Open up scanner.
			scanner = new Scanner(myFile);
			
			while(scanner.hasNextLine())
				str1 += scanner.nextLine();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		addtoMap(str1, hashMap);
				
	}
	
	// Declare function to add these values one by to to our hashmap.
	public static void addtoMap(String str, HashMap<String, Integer> map)
	{		
		String[] tempString = str.split(" ");
		List<Integer> array1 = new ArrayList<Integer>();

		
		// Process through.
		for (int i = 0; i < tempString.length - 1; i++) 	
		{
			// Since everything occurs atleast once.
			int holder = 1;
			
			for (int j = i + 1; j < tempString.length; j++) 
			{
				
				if(tempString[i].equals(tempString[j]))
				{
					holder++;
					tempString[j]= ""; 
				}
			}
			array1.add(holder);
			
			// Fill our hashmap.
			map.put(tempString[i], array1.get(i));
		}
		
		System.out.println(map);
		
	}

}













