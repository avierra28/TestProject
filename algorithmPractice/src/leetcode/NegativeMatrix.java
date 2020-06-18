package leetcode;

public class NegativeMatrix {

	public static void main(String[] args) {

		int[][] matrix1 = {{4, 3, 2, -1},
				{3, 2, 1, -1},
				{1, 1, -1, -2},
				{-1, -1, -2, -3}};
		int[][] matrix2 = {{5, 1, 0}, {-5, -5, -5}};

		// Find number of negatives.
		System.out.println(getNumber(matrix2));

	}
	
	public static int getNumber(int[][] grid) {
		
		int num = 0;
		
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] < 0)
					num++;
			}
			
		}
		
		// Return the num.
		return num;
	}
}

