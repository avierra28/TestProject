package holder2;

public class Car 
{
	/*
	 * Define our attributes for the Car class.
	 */
	protected String make, color;
	protected int year, numWheels;
	
	// Normal Constructor.
	public Car()
	{
		this.make = "";
		this.color = "";
		this.numWheels = 0;
		this.year = 0;
	}
	
	// Overloaded constructor.
	public Car(String make, String color, int numWheels, int year) 
	{
		super();
		this.make = make;
		this.color = color;
		this.numWheels = numWheels;
		this.year = year;
	}

	
	/*
	 * Setters and getters.
	 */
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumWheels() {
		return numWheels;
	}

	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
