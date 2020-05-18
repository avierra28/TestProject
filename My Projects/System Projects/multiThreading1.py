
# Created by: Anthony Vierra
import threading
import time
sem = threading.Semaphore(2)
list1 = []
list2 = []
 # Open a file for output.
outfile = open('consumer_file.txt', 'a')

class A(object):
    v = 0
    b = 0

def producer():
    for x in range(len(list1)):
        # Call the put function inside the main.
        put(list1)

        

def consumer():
    for x in range(len(list1)):
        get(list2)


def put(list1):
    # Acquire the semaphore.
    sem.acquire()
    
    # This list2 will be the shared critical region between
    # both producer and consumer.
    list2.append(list1[A.b])
    A.b += 1

    # Print a display message.
    print("Producer put an item in the list")

    # Release this.
    sem.release()

def get(list2):

    sem.acquire()

    if len(list2) >= 1:
        # If this actually contains a value.
        outfile.write(list2[0])
        # Increase list to the next index.
        list2.pop(0)

        print("Consumer retrieved an item from the list")
    else:
        time.sleep(.05)

    sem.release()




def main():

    # Read from our input file.
    with open("buffer_file.txt") as f:
        for line in f:
            list1.append(line)

    t = threading.Thread(target = producer)
    t.start()
    t2 = threading.Thread(target = consumer)
    t2.start()


main()
