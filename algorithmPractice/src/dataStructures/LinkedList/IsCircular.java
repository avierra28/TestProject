package dataStructures.LinkedList;

import java.util.Random;

import dataStructures.LinkedList.MiddleElement.Node;


public class IsCircular {

	private static Random random;
	private static int counter;
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

	public static void main(String[] args) {

		random = new Random();
		counter = 0;

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
		Node obj7 = new Node(random.nextInt(100) + 1);
		obj6.nextNode = obj7;
		obj7.nextNode = null;
		// Display the list before the deletion of the end.

		//display(obj1);
		System.out.println(isCircular(obj1));
	}

	public static void display(Node head)
	{
		Node tempNode = head;
		// for loop.
		while(tempNode.nextNode != null)
		{
			counter++;
			System.out.print(tempNode.key + " ");
			tempNode = tempNode.nextNode;
		}
		System.out.println(tempNode.key);
		counter++;
	}

	public static boolean isCircular(Node head) {

		// Create temp.
		Node tempNode = head;
		boolean flag = false;

		if(head == null)
			return false;
		else {

			while(tempNode.nextNode != null || tempNode.nextNode == head)
			{
				tempNode = tempNode.nextNode;
				if(tempNode.nextNode == head)
				{
					flag = true;
					break;
				}

			}
			if(flag)
				return true;
			else {
				return false;
			}

		}
	}

}
















