package arrayWork;

import java.util.Arrays;

public class RunningSum {

	public static void main(String[] args) {

		int[] array1 = {1, 1, 1, 1, 1};
		
		// Print out return array.
		System.out.println(Arrays.toString(getSum(array1)));
	}
	
	public static int[] getSum(int[] arr) {
		
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			
			if(i == 0)
			{
				temp[i] = arr[i];
				continue;
			}
				
			temp[i] = temp[i - 1] + arr[i]; 
		}
		return temp;
	}
	

}
