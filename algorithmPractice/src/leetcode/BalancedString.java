package leetcode;

public class BalancedString {

	public static void main(String[] args) {
		
		String str1 = "RLRRLLRLRL";
		int count = 0, result = 0;
		
		for (int i = 0; i < str1.length(); i++) {
			
			if(str1.charAt(i) == 'R')
				count++;
			else if(str1.charAt(i) == 'L')
			{
				count--;
				
				if(count == 0)
					result++;
			}
		}
		
		System.out.println(result);
	}

}
