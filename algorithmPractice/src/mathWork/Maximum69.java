package mathWork;


public class Maximum69 {

	public static void main(String[] args) {
		
		// Declare num
		int num = 6996;
		
		System.out.println(maxNum(num));
	}
	
	public static int maxNum(int n)
	{
		// Declare temp number.
		int p = 0;
		
		for(int i = 1; i <= n; i *= 10)
		{
			if((n / i) % 10 == 6)
				p = i;
		}
		return n += p * 3;
	}

}
