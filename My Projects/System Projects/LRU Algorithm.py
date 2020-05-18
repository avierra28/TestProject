"""
Created by: Anthony Vierra
"""
import random
import time

def addone(stack):

	for x in range(len(stack)):
		if(stack[x][1] >= 1 or stack[x][2] == True):
			stack[x][1] += 1

def checkStack(stack, temp):

	# This function will check if any value will be the same.
	for x in range(len(stack)):
		if(temp == stack[x][0]):
			return True
	# Else if no match has been found return false.
	return False

def findNumber(stack, temp):

	# Go through the stack again.
	for x in range(len(stack)):
		if(stack[x][0] == temp):
			return x

def replaceLRU(stack, reference):

	# This function will replace the least recently used.
	maxnum = stack[0][1]
	position = 0
	for x in range(len(stack)):
		if(stack[x][1] > maxnum):
			maxnum = stack[x][1]
			position = x

	# Now that we have max number in the counter of our array replace it.
	stack[position][0] = reference
	stack[position][1] = 0

	# Then add one.
	addone(stack)

def checkAllTrue(stack):
	for x in range(len(stack)):
		if(stack[x][2] == False):
			return False

	return True

def main():

	# Ask the user how many reference lists he would like.
	num_frames = 4
	counter = 0
	page_fault = 0

	stack = [[]]
	display_array = []
	reference = [7, 1, 2, 3, 4, 2, 4, 3, 2, 1, 2, 1, 7, 1]
	flag1 = False
	pfc = False
	
	for x in range(num_frames):
		stack.append([0, 0, False])
	stack.pop(0)

	# Print out the reference for the user to compare.
	print "Our reference string: ", reference
	
	for x in range(len(reference)):
		if(x >= num_frames and checkAllTrue(stack) == True):
			# Check if the page is already in memory at the offset.
			temp = reference[x]
			flag2 = checkStack(stack, temp)
			if(flag2 == True):
				num1 = findNumber(stack, temp)
				stack[num1][1] = 0
				addone(stack)
			else:
				page_fault += 1
				# if no match found simply replace the LRU.
				replaceLRU(stack, reference[x])
				pfc = True
		else:
			temp = reference[x]
			flag1 = checkStack(stack, temp)

			# If checkStack returns false then proceed normally.
			if(flag1 == False):
				page_fault += 1
				stack[x][0] = reference[x]
				stack[x][2] = True
				if(stack[x][2] == True):
					stack[x][1] += 1
				pfc = True
				addone(stack)
			else:
				# Else we will have to account for the duplicate item.
				num1 = findNumber(stack, temp)
				# This basically means we already have everything in memory.
				# Reset the counter.
				stack[num1][1] = 0
				# Increase everything by 1.
				addone(stack)
		for q in range(len(stack)):
			display_array.append(stack[q][0])

		# Display it at the end.
		for elem in display_array:
			print elem
		if(pfc == True):
			print " ** Page fault"
		# Then mark it back to false.
		pfc = False
		display_array = []
		print "----------"

	# Print out the page fault number at the end.
	print "Page faults: ", page_fault



main()

















