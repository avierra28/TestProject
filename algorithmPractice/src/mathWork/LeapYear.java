package mathWork;

public class LeapYear {

	public static void main(String[] args) {
		
		if(leapYear(2012))
			System.out.println("This year is a leap year.");
		else {
			System.out.println("This year is not a leap year.");
		}

	}
	
	public static boolean leapYear(int year) {
		
		return ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0)));
		
	}

}
