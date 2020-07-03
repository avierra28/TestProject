package arrayWork;

import java.util.Arrays;
import java.util.Random;

public class SumZero {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(getArray(100)));
	}

	public static int[] getArray(int n) {

		//
		int[] arr = new int[n];

		if (n == 1) {
			arr[0] = 0;
			return arr;
		} else {
			
			Random random = new Random();
			int runningTotal = 0;
			
			while(true)
			{
				for (int i = 0; i < arr.length; i++) {
					
					arr[i] = random.nextInt(15 + 10) - 10;
				}
				
				for (int i = 0; i < arr.length; i++) {
					runningTotal += arr[i];
				}
				
				if(runningTotal == 0)
					break;
				else {
					runningTotal = 0;
				}
			}
			return arr;
		}
	}

}
