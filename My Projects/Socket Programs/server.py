import socket

last_message = "NONE"

s = socket.socket()          
print "Socket successfully created"
 
port = 12345                

s.bind(('', port))         
print "socket binded to %s" %(port) 
  
# put the socket into listening mode 
s.listen(5)      
print "socket is listening"            

while True: 
  
   # Establish connection with client. 
   c, addr = s.accept()      
   print 'Got connection from', addr 

   print 'Sending last message'
   c.send(last_message)

   msg = c.recv(1024)
   print 'new message recieved:'
   print msg

   # Update last message recieved
   last_message = msg

   # Close the connection with the client 
   c.close() 
