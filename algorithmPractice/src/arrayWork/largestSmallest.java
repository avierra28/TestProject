package arrayWork;

import java.util.Arrays;
import java.util.Random;

public class largestSmallest 
{

	public static void main(String[] args) 
	{
		// Will find the largest and smallest in any given array.
		int[] arr = new int[15];
		Random random = new Random();
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(100 - 1) + 1;
		
		System.out.println("The Array: " + Arrays.toString(arr) + 
		"\nSmallest: " + smallest(arr) + "\n" +
		"Largest: " + largest(arr));
		
	}
	
	public static int smallest(int[] arr)
	{
		int min = arr[0];
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] < min)
				min = arr[i];
		}
		
		return min;
	}
	
	public static int largest(int[] arr)
	{
		int max = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] > max)
				max = arr[i];
		}
		
		return max;
	}

}
