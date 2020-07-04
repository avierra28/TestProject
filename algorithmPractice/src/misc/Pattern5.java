package misc;

import java.util.Scanner;

public class Pattern5 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Gather input.
		System.out.print("Enter odd number between 3 - 23: ");
		int number = scanner.nextInt();

		// While check.
		while ((number % 2 == 0) || (number < 3) || (number > 23)) {
			System.out.println("Error, please enter again (3 - 23): ");
			number = scanner.nextInt();
		}

		// Call the function.
		printDiamond(number);
	}

	public static void printDiamond(int n) {

		boolean flag = true;
		// Begin our for loops.
		for (int i = 0; i < n; i++) {


			if (flag) {
				for (int j = n; j > i; j--) {
					System.out.print(" ");
				}
				
				for (int j = 0; j < i; j++) {
					System.out.print(" *");
				}
			}
			else {
				for (int j = n/2; j >= 0; j--) {
					System.out.print(" ");
				}
				for (int j = 0; j < n - i; j++) {
					System.out.print(" *");
				}
			}
			
			if(i == (n/2))
				flag = false;
			
			System.out.println();
		}

	}
}
