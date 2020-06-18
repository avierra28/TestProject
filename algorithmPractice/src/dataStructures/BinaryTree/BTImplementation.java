package dataStructures.BinaryTree;

public class BTImplementation {

	// Define a BT variable.
	private static BinaryTree root;
	
	public static void main(String[] args) 
	{
		BTImplementation obj1 = new BTImplementation();
		
		// Add
		obj1.insert(50);
		obj1.insert(60);
		obj1.insert(40);
		obj1.insert(12);
		obj1.insert(34);
		obj1.insert(87);
		obj1.insert(39);
		obj1.insert(90);
		
		displayTree(root);
	}

	// Define an isempty.
	public boolean isEmpty(BinaryTree r)
	{
		if(r == null)
			return true;
		else {
			return false;
		}
	}
	
	// Define an add value.
	public void insert(Integer key)
	{
		// Check if empty.
		System.out.println("Inputing key:" + key);
		
		if(root == null)
		{
			// Meaning there is nothing in the tree.
			this.root = new BinaryTree(key);
			System.out.println(key + " inserted into the tree.");
		}
		else {
			// Call the other function to insert the node.
			insertNode(this.root, key);
			System.out.println(key + " inserted into the tree.");
		}
	}
	
	// Define insernode.
	public BinaryTree insertNode(BinaryTree r, Integer data)
	{
		// Create a holder node.
		BinaryTree tempBinaryTree = null;
		
		if(r.getDataInteger() >= data)
		{
			// Check to see if thats null.
			if(r.getLeft() == null)
			{
				// Create new instance.
				r.setLeft(new BinaryTree(data));
				return r.getLeft();
			}
			else {
				tempBinaryTree = r.getLeft();
			}
		}
		else {
			
			if(r.getRight() == null)
			{
				// Create new instance.
				r.setRight(new BinaryTree(data));
				return r.getRight();
			}
			else {
				tempBinaryTree = r.getRight();
			}
		}
		
		// Do recursive call.
		return insertNode(tempBinaryTree, data);
		
	}
	
	// Display the tree.
	public static void displayTree(BinaryTree r)
	{
		if(r != null)
		{
			displayTree(r.getLeft());
			System.out.println(r.getDataInteger());
			displayTree(r.getRight());
		}
	}
	
	
}

















