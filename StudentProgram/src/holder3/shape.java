package holder3;


public class shape 
{
	protected String size, color;
	
	public shape() 
	{
		super();
	}

	public shape(String size, String color) 
	{
		super();
		this.size = size;
		this.color = color;
	}
	
	// Overall functions.
	public void description()
	{
		System.out.println("This is being called from the shape parent class.\n");
	}
	
}
