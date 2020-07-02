package advancedDatastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparablePractice {

	public static void main(String[] args) {

		List<Student> myList = new ArrayList<>();
		
		myList.add(new Student("Tony", "Vierra", "CA", 29));
		myList.add(new Student("John", "Smith", "CA", 56));
		myList.add(new Student("Steve", "Joe", "TX", 16));
		myList.add(new Student("Bruce", "Wayne", "MI", 45));
		Collections.sort(myList);
		
		for (int i = 0; i < myList.size(); i++) {
			
			System.out.println(myList.get(i));
		}
	}

}
