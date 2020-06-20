package dataStructures.BinaryTree;

public class BinaryTree {
	
	// Define our attributes for our class.
	private BinaryTree left, right;
	private Integer dataInteger;
	
	public BinaryTree()
	{
		super();
	}
	
	public BinaryTree(BinaryTree left, BinaryTree right, Integer dataInteger) {
		super();
		this.left = left;
		this.right = right;
		this.dataInteger = dataInteger;
	}

	public BinaryTree(Integer dataInteger) {
		super();
		this.dataInteger = dataInteger;
	}

	public BinaryTree getLeft() {
		return left;
	}


	public void setLeft(BinaryTree left) {
		this.left = left;
	}


	public BinaryTree getRight() {
		return right;
	}


	public void setRight(BinaryTree right) {
		this.right = right;
	}


	public Integer getDataInteger() {
		return dataInteger;
	}


	public void setDataInteger(Integer dataInteger) {
		this.dataInteger = dataInteger;
	}
	
	
	

}
