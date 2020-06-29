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
	
	// private search function.
	private boolean search(Node r, int val)
	{
		// Define a flag first.
		boolean flag = false;
		
		while((r != null) && !flag)
		{
			int rval = r.getData();
			
			if(val < rval)
				r = r.getLeft();
			else if(val > rval)
				r = r.getRight();
			else {
				flag = true;
				break;
			}
			
			// Recursive call.
			flag = search(r, val);
		}
		
		// Finally return found.
		return flag;
	}
	
	// Count the number of nodes privately.
	private int countNodes(Node r)
	{
		if(r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}
	
	// Delete the node privately.
	private Node delete(Node r, int val)
	{
		// Create some temporary nodes.
		Node p, p2, n;
		
		if(r.getData() == val)
		{
			// Matching the value.
			Node ltNode, rtNode;
			
			ltNode = r.getLeft();
			rtNode = r.getRight();
			
			// Check for nulls.
			if(ltNode == null && rtNode == null)
			{
				return null;
			}
			else if(ltNode == null)
			{
				p = rtNode;
				return p;
			}
			else if(rtNode == null)
			{
				p = ltNode;
				return p;
			}
			else {
				p2 = rtNode;
				p = rtNode;
				
				while(p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(ltNode);
				
				return p2;
			}
			
		}
		
		// Another if.
		if(val < r.getData())
		{
			n = delete(r.getLeft(), val);
			r.setLeft(n);
		}
		else {
			n = delete(r.getRight(), val);
			r.setRight(n);
		}
		
		// Finally return the root.
		return r;
	}
	
	
	
	
	
	
	
	
	
	// Public delete method.
	public void delete(int val)
	{
		// Check if empty.
		if(isEmpty())
			System.out.println("Tree is empty");
		else if(search(val) == false)
			System.out.println("Value is not found in tree");
		else {
			r = delete(r, val);
			System.out.println(val + " deleted from the tree");
		}
	}
	
	
	// Count number of nodes function.
	public int countNodes()
	{
		return countNodes(r);
	}
	
	// Define the search function.
	public boolean search(int val)
	{
		return search(r, val);
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












