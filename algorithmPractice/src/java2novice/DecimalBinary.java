package java2novice;

public class DecimalBinary {

	public static void main(String[] args) 
	{
		// Declare number.
		int num = 456;
		
		// Call function.
		binaryConversion(num);
		
	}
	
	public static void binaryConversion(int n)
	{
		int[] tempArray = new int[30];
		int counter = 0;
		
		while(n > 0)
		{
			// Fill our array.
			tempArray[counter++] = n % 2;
			n = n/2;
		}
		
		for (int i = counter; i >= 0; i--) 
			System.out.print(tempArray[i]);
		
	}

}
