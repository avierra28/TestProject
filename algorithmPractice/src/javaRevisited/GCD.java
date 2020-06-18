package javaRevisited;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		int num1 = scanner.nextInt();
		System.out.print("Enter second number: ");
		int num2 = scanner.nextInt();
		
		System.out.println("Greatest common divisor: " + func1(num1, num2));
	}
	
	public static int func1(int n1, int n2) {
		
		if(n2 == 0)
			return n1;
		
		return func1(n2, n1%n2);
	}

}
