package misc;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class PlusOne {

	public static void main(String[] args) {

		// Initialize an array.
		int[] array1 = { 1, 2, 3, 4 };

		// Call the function to plus one.
		plusone(array1);
		
		/*
		 * Making changes here.
		 */
		
		Hashtable<Integer, LinkedList<String>> myHashtable = new Hashtable<Integer, LinkedList<String>>();
		
		

	}

	public static void plusone(int[] arr) {

		int n = arr.length - 1;
		arr[n] = arr[n] + 1;
		System.out.println(Arrays.toString(arr));

	}

}
