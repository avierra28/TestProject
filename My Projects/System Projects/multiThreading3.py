"""
Created by: Anthony Vierra
CS 421
"""
import threading
import time
import random
from random import randrange
# Construct our semaphores.
sem = threading.Semaphore(2)
# Create a global double list to hold the cars and the binary value.
island_list = []

class A(object):
	master_counter = 0
	counter = 0
	p_counter = 0
	i_counter = 0
	# If ferry locator is false then its at the parking lot
	# If true then its at the island.
	ferry_locator = False
	car_list1 = []
	checkpoint = False

def start(car):
	parking_lot(car)

def parking_lot(car_list):

	# Grab our semaphore.
	if(A.p_counter == 0):
		sem.acquire()
		A.p_counter += 1

	temp_list = []

	if(A.counter == 0):
		# Create a dual list.
		A.car_list1 = ["Car A", "Car B", "Car C", "Car D", "Car E", "Car F", "Car G", "Car H", "Car I", "Car J", "Car K", "Car L", "Car M", "Car N", "Car O", "Car P", "Car Q", "Car R", "Car S", "Car T", "Car U", "Car V"]

		# Increase the counter by 1 so this list is only created once.
		A.counter += 1

	random.shuffle(A.car_list1)

	if(A.ferry_locator == False and A.checkpoint == False):

		# Print message for the user.
		print "**The ferry is at the parking lot**"

		# Then pass only 4 through to the ferry.
		for x in range(4):
			num = randrange(len(A.car_list1))
			temp_list.append(A.car_list1[num])
			print temp_list[x], " has boarded the ferry"
			A.car_list1.pop(num)
		A.checkpoint = True
		# Sending that over to the ferry.
		ferry(temp_list)
	elif(A.ferry_locator == False and len(car_list) > 0):
		# Meaning the ferry has come back from the island.
		if(len(car_list) > 0):
			for x in range(len(car_list)):
				# Append it to the end of car list 1.
				A.car_list1.append(car_list[x])
				print car_list[x], " has came back to the parking lot from the island"
			car_list = []

		# now pick up any cars.
		for x in range(len(A.car_list1)):
			if(x == 4):
				break
			else:
				temp_list.append(A.car_list1[x])
				print temp_list[x], " has boarded the ferry"
				A.car_list1.pop(x)

		# Now call the ferry
		ferry(temp_list)
	elif(A.ferry_locator == False and len(car_list) == 0):
		# Then pass only 4 through to the ferry.
		for x in range(4):
			num = randrange(len(A.car_list1))
			temp_list.append(A.car_list1[num])
			print temp_list[x], " has boarded the ferry"
			A.car_list1.pop(num)

		# Call the ferry.
		ferry(temp_list)
	else:
		print "Error"





def ferry(array):

	if(A.master_counter == 10):
		# Shut down the program.
		exit(0)
	
	# Call the island.
	if(A.ferry_locator == False and len(array) > 0):
		# Means its coming from the parking lot.
		A.master_counter += 1
		A.ferry_locator = True
		print "**The ferry is at the island.**"
		print "Size of Parking Lot: ", len(A.car_list1), " cars"
		print "Size of Island: ", len(island_list), " cars"
		island(array)
	elif(A.ferry_locator == True and len(array) == 0):
		A.master_counter += 1
		A.ferry_locator = False
		print "**The ferry is at the parking lot**"
		print "Size of Parking Lot: ", len(A.car_list1), " cars"
		print "Size of Island: ", len(island_list), " cars"
		parking_lot(array)
	elif(A.ferry_locator == True and len(array) > 0):
		A.master_counter += 1
		# Meaning we just got back from the island with a full ferry.
		A.ferry_locator = False
		print "**The ferry is at the parking lot**"
		print "Size of Parking Lot: ", len(A.car_list1), " cars"
		print "Size of Island: ", len(island_list), " cars"
		parking_lot(array)
		



def island(array):

	# Acquire the semaphore.
	if(A.i_counter == 0):
		sem.acquire()
		A.i_counter += 1

	# Dump the cars into 
	if(A.ferry_locator == True and len(island_list) == 0):

		# Dump the cars into the island.
		for x in range(len(array)):
			island_list.append(array[x])
			print island_list[x], " has landed on the island."

		# Then clear the array.
		array = []

		# Now call the ferry again.
		ferry(array)
	elif(A.ferry_locator == True and len(island_list) > 0):
		# Shuffle the island list queue.
		random.shuffle(island_list)
		# Meaning the ferry is here and is ready to pick up some cars that exist here on the island.

		# First unload the ferry if it has anything.
		if(len(array) > 0):
			for x in range(len(array)):
				island_list.append(array[x])
				print array[x], " has landed on the island"

		# Clean out the array.
		array = []

		for x in range(random.randint(2, 4)):
			array.append(island_list[x])
			print island_list[x], " has boarded the ferry"
			island_list.pop(x)

		# Now call the ferry with the newly appended array.
		ferry(array)







def main():

	#Call the threads
	s1 = threading.Thread(target = start, args=(A.car_list1,))
	s1.start()
	time.sleep(.05)
	s2 = threading.Thread(target = island, args=(island_list,))
	s2.start()
	time.sleep(.05)

main()















