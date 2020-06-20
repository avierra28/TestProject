package dataStructures.BinaryTree;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		
		Random random = new Random();
		Node n1 = new Node();
		
		for (int i = 0; i < 20; i++) {
			n1.append(random.nextInt(100) + 1);
		}
		
		n1.printTree();
		
	}

}
