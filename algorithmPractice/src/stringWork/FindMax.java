package stringWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMax {

	private static List<String> myList, holderList;
	private static Scanner myScanner;

	public static void main(String[] args) throws FileNotFoundException {

		myList = new ArrayList<>();


		File myFile = new File("/Users/tonyvierra/git/My-Repository/algorithmPractice/src/stringWork/wordFile.txt");
		myScanner = new Scanner(myFile);

		// Load this into our list.
		while(myScanner.hasNext())
			myList.add(myScanner.nextLine());

		// Find the longest lines.
		findLongest();
	}

	public static void findLongest() {

		holderList = new ArrayList<>();
		int max = 0, temp = 0 , temp2 = 0, max2 = 0;

		// Iterate through list.
		for (int i = 0; i < myList.size(); i++) {

			String tempString = new String(myList.get(i));

			if(max < tempString.length()) {
				max = tempString.length();
				temp = i;
			}
		}

		// Iterate again.
		for (int i = 0; i < myList.size(); i++) {

			String tempString = new String(myList.get(i));

			if(max2 < tempString.length() && max2 != max) {
				max2 = tempString.length();
				temp2 = i;
			}
		}
		System.out.println(myList.get(temp));
		System.out.println(myList.get(temp2));
	}

}














