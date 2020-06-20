package dataStructures.BinaryTree;


public class RangeSum {

	public static void main(String[] args) {
		BTImplementation btImplementation = new BTImplementation();
		BinaryTree bTree = new BinaryTree(20);
		
		btImplementation.insert(13);
		btImplementation.insert(3);
		btImplementation.insert(7);
		btImplementation.insert(5);
		btImplementation.insert(19);
		btImplementation.insert(24);
		btImplementation.insert(18);
		btImplementation.insert(30);
		
		// Get sum of left.
		BTImplementation.displayTree(bTree);
	}
	
//	public static int sumLeft(BinaryTree r) {
//		
//		
//		
//	}

}
