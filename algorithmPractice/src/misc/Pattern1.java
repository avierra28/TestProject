package misc;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of rows: ");
		int rows = scanner.nextInt();
		
		print(rows);
	}
	
	public static void print(int numRows) {
		int rowCount = 1;
		
		for (int i = numRows; i > 0; i--) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= rowCount; j++) {
				System.out.print(rowCount + " ");
			}
			
			System.out.println();
			
			rowCount++;
		}
		
	}

}
