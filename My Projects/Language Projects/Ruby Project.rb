=begin
A menu presentation for students and teachers performing various calculations
and data displays
Created by: Anthony Vierra
=end

# Import the cmath libary.
require 'cmath'
require 'complex'
include Math

def mainMenu()

  # Display the main menu
  puts "----------Main Menu----------"
  puts "1.) Gather student names and data"
  puts "2.) Calculate GPA"
  puts "3.) Test Stats"
  puts "4.) Sort names"
  puts "5.) Calculate a logarithm in base 10"
  puts "6.) Integer into binary"
  puts "7.) Binary number into integer"
  puts "8.) Quit"
  print "Your choice (1 - 8): "
  selection = gets.to_i

  while selection < 1 or selection > 8
  print "Error, selection must be between 1 - 8: "
  selection = gets.to_i
  end

  # Finally return selection
  return selection
end

def option1()

  # Print a new line for neatness.
  print "\n"

  print "How many students would you like to enter: "
  num_s = gets.to_i

  # Create a string array and an integer array.
  names1 = []
  gpa1 = []

  for x in 0...num_s

  print "Enter Student's first name # ", (x + 1), ": "
  name = gets
  names1.push(name)

  # Then in the same for loop gather their gpa's as well
  print "Enter Student #", (x + 1), " gpa: "
  gpa = gets.to_f
  gpa1.push(gpa)

  end

  # Now print out these in a table format displaying the names on the left and the gpa corresponding on the right.
  puts "\n"
  puts "-----------Names and GPA-----------"
  for q in 0...num_s

    # display the names first then the gpa.
    print "Student #", (q + 1), ": ", names1[q]
    print "Student #", (q + 1), " GPA: ", gpa1[q]

    print "\n\n"

  end
end

# Definition of the second option function.
def option2()

  # Print a new line for neatness.
  print "\n"

  # Ask the user how many classes are they taking.
  print "How many classes is the student taking: "
  num_classes = gets.to_i

  # Create a char array.
  grades = []
  units = []
  gradeConv = []
  gradeWeightAverage = []
  sumWeight = 0
  unitSum = 0

  # Create a for loop adding these grades to an array.
  for x in 0...num_classes

    print "\n---------Grade Selector---------\n"
    puts "1.) A"
    puts "2.) B"
    puts "3.) C"
    puts "4.) D"
    puts "5.) F"
    print "Choose the integer that corresponds to grade for class #", (x+1), ": "
    grade = gets.to_i

    # Define a guard against any other inputs.
    while grade < 1 or grade > 5
      print "\n*Error* Input must be between 1 - 5: "
      grade = gets.to_i
    end

    # Define a switch statement but the equivalent in ruby.
    case grade
    when 1
      gradeConv.push(4.0)
    when 2
      gradeConv.push(3.0)
    when 3
      gradeConv.push(2.0)
    when 4
      gradeConv.push(1.0)
    else
      gradeConv.push(0)
    end

    # Collect the units for that class.
    print "How many units was class #", (x + 1), ": "
    unit1 = gets.to_i
    # Push that back onto the array.
    units.push(unit1)

    gradeWeightAverage.push(gradeConv[x] * units[x])

    sumWeight += gradeWeightAverage[x]
    unitSum += units[x]

  end

  print "\n"

  # Now that we have the information we need begin calculating the grade weight average.
  final = sumWeight / unitSum

  # Finally print out the students grade point average.
  print "\nThe Students GPA is: ", final

  print "\n"
end

