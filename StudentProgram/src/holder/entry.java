package holder;

import java.util.ArrayList;
import java.util.Scanner;

public class entry implements DriverInterface
{
	private ArrayList<students> ourList;
	private Scanner scanner;
	
	
	
	// Create the constructor.
	public entry() 
	{
		ourList = new ArrayList<>();

        boolean flag1 = false;

        // Begin a while loop.
        while(true)
        {
            // Call the main menu function.
            int selection = mainMenu();

            switch(selection)
            {
                case 1:
                {
                    // Add student.
                    addStudent();
                    break;
                }
                case 2:
                {
                    // View students.
                    viewStudents();
                    break;
                }
                case 3:
                {
                	// Remove student function.
                	removeStudent();
                	break;
                }
                case 4:
                {
                    // Quit the program.
                    flag1 = true;
                }
            }

            // Check the quit flag.
            if(flag1)
                break;
        }
	}

	@Override
	public void viewStudents() 
	{
		// View everything.
        for(int i = 0; i < ourList.size(); i++)
        {
            System.out.print("\n----Entry #" + (i + 1) + "----\n" +
            "First name: " + ourList.get(i).getfName() + "\n" +
            "Last name: " + ourList.get(i).getlName() + "\n" +
            "Major: " + ourList.get(i).getMajor() + "\n" +
            "Age: " + ourList.get(i).getAge() + "\n\n");
        }
	}
	
	@Override
	public void removeStudent()
	{

		scanner = new Scanner(System.in);
    	// Remove selected student.
    	System.out.print("\nWhich student? (1 - " + ourList.size() + "): ");
    	int choice = scanner.nextInt();
    	// Check if thats valid.
    	if(choice < 1 || choice > ourList.size())
    	{
    		System.out.print("\nError, must be between (1 - " + ourList.size() + "): ");
    		choice = scanner.nextInt();
    	}
    	
    	// Now remove student.
    	ourList.remove(choice);
    	
    	System.out.println("Student removed. Going back to main menu.");
    			
	}
	
	@Override
	public int mainMenu() 
	{
		scanner = new Scanner(System.in);

        System.out.print("\n----------Main Menu----------\n");
        System.out.println("1.) Add Student");
        System.out.println("2.) View Students");
        System.out.println("3.) Remove Student");
        System.out.println("4.) Quit");
        System.out.print("Your choice (1 - 4): ");
        int choice = scanner.nextInt();

        while(choice < 1 || choice > 4)
        {
            System.out.println("*Error* Must be between 1 - 4: ");
            choice = scanner.nextInt();
        }
        
        return choice;
	}
	
	@Override
	public void addStudent()
	{
		scanner = new Scanner(System.in);
		
		System.out.println("Enter first name: ");
		String firstString = scanner.nextLine();
		System.out.println("Enter last name: ");
		String lastString = scanner.nextLine();
		System.out.println("Enter major: ");
		String ma = scanner.nextLine();
		System.out.println("Enter age: ");
		int ag = scanner.nextInt();
		
		// Create a new instance of students.
		students tempStudents = new students(firstString, lastString, ma, ag);
		
		ourList.add(tempStudents);
		
	}

}
