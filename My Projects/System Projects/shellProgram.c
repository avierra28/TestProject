/*
Created by: Anthony Vierra
*/
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>


int main(int argc, char **argv)
{
	// Defining variables that will be used in the program.
	char user_input[100], **string_holder, executable[4];
	int num_strings, child, waitid, status;

	while(1)
	{
		// Printing out the main comman line display.
		printf("\ntish>> ");
		gets(user_input);

		// If the user entered bye.
		if(strcmp(string_holder[0], "bye") == 0)
		{
			printf("Exiting terminal...\n");
			break;
		}

		// Set the num_strings to 0 in the body of the loop.
		num_strings = 0;
		// Assigning first input to our string holder.
		string_holder[num_strings] = strtok(user_input, " ");
		// Then while loop it.
		while(string_holder[num_strings] != NULL)
			string_holder[++num_strings] = strtok(NULL, " ");
		printf("Executing = ");
		// Then simply print out what the user types in.
		for(int i = 0; i < num_strings; i++)
			printf(string_holder[i], " ");
		// Print blank line.
		printf("\n\n");

		child = fork();
		if(child == 0)
		{
			if(strcmp(string_holder[0], "jobs") == 0)
			{
				execvp(string_holder[0], string_holder);
				perror("Failed");
				break;
			}
			else if(strcmp(string_holder[0], "kill") == 0)
			{
				execvp(string_holder[0], string_holder);
				perror("Failed");
				break;
			}
			else
			{
				execvp(string_holder[0], string_holder);
				perror("Failed");
				break;
			}
		}
    	waitid = wait(&status);
    	printf("Shell process %d exited with status %d\n", waitid, (status >> 8));
		printf("\n");

	}
}
























