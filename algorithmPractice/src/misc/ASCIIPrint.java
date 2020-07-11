package misc;

public class ASCIIPrint {
	
	/*
	 * Ascii print out.
	 */

	public static void main(String[] args) {

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
