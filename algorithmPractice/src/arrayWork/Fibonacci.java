package arrayWork;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("To what fibonacci number should we calculate: ");
		int num = scanner.nextInt();
		
		
		// Call function.
		calculate(num);
	}
	
	public static void calculate(int n) {
		
		int[] arr1 = new int[n];
		
		if(n == 1)
			System.out.println(1);
		else if(n == 2)
		{
			arr1[0] = 1;
			arr1[1] = 1;
			System.out.println(Arrays.toString(arr1));
		}
		else {
			arr1[0] = 1;
			arr1[1] = 1;
			int counter = 2;
			
			while(counter < n)
			{
				arr1[counter] = arr1[counter - 1] + arr1[counter - 2];
				counter++;
			}
			System.out.println(Arrays.toString(arr1));
		}
	}

}
