package arrayWork;

import java.util.Arrays;

public class XorOperation {

	public static void main(String[] args) {
		
		System.out.println(bitwiseXOR(4, 0));
	}
	
	public static int bitwiseXOR(int n, int start) {
		
		int[] nums = new int[n];
		
		for (int i = start; i < nums.length; i++) {
			nums[i] = start + (2 * i);
		}
		
		System.out.println(Arrays.toString(nums));
		
		
		
		return 0;
	}

}
