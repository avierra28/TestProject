package mathWork;

import java.util.Scanner;

public class PalindromeInteger {

	public static void main(String[] args) {

		int num = 15451;
		Scanner myScanner = new Scanner(System.in);
		
		
		/*
		 * Entering the option for the user to input his own number,
		 * instead of statically sending a number preinputted.
		 */
		System.out.println("Enter an integer: ");
		int number = myScanner.nextInt();
		
		System.out.println(reverseInt(number));
	}
	
	public static int reverseInt(int n) {
		
		int temp = 0, holder = n;
		
		while(holder > 0)
		{
			temp = (temp * 10) + (holder % 10);
			holder = holder/10;
		}
		
		
		if(temp == n)
			System.out.println("Integer is a palindrome");
		else {
			System.out.println("Integer is not a palindrome");
		}
		return temp;
	}

}
