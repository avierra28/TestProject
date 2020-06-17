package java2novice;

public class TopTwoMax {

	public static void main(String[] args)
	{
		int[] array1 = {45, 32, 66, 78, 91, 33, 6, 3, 90, 100, 101};
		
		findMax(array1);
		
	}
	
	public static void findMax(int[] arr) {
		
		// Begin finding it.
		int max = 0, max2 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] > max)
			{
				max2 = max;
				max = arr[i];
			}
			if(max2 < arr[i] && arr[i]!= max)
				max2 = arr[i];
		}
		
		System.out.println("Max element: " + max + "\n"
				+ "Second max element: " + max2);
	}

}
