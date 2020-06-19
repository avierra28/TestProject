package dataStructures.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertBinary
{
	
	// Inner class declaration.
	static class Node
	{
		int key;
		Node nextNode;
		public Node(int temp)
		{
			this.key = temp;
		}
	}

	public static void main(String[] args)
	{
		// Add some elements.
		Node n1 = new Node(1);
		Node n2 = new Node(0);
		n1.nextNode = n2;
		Node n3 = new Node(1);
		n2.nextNode = n3;
		Node n4 = new Node(1);
		n3.nextNode = n4;
		Node n5 = new Node(1);
		n4.nextNode = n5;
		Node n6 = new Node(1);
		n5.nextNode = n6;
		
		System.out.println(getDecimalValue(n1));
	}
	
	public static int getDecimalValue(Node head) {
		
		Node tempNode = head;
		List<Integer> list = new ArrayList<Integer>();
		
		while(tempNode.nextNode != null)
		{
			list.add(tempNode.key);
			tempNode = tempNode.nextNode;
		}
		list.add(tempNode.key);
		int[] arr1 = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			arr1[i] = list.get(i); 
		}
		
		System.out.println(Arrays.toString(arr1));
		
		// Then we can start converting it to decimal.
		int temp = 0, j = 0;
		for (int i = arr1.length - 1; i >= 0; i--) {
			
			if(arr1[i] == 1)
			{
				temp += (Math.pow(2, j));
			}
			j++;
		}
		return temp;
	}

}













