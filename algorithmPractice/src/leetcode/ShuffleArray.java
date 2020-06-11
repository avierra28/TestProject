package leetcode;

import java.util.Arrays;

public class ShuffleArray
{

	public static void main(String[] args) 
	{
		// Declare an array of even size.
		int[] array1 = {2, 5, 1, 3, 4, 7, 12, 60, 32, 50, 55, 7};
		
		// Call the function.
		shuffle(array1, array1.length);
	}
	
	// Begin the shuffle.
	public static void shuffle(int[] arr, int n) 
	{
		int[] temp1 = new int[n], temp2 = new int[n], temp3 = new int[n];
		int counter = 0, counter2 = n/2;
		
		// Fill our temp arrays.
		for (int i = 0; i < n; i++) 
		{
			if(i < n/2)
			{
				temp1[i]= arr[i];
				temp2[i] = 0; 
			}
			else
			{
				temp2[i]= arr[i];
				temp1[i] = 0; 
			}
		}
		
		// Fill the actual array.
		for (int i = 0; i < n; i++) 
		{
			if(i % 2 == 0)
			{
				temp3[i]= temp1[counter];
				counter++;
			}
			else
			{
				temp3[i] = temp2[counter2];
				counter2++;
			}
		}
		
		System.out.println(Arrays.toString(temp3));
	}

}
