package arrayWork;

import java.util.Arrays;

public class SortArray1 {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 2, 0, 0, 1, 2, 2, 1 };

		System.out.println(Arrays.toString(sortArray(arr1)));
	}

	public static int[] sortArray(int[] ar) {

		// Create a temp array.
		int[] temp = new int[ar.length];
		int counter = 0, counter2 = 0;

		for (int i = 0; i < temp.length; i++) {
			if (ar[i] == counter) {
				temp[counter2] = ar[i];
				counter2++;
			}
		}
		// Increase the counter by 1.
		counter++;

		for (int i = 0; i < temp.length; i++) {
			if (ar[i] == counter) {
				temp[counter2] = ar[i];
				counter2++;
			}
		}
		counter++;

		for (int i = 0; i < temp.length; i++) {
			if (ar[i] == counter) {
				temp[counter2] = ar[i];
				counter2++;
			}
		}
		
		return temp;
	}

}
