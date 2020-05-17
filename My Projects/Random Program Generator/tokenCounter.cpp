/*
Created by: Anthony Vierra
*/
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <iomanip>
using namespace std;

//Each token has a type and points to the next token
class Token
{
private:
    string tok;
    int type;
    Token *next;
public:
    // Create a constructor to set out private members.
    Token(string tok, int type)
    {
        this->tok = tok;
        this->type = type;
        this->next = NULL;
    }
    // Then define a set function.
    void setNext(Token *t)
    {
        this->next = t;
    }
    // And our getters.
    string getToken()
    {
        return tok;
    }
    int getType()
    {
        return type;
    }
    Token *getNext()
    {
        return next;
    }
    /*
     Then this will be our display function that will display the
     different types of tokens on the display table.
     */
    void display()
    {
        cout << setw(10);
        switch (type)
        {
            case 2:
                cout << "Identifier ";
                break;
            case 3:
                cout << "Integer ";
                break;
            case 4:
                cout << "Real ";
                break;
            case 5:
                cout << "Special ";
                break;
            case 1:
                cout << "Keyword ";
                break;
        }
        cout << setw(15) << tok << endl;
    }
};


// Defining 
int KEYWORD = 1, IDENTIFIER = 2, INTEGER = 3, REAL = 4, SPECIAL = 5;


void process(fstream &file) 
{
	// Creating a char array to hold the actual string we will read from the file.
	const int MAX_LINE_SIZE = 256;
	char arr[MAX_LINE_SIZE];

	// These will be strings to hold the keywords and the special characters.
	string keywords[] = { "if", "then", "else", "begin", "end" }; 
	string space = " \t\n", special = "()[]+-=,;";

	// Define some variable for us later on in the program.
	int start;
	int type;
	string token;

	//counters for keyword, identifiers, integers, reals and special
	int cnt = 0, kcnt = 0, idcnt = 0, icnt = 0, rcnt = 0, scnt = 0;

	Token *first = NULL, *current, *temp;
	while (!file.eof()) 
	{

		//Read lines from the file and store it all in our array.
		if ((file.getline(arr, MAX_LINE_SIZE)) == 0)
			return;

		int i = 0;
		type = 0;
		start = 0;

		while (true) 
		{
			// This will check to see element i is a character.
			if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')) 
			{
				if (type == 0) 
				{
					type = IDENTIFIER;

					// Start will always be the start of where this occured.
					start = i;
				}
			}
			// Will check to see if element i is a digit.
			else if (arr[i] >= '0' && arr[i] <= '9') 
			{
				if (type == 0) 
				{
					type = INTEGER;
					start = i;
				}
			}
			// If the element is a real integer we know this by the decimal point '.'
			else if (arr[i] == '.') 
			{
				if (type == INTEGER)	
					type = REAL;
			}
			//If the character is one of the special characters
			else if (special.find(arr[i]) != string::npos) 
			{
				if (type == 0) 
				{
					type = SPECIAL;
					start = i;
				}
			}

			//Case: If at the end of the arr without finding a valid token
			if (type == 0 && arr[i] == '\0')
				break;


			/*
			1.) if the element in arr[i] DOES have a position thats in space.
			or
			2.) if the element in arr[i] is a special character.
			or
			3.) if arr[i] is a newline character.
			*/ 
			if ((space.find(arr[i]) != string::npos) || (special.find(arr[i]) != string::npos) || (arr[i] == '\0')) //found whitepace chars , check if got a token
			{

				if (type == 0) 
				{
					i++;
					continue;
				}

				// This means that if we've reached a space in our string, then iterate 
				// our if statement.
				if (type != SPECIAL) 
				{
					// Constructing our token and being sure not to include the delimiter.
					token = string(arr + start, i - start);
					bool kw = false;

					// Iterate 5 times for the 5 keywords stored in this string array.
					for (int j = 0; j < 5; j++) 
					{
						if (keywords[j].compare(token) == 0)
							kw = true;
					}
					// get all characters from recorded starting position till the delimiter
					// and creating a new Token with that token in it.
					temp = new Token(token, kw ? KEYWORD : type);
					// If its already empty or the list is empty.
					if (first == NULL)
						first = current = temp;
					else 
					{
						current->setNext(temp);
						current = temp;
					}
					start = i;
				}		
				// Then we will do the same thing if its any of the special characters.
				if (special.find(arr[i]) != string::npos) 
				{
					token = string(arr + start, 1);

					temp = new Token(token, SPECIAL);
					if (first == NULL)
						first = current = temp;
					else 
					{
						current->setNext(temp);
						current = temp;
					}
					start = i + 1;

				}
				type = 0;
			}

			if (arr[i] == '\0')
				break;

			// Increase our iterator at the end of the inner while loop.
			i++;
		}
	}

	//Display the summary
	cout << setw(10) << "Type" << setw(15) << "Token" << endl;
	cout << "=====================================" << endl;
	temp = first;
	while (temp != NULL) 
	{
		cnt++;
		switch (temp->getType()) 
		{
			case 1:
			{
				kcnt++;
				break;
			}
			case 2:
			{
				idcnt++;
				break;
			}
			case 3:
			{
				icnt++;
				break;
			}
			case 4:
			{
				rcnt++;
				break;
			}
			case 5:
			{
				scnt++;
			}
		}
		temp->display();
		temp = temp->getNext();
	}

	// Then display the counters one by one in a table format.
	cout << "=====================================" << endl;

	cout << "Found " << cnt << " tokens." << endl;
	cout << "Found " << kcnt << " keywords tokens." << endl;
	cout << "Found " << idcnt << " identifier tokens." << endl;
	cout << "Found " << icnt << " integer tokens." << endl;
	cout << "Found " << rcnt << " real tokens." << endl;
	cout << "Found " << scnt << " special tokens." << endl;
}

int main() 
{
	// Create a file to open it.
	fstream file;

	//open the input file
	file.open("program.txt", ios::in);

	/* if fopen( ) was not successful there was an error, so exit with error */
	if (!file.is_open())
	{
		cout << "Error opening input file";
		exit(1);
	}

	//Now continue reading the file till end of file reached/
	process(file);

	cout << "\n\nPress enter to exit...";
	cin.get();
	file.close();

	exit(0);
}
















