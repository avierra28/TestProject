package dataStructures.LinkedList;

import java.util.Random;

public class ReverseList 
{
	private static Random random;
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
		random = new Random();
		
		Node obj1 = new Node(random.nextInt(100) + 1);
		Node obj2 = new Node(random.nextInt(100) + 1);
		obj1.nextNode = obj2;
		Node obj3 = new Node(random.nextInt(100) + 1);
		obj2.nextNode = obj3;
		Node obj4 = new Node(random.nextInt(100) + 1);
		obj3.nextNode = obj4;
		Node obj5 = new Node(random.nextInt(100) + 1);
		obj4.nextNode = obj5;
		Node obj6 = new Node(random.nextInt(100) + 1);
		obj5.nextNode = obj6;
		obj6.nextNode = null;
		// Display the list before the deletion of the end.
		
		display(obj1);
		reverseList(obj1);

	}
	
	public static void display(Node head)
	{
		Node tempNode = head;
		// for loop.
		while(tempNode.nextNode != null)
		{
			System.out.print(tempNode.key + " ");
			tempNode = tempNode.nextNode;
		}
		System.out.println(tempNode.key);
	}
	
	public static void reverseList(Node head)
	{
		Node tempNode = head, tempNode2 = head, holderNode = null;
		
		while(tempNode.nextNode != null)
		{
			holderNode = tempNode.nextNode;
			tempNode.nextNode = tempNode2;
			tempNode2 = tempNode;
			tempNode = holderNode;
		}
		holderNode.nextNode = tempNode2;
		head.nextNode = null;
		
		// Fix head.
		head = holderNode;
		
		System.out.println("\n");
		
		display(head);
	}

}











