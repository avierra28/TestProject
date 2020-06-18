package javaRevisited;

import java.util.Scanner;

public class ArmstrongNumber {

	private static int number;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		
		System.out.println("Enter an integer to check if its an armstrong number: ");
		int num = scanner.nextInt();
		
		// Check.
		check(num);
	}
	
	
	public static void check(int n) {
		int temp = 0, holder = n;
		
		while(n > 0)
		{
			temp = n % 10;
			
			number += (Math.pow(temp, 3));
			
			n = n/10;
		}
		
		if(number == holder)
			System.out.println("Number is an armstrong number");
		else {
			System.out.println("Number is not an armstrong number");
		}
	}

}
