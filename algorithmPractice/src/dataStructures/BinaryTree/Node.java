package dataStructures.BinaryTree;

public class Node {
	
	// Set our properties for our binary tree.
	private int data;
	private Node left, right, root;
	
	
	public Node(int data) {
		super();
		this.data = data;
	}

	public Node() {
		super();
	}
	

	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node(int data, Node left, Node right, Node root) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
		this.root = root;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	private void append(Node r, int key)
	{
		// r being the constantly updated root using recursion.
		if(r == null)
		{
			// Create a new object.
			r = new Node(key, null, null);
		}
		else if(key < r.getData())
			append(r.getLeft(), key);
		else {
			append(r.getRight(), key);
		}
	}
	
	/*
	 * Print method.
	 */
	private void print(Node r)
	{
		// In-order method.
		if(r == null)
			return;
		else {
			print(r.getLeft());
			System.out.println(r.getData());
			print(r.getRight());
		}
	}
	
	public void printTree()
	{
		print(root);
	}
	
	public void append(int v)
	{
		// Call the private method.
		append(root, v);
	}
	
	
	
}

















