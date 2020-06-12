package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PascalsTriangle 
{
	// Define the variables needed for this function.
	private static HashMap<Integer, ArrayList<Integer>> hashMap;
	private static ArrayList<Integer> myList;
	private static Scanner scanner;

	public static void main(String[] args)
	{
		// Call function to initialize everything.
		initialize();

		// Calling pascal function.
		pascal();

		// Call the function to display it.
		displayTriangle();

		// Close the scanner.
		scanner.close();
	}

	// Fill the hashmap with pascal arithmetic.
	public static void pascal()
	{
		// Declare a temp list.
		ArrayList<Integer> tempArrayList;

		// Gather input from user.
		System.out.print("Number of rows for the pascal triangle: ");
		int numRows = scanner.nextInt();

		// Begin the display.
		for (int i = 1; i <= numRows; i++) 
		{
			// Fill the pascal triangle manually for the first two.
			if(i == 1)
			{
				// Add 1 to the list.
				myList.add(1);

				// Populate the hashmap.
				hashMap.put(i, myList);

				// Then ascribe a new arraylist.
				myList = new ArrayList<Integer>();
			}
			else if (i == 2) 
			{
				// Add 1 to the list.
				myList.add(1);
				myList.add(1);

				// Populate the hashmap.
				hashMap.put(i, myList);

				// Then ascribe a new arraylist.
				myList = new ArrayList<Integer>();

			}
			else
			{
				// Create a temporary arraylist.
				tempArrayList = new ArrayList<Integer>();
				myList = new ArrayList<Integer>();

				tempArrayList.add(1);

				// If not 1 or 2 continue like normal.
				myList = hashMap.get(i - 1);

				for (int j = 0; j < myList.size() - 1; j++) 
					tempArrayList.add(myList.get(j) + myList.get(j + 1));

				tempArrayList.add(1);

				// Finally add the temparraylist to the hashmap.
				hashMap.put(i, tempArrayList);

			}
		}

	}

	public static void initialize() 
	{
		// Initialize everything.
		hashMap = new HashMap<Integer, ArrayList<Integer>>();
		myList = new ArrayList<Integer>();
		scanner = new Scanner(System.in);
	}

	public static void displayTriangle()
	{
		for (int i = 1; i <= hashMap.size(); i++) 
		{
			for (int j = hashMap.size(); j > i; j--) 
				System.out.print(" ");

			// Print out line by line.
			System.out.println(hashMap.get(i));
		}
	}
}











