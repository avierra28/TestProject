package arrayWork;

import java.util.Arrays;

public class TargetArray {

	public static void main(String[] args) {
		// Create two arrays.
		int[] arr1 = { 0, 1, 2, 3, 4 }, arr2 = { 0, 1, 2, 2, 1 };

		// Pass this through.
		System.out.println(Arrays.toString(getArray(arr1, arr2)));
	}

	public static int[] getArray(int[] a1, int[] a2) {

		int[] temp = new int[a1.length];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i]= -1; 
		}
		
		for (int i = 0; i < temp.length; i++) {
			
			if(temp[a2[i]] != -1)
			{
				int position = a2[i];
				int[] temp2 = new int[temp.length - position];
				
				while(position < temp.length)
				{
					temp[position + 1] = temp[position];
					position++;
				}
			}
			temp[a2[i]] = a1[i]; 
		}
		return temp;
	}
}
