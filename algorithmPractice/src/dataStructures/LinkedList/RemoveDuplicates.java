package dataStructures.LinkedList;


public class RemoveDuplicates
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
		// Declare Node elements.
		Node ob1 = new Node(3);
		Node ob2 = new Node(6);
		ob1.nextNode = ob2;
		Node ob3 = new Node(6);
		ob2.nextNode = ob3;
		Node ob4 = new Node(19);
		ob3.nextNode = ob4;
		Node ob5 = new Node(21);
		ob4.nextNode = ob5;
		Node ob6 = new Node(21);
		ob5.nextNode = ob6;
		Node ob7 = new Node(80);
		ob6.nextNode = ob7;
		Node ob8 = new Node(80);
		ob7.nextNode = ob8;
		
		// Display.
		display(ob1);
		
		// Remove duplicates.
		removeDuplicate(ob1);
		
	}
	
	public static void display(Node head)
	{
		Node tempNode = head;
		
		while(tempNode.nextNode != null)
		{
			System.out.print(tempNode.key + " ");
			tempNode = tempNode.nextNode;
		}
		System.out.print(tempNode.key);
	}
	
	public static void removeDuplicate(Node head)
	{
		Node tempNode1 = head;
		
		while(tempNode1.nextNode != null)
		{
			if(tempNode1.key == tempNode1.nextNode.key)
			{
				if(tempNode1.nextNode.nextNode == null)
				{
					tempNode1.nextNode = null;
					break;
				}
				tempNode1.nextNode = tempNode1.nextNode.nextNode;
			}
			
			// Advance to the next node.
			tempNode1 = tempNode1.nextNode;
		}
		
		System.out.println("\n");
		display(head);
	}

}












