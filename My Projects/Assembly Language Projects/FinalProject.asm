# Created by Anthony Vierra

# This project will be a math library, to calculate non-trivial floating point
# arithmetic.

 .data
 
 # Creating some menu-presentation options for the user.
 	menu1: .asciiz "\n1.) Get the square root of a decimal number"
 	menu2: .asciiz "\n2.) Raise a decimal number to x exponent"
 	menu3: .asciiz "\n3.) Evaluate a function of decimals"
 	menu4: .asciiz "\n4.) Raise 'e' to power of x: "
 	menu5: .asciiz "\n5.) Calculate the mean of a decimal sample set"
 	menu6: .asciiz "\n6.) Quit"
 	
 # Then some outputs for the user.
 	output1: .asciiz "\n-----------Main Menu-----------" 
 	output2: .asciiz "\nYour choice (1 - 6): "
 	
 # Provide some outputs for the menu option 1.
 	square1: .asciiz "Please enter a decimal number to square root: "
 	square2: .asciiz "Square root is: "
 	square_counter1: .double 2.0
 	square_counter2: .double 0.0
 	square_counter3: .double 1.0
 	
 # Miscellaneous instruction.
 	misc1: .asciiz "\nPress any key to continue..."
 	
 # Provide some outputs for menu option 2.
 	exponent1: .asciiz "Please enter a decimal digit: "
 	exponent2: .asciiz "To what power would you like to raise that to (integer): "
 	exponent3: .asciiz "Result is: "
 	
 # Provide some outputs for menu option 3.
 	fraction1: .asciiz "Enter the numerator (decimal or integer): "
 	fraction2: .asciiz "Enter the denominator (decimal or integer): "
 	frac1: .asciiz "\n----"
 	frac2: .asciiz "\n"
 	frac3: .asciiz "   ====>   "
 	
 # Provide some outputs for menu option 4.
 	e_number1: .asciiz "Enter the exponent for 'e' (integer): "
 	e_number2: .asciiz "Result is: "
 	our_e: .double 2.718281828
 	
 # Provide some outputs for menu option 5.
 	mean1: .asciiz "What is your sample size (integer): "
 	mean2: .asciiz "Average of those numbers: "
 	mean_loop1: .asciiz "Enter sample #"
 	mean_loop2: .asciiz ": "
 	mean_holder: .double 0.0
 	sub_mean: .double 1.0
 	zero_mean: .double 0.0
 	
 .text
 
 # Create a main label for looping back up to the main function.
 main:
 
 # Add some memory to the stack.
 	addiu $sp, $sp, -4
 # Make an empty register to hold our selection.
 	li $s0, 0
 # Then store some stuff on the stack.
 	sw $s0, ($sp)
 	
 # Calling the display function.
 	jal main_menu_display
 	
 # Load back our items from the stack.
 	lw $t0, ($sp)
 	addiu $sp, $sp, 4
 
  # Compare and branch to the appropriate function.
 	beq $t0, 4, e_number
 	beq $t0, 1, square_root
 	beq $t0, 2, exponent
 	beq $t0, 3, fraction
 	beq $t0, 6, exit
 	beq $t0, 5, mean_function
 

 ##############################Main Menu Display##############################
 main_menu_display:
 
 # Load our parameters from the stack.
 	lw $t0, ($sp)
 
 # Display the main menu line.
 	li $v0, 4
 	la $a0, output1
 	syscall
 # Then begin displaying the main menu options.
 	la $a0, menu1
 	syscall
 	la $a0, menu2
 	syscall
 	la $a0, menu3
 	syscall
 	la $a0, menu4
 	syscall
 	la $a0, menu5
 	syscall
 	la $a0, menu6
 	syscall
 	la $a0, output2
 	syscall
 # Gather the input from the user.
 	li $v0, 5
 	syscall
 # move that input into a temporary register for safekeeping.
 	move $t0, $v0
 	
 # Store it back into the stack.
 	sw $t0, ($sp)
 
 # Return to the main function.
 	jr $ra
##############################End of Display Menu##############################

 exit: 
 # Terminate the program.
 	li $v0, 10
 	syscall



# The first option in the main menu. To find a square root of a decimal number.
##############################Square Root Function##############################
square_root:

# Load some addresses from the data section.
	ldc1 $f6, square_counter1
	ldc1 $f8, square_counter3
	ldc1 $f10, square_counter1

# Display the text for this option.
	li $v0, 4
	la $a0, square1
	syscall
# Prime it for a decimal entry.
	li $v0, 7
	syscall
	
# This entry got stored into $f0 as a double.
	li $s0, 20
	
# Begin a loop to get the square root.
# Notes:
# $f0 holds our number.
# $f8 holds 1.0 our esitmation.
square_loop:
	beqz $s0, square_done
	
# Using the Babylonian Method
	div.d $f4, $f0, $f8
	add.d $f10, $f4, $f8
	div.d $f8, $f10, $f6
# Thus $f10 holds out estimation for the square root.
# Decrease our main counter by 1.
	addi $s0, $s0, -1
	j square_loop
square_done:

# Now lets display the actual result.
	li $v0, 4
	la $a0, square2
	syscall
	li $v0, 3
	mov.d $f12, $f8
	syscall
	
# Print out the misc display to get back to the main menu.
	li $v0, 4
	la $a0, misc1
	syscall
# Gather the result.
	li $v0, 12
	syscall
# Branch to main if 5.
	bge $v0, 1, main
##############################End of Square Root Function##############################

	
# Now Define the exponent function.
##############################Exponent Function##############################
exponent:

