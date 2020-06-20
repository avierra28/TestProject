package misc;

import java.util.Scanner;

public class Pattern4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of rows: ");
		int rows = scanner.nextInt();

		print(rows);
	}

	public static void print(int numRows) {

		int rowCount = 1;

		for (int i = numRows; i > 0; i--) {

			for (int j = 1; j <= i*2 ; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= rowCount; j++) {
				System.out.print(j + " ");
			}
			
			for (int j = rowCount; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();

			rowCount++;
		}

	}

}
