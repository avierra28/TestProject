package mathWork;

public class MiddleIndex {

	public static void main(String[] args) {

		int[] num = { 3,4,5,4,3 };
		
		System.out.println("Array index would be: " + findIndex(num));
		
	}
	
	public static int findIndex(int[] arr) {
		
		//
		int index = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int sum1 = 0, sum2 = 0;
			
			for (int j = i + 1; j < arr.length; j++) {
				sum1 += arr[j];
			}
			
			for (int j = 0; j < i; j++) {
				sum2 += arr[j];
			}

			if(sum1 == sum2)
				index = i;
			
		}
		
		return index;
	}

}