# Load the display for the user
	li $v0, 4
	la $a0, exponent1
	syscall
# Gather the decimal digit.
	li $v0, 7
	syscall
# Now gather the integer power.
	li $v0, 4
	la $a0, exponent2
	syscall
# Gather the exponent
	li $v0, 5
	syscall
	
# Move this into a diff register. And get a counter.
	move $t0, $v0
	addi $t0, $t0, 1
# Get a 1.0 register.
	ldc1 $f2, square_counter3
	
# Set up a for loop and multiply this as many times as the exponent.
exponent_loop:
	beq $t0, 1, exponent_done

# Multiply the decimal numbers.
	mul.d $f2, $f2, $f0
	
# Decrease the exponent by 1.
	addi $t0, $t0, -1
# Jump back up to the loop address.
	j exponent_loop

exponent_done:

# Now display the outcome.
	li $v0, 4
	la $a0, exponent3
	syscall
	li $v0, 3
	mov.d $f12, $f2
	syscall
	
# Print out the misc display to get back to the main menu.
	li $v0, 4
	la $a0, misc1
	syscall
# Gather the result.
	li $v0, 12
	syscall
# Branch to main if 5.
	bge $v0, 1, main
##############################End of Exponent Function##############################

##############################Start of E function##############################
 e_number:
 
 # Load the address of the e number to a register.
 	ldc1 $f2, our_e
 
 # Display the first message.
 	li $v0, 4
 	la $a0, e_number1
 	syscall
 # Gather the number.
 	li $v0, 5
 	syscall
 	
 # Move that to another register.
 	move $s0, $v0
 	addi $s0, $s0, 1
 	ldc1 $f0, square_counter3
 	
 # Set up a loop for this.
 e_loop:
 	beq $s0, 1, e_done
 
 # Calculate this.
 	mul.d $f0, $f0, $f2
 # Decrement our counter.
 	addi $s0, $s0, -1	
 	
 # Branch up to e_loop.
 	j e_loop
 	
 e_done:
 
 # Now display the actual result.
 	li $v0, 4
	la $a0, e_number2
	syscall
	li $v0, 3
	mov.d $f12, $f0
	syscall

# Display the leaving message.
	li $v0, 4
	la $a0, misc1
	syscall
# Gather the result.
	li $v0, 12
	syscall
# Branch to main if 5.
	bge $v0, 1, main	
 ##############################End of E Function##############################
 
 ##############################Start of Fraction##############################
 fraction:
 
 # Display the messages.
 	li $v0, 4
 	la $a0, fraction1
 	syscall
 # Gather the input.
 	li $v0, 7
 	syscall
 # Move this to another register.
 	mov.d $f2, $f0
 
 # Display the messages.
 	li $v0, 4
 	la $a0, fraction2
 	syscall
 # Gather the input.
 	li $v0, 7
 	syscall
 	
 # $f0 is holding the denominator
 # $f2 is holding the numerator.
 
 # Do the division.
 	div.d $f4, $f2, $f0
 
# Display a new line.
	li $v0, 4
	la $a0, frac2
	syscall	
# Display the numbers and line.
	li $v0, 3
	mov.d $f12, $f2
	syscall
# Display the line
	li $v0, 4
	la $a0, frac1
	syscall
	la $a0, frac3
	syscall
# Display the result here.
	li $v0, 3
	mov.d $f12, $f4
	syscall
# Display a new line.
	li $v0, 4
	la $a0, frac2
	syscall
	li $v0, 3
	mov.d $f12, $f0
	syscall
	
# Now display the leaving message.
	li $v0, 4
	la $a0, misc1
	syscall
# Gather the result.
	li $v0, 12
	syscall
# Branch to main if 5.
	bge $v0, 1, main
##############################End of fraction##############################	

##############################Start of mean################################
 mean_function:
 
 # Display this functions display.
 	li $v0, 4
 	la $a0, mean1
 	syscall
 # Gather the number
 	li $v0, 7
 	syscall
 	
 # Move that over to a register for safekeeping.
 	mov.d $f6, $f0
 	mov.d $f10, $f0
 	ldc1 $f8, sub_mean
 	ldc1 $f14, zero_mean
 	li $s1, 1
 # Load $f2 as an accumulator.
	ldc1 $f2, mean_holder #0.0
 	
 # Now set up a loop iterating that many times.
 mean_loop:
 
 # Branch to done.
 	c.eq.d $f6, $f14 
 	bc1t mean_done
 	
 # Display the loop message.
 	li $v0, 4
 	la $a0, mean_loop1
 	syscall
 	li $v0, 1
 	la $a0, ($s1)
 	syscall
 	li $v0, 4
 	la $a0, mean_loop2
 	syscall
 	
 # Gather the users input.
 	li $v0, 7
 	syscall
	
# Then continuously add this to $f2.
	add.d $f2, $f0, $f2
 	
 # Increase our counters.
 	sub.d $f6, $f6, $f8 
 	addi $s1, $s1, 1
 
 # Jump back up to the loop.
 	j mean_loop
 
 
 mean_done:
 
 # Divide $f2 by the amount of numbers in the set.
 	div.d $f4, $f2, $f10
 
 # Then display the average.
 	li $v0, 4
 	la $a0, mean2
 	syscall
 	li $v0, 3
 	mov.d $f12, $f4
 	syscall
 
 # Leaving message.
 	li $v0, 4
	la $a0, misc1
	syscall
# Gather the result.
	li $v0, 12
	syscall
# Branch to main if 5.
	bge $v0, 1, main	
 
 ##############################End of mean function##############################
 
 
 
 
 
 
 
 
 
 
 
 
 


