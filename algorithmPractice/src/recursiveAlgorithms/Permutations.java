package recursiveAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {
	
	private static ArrayList<String> myList;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		myList = new ArrayList<String>();
		
		System.out.print("Enter in a string: ");
		String str1 = scanner.nextLine();
		
		// Pass this to the function.
		myList = getPermutation(str1);
		
		System.out.println(myList.size() + " total permutations\n-------------------");
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
			
		}
	}
	
	public static ArrayList<String> getPermutation(String str) {
		
		// Check to see if its empty.
		if(str.isEmpty())
		{
			// Return an empty array list.
			ArrayList<String> tempArrayList = new ArrayList<String>();
			tempArrayList.add("");
			return tempArrayList;
		}
		else {
			// Get char.
			char ch = str.charAt(0);
			
			// Then get substring.
			String subString = str.substring(1);
			ArrayList<String> prevResult = getPermutation(subString);
			

	        ArrayList<String> Res = new ArrayList<>(); 
	  
	        for (String val : prevResult) { 
	            for (int i = 0; i <= val.length(); i++) { 
	                Res.add(val.substring(0, i) + ch + val.substring(i)); 
	            } 
	        } 
	  
	        // Return the resultant arraylist 
	        return Res; 
			
		}
		
	}


}

















