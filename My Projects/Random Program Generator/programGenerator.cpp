#include <iostream>
#include <fstream>
#include <string>
#include <ctime>
#include <iomanip>
#include <vector>
using namespace std;

// Define our main class.
class Production
{
public:
	// Define a vector string.
	vector<string> lhs;
	string mainString;
public:
	Production()
	{
		mainString = "";
	}
	// Begin our public member functions.
	void retrieveProg()
	{
		// Change the value into something.
		mainString += "int main() \n{\n" + getStat();
	}
	string getStat()
	{
		// Define our local variables within this function right here.
		int max_lim = 5, counter1 = 0, random;
		string result = "";

		// Test using a while loop.
		while(!lhs.empty())
		{
			random = rand() % 100 + 1;

			if(random <= 15 && counter1 < max_lim)
			{
				counter1++;
				lhs.back() += randomStat();
				lhs.push_back("");
			}
			else
			{
				lhs.back() += randomStat();
			}
			result += lhs.back();
			lhs.pop_back();
		}
		// Return the result.
		return result;
	}
	string randomStat()
	{
		// Define our local variables.
		string value;
		int random = rand() % 100 + 1;

		// Begin our if statements.
		if(random <= 10)
			value += getCMPD();
		if(random > 10 && random <= 20)
			value += getif_stat();
		if(random > 20 && random <= 30)
			value += getiter_stat();
		if(random > 30 && random <= 65)
			value += getassn_stat();
		if(random > 65 && random < 100)
			value += getdecl_stat();

		// Then finally return the value.
		return value;
	}
	string getCMPD()
	{
		string value;
		// Call back the random stat list function.
		value += getStat();

		// return the value.
		return value;
	}
	string getif_stat()
	{
		// Define the value variable.
		string value;

		// Random number.
		int random = rand() % 100 + 1;

		if(random < 10)
			value += "if(" +getExp()+ ")" + getStat();
		else if(random > 10 && random <= 25)
			value += "if(" +getExp()+ ")" + getCMPD();
		else if(random > 25 && random <= 40)
			value += "if(" +getExp()+ ")\n" + getStat() + " else\n" + getStat();
		else if(random > 40 && random <= 65)
			value += "if(" +getExp()+ ")\n" + getCMPD() + " else\n" + getStat();
		else if(random < 65 && random <= 80)
			value += "if(" +getExp()+ ")\n" + getStat() +" else\n" + getCMPD();
		else
			value += "if(" + getExp() + ")\n" + getExp() + "else\n" + getCMPD();

		// Then return the value.
		return value;
	}
	string getiter_stat()
	{
		// string value.
		string value;
		int random = rand() % 100 + 1;

		if(random <= 70)
			value += "while(" + getExp() + ")\n" + getStat();
		else
			value += "while(" + getExp() + ")\n" + getCMPD();

		return value;
	}
	string getassn_stat()
	{
		// Define our local string.
		string value;
		// Then start adding the syntactical things to it.
		value += getChar();
		value += string(" = ");
		value += getExp() + ";";
		return value;
	}
	string getdecl_stat()
	{
		string number, value;
		int random = rand() % 2;

		// if statements.
		if(random == 0)
		{
			value += getType();
			value += getDigits();
		}
		else
		{
			value += getType();
			value += getassn_stat();
		}

		return value;
	}
	string getExp()
	{
		string value;
		int counter = 0, max_lim = 5, random = rand() % 100 + 1;

		if(random <= 40 && counter < max_lim)
		{
			value += getExp();
			value += getOp();
			value += getExp();
			counter++;
		}
		else if(random > 40 && random <= 70)
			value += getchar_seq();
		else
			value += getDigits();

		return value;
	}
	string getchar_seq()
	{
		int number = 5;
		string value;

		// Add to the value a character.
		value = getChar();

		for(int i = 0; i < number; i++)
		{
			if((rand() % 2) == 1)
			{
				value += getChar();
			}
			else
			{
				value += getDigits();
			}
		}

		return value;
	}
	string getChar()
	{
		// Define our characters and append them to a string called alphabet.
		string alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// Get a random from this array.
		int random = rand() % 52;
		string temp = "";
		temp += alphabet[random];
		return temp;
	}
	string getType()
	{
		string value;

		int random = rand() % 2;

		if(random == 1)
			value = "int ";
		else
			value = "double ";

		return value;
	}
	string getOp()
	{
		int random = rand() % 4;
		string value;

		if(random == 0)
			value = " + ";
		else if(random == 1)
			value = " - ";
		else if(random == 2)
			value = " * ";
		else
			value = " / ";

		return value;
	}
	string getDigits()
	{
		string value;

		// Do a random number from 0 - 9.
		value = static_cast<char>((rand() % 9) + '0');

		return value;
	}
	string getdigit_seq()
	{
		int length = rand() % 10;
		length++;
		string value;

		for(int i = 0; i < length; i++)
			value += getDigits();

		return value;
	}
	string end()
	{
		return "\nreturn 0;\n}";
	}
	void showVector()
	{
		for(int i = 0; i < lhs.size(); i++)
			cout << lhs[i] << "\n";
	}
	string mainStr()
	{
		return mainString;
	}
};

// Define the main function.
int main()
{
	Production obj;
	// Generate a random number.
	int counter = 0;
	// Declare a file name.
	fstream myFile;
	myFile.open("program.txt", ios::out);

	srand(time(NULL));
	
	obj.retrieveProg();
	cout << obj.mainStr() << endl;
	myFile << obj.mainStr();
	
	// Now go through this a few times.
	while(counter < 7)
	{
		int x = rand() % 7 + 1;
		counter++;
		if(x == 1)
		{
			cout << obj.getif_stat() << endl;
			myFile << obj.getif_stat() << endl;
		}
		if(x == 2)
		{
			cout << obj.getiter_stat() << endl;
			myFile << obj.getiter_stat() << endl;
		}
		if(x == 3)
		{
			cout << obj.getassn_stat() << endl;
			myFile << obj.getassn_stat() << endl;
		}
		if(x == 4)
		{
			cout << obj.getdecl_stat() << endl;
			myFile << obj.getdecl_stat() << endl;
		}
		if(x == 5)
		{
			cout << obj.getType();
			cout << obj.getassn_stat() << endl;
		}
	}
	cout << obj.end();
	myFile << obj.end();
	

	cout << "\n\nPress any key to continue...";
	cin.get();

	return 0;
}





































