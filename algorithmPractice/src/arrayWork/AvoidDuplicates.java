package arrayWork;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class AvoidDuplicates {

	public static void main(String[] args) {

		int[] nums = { 5, 2, 7, 2, 4, 7, 8, 2, 3 };

		// Call the function.
		printDistinct(nums);
		List<String> myList = new ArrayList<>();
		
	}

	public static void printDistinct(int[] arr) {

		// Brute force approach.
		for (int i = 0; i < arr.length; i++) {

			boolean flag = false;

			for (int j = 0; j < i; j++) {

				if (arr[i] == arr[j]) {
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.print(arr[i] + " ");

		}
	}

}
