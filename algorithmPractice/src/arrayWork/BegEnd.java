package arrayWork;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BegEnd {

	public static void main(String[] args) {

		int[] array1 = {5,7,7,8,8,8,10};
		
		System.out.println(Arrays.toString(findPositions(array1, 6)));
	}
	
	public static int[] findPositions(int[] n, int num) {
		
		List<Integer> myIntegers = new LinkedList<Integer>();
		boolean flag = false;
		
		
		
		for (int i = 0; i < n.length; i++) {
			myIntegers.add(n[i]);
			
			if(n[i] == num)
				flag = true;

		}
		
		if(!flag)
			return new int[] {-1, -1};
		
		
		int[] temp = new int[2];
		flag = false;
		
		for (int i = 0; i < n.length; i++) {
			
			if(myIntegers.get(i) == num && flag == false) {
				temp[0] = i;
				myIntegers.remove(i);
				myIntegers.add(i, -5);
				flag = true;
				i--;
				continue;
			}
			
			if(myIntegers.get(i) == num && flag == true) {
				temp[1] = i;
				myIntegers.remove(i);
				myIntegers.add(i, -5);
				i--;
			}
		}
		
		return temp;
		
	}

}
