package stringWork;

import java.util.Scanner;

public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter string with spaces: ");
		String str1 = scanner.nextLine();
		
		removeSpaces(str1);
	}
	
	public static void removeSpaces(String s) {
		
		System.out.println(s.replaceAll(" ", ""));
	}
	
	

}
