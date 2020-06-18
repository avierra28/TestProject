package javaRevisited;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {

		// Declare number.
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a number to check: ");
		int num = scanner.nextInt();
		
		System.out.println(primeNumber(num));
	}
	
	public static boolean primeNumber(int n) {
		
		int j = 2;
		
		if(n == 1)
			return true;
		else if(n== 2)
			return true;
		
		while(j < n)
		{
			if(n % j == 0)
				return false;
			
			j++;
		}
		return true;
	}

}
