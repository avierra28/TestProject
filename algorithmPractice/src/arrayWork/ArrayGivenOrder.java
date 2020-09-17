package arrayWork;

import java.util.LinkedList;

public class ArrayGivenOrder {

	public static void main(String[] args) {

		int[] nums = { 0, 1, 2, 3, 4 }, index = { 0, 1, 2, 2, 1 };

		System.out.println(insertArrayMethod(nums, index));
	}

	public static LinkedList<Integer> insertArrayMethod(int[] nums, int[] indexes) {

		LinkedList<Integer> myIntegers = new LinkedList<Integer>();

		for (int i = 0; i < indexes.length; i++) {
			myIntegers.add(-1);
		}

		for (int i = 0; i < indexes.length; i++) {

				myIntegers.add(indexes[i], nums[i]);
		}
		
		for (int i = 0; i < myIntegers.size(); i++) {
			if(myIntegers.get(i) == -1) {
				myIntegers.remove(i);
				i--;
			}
		}

		return myIntegers;
	}

}
