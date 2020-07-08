package arrayWork;

import java.util.Arrays;

public class SortArray2 {

	public static void main(String[] args) {

		int[] arr1 = { 12, 17, 70, 15, 22, 65, 21, 90 };

		System.out.println(Arrays.toString(sortArray(arr1)));
	}

	public static int[] sortArray(int[] ar) {

		int[] temp = new int[ar.length];
		int counter = 0;

		for (int i = 0; i < temp.length; i++) {
			if(ar[i] % 2 == 0) {
				temp[counter] = ar[i];
				counter++;
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			if(ar[i] % 2 != 0)
			{
				temp[counter]= ar[i];
				counter++;
			}
		}
		
		return temp;
	}

}
