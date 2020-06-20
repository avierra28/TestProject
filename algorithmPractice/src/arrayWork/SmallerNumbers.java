package arrayWork;

import java.util.Arrays;

public class SmallerNumbers 
{

	public static void main(String[] args) 
	{
		// Start out with an array.
		int[] nums = {8, 1, 2, 2, 3};
		
		// Call the function.
		System.out.println(Arrays.toString(smallerNumbers(nums)));
	}
	
	public static int[] smallerNumbers(int[] arr)
	{
		// Declare an integer.
		int[] temp = new int[arr.length];
		
		for (int i = 0; i < temp.length; i++) 
		{
			for (int j = 0; j < temp.length; j++) 
			{
				if(arr[j] < arr[i])
					temp[i]++;
			}
		}
		
		
		// Return the int.
		return temp;
	}

}
