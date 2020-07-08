package mathWork;

public class SumPrime {

	public static void main(String[] args) {

		// Check this.
		int count = 2;
		long total = 0;
		while(count < 1000)
		{
			if(isPrime(count))
				total += count;
			
			count++;
		}
		
		System.out.println(total);
	}
	
	public static boolean isPrime(int n) {
		
		boolean flag = true;
		
		// Check if n is a prime number.
		for (int i = 2; i < n; i++) {
			
			if(n % i == 0)
				flag = false;
				
		}
		
		return flag;
	}
}
