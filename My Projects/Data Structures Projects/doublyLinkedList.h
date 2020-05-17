/*
Created by: Anthony Vierra
Header file definition of the class MyVector.h
*/
#ifndef MYVECTOR_H
#define MYVECTOR_H
#include <iostream>
#include <iomanip>
#include <cstdlib>
using namespace std;

// Definition of the class myvector.
class MyVector
{
	// Under the private list is going to be our embedded struct.
private:
	struct Node
	{
		// Our members inside this struct.
		int value;
		Node *next;
	};
	// Then normal private members.
	Node *head, *tail;
	// End of private member declaration, on to the public functions.
public:
	// Constructor will initialize both head and tail to nullptr;
	MyVector()
	{
		tail = nullptr;
		head = nullptr;
	} 
	// Free memory in the tail and head.
	~MyVector()
	{
		Node *p = head;

		// Make a for loop and step through the array.
		while(p != nullptr)
		{
			head = head->next;
			delete p;
			p = head;
		}
		head = nullptr;
		tail = nullptr;
	}
	// Definition of the push_back function.
	void push_back(int i)
	{
		// Create a new node.
		Node *temp = new Node;
		static int counter = 0;

		// Assign the argument i to the data value.
		temp->value = i;

		// Check if theres more than one element in the list.
		if(head == nullptr)
		{
			head = temp;
			tail = temp;
			counter++;
		}
		else
		{
			// Assign the tail next to the temp first.
			tail->next = temp;
			// if theres more than one element in the list
			tail = temp;
			tail->next = nullptr;
			counter++;

			// If the counter is 2 then assign head to temp.
			if(counter == 2)
			{
				head->next = temp;
			}
		}
	}
	// Definition OF the pop_back function.
	void pop_back()
	{
		Node *temp = head, *prev = nullptr;

		if(head == nullptr)
			throw "EMPTY VECTOR";

		while(temp != tail)
		{
			prev = temp;
			temp = temp->next;
		}
		if(prev != nullptr)
		{
			prev->next = temp->next;
			tail = prev;
			delete temp;
		}
	}
	// Definition of the at function.
	int &at(int i)
	{
		// Throw out exceptions at the beginning of the function.
		if(head == nullptr)
			throw "EMPTY VECTOR";
		if(i < 0 || i > size())
			throw "OUT OF BOUNDS";

		// Dynamically allocate an array of the size function.
		Node *p = head;
		int counter = 0, *temp = new int;
		*temp = -1;
		
		// Set up a while loop.
		while(p != nullptr)
		{
			if(counter == i)
			{
				// Return the value thats inside.
				return p->value;
			}
			//  Increase the count value.
			counter++;
			// Move to the next node.
			p = p->next;
		}
		return *temp;
	}
	// Definition of the clear function.
	void clear()
	{
		// Create a temporary pointer.
		Node *s = head;

		// Set up a while loop to begin destruction of all the nodes.
		while(head->next != nullptr)
		{
			head = head->next;
			delete s;
			
			// Then assign s to head.
			s = head;
		}

		// Then assign head and tail back to nullptr.
		head = nullptr;
		tail = nullptr;
	}
	// Define the size function.
	int size()
	{
		// create a holder variable that will hold the size.
		int x = 0;
		Node *P = head;
		// Set up a while loop.
		while(P->next != nullptr)
		{
			// Increase the counter of x.
			x++;

			// Move to the next.
			P = P->next;
		}
		// Increase the counter one last time.
		x++;

		// Return the number.
		return x;
	}
	// Definition of the insert function.
	void insert(int pos, int i)
	{
		// Check for a positional error.
		if((pos > size()) || (pos <= 0))
			throw "ERROR OUT OF BOUNDS";
		// Create a temporary counter.
		//int counter = 0;

		// Create a temp node.
		Node *temp = new Node, *p, *q, *r;

		// Make temps value the actual argument being passed from the function.
		temp->value = i;

		// Then have this point to the very beginning.
		r = head;

		// going to the node just 1 short of the position.
		for(int i = 0; i < pos; i++)
		{
			// Store the node from pos - 1 into a holder.
			if(i == (pos - 1))
				p = r;
			if(i == pos)
				q = r;


			// Then move to the next position.
			r = r->next;
		}

		// Then as long as this isn't the end, the adding that to the value in question.
		if(temp != nullptr)
		{
			// Insert temp in between these two node.
			p->next = temp;
			temp->next = r;
		}
	}
	// Create an isFull function.
	bool isFull()
	{
		// Check to see if this function is going to be full.
		try
		{
			Node *p = new Node;
			delete p;
			return false;
		}
		catch(bad_alloc)
		{
			return true;
		}
	}
	bool isEmpty()
	{
		// Check to see if its empty.
		if(head == nullptr)
			return true;
		else
			return false;
	}
	// Define a find algorithm.
	void find(int key)
	{
		// Begin finding it.
		int counter = 0;
		Node *p = head;

		// While loop.
		while(p->next != nullptr)
		{
			if(p->value == key)
			{
				cout << "\nValue found at position " << counter << endl;

				return;
			}
			else
			{
				// Inrease the counter.
				counter++;

				// And advance to the next node.
				p = p->next;
			}

		}
		// If it exits and doesn't find it then its not in the loop.
		cout << "\nElement not found in the list." << endl;
	}

};

#endif



















