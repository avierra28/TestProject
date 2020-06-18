package dataStructures.LinkedList;

import java.util.Stack;


public class IsPalindrome 
{
	static class Node
	{
		int key;
		Node nextNode;
		public Node(int temp)
		{
			this.key = temp;
		}
	}
	
	private static Stack<Node> myStack;
	
	public static void main(String[] args) 
	{
		myStack = new Stack<Node>();
		boolean flag = false;
		
		// Fill stack.
		Node o1 = new Node(20);
		Node o2 = new Node(21);
		Node o3 = new Node(50);
		Node o4 = new Node(21);
		Node o5 = new Node(20);
		
		myStack.push(o1);
		o1.nextNode = o2;
		myStack.push(o2);
		o2.nextNode = o3;
		myStack.push(o3);
		o3.nextNode = o4;
		myStack.push(o4);
		o4.nextNode = o5;
		myStack.push(o5);
		
		System.out.println(isPalindrome(o1));
	}
	
	public static boolean isPalindrome(Node head)
	{
		Node tempNode = head;
		
		while(tempNode.nextNode != null)
		{
			if(tempNode.key != myStack.pop().key) 
				return Boolean.FALSE;
			tempNode = tempNode.nextNode;
		}
		return Boolean.TRUE;
	}

}












