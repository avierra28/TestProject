package stringWork;

public class ReverseString 
{
	private static String masterString;
	
	public static void main(String[] args) 
	{
		masterString = "";
		
		// Declare string.
		String str1 = new String("This is an example string.");

		System.out.println(reverseString(str1));
	}
	
	// Declare function to reverse.
	public static String reverseString(String str)
	{
		if(str.length() == 1)
			return str;
		else {
			masterString += str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
					
			return masterString;
		}
	}

}
