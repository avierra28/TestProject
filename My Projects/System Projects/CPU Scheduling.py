"""
CPU Scheduling Algorithms
Created by: Anthony Vierra
CS 421 - Operating Systems
"""
import random
import time
import operator

def mainMenu(choice):
	# Print the main menu.
	print "============Main Menu============"
	print "1.) First Come First Serve algorithm"
	print "2.) Short Job First algorithm"
	print "3.) Priority Scheduling"
	print "4.) Quit"
	choice = int(input("Your choice (1 - 4): "))

	# Protect against any error.
	while(choice < 1 or choice > 4):
		choice = int(input("*Error* Input must be between 1 - 4: "))

	return choice

def fcfs(size):

	# Initialize the list.
	array = [[]]

	# This function will be the first come first serve algorithm.
	# Fill the job list.
	for x in range(size):
		# The first position in the list is the time and the second position will be
		# the job time.
		array.append([random.randint(0, size), random.randint(2, 42)],)

	# Declare some local variables that we will use here.
	average = 0.0
	total_wait = 0
	turnaround_time = 0.0
	throughput = 0.0
	# Print our array.
	array.pop(0)
	print "[Position it arrived in, Burst time in milliseconds]"
	for (x) in range(size):
		print "Process #", (x+1), ": ", array[x]
		time.sleep(.05)

	# Print out the jobs on one line sorted by the time of arrival.
	print "\nJobs will be sorted in the order they were received (FCFS algorithm)"
	array.sort(key=lambda x: x[0])
	print array

	# Do the statistics.
	for x in range(size - 1):
		total_wait += array[x][1]
	average = total_wait
	for x in range(size):
		turnaround_time += array[x][1]
	throughput = turnaround_time / size
	turnaround_time += total_wait
	average /= size

	print "\n-------Statistics-------"
	print "Total wait time is: ", total_wait, "ms"
	print "Average wait time: ", average, "ms"
	print "Turnaround time: ", turnaround_time, "ms"
	print "Throughput time: ", throughput, "ms"

def sjf(size):

	# Initialize the list.
	array = [[]]
	# Declare some local variables that we will use here.
	average = 0.0
	total_wait = 0
	turnaround_time = 0.0
	throughput = 0.0

	# This function will be the first come first serve algorithm.
	# Fill the job list.
	for x in range(size):
		# The first position in the list is the time and the second position will be
		# the job time.
		array.append([random.randint(0, size), random.randint(2, 42)],)

	# Print our array.
	array.pop(0)
	print "[Position it arrived in, Burst time in milliseconds]"
	for (x) in range(size):
		print "Process #", (x+1), ": ", array[x]
		time.sleep(.05)

	# Display a message for the user.
	print "Jobs will be sorted with shortest one first (SJF Algorithm)"
	array.sort(key=lambda x: x[1])
	print array

	# Do the statistics.
	for x in range(size - 1):
		total_wait += array[x][1]
	average = total_wait
	for x in range(size):
		turnaround_time += array[x][1]
	throughput = turnaround_time / size
	turnaround_time += total_wait
	average /= size

	print "\n-------Statistics-------"
	print "Total wait time is: ", total_wait, "ms"
	print "Average wait time: ", average, "ms"
	print "Turnaround time: ", turnaround_time, "ms"
	print "Throughput time: ", throughput, "ms"

def ps(size):

	# Initialize the list.
	array = [[]]

	# This function will be the first come first serve algorithm.
	# Fill the job list.
	for x in range(size):
		# The first position in the list is the time and the second position will be
		# the job time.
		array.append([random.randint(0, size), random.randint(2, 42), random.randint(0, size)])

	# Declare some local variables that we will use here.
	average = 0.0
	total_wait = 0
	turnaround_time = 0.0
	throughput = 0.0
	# Print our array.
	array.pop(0)
	print "[Position it arrived in, Burst time in milliseconds, Priority number]"
	for (x) in range(size):
		print "Process #", (x+1), ": ", array[x]
		time.sleep(.05)

	# Print out the jobs on one line sorted by the time of arrival.
	print "\nJobs will be sorted with the highest priority first (Priority Scheduling)"
	array.sort(key=lambda x: x[2], reverse=True)
	print array

	# Do the statistics.
	for x in range(size - 1):
		total_wait += array[x][1]
	average = total_wait
	for x in range(size):
		turnaround_time += array[x][1]
	throughput = turnaround_time / size
	turnaround_time += total_wait
	average /= size

	print "\n-------Statistics-------"
	print "Total wait time is: ", total_wait, "ms"
	print "Average wait time: ", average, "ms"
	print "Turnaround time: ", turnaround_time, "ms"
	print "Throughput time: ", throughput, "ms"

def main():

	# Define a list inside of a list.
	job_list = [[]]
	selection = 0
	again = "y"

	# While loop.
	while(again == 'y'):
		print "\n"
		# Call the main menu function.
		selection = mainMenu(selection)

		# Create our if/elif structure.
		if(selection == 1):
			# Get how many jobs they would like to do.
			num1 = int(input("How many jobs would you like to calculate: "))
			# Call the fcfs function.
			fcfs(num1)

		elif(selection == 2):
			# Get how many jobs they would like to do.
			num1 = int(input("How many jobs would you like to calculate: "))

			# Call the Shortest job first.
			sjf(num1)

		elif(selection == 3):

			# Get the number of jobs
			num1 = int(input("How many jobs would you like to calculate: "))

			# Call the ps function.
			ps(num1)
			
		else:
			print "Exiting the program..."
			break

main()





















