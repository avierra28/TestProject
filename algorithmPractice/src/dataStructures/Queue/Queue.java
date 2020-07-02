package dataStructures.Queue;

import java.util.NoSuchElementException;

public class Queue {

	private Node front, rear;
	public int size;

	public Queue() {
		front = null;
		rear = null;
		size = 0;
	}

	// Begin with other functions.
	public boolean isEmpty() {
		return front == null;
	}

	public int getSize() {
		return size;
	}

	public void insert(int data) {

		Node tempNode = new Node(data, null);

		if (rear == null) {
			front = tempNode;
			rear = tempNode;
		} else {
			rear.setNextNode(tempNode);
			rear = rear.getNextNode();
		}

		// Increase the size.
		size++;
	}

	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException("No such element.");
		return front.getData();
	}

	public void display() {
		
		System.out.println("Queue: ");
		if(size == 0)
		{
			System.out.print("Empty\n");
			return;
		}
		else {
			Node tempNode = front;
			
			while(tempNode != rear.getNextNode())
			{
				System.out.print(tempNode.getData() + " ");
				tempNode = tempNode.getNextNode();
			}
		}
		System.out.println();
	}

}










