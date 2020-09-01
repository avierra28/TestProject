package misc;

import java.util.Vector;

public class VectorPractice {

	public static void main(String[] args) {

		Vector<String> myStrings = new Vector<String>();
		
		for (int i = 0; i < 100; i+=2) {
			myStrings.add(""+i);
		}
		
	}

}
