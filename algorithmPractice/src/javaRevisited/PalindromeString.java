package javaRevisited;

public class PalindromeString {

	public static void main(String[] args) {

		String str1 = "otto";
		
		// call the function.
		checker(str1);
		
	}
	
	public static void checker(String str) {
		
		String oppositeString = "";
		
		for (int i = str.length() - 1; i >= 0; i--) 
			oppositeString += str.charAt(i);
		
		if(str.equals(oppositeString))
			System.out.println("String is a palindrome");
		else {
			System.out.println("String is not a palindrome");
		}
		
	}

}
