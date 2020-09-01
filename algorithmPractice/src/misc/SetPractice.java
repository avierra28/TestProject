package misc;

import java.util.Hashtable;
import java.util.Map;

public class SetPractice {

	public static void main(String[] args) {
		String text1 = "HellothisistonyvierraandimworkingonthisstringhereHellotonyisim";
		gatherResults(text1);
	}

	public static void gatherResults(String str) {
		char[] charArray = str.toCharArray();
		
		Map<Character, Integer> myMap = new Hashtable<Character, Integer>();
		for (int i = 0; i < charArray.length; i++) {
			if (myMap.containsKey(charArray[i]))
				myMap.put(charArray[i], 1 + myMap.get(charArray[i]));
			else
				myMap.put(charArray[i], 1);

		}
		System.out.println(myMap);
	}

}
