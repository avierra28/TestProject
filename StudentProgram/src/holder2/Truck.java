package holder2;

public class Truck extends Car
{
	// Overloaded constructor.
	public Truck(String make, String color, int numWheels, int year) 
	{
		super();
		this.make = make;
		this.color = color;
		this.numWheels = numWheels;
		this.year = year;
	}
	
	// Define methods unique to the truck.
	public String truckWheels()
	{
		return ("This truck has: " + numWheels + " wheels");
	}
	public String model()
	{
		return ("This truck is a(n)" + make);
	}
}
