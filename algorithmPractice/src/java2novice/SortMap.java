package java2novice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMap {

	public static void main(String[] args) {
		
		// Define a hashmap.
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		
		// Add values.
		hashMap.put("String 3", 56);
		hashMap.put("String 21", 702);
		hashMap.put("String 89", 991);
		hashMap.put("String 32", 902);
		hashMap.put("String 1", 45);
		hashMap.put("String 82", 23);
		
		Set<Entry<String, Integer>> set = hashMap.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(set);
		
		
		// Sort by collections.
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
		{
			// Describe function to do the sorting.
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)
			{
				return (e2.getValue().compareTo(e1.getValue()));
			}
		});
		
		// Then syso it out.
		for(Map.Entry<String, Integer> entry: list)
			System.out.println(entry.getKey() + "==> " + entry.getValue());

	}

}







