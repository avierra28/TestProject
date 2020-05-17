#include <iostream>
#include <string>
using namespace std;


class HashTable
{
	// Begin to create our private struct.
private:
	/*
	For the mark:
	0 = unused.
	1 = deleted.
	2 = used.
	*/
	struct Element
	{
		string key;
		int mark;
	};
	Element *table;
	int size;

	// Define the hash function.
	int hash(string s)
	{
		int num = 0;

		// This function will return the index location of the formal
		// variable being passed in.
		for(int i = 0; i < s.length(); i++)
			num += s[i];
		num = num % size;
		return num;
	}
	// Then the public methods.
public:
	// Define the constructor.
	HashTable(int s)
	{
		table = new Element[s];
		size = s;
		clear();
	}
	~HashTable()
	{
		delete [] table;
	}
	void insert(string s)
	{
		if(isFull())
			return;
		else
		{
			// Create a variable to hold some values.
			int hi = hash(s);

			// Create a while loop.
			while(table[hi].mark == 2)
				hi = (hi + 1) % size;

			// Add this to the array.
			table[hi].key = s;
			table[hi].mark = 2;
		}
	}
	void remove(string s)
	{
		// Begin the process of removing.
		if(isEmpty())
			return;
		else
		{
			// Create the hi variable again.
			int hi = hash(s), count = 0;

			// Construct a while loop.
			while(count < size && table[hi].mark != 0)
			{
				// Then check if it matches the key.
				if(table[hi].key == s)
				{
					table[hi].mark = 1;

					// Break out of the loop.
					break;
				}

				// Else just increae the count.
				count++;
				hi = (hi + 1) % size;
			}
		}
	}
	bool find(string s)
	{
		// Check to see if a certain key is found.
		if(isEmpty())
			return false;
		else
		{
			// Use the hash function.
			int hi = hash(s), counter = 0;

			// Create a boolean flag as false.
			bool flag = false;

			while((table[hi].mark != 0) && (flag == false) && (counter < size))
			{
				if((table[hi].mark == 2) && (table[hi].key == s))
				{
					// Then we have found it mark the flag true.
					flag = true;	
				}

				// If not use the linear probing.
				hi = (hi + 1) % size;
				counter++;
			}

			// Then finally at the end return the boolean value.
			return flag;
		}
	}
	bool isFull()
	{
		cout << "\n\t";
		int count = 0;

		for(int i = 0; i < size; i++)
		{
			if(table[i].mark == 2)
				count++;
		}
		if(count == size)
			return true;
		else
			return false;
	}
	bool isEmpty()
	{
		cout << "\n\t";
		// Search and see if its empty.
		int count = 0;

		for(int i = 0; i < size; i++)
		{
			if(table[i].mark == 0 || table[i].mark == 1)
				count++;
		}

		// If count is the size then its empty.
		if(count == size)
			return true;
		else
			return false;
	}
	void clear()
	{
		for(int i = 0; i < size; i++)
			table[i].mark = 0;
	}
	void print()
	{
		// Print out key and the mark.
		for(int i = 0; i < size; i++)
		{
			cout << "\n\tKey: " << table[i].key;
			cout << "\n\tMark: " << table[i].mark;
		}
	}
};

int main()
{
	HashTable h(5);
	
	cout << h.isFull() << ", " << h.isEmpty() << endl;
	
	h.insert("Hello!");
	h.insert("Hello!");
	h.insert("How");
	h.insert("Are");
	h.insert("You?");
	h.print();
	h.remove("Hello!");
	h.remove("Hello!");
	h.print();
	
	cout << h.isFull() << ", " << h.isEmpty() << endl;

	cout << h.find("How") << ", " << h.find("Hello") << endl;
	cout << h.find("Dog") << endl;
	
	h.remove("Dog");
	h.print();
	h.clear();
	h.print();

	cout << "\n";
}