package dataStructures.Queue;


public class Driver {

	public static void main(String[] args) {
		
		Queue myQueue = new Queue();
		
		myQueue.insert(10);
		myQueue.insert(15);
		myQueue.insert(67);
		myQueue.insert(3);
		
		myQueue.display();
	}

}
