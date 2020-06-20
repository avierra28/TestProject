package arrayWork;

public class ProductDifference {

	public static void main(String[] args) {

		int[] nums = {1, 5, 4, 5};
		
		System.out.println(number(nums));
	}
	
	public static int number(int[] arr) {
		
		int max = 0, temp = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i + 1; j <= arr.length - 1; j++) {
				
				if(max < (arr[i] * arr[j]))
				{
					max = arr[i] * arr[j];
					temp = (arr[i] - 1) * (arr[j]- 1);
				}
			}
		}
		
		// Return the temp.
		return temp;
	}

}
