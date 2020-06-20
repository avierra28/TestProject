/*
Created by: Anthony Vierra
*/

#ifndef AVLTREE_H
#define AVLTREE_H

#include <iostream>
#include <iomanip>
using namespace std;


// Define class definition.
class AVLtree
{
	// Our private members for this class.
private:
	struct Node
	{
		int value;
		Node *left, *right;
	} *root;

	// Define our private member functions.
	void append(Node *&r, int v)
	{
		// Test to see if its empty.
		if(r == nullptr)
		{
			// Create a new node and assign the values accordingly.
			r = new Node;
			r->value = v;
			r->left = nullptr;
			r->right = nullptr;
		}
		else if(v < r->value)
			append(r->left, v);
		else
			append(r->right, v);

		balance(root);
	}
	void print(Node *r)
	{
		// This will print out the binary tree in an inorder way.

		// First check to see if the tree is empty.
		if(r == nullptr)
			return;
		else
		{
			// Meaning the tree has at least one node contained in it.
			print(r->left);
			cout << r->value << " ";
			print(r->right);
		}
	}
	void remove(Node *&r, int v)
	{
		// Check to see if the tree is empty.
		if(isEmpty())
			return;
		else
		{
			// If the tree does indeed have values.
			// Check first to see if the value is in the left part of the tree.
			// Or the right part of th tree.
			if(v < r->value)
			{
				remove(r->left, v);
				balance(root);
			}
			else if(v > r->value)
			{
				remove(r->right, v);
				balance(root);
			}
			else
			{
				// This else clause is if we've found the value to be deleted.
				/*
				This will be for different scenarios.
				1.) If the node has 0 children.
				2.) If the node has 1 left child
				3.) If the node has 1 right child.
				4.) If the node has 2 children.
				*/
				if(r->left == nullptr && r->right == nullptr)
				{
					// For scenario number 1.
					delete r;
					// Assign the root to null.
					r = nullptr;
				}
				else if(r->left != nullptr && r->right == nullptr)
				{
					// For scenario number 2.
					Node *temp = r;
					// Advance r to the next node.
					r = r->left;
					// Then delete the the temp node.
					delete temp;
				}
				else if(r->left == nullptr && r->right != nullptr)
				{
					// For scenario number 3.
					Node *temp = r;
					r = r->right;
					delete temp;
				}
				else
				{
					// For scenario 4
					Node *temp = r->right;
					while(temp->left != nullptr)
						temp = temp->left;

					// Then preserve another node.
					temp->left = r->left;
					temp = r;
					r = r->right;
					delete temp;
				}
			}
		}
	}
	void find(Node *r, int v)
	{
		// Make a boolean set to false.
		bool flag = false;

		// This function will return true if found and false otherwise.
		while(r != nullptr)
		{
			// If the value is larger than the root node continue on the right part of the tree.
			if(v > r->value)
				r = r->right;
			else if(v < r->value)
				r = r->left;
			else
			{
				cout << "Found." << endl;

				// Set the flag to true.
				flag = true;

				// Break out of the loop.
				break;
			}
		}
		// If it was not found simply return false;
		if(flag == true)
			return;
		else
			cout << "Not found.";
	}
	void clear(Node *&r)
	{
		// Begin by checking if its empty.
		if(r == nullptr)
			return;
		else
		{
			// If not pointing to null.
			clear(r->left);
			clear(r->right);

			// Then actually delete the node.
			delete r;
		}
	}
	/*
	End of normal binary tree functions.
	Below will be the AVL functions.
	*/
	int height(Node *r)
	{
		// Find the maximum height of the tree in question.
		if(r == nullptr)
			return 0;
		else
		{
			// If our tree is not empty we will begin the actual recursion.
			int Left = height(r->left);
			int Right = height(r->right);

			// Then create a nested decision structure.
			if(Left > Right)
				return Left += 1;
			else
				return Right += 1;
		}
	}
	void rotateRight(Node *&r)
	{
		// This function will rotate the tree to the right by one.
		// Start by setting a temporary pointer to the grandparents left child.
		Node *temp = r->left;
		r->left = temp->right;
		temp->right = r;
		r = temp;
	}
	void rotateLeft(Node *&r)
	{
		// Rotate left function, very similar to the rotateRight function.
		Node *temp = r->right;
		r->right = temp->left;
		temp->left = r;
		r = temp;
	}
	void rotateRightLeft(Node *&r)
	{
		// This will perform 2 rotations in a single function if our tree cannot be solves by a single rotation.
		rotateRight(r->right);
		rotateLeft(r);
	}
	void rotateLeftRight(Node *&r)
	{
		// This will be the same as above only with a minor change.
		rotateLeft(r->left);
		rotateRight(r);
	}
	int difference(Node *r)
	{
		// This will find and determine if we need to balance the node or not.
		return height(r->right) - height(r->left);
	}
	void balance(Node *&r)
	{
		// And lastly this will balance the actual nodes if given a specific position.
		if(difference(r) == 2)
		{
			// If our balance factor is atleast 2.
			if(difference(r->right) == 1)
				rotateLeft(r);
			else
				rotateRightLeft(r);
		}
		else if(difference(r) == -2)
		{
			// if its a difference positions.
			if(difference(r->left) == -1)
				rotateRight(r);
			else
				rotateLeftRight(r);
		}
	}

	// Now define our public member functuons.
public:
	// Constructor and destructor definition.
	AVLtree()
	{
		// Set defaults for the node members.
		root = nullptr;
	}
	~AVLtree()
	{
		clear();
	}
	/*
	The following functions are the basic binary tree functions without the
	avl tree functionality.
	*/
	void append(int v)
	{
		// Call the private member function append that will do the work for us.
		append(root, v);
	}
	// Define the isEmpty function.
	bool isEmpty()
	{
		// Check to see if the root has anything or not.
		if(root == nullptr)
			return true;
		else
			return false;
	}
	// Define the isFull function.
	bool isFull()
	{
		// Do a try and catch.
		try
		{
			Node *r = new Node;
			return false;
		}
		catch(bad_alloc)
		{
			// Meaning there was a problem creating the new node.
			return true;
		}
	}
	// Define the print function.
	void print()
	{
		// This will call the private function to actually display the values.
		print(root);
		cout << endl;
	}
	// Define the remove function.
	void remove(int v)
	{
		// Call the provate remove function that will actually do the removing.
		remove(root, v);
	}
	// Defining the find function.
	void find(int v)
	{
		// Call the actual find function.
		find(root, v);
	}
	void clear()
	{
		// Call the actual clear function in the private space.
		clear(root);
	}
};



#endif