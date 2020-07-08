package arrayWork;

import java.util.Arrays;

public class CloseToZero {

	public static void main(String[] args) {

		int[] array1 = {1,3,-5,7,8,20,-40,6};
		
		// Call the function.
		getSum(array1);
	}
	
	public static void getSum(int[] array1) {
		
		//
		int min = 100;
		int[] temp = new int[2];
		
		for (int i = 0; i < array1.length-1; i++) {
			for (int j = i + 1; j < array1.length; j++) {
				if((array1[i]+array1[j]) < min)
				{
					min = array1[i]+array1[j];
					temp[0] = array1[i];
					temp[1] = array1[j];
				}
			}
		}
		
		// Display the array.
		System.out.println(Arrays.toString(temp));
	}

}
