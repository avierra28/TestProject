package mathWork;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// Enter a num.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter an integer: ");
		int num = scanner.nextInt();
		
		// Reverse the integer.
		reverseInt(num);
		
		
		scanner.close();
	}

	public static void reverseInt(int n) {
		int temp = 0;

		while (n > 0) {
			temp = (temp * 10) + (n % 10);
			n /= 10;
		}

		System.out.println(temp);
	}

}
