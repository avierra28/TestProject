package java2novice;

public class PerfectNumber {

	public static void main(String[] args)
	{
		int number = 33550336;
		
		// Call function.
		if(checker(number))
			System.out.println(number + " is a perfect number.");
		else {
			System.out.println(number + " is not a perfect number.");
		}
	}
	
	public static boolean checker(int n)
	{
		int i = 1, temp = 0;
		// Check on thus.
		while(i < n)
		{
			if(n % i == 0)
				temp += i;
			
			i++;
		}
		
		if(temp == n)
		{
			if(((temp + n) / 2) == n)
				return Boolean.TRUE;
			else {
				return Boolean.FALSE;
			}
		}
		else {
			return Boolean.FALSE;
		}
	}

}
