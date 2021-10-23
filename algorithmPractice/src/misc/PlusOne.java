package misc;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {

		// Initialize an array.
		int[] array1 = { 1, 2, 3, 4 };

		// Call the function to plus one.
		plusone(array1);
		
		/*
		 * Making changes here.
		 */

	}

	public static void plusone(int[] arr) {

		int n = arr.length - 1;
		arr[n] = arr[n] + 1;
		System.out.println(Arrays.toString(arr));

	}

}
