package dataStructures.BinaryTree2;

import java.util.Scanner;

public class Driver {
	
	private static Scanner scanner;
	
	public static void main(String[] args)
	{
		// Create a new Binary tree object.
		BinaryTree binaryTree = new BinaryTree();
		scanner = new Scanner(System.in);
		boolean flag = true;
		
		while(flag)
		{
			int choice = mainMenu();
			
			switch(choice)
			{
			case 1:
			{
				System.out.print("Enter node to insert: ");
				binaryTree.append(scanner.nextInt());
				
				// Confirm the append.
				System.out.println("Node inserted.\n");
				break;
			}
			case 3:
			{
				System.out.println("\nCurrent tree: ");
				binaryTree.print();
				System.out.println("\n");
				
				break;
			}
			case 5:
			{
				flag = false;
				break;
			}
			}
		}
		
	}
	
	// Define the main menu.
	public static int mainMenu()
	{
		System.out.println("----------Main Menu----------");
		System.out.println("1.) Enter a node");
		System.out.println("2.) Delete a node");
		System.out.println("3.) Display the tree");
		System.out.println("4.) Get number of nodes in tree");
		System.out.println("5.) Quit");
		System.out.print("Your choice (1 - 5): ");
		int num = scanner.nextInt();
		
		while(num < 1 || num > 5)
		{
			System.out.print("Error. Enter again: ");
			num = scanner.nextInt();
		}
		return num;
	}

}
