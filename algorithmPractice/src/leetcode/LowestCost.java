package leetcode;

public class LowestCost {

	public static void main(String[] args)
	{
		// Declare a two dimensional array.
		int[][] data = { {259, 770},
						{448, 54},
						{926, 667},
						{184, 139},
						{840, 118},
						{577, 469} };
						
		
		// Call the function.
		System.out.println(getCost(data));
		
	}
	
	public static int getCost(int[][] arr)
	{
		int total = 0;
		
		// Iterate over the 2d array.
		for (int i = 0; i < arr.length; i++) 
			if(arr[i][0] > arr[i][1])
				total += arr[i][1];
			else
				total += arr[i][0];
			
		return total;
	}

}
