package misc;

public class PowerOfFour {

	public static void main(String[] args) {

		int x = 1296;
		
		System.out.println(isPower(x));
	}
	
	private static boolean isPower(int num) {
		return Math.pow(num, .25) % 1 == 0;
	}

}
