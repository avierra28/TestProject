package arrayWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DecompressList {

	public static void main(String[] args) 
	{
		// Start out with an integer array.
		int[] nums = {1, 2, 3, 4};
		
		// Print out the list.
		System.out.println(Arrays.toString(decompress(nums)));
	}
	
	// Declare the function.
	public static int[] decompress(int[] arr)
	{
		// Begin.
		List<Integer> tempList = new ArrayList<Integer>();
		
		// Step through the array in a unique way.
		for (int i = 0; i < arr.length; i += 2) 
		{
			while(arr[i] > 0)
			{
				tempList.add(arr[i + 1]);
				
				// Reduce the key by 1.
				arr[i]--;
			}
		}
		
		// Initialize a new array.
		int[] temp = new int[tempList.size()];
		
		for (int i = 0; i < temp.length; i++) 
			temp[i] = tempList.get(i);
		
		return temp;
	}

}