# Define the third option function.
def option3()

  # Begin the definition.
  testScores = []
  testSum = 0
  # Set our min and max variables outside of the for loop.
  max1 = 1
  min1 = 1

  puts "\n---------Test Stats---------"
  puts "1.) Random test scores"
  puts "2.) Manual entry"
  print "Your entry (1 - 2): "
  choice1 = gets.to_i

  # Make sure this is inbetween either 1 or two.
  while choice1 < 1 or choice1 > 2
    print "Error, must be between 1 - 2: "
    choice1 = gets.to_i
  end

  # Ask the user how many tests they would like to gather
  print "How many tests would you like to input: "
  num_test = gets.to_i

  # Begin an if/else statement.
  case choice1
  when 1
    for x in 0...num_test
      # Fill a list with random values.
      testScores.push(rand(30..100))
      testSum += testScores[x]
    end
    # Print out the test list.
    print testScores

    max1 = testScores[0]
    min1 = testScores[0]

    # Determine the min and max.
    for x in 0...num_test
      if testScores[x] > max1
        max1 = testScores[x]
      end

      if testScores[x] < min1
        min1 = testScores[x]
      end
    end


  when 2
    # Create a loop with num_tests as the limit.
    for x in 0...num_test
      print "Enter test score #", (x + 1), ": "
      temp1 = gets.to_f
      testSum += temp1

      # Push this back in our testscores array.
      testScores.push(temp1)

      max1 = testScores[0]
      min1 = testScores[0]
    end

    for x in 0...num_test
     # Begin determining the min and max.
      if testScores[x] > max1
        max1 = testScores[x]
      end

      if testScores[x] < min1
        min1 = testScores[x]
      end
    end

  end

  # Calculate the average of all the tests.
  average = (testSum / num_test)

  sdSum = 0

  # Find the standard deviation and display that as well.
  for q in 0...num_test
    sdSum += ((testScores[q] - average)**2)
  end
  # Then divide this by n - 1.
  sdSum /= ((num_test - 1))
  # Then square root it.
  sdSum = sqrt(sdSum)

  # Begin the calculation for the tests.
  print "\n----------Test results----------"
  print "\nMaximum Score: ", max1
  print "\nMinimum Score: ", min1
  print "\nAverage: ", average
  print "\nStandard deviation: ", sdSum
  print "\n\n"
end

# Define the fourth option function.
def option4()

  print "\n"
  puts "This option will sort last names only."
  print "How many names would you like to sort: "
  num_names = gets.to_i
  # Define a string array.
  last_names = []

  # Create a for loop for this.
  for x in 0...num_names
    print "Enter last name #", (x + 1), ": "
    names = gets

    # Push this onto the array.
    last_names.push(names)

  end

  # Sort the array an alphabetical order.
  last_sort = last_names.sort

  puts "\n----------Sorted names----------"
  for q in 0...num_names
    # Display each name on a seperate line.
    puts last_sort[q]

  end

  # Display a line for cleanness.
  print "\n"
end

# Define the fift option function.
def option5()

  # Print out a table.
  puts "\n----------Logarithm Calculation----------"
  print "Enter a number (integer or decimal): "
  loga = gets.to_f

  # Now call the logarithm function.
  loga = Math::log(loga, 10)

  print "The logarithm for that number in base 10 is: ", loga
end

def option6(num)

  # Begin recursive calling this function.
  if num > 1
    option6(num/2)
  end

  # Then just display each one individually.
  print num % 2
end

def option7(num2)

  # Begin declaring some other variables.
  num3 = num2
  value = 0
  base_2 = 1
  temp = num2

  # Create a while loop.
  while temp > 0
    last = temp % 10
    temp /= 10
    value = value + (last * base_2)
    base_2 *= 2
  end

  puts value
end



# Definition of the sixth option.
def option8()

  # quit the program.
  abort("Exiting program now...")
end


# The main function.
again = 'y'
while again == 'y'

  # Define a variable to pass to the mainMenu function.
  
  selection = mainMenu()

  if selection == 1
    # If the user wants to do option one, call the function for the first option.
  puts option1

  elsif selection == 2

    # Call the function for if the user inputs option number 2.
    puts option2

  elsif selection == 3

    # Call the function for if the user enters 3.
    puts option3

  elsif selection == 4

    # Call the function for if the user enters 4.
    puts option4

  elsif selection == 5

    # Calculate the logarithm.
    puts option5

  elsif selection == 6

    # Display the message for the user inside here.
    print "\nEnter any integer number: "
    number = gets.to_i

    # Call the function option 6
    puts option6(number)

  elsif selection == 7

    # Ask th user for a number.
    print "\nEnter a binary number: "
    number2 = gets.to_i

    # Call the option7 function for this.
    puts option7(number2)


  elsif selection == 8

    # The quitting option.
    puts option6

  else
    puts "Invalid entry"

  end

end