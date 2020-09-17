package stringWork;

public class ShuffleString {

	public static void main(String[] args) {

		String string = "codeleet";
		int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
		
		System.out.println(Shuffle(string, indices));
	}
	
	public static String Shuffle(String s, int[] n) {
		
		String tempString = "";
		
		for (int i = 0; i < n.length; i++) {
			tempString += "x";
		}
		
		char[] temp = tempString.toCharArray();
		
		for (int i = 0; i < n.length; i++) {
			temp[n[i]] = s.charAt(i);
		}
		
		tempString = String.valueOf(temp);
		
		return tempString;
	}

}
