package misc;


public class SwapVariables {

	public static void main(String[] args) {
		
		// Declare ints.
		int x = 10;
		int y = 30;
		
		System.out.println("Before Swap:");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		// Begin the swap.
		x = y + x;
		y = x - y;
		x = x - y;

		System.out.println("After swap (using math):");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

}
