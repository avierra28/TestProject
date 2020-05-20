package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

/*
 * Merge Sort Program
 * Created by: Anthony Vierra
 * Concept: Works on the concept of breaking down an array into smaller portions in hopes to
 * simplify the problem. This works by recursion.
 * 
 *  Time Complexities:
 *  Best: O(nlogn) (If the array is already sorted)
 *  Worst: O(nlogn)
 *  There's no way to improve upon O(nlogn) as the nature of the algorithm does not allow us
 *  to do so.
 *  
 *  Space Complexity:
 *  O(n)
 */

public class mergeSort 
{

	public static void main(String[] args)
	{
		// Begin with a random array.
		Random random = new Random();
		int array1[] = new int[10];
		
		for(int i = 0; i < array1.length; i++)
			array1[i] = random.nextInt(50 - 1) + 1;
		
		// Display the array.
		System.out.println("Original Array: " + Arrays.toString(array1));
		
		// Merge sort it.
		mergeSortAlg(array1);
		
		// Print out the final array.
		System.out.println("Sorted Array: " + Arrays.toString(array1));
		
	}
	
	// Overloaded function 1
	public static void mergeSortAlg(int[] arr)
	{
		// Calling overloaded function 2.
		mergeSortAlg(arr, 0, arr.length - 1);
	}
	
	// Overloaded function 2
	public static void mergeSortAlg(int[] arr, int l, int r)
	{
		/*
		 * l = the beginning of the array.
		 * r = the end of the array.
		 */
		if(l < r)
		{
			// Get the middle point.
			int m = (l + r) / 2;
			
			// Recursive calls.
			// Lower half of the array.
			mergeSortAlg(arr, l, m);
			// Upper half of the array.
			mergeSortAlg(arr, (m + 1), r);
			
			// Then finally merge the sorted halves.
			mergeSortAlg(arr, l, m, r);
			
		}
	}
	
	// Overloaded function 3.
	public static void mergeSortAlg(int[] arr, int l, int m, int r)
	{
		int n1 = m - l + 1, n2 = r - m;
		// Dynamically create new holder arrays.
		int[] first = new int[n1];
		int[] second = new int[n2];
		
		// Copying into first array.
		for(int i = 0; i < first.length; i++)
			first[i]= arr[l + i]; 
		
		// Copying into second array.
		for(int i = 0; i < second.length; i++)
			second[i]= arr[m + 1 + i];
		
		// Declaring some other variables.
		int i = 0, j = 0, k = l;
		
		// Merge with a while loop.
		while(i < n1 && j < n2)
		{
			if(first[i] <= second[j])
			{
				arr[k]= first[i];
				i++;
			}
			else
			{
				arr[k] = second[j];
				j++;
			}
			// Increment k.
			k++;
		}
		
		while(i < n1)
		{
			arr[k] = first[i]; 
            i++; 
            k++; 
		}
		while (j < n2) 
	    { 
			arr[k] = second[j]; 
	        j++; 
	        k++; 
	    }	
	}

}


















