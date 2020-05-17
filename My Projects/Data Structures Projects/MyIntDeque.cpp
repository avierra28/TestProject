// The driver for the header file.

#include <iostream>
#include "solution.h"
using namespace std;

void systemClear()
{
	system("clear");
}

void mainMenu(int &choice)
{
	systemClear();

	cout << "\n\t------------Main Menu------------";
	cout << "\n\t1.) Push an element to the front";
	cout << "\n\t2.) Push an element to the back";
	cout << "\n\t3.) Pop from the back";
	cout << "\n\t4.) Pop from the front";
	cout << "\n\t5.) Display the list";
	cout << "\n\t6.) Get the length of the dequeue";
	cout << "\n\t7.) Quit";
	cout << "\n\tYour choice (1-7): ";
	cin >> choice;

	while(choice < 1 || choice > 7)
	{
		cout << "\n\t*Error must be 1-7: ";
		cin >> choice;
	}

	systemClear();
}

// Create the main function.
int main()
{
	systemClear();
	int size, selection;
	char again = 'y';

	// Create an instance of the class.
	MyIntDeque v(10);

	while(tolower(again) == 'y')
	{
		// Call the main menu function.
		mainMenu(selection);

		// Begin our switch statement to start testing this.
		switch(selection)
		{
			case 1:
			{
				int temp;

				cout << "\n\tEnter the value you want to input: ";
				cin >> temp;

				// Pass through the function.
				v.push_front(temp);
				cin.ignore();

				// Show the array.
				cout << "\n\t";
				v.showArray();

				cout << "\n\tPress enter to continue...";
				cin.get();

				break;
			}
			case 2:
			{
				int temp;

				cout << "\n\tEnter the value to push to the back: ";
				cin >> temp;

				v.push_back(temp);
				cin.ignore();

				// Show the array.
				cout << "\n\t";
				v.showArray();

				cout << "\n\tPress enter to continue...";
				cin.get();

				break;
			}
			case 3:
			{
				if(v.isEmpty())
				{
					cout << "\n\tArray already empty.";

					break;
				}
				cout << "\n\tPopping from the back...";

				// Ignore a line.
				cin.ignore();

				v.pop_back();
				// Show the array.
				cout << "\n\t" ;
				v.showArray();
				cout << "\n\tPress enter to go back to the main menu...";
				cin.get();

				break;
			}
			case 4:
			{
				if(v.isEmpty())
				{
					cout << "\n\tArray already empty.";

					break;
				}
				cout << "\n\tPopping from the front...";
				cin.ignore();

				v.pop_front();
				cout << "\n\t" ;
				v.showArray();
				cout << "\n\tPress enter to go back to the main menu...";
				cin.get();

				break;
			}
			case 5:
			{
				// Display the list.
				cout << "\n\t";
				v.showArray();
				cin.ignore();
				cout << "\n\tPress enter to advance...";
				cin.get();

				break;
			}
			case 6:
			{
				// Grab the size.
				cout << "\n\tThe length of our dequeue is: " << v.size();
				cin.ignore();

				cout << "\n\tPress enter to go back...";
				cin.get();

				break;
			}
			case 7:
			{
				systemClear();
				cin.ignore();

				cout << "Closing program...";
				cout << "\nPress enter to exit...";
				cin.get();

				exit(0);
			}
		}
	}
}












