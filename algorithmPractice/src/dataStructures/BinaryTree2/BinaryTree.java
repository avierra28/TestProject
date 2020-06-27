package dataStructures.BinaryTree2;

public class BinaryTree
{
	/*
	 * This class will only contain the methods for the class.
	 */
	private Node r;
	
	public BinaryTree()
	{
		r = null;
	}
	
	// Define the isEmpty function.
	public boolean isEmpty()
	{
		return r == null;
	}
	
	// Private append function.
	private Node append(Node node, int k)
	{
		// Check if empty.
		if(node == null)
			node = new Node(k);
		else 
		{
			// Initiate the recursive strategy.
			if(k < node.getData())
				node.left = append(node.left, k);
			else
				node.right = append(node.right, k);
		}
		// Return the node.
		return node;
	}
	
	// Private inorder printing method.
	private void print(Node r)
	{
		if(r == null)
			return;
		else
		{
			print(r.getLeft());
			System.out.print(r.getData() + " ");
			print(r.getRight());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// The append method.
	public void append(int val)
	{
		// Call the private function.
		r = append(r, val);
	}
	
	// The print method.
	public void print()
	{
		// Call the private method.
		print(r);
	}
}












