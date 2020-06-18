package leetcode;

public class EvenDigits {

	public static void main(String[] args) {

		int[] array1 = {555, 901, 482, 1771};
		
		System.out.println(findNumbers(array1));
	}
	
	public static int findNumbers(int[] arr) {
		
		int num = 0;
		
		// Start here.
		for (int i = 0; i < arr.length; i++) {
			int holder = 0;
			
			while(arr[i]> 0)
			{
				arr[i] /= 10;
				holder++;
			}
			
			if(holder % 2 == 0)
				num++;
		}
		
		// Return.
		return num;
	}

}
