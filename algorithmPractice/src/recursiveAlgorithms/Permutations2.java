package recursiveAlgorithms;

import java.util.Scanner;


public class Permutations2 {

	private static Scanner scanner;
	private static int counter;
	
	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		counter = 0;
		
		// Ask the user for a string.
		System.out.print("Enter a string: ");
		String string = scanner.nextLine();
		
		// Call the find permute function.
		findPermute(string, 0, string.length() - 1);
		System.out.println(counter + " different permutations of this string.");
	}
	
	// The main function of the class.
	/*
	 * Paramters being:
	 * str = the actual string.
	 * left = the start of the string.
	 * right = the end of the string.
	 */
	public static void findPermute(String str, int left, int right) {
		
		// Base case.
		if(left == right) {
			System.out.println(str);
			counter++;
		}
		else {
			for (int i = left; i <= right; i++) {
				str = swap(str, left, i);
				findPermute(str, left+1, right);
				str = swap(str, left, i);
			}
		}
	}
	
	
	// Swap function.
	public static String swap(String a, int i, int j) {
		
		char temp;
		char[] tempArray = a.toCharArray();
		temp = tempArray[i];
		tempArray[i]= tempArray[j];
		tempArray[j] = temp;
		return String.valueOf(tempArray);
	}

}


















