package dataStructures.Stack;

public class Stack {
	
	// Define attributes for the stack.
	static final int MAX = 1000;
	int top;
	int[] a = new int[MAX];
	
	public Stack()
	{
		// Create an empty stack.
		top = -1;
	}
	
	public boolean isEmpty()
	{
		return (top < 0);
	}
	
	public boolean push(int x)
	{
		if(top >= (MAX - 1))
		{
			System.out.println("Stack overflow!");
			return false;
		}
		else {
			a[++top] = x;
			System.out.println(x + " pushed onto the stack.");
			return true;
		}
		
	}
	
	public int pop()
	{
		if(top < 0)
		{
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			int x = a[top--];
			return x;
		}
	}
	
	public int peek()
	{
		if(top < 0)
		{
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			return a[top];
		}
	}
	

	public static void main(String[] args) {

		Stack stack = new Stack();
		
		stack.push(10);
		stack.push(45);
		stack.push(2);
		stack.push(78);
		stack.push(44);
		System.out.println(stack.peek());
		
	}

}









