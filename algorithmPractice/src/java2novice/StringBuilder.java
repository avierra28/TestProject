package java2novice;

public class StringBuilder {

	public static void main(String[] args) {
		StringBuffer myBuffer = new StringBuffer();
		
		// Reverse string using built in stringbuilder
		String str1 = "This string will be reversed.";
		System.out.println(str1);
		myBuffer.append(str1);
		System.out.println(myBuffer.reverse());
	}

}
