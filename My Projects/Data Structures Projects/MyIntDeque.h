/*
Created by: Anthony Vierra
*/

#include <iostream>
#ifndef MYINTDEQUE_H
#define MYINTDEQUE_H
using namespace std;

// Create the definition for the class.
class MyIntDeque
{
	// Begin by creating the private member of this function.
private:
	int *list, cap, length, first, last;
public:
	// Constructor.
	MyIntDeque(int s)
	{
		cap = s;
		list = new int[s];
		length = 0;
	}
	~MyIntDeque()
	{
		// Delete the list.
		delete [] list;
	}
	void push_back(int i)
	{
		int temp;

		// Check if its full.
		if(isFull())
			return;
		else
		{
			if(length == 0)
			{
				// Assign it to the first node.
				last = 0;
				first = 0;
				list[0] = i;

				// Increase the length by 1.
				length++;
				return;
			}
			list[(last + 1) % cap] = i;

			// Increase the length of the list now by 1.
			length++;

			// Do our push back here.
			last = (last + 1) % cap;

		}
	}
	void push_front(int i)
	{
		// Declare a boolean value.
		static bool flag = false;

		if(isFull())
			return;
		else
		{
			// This function will push an integer at the front of the queue.
			if(length == 0)
			{
				list[0] = i;
				first = 0;
				last = 0;

				// Increase the length by 1.
				length++;

				// Return back to the main function.
				return;
			}
			// Assign first to cap.
			if(flag == false)
			{
				first = cap;

				// Turn it back to true.
				flag = true;
			}

			// Now if the length is not 0;
			list[(first - 1) % cap] = i;

			// Increase the length.
			length++;

			// Assign this new index location to the front.
			first = (first - 1) % cap;
		}
	}
	void pop_back()
	{
		// Check to see if its empty.
		if(isEmpty())
			return;
		else
		{
			// Create a holder int.
			int temp = last;

			// Delete the temp and assign end one lest.
			list[temp] = 0;

			// Decrease the last by 1.
			last = ((last + cap) - 1) % cap;

			// Decrease the length by 1.
			length--;
		}
	}
	void pop_front()
	{
		// Check to see if its empty.
		if(isEmpty())
			return;
		else
		{
			// Create a holder.
			int temp = first;

			// Delete the front.
			list[temp] = 0;

			// Then re assign first to the new first.
			first = ((first + cap) + 1) % cap;

			// Decrease the length.
			length--;
		}
	}
	int size()
	{
		return length;
	}
	int front()
	{
		if(!isEmpty())
			return list[first];
		else
			return -1;
	}
	int back()
	{
		if(!isEmpty())
			return list[last];
		else
			return -1;
	}
	void clear()
	{
		for(int i = 0; i < length; i++)
			list[i] = 0;
	}
	bool isEmpty()
	{
		// Check to see if the queue is empty.
		if(length == 0)
			return true;
		else
			return false;
	}
	bool isFull()
	{
		// Check to see if the queue is full.
		if(length == (cap - 1))
			return true;
		else
			return false;
	}
};

#endif






















