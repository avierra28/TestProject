package leetcode;

public class JewelsStones {

	public static void main(String[] args) {
		
		// Define the stones and jewels string.
		String stoneString = "ZZ", jewelString = "z";
		
		System.out.println(getJewels(jewelString, stoneString));

	}
	
	public static int getJewels(String j, String s) {
		
		int num = 0;
		
		for (int i = 0; i < j.length(); i++) {
			
			for (int k = 0; k < s.length(); k++) {
				
				if(j.charAt(i) == s.charAt(k))
					num++;
			}
		}
		
		
		return num;
	}

}
