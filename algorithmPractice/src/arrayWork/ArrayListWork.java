package arrayWork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListWork {

	public static void main(String[] args) {

		ArrayList<String> myArrayList = new ArrayList<String>();
		Iterator<String> myIterator;
		
		myArrayList.add("California");
		myArrayList.add("Texas");
		myArrayList.add("Idaho");
		myArrayList.add("Washington");
		myArrayList.add("Oregon");
		
		myIterator = myArrayList.iterator();
		
		while(myIterator.hasNext()) {
			String tempString = myIterator.next();
			System.out.println(tempString);
		}
		
	}

}
