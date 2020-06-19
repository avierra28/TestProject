package javaRevisited;

import java.util.Scanner;

public class StringAnagram {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter string 1: ");
		String st1 = scanner.nextLine();
		System.out.print("Enter string 2: ");
		String st2 = scanner.nextLine();
		
		// Pass it to the function.
		System.out.println(anagram(st1, st2));
		
		
	}
	
	public static boolean anagram(String s1, String s2) {
		
		boolean flag1 = false;
		
		// Check if they are the same size.
		if(s1.length() != s2.length())
			return false;
		else {
			for (int i = 0; i < s1.length(); i++) {
				char temp1 = s1.charAt(i);
				String string = String.valueOf(temp1);
				
				if(s2.contains(string))
					flag1 = true;
				else {
					return false;
				}
				
			}
		}
		return flag1;
	}

}
