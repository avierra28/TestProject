package arrayWork;

import java.util.ArrayList;

public class FindDuplicate {

	public static void main(String[] args) {

		ArrayList<Integer> myArrayList = new ArrayList<>();
		for (int i = 0; i < 40; i++) {
			myArrayList.add(i);
		}
		myArrayList.add(20);

		System.out.println(myArrayList);
		System.out.println("Repeated number: " + findDuplicate(myArrayList));
	}

	public static int findDuplicate(ArrayList<Integer> list) {

		boolean flag = false;
		int number = 0;

		// Start here
		for (int i = 0; i < list.size(); i++) {

			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(j) == list.get(i)) {
					flag = true;
					number = list.get(i);
					break;
				}
			}

			if (flag)
				break;

		}

		return number;
	}

}
