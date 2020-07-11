package misc;

import java.util.Scanner;

public class Earnings {

	public static void main(String[] args) {
		
		/*
		 * Penny Conversion.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		// Ask for how many days.
		System.out.print("How many days? ");
		int numDays = scanner.nextInt();
		
		// Calculate days.
		calculate(numDays);
	}
	
	public static void calculate(int n) {
		
		double num1 = 0.0, temp = 0.0, holder = 0.0;
		boolean flag = false;
		int totalPennies = 0;
		
		for (int i = 1; i <= n; i++) 
		{
			System.out.println("Pay for day " + i + " = " + (int)Math.pow(2, (i - 1)));
			
			// Add this.
			temp = (int)Math.pow(2, (i - 1));
			totalPennies += (int)Math.pow(2, (i - 1));
			
			if(temp > 100)
			{
				double temp2 = temp;
				temp /= 100;
				holder = temp2 % (temp * 100) / 100;
				flag = true;
			}
			
			/*
			 * temp holder the number before the decimal.
			 * holder holds the number after the decimal.
			 */
			
			if(flag)
				num1 += (temp + holder);
			else {
				holder = temp / 100;
				num1 += holder;
			}
			
		}
		System.out.println("Total pennies: " + totalPennies);
		System.out.println("Total pay: $" + num1);
	
	}

}









