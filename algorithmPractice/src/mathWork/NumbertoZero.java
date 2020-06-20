package mathWork;

public class NumbertoZero 
{

	public static void main(String[] args) 
	{
		// Start out with an integer.
		int num = 14;
		
		// Call the function.
		System.out.println(numCount(num));
	}
	
	public static int numCount(int n)
	{
		// Declare a temporary integer and some counters.
		int numofSteps = 0;
		
		// While loop.
		while(n > 0)
		{
			// Do this as long as n is greater than zero.
			if(n % 2 == 0)
			{
				// Meaning even. Divide by half.
				n /= 2;
				numofSteps++;
				continue;
			}
			else
			{
				// Meaning its odd. Minus it by 1.
				n -= 1;
				numofSteps++;
				continue;
			}
		}
		
		// Return the number of steps.
		return numofSteps;
	}
}
