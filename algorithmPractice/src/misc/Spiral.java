package misc;

import java.io.FileWriter;
import java.util.Scanner;

public class Spiral 
{
	private static int[][] spiral;
	private static String spiralString;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int iteration = 0;
		spiralString = "";
		
		// Begin by gathering 2 integers.
		System.out.println("Enter number of rows and columns: ");
		int numDimension = scanner.nextInt();
	
		// Pass these to a function.
		fillSpiral(numDimension, numDimension);
		
		// Print out the spiral.
		printSpiral(numDimension);
		
		try 
		{
			FileWriter myFile = new FileWriter("spiral.txt");

			System.out.println("\nFile created");
			myFile.write(spiralString);
			
			myFile.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * fillSpiral Method, comes to O(n^2) quadratic time.
	 */
	
	// Fill spiral.
	public static void fillSpiral(int nR, int nC)
	{
		spiral = new int[nR][nC];
		int masterCounter = 0, colCounter = 0, rowCounter = 0, numFill = 1;
		int colCounter2 = nC - 1, rowCounter2 = nR - 1;
		
		while(masterCounter < (nR + nC - 1))
		{
			// This loop will fill the row from the top.
			for (int i = rowCounter; i <= colCounter2; i++) 
			{
				spiral[colCounter][i] = numFill;
				numFill++;
			}
			// Increase the row counter by 1.
			rowCounter++;
			
			// Fill the end.
			for (int i = rowCounter; i <= rowCounter2; i++) 
			{
				spiral[i][colCounter2]= numFill;
				numFill++;
			}
			// Increase our counters.
			colCounter2--;

			// Fill the bottom.
			for (int i = colCounter2; i >= colCounter; i--) 
			{
				spiral[rowCounter2][i]= numFill;
				numFill++;
			}
			// Increase our counters.
			rowCounter2--;
			
			// Fill the inside.
			for (int i = rowCounter2; i >= rowCounter; i--)
			{
				spiral[i][colCounter] = numFill;
				numFill++;
			}
			// Increase our counters.
			colCounter++;
			
			
			
			// Then at the very end increase the masterCounter.
			masterCounter++;
		}
	}
	
	
	// Print out the sprial.
	public static void printSpiral(int r)
	{
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++) {
				System.out.print(spiral[i][j] + " ");
				spiralString += spiral[i][j] + " "; 
			}
			spiralString += "\n";
			System.out.println();
		}
	}

}













