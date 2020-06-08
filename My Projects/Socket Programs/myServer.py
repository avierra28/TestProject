'''
This is a socket program that will replicate a server done in python.
Created by: Anthony Vierra
'''
import socket
mySocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Defining the port.
port = 5678
flag = True

# Binding the variable to the localhost and our port.
mySocket.bind(('localhost', port))
print "The server socket was bound to the localhost on port #", port
mySocket.listen(5)

while flag:
    
    # When the client send a message accept it and display it.
    m, address = mySocket.accept()
    print "Incoming message from ", address, "..."

    while True:
        # Get the actual message.
        message = m.recv(1024)
        print message

        mySocket.listen(5)


