package leetcode;

import java.util.Arrays;

public class FinalPrices {

	public static void main(String[] args) {
		int[] prices = {8, 4, 6, 2, 3};
		
		System.out.println(Arrays.toString(getArray(prices)));
	}
	
	public static int[] getArray(int[] arr)
	{
		int [] tempArray = new int[arr.length];
		int counter = 0;
		
		for (int i = 0; i < tempArray.length; i++) {
			for (int j = i + 1; j < tempArray.length; j++) {
				if(arr[i] >= arr[j] && j > i)
				{
					tempArray[i] = arr[i] - arr[j];
					counter++;
					break;
				}
				else {
					tempArray[i] = arr[i];
					counter++;
					break;
				}
				
			}
			System.out.println(tempArray[i]);
		}
		return tempArray;
	}

}
