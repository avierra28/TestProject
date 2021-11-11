package misc;

import java.util.Hashtable;

public class ASCIIPrint {
	
	/*
	 * Ascii print out.
	 * Ascii print out2.
	 */

	public static void main(String[] args) {
		
		/*
		 * These will be just comments.
		 * 
		 */
		Hashtable<Integer, String> myHashtable = new Hashtable<Integer, String>();
		
		myHashtable.put(3, "This is pretty cool!");
		
		System.out.println(myHashtable);

		int counter = 0;
		char start = ' ';
		
		for (int i = (int)start; i <= 126; i++) {
			System.out.print((char)i + " ");
			counter++;
			
			if(counter % 16 == 0) 
				System.out.println();
		}
	}

}
