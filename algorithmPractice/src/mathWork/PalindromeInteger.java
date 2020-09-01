package mathWork;

public class PalindromeInteger {

	public static void main(String[] args) {

		int num = 15451;
		
		System.out.println(reverseInt(num));
	}
	
	public static int reverseInt(int n) {
		
		int temp = 0, holder = n;
		
		while(holder > 0)
		{
			temp = (temp * 10) + (holder % 10);
			holder = holder/10;
		}
		
		
		if(temp == n)
			System.out.println("Integer is a palindrome");
		else {
			System.out.println("Integer is not a palindrome");
		}
		return temp;
	}

}
