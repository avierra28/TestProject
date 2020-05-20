package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

/*
 * Insertion Sort Sort Program
 * Created by: Anthony Vierra
 * Concept: Starts at position 1 in the array and constantly updates the smallest value to be
 * at the beginning of the array. This is more robust than the bubble sort.
 * 
 *  Time Complexities:
 *  Best: O(n) (If the array is already sorted)
 *  Worst: O(n^2)
 *  There's no way to improve upon O(n^2) as the nature of the algorithm does not allow us to do
 *  so.
 *  
 *  Space Complexity:
 *  O(1)
 */

public class insertionSort 
{

	public static void main(String[] args) 
	{
		// The insertion sorting program.
		Random random = new Random();
		int[] array1 = new int[10];
		
		for(int i = 0; i < array1.length; i++)
			array1[i]= random.nextInt(50 - 1)+1;
		
		System.out.print("Original Array: " + Arrays.toString(array1));
		
		System.out.print("\n");
		
		// Call the insertion sorting algorithm.
		insertSort(array1);
	}
	
	public static void insertSort(int[] arr)
	{
		// Get the length.
		int n = arr.length;
		
		for(int i = 1; i < n; i++)
		{
			int key = arr[i], j = i - 1;
			
			while(j >= 0 && arr[j] > key)
			{
				arr[j + 1] = arr[j];
				j--;
			}
			// At the end of the for loop.
			arr[j + 1] = key;
		}
		
		System.out.print("\nSorted Array: " + Arrays.toString(arr));

	}

}















