
# Created by: Anthony Vierra


import threading
from threading import Thread, Lock
import time
# Our mutex.
teacher = threading.Lock()
# Our Semaphore.
sem = threading.Semaphore(4)


def answer_done(student):
    # Have the student and teacher release.
    # Opening the possibility for the teacher to take another studet.
    # And the semaphore being done with the share space.
    print student, " is leaving the professor's office."
    teacher.release()
    sem.release()

def answer_start():
    for x in range(2):
        print "The professor is answering the question..."


def question_start(student):
    # Have the mutex lock this.
    teacher.acquire()
    for x in range(2):
        print student, " is asking the question..."

    # Start the answer for the professor.
    answer_start()

    # Then have the professor finish answering the question.
    answer_done(student)


def waiting_room(student, student_num):
    # Create a local list to hold the semaphores.
    queue = [" "] * 3 
    # Passing the student through as an argument to the  
    sem.acquire()
    queue.append(student)
    time.sleep(.05)

    # Call the question start function.
    question_start(student)



def main():

    # This will start 6 threads but the queue will only have 4 seats.
    s1 = threading.Thread(target = waiting_room, args=("Student 1", 1,))
    s1.start()
    s2 = threading.Thread(target = waiting_room, args=("Student 2", 2,))
    s2.start()
    s3 = threading.Thread(target = waiting_room, args=("Student 3", 3,))
    s3.start()
    s4 = threading.Thread(target = waiting_room, args=("Student 4", 4,))
    s4.start()
    s5 = threading.Thread(target = waiting_room, args=("Student 5", 5,))
    s5.start()
    s6 = threading.Thread(target = waiting_room, args=("Student 6", 6,))
    s6.start()

main()












    
