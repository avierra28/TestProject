package arrayWork;

public class Triplets {

	public static void main(String[] args) {

		int[] arr = { 3, 0, 1, 1, 9, 7 }, arr2 = { 1, 1, 2, 2, 3 };

		findTriplets(arr2, 7, 2, 3);
	}

	public static void findTriplets(int[] arr, int a, int b, int c) {

		int count = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 1, k = i + 2;

			if (Math.abs(arr[i] - arr[j]) <= a || Math.abs(arr[j] - arr[k]) <= b || Math.abs(arr[i] - arr[k]) <= c)
				count++;
		}

		System.out.println(count);
	}
}
