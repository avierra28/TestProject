'''
The client side of the two way conversation of our socket program
Created by: Anthony Vierra
'''

import socket
mySocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Have the same port number as in the server.
port = 5678
flag = True
mySocket.connect(('localhost', port))

while flag:

    # Then send a message back.
    message = raw_input("Enter a message: ")
    mySocket.send(message)
