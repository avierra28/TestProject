package stringWork;

import java.util.*;

public class countOccurance 
{

	public static void main(String[] args)
	{
		// Give a string.
		String testString = "This is a testing string to count occurance";
		Scanner scan = new Scanner(System.in);
		
		// Enter which char.
		System.out.println("Enter a char for us to count occurance: ");
		String temp = scan.nextLine();
		
		// Pass through function.
		countOcc(testString, temp);
		
		scan.close();
	}
	
	public static void countOcc(String str, String ch)
	{
		int count = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == ch.charAt(0))
				count++;
			
		}
		
		System.out.println("There are(is) " + count + " occurance(s) of that char\n");
	}

}
