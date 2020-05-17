/*
Created by: Anthony Vierra
*/
#ifndef HEAPQUEUE_H
#define HEAPQUEUE_H
#include <iostream>
using namespace std;

// Begin by defining the class.
class HeapQueue
{
private:
	int *heap, size, bottom;

	// The function definining the re heap up to rebuild the head.
	void ReHeapUp()
	{
		// Create a temporary variable to hold the bottom variable.
		int temp1 = bottom;

		while(temp1 != size)
		{
			int temp2 = (temp1 - 1) / 2;

			if(heap[temp1] > heap[temp2])
				swap(heap[temp2], heap[temp1]);

			// Then swap assignment statements with p and i.
			temp1 = temp2;
		}
	}
	void ReHeapDown()
	{
		// Define the reheapdown function.
		int p = 0;

		while(true)
		{
			// Create a bc variale to hold our biggest child.
			int bc, lc = (2 * p) + 1, rc = (2 * p) + 2;

			if(lc > bottom)
				return;

			if(rc <= bottom)
			{
				if(heap[lc] > heap[rc])
					bc = lc;
				else
					bc = rc;
			}
			else
				bc = lc;

			if(heap[p] < heap[bc])
				swap(heap[p], heap[bc]);
			else
				return;

			p = bc;
		}
	}

public:
	// Definition of the constructor.
	HeapQueue(int s)
	{
		heap = new int[s];
		size = s;
		bottom = -1;
	}
	~HeapQueue()
	{
		// Deallocate the array 
		delete [] heap;
	}
	// Defining the main functions for this class.
	void enqueue(int i)
	{
		// Check to see if its full.
		if(bottom >= size)
			return;
		else
		{
			// Since were adding one, we increase the bottom by one.
			bottom++;
			// Then write the actual value to our heap array.
			heap[bottom] = i;
			// Call the function to re-head up function.
			ReHeapUp();
		}
	}
	void dequeue()
	{
		// Remove one from the head if it isn't empty.
		if(bottom == -1)
			return;
		else
		{
			swap(heap[0], heap[bottom]);
			// Then decreasee the bottom since we removing one.
			bottom--;
		}
		// Reheap down.
		ReHeapDown();
	}
	int top()
	{
		// If empty return -1, else return element 0 in the heap.
		if(bottom == -1)
			return -1;
		else
		{
			return heap[0];
		}
	}
};


#endif
