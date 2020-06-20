package recursiveAlgorithms;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number: ");
		int num = scanner.nextInt();
		
		iterativeApproach(num);
		System.out.println("Recursive: " + recursiveApproach(num));
		
	}
	
	public static void iterativeApproach(int n) {
		
		int temp = 1;
		
		while(n > 0)
		{
			temp *= n;
			n -= 1;
		}
		System.out.println("Iterative: " + temp);
	}
	
	public static int recursiveApproach(int n) {
		
		if(n <= 1)
			return 1;
		else {
			return n * recursiveApproach(n - 1);
		}
	}

}
