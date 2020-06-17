package java2novice;

public class stringcount 
{

	public static void main(String[] args) 
	{
		// Declare the string.
		String string = new String("there is a quiet mouse");
		
		// Call the function.
		countFunction(string);

	}
	
	public static void countFunction(String str)
	{
		int vowel = 0, cons = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == ' ')
				continue;
			else 
			{
				if(str.charAt(i) == 'a' || str.charAt(i) == 'A' ||
						str.charAt(i) == 'e' || str.charAt(i) == 'E' ||
						str.charAt(i) == 'i' || str.charAt(i) == 'I' ||
						str.charAt(i) == 'o' || str.charAt(i) == 'O' ||
						str.charAt(i) == 'u' || str.charAt(i) == 'U')
					vowel++;
				else {
					cons++;
				}
			}
		}
		
		// Print it out.
		System.out.println("Vowels: " + vowel + "\n" +
		"Consenants: " + cons);
		
	}

}
