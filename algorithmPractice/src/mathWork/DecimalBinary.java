package mathWork;

import java.util.Scanner;

public class DecimalBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int num = scanner.nextInt();

		// Call function.
		binaryConversion(num);

		scanner.close();
	}

	public static void binaryConversion(int n) {
		int[] tempArray = new int[30];
		int counter = 0;

		while (n > 0) {
			// Fill our array.
			tempArray[counter++] = n % 2;
			n = n / 2;
		}

		for (int i = counter; i >= 0; i--)
			System.out.print(tempArray[i]);

	}

}









