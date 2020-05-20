package sortingAlgorithms;

/*
 * Bubble Sort Program
 * Created by: Anthony Vierra
 * Concept: Go through the array and compare every element to its neighbor. If the neighbor is
 * smaller, than swap it otherwise continue iterating. This will pass through the array n - 1
 * times to make sure all values are accounted for.
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



public class bubbleSort {

	public static void main(String[] args) 
	{
		// Start off with an array.
		int[] array1 = {3, 1, 5, 6, 6, 3, 8, 3, 5, 9, 4, 2};
		
		// Call the function to sort the array.
		bubbleSort1(array1);
	}
	
	public static void bubbleSort1(int[] arr)
	{
		// Begin with a temp var.
		int n = arr.length;
		
		// For loops.
		for(int i = 0; i < n - 1; i++)
		{
			for(int q = 0; q < (n - i - 1); q++)
			{
				if(arr[q] > arr[q + 1])
				{
					// Swap the values.
					int temp = arr[q];
					arr[q] = arr[q+1];
					arr[q + 1]= temp; 
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
}
