package arrayWork;

public class GoodPairs {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 1, 1, 3 }, nums2 = { 1, 1, 1, 1 }, nums3 = { 1, 2, 3 };

		System.out.println(findGood(nums));
		System.out.println(findGood(nums2));
		System.out.println(findGood(nums3));
	}

	public static int findGood(int[] n) {

		int count = 0;

		for (int i = 0; i < n.length; i++) {

			for (int j = 0; j < n.length; j++) {

				if (n[i] == n[j] && i < j)
					count++;
			}
		}

		return count;
	}

}
