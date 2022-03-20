package misc;

/*
 * Singleton class means you can only have one object at any given time for the class
 * by making the constructor as private and static.
 */
public class Singleton 
{
	private static Singleton obj1;
	
	private Singleton()
	{
		// Fill in code here..
	}
	
	static
	{
		obj1 = new Singleton();
	}
	
	public static Singleton getObject()
	{
		return obj1;
	}
	
	public static void testoutput()
	{
		System.out.println("Hello world!!\n");
	}

	public static void main(String[] args) 
	{
		Singleton obj1 = getObject();
		obj1.testoutput();
		
	}

}
