package mathWork;

public class ReverseNumber 
{

	public static void main(String[] args) 
	{
		// Declare integer.
		int num = 154;
		
		// Reverse the integer.
		reverseInt(num);
	}
	
	public static void reverseInt(int n)
	{
		int temp = 0;
		
		while(n > 0)
		{
			temp = (temp * 10) + (n % 10);
			n /= 10;
		}
		
		System.out.println(temp);
	}

}
