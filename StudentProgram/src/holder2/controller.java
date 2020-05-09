package holder2;

import java.util.ArrayList;
import java.util.Scanner;

public class controller 
{
	private ArrayList<Car> carList;
	private ArrayList<Truck> truckList;
	private Scanner scanner;
	
	// Create out constructor.
	public controller() 
	{
		carList = new ArrayList<>();
		truckList = new ArrayList<>();
		boolean flag1 = false;
		
		// Begin with our program.
		while(true)
		{
			int selection = mainMenu();
			
			// If else block.
			if(selection == 1)
				addCar();
			else if(selection == 2)
				addTruck();
			else if(selection == 3)
				viewCar();
			else if(selection == 4)
				viewTruck();
			else {
				flag1 = true;
			}
			
			if(flag1)
				break;
		}
		
		// Close the scanner.
		scanner.close();
	}
	
	public int mainMenu()
	{
		scanner = new Scanner(System.in);

        System.out.print("\n----------Main Menu----------\n");
        System.out.println("1.) Add Car");
        System.out.println("2.) Add Truck");
        System.out.println("3.) View Car(s)");
        System.out.println("4.) View Truck(s)");
        System.out.println("5.) Quit");
        System.out.print("Your choice (1 - 5): ");
        int choice = scanner.nextInt();

        while(choice < 1 || choice > 5)
        {
            System.out.println("*Error* Must be between 1 - 5: ");
            choice = scanner.nextInt();
        }
        
        return choice;
	}

	public void addCar()
	{
		scanner = new Scanner(System.in);
		
		System.out.println("Enter make: ");
		String firstString = scanner.nextLine();
		System.out.println("Enter color: ");
		String lastString = scanner.nextLine();
		System.out.println("Enter number of wheels: ");
		int ma = scanner.nextInt();
		System.out.println("Enter year: ");
		int ag = scanner.nextInt();
		
		// Create a new instance of students.
		Car tempCar = new Car(firstString, lastString, ma, ag);
		
		carList.add(tempCar);
	}
	
	public void addTruck()
	{
		scanner = new Scanner(System.in);
		
		System.out.println("Enter make: ");
		String firstString = scanner.nextLine();
		System.out.println("Enter color: ");
		String lastString = scanner.nextLine();
		System.out.println("Enter number of wheels: ");
		int ma = scanner.nextInt();
		System.out.println("Enter year: ");
		int ag = scanner.nextInt();
		
		// Create a new instance of students.
		Truck tempTruck = new Truck(firstString, lastString, ma, ag);
		
		truckList.add(tempTruck);
	}
	
	public void viewTruck()
	{
		// View everything.
        for(int i = 0; i < truckList.size(); i++)
        {
            System.out.print("\n----Entry #" + (i + 1) + "----\n" +
            "Make : " + truckList.get(i).getMake() + "\n" +
            "Color : " + truckList.get(i).getColor() + "\n" +
            "Number of wheels: " + truckList.get(i).getNumWheels() + "\n" +
            "Year: " + truckList.get(i).getYear() + "\n\n");
            
            System.out.print("Truck specific functions: \n" + 
            truckList.get(i).truckWheels() + "\n" + truckList.get(i).model() + "\n");
        }
	}
	
	public void viewCar()
	{
		// View everything.
        for(int i = 0; i < carList.size(); i++)
        {
            System.out.print("\n----Entry #" + (i + 1) + "----\n" +
            "Make : " + carList.get(i).getMake() + "\n" +
            "Color : " + carList.get(i).getColor() + "\n" +
            "Number of wheels: " + carList.get(i).getNumWheels() + "\n" +
            "Year: " + carList.get(i).getYear() + "\n\n");
        }
	}



}

