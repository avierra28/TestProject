package misc;

public class MatrixDiagonal {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
				matrix2 = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } }, matrix3 = { { 5 } },
				matrix4 = { { 4, 6, 7 }, { 2, 9, 4 }, { 5, 5, 5 } },
				matrix5 = { { 34, 57, 12, 89, 32, 56, 76 }, { 98, 89, 22, 66, 89, 100, 432 },
						{ 98, 89, 22, 66, 89, 100, 432 }, { 98, 89, 22, 66, 89, 100, 432 },
						{ 98, 89, 22, 66, 89, 100, 432 }, { 98, 89, 22, 66, 89, 100, 432 },
						{ 98, 89, 22, 66, 89, 100, 432 } };

		System.out.println(diagonalSum(matrix5));
	}

	public static int diagonalSum(int[][] matrix) {

		int count = 0, reverseCount = matrix[0].length - 1, runningTotal = 0;

		if (matrix.length == 1)
			return matrix[count][count];

		for (int i = 0; i < matrix.length; i++) {

			runningTotal += (matrix[count][count] + matrix[count][reverseCount]);

			if (matrix.length % 2 != 0 && count == reverseCount)
				if (matrix[count][count] == matrix[count][reverseCount])
					runningTotal -= matrix[count][count];

			count++;
			reverseCount--;
		}

		return runningTotal;
	}

}
