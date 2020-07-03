package arrayWork;

public class ReverseArray {

	public static void main(String[] args) {

		int[] arr1 = {5, 43, 21, 78, 3, 9}, arr2 = new int[arr1.length];
		int j = 0;
	
		for (int i = arr1.length - 1; i >= 0; i--) {
			
			arr2[j] = arr1[i]; 
			System.out.print(arr2[j]+ " ");
			j++;
		}
		
		
	}
	

}
