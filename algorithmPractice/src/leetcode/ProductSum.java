package leetcode;

import java.util.Scanner;

public class ProductSum {

	public static void main(String[] args) {
		
		//
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		int num1 = scanner.nextInt();
		
		System.out.println(subtractionprodsum(num1));
	}
	
	public static int subtractionprodsum(int n) {
		
		int temp1 = 1, temp2 = 0;
		
		while(n > 0)
		{
			temp1 *= n % 10;
			temp2 += n % 10;
			n /= 10;
			
		}

		
		return temp1  - temp2;
		
	}

}
