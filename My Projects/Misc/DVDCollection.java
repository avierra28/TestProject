import java.io.*;
import java.util.Scanner;

public class DVDCollection {

	// Data fields
	
	/** The current number of DVDs in the array */
	private int numdvds;
	
	/** The array to contain the DVDs */
	private DVD[] dvdArray;
	
	/** The name of the data file that contains dvd data */
	private String sourceName;
	
	/** Boolean flag to indicate whether the DVD collection was
	    modified since it was last saved. */
	private boolean modified;
	
	/**
	 *  Constructs an empty directory as an array
	 *  with an initial capacity of 7. When we try to
	 *  insert into a full array, we will double the size of
	 *  the array first.
	 */
	public DVDCollection() 
    {
		numdvds = 0;
		dvdArray = new DVD[7];
	}
	
	public String toString() 
    {
    	String temp = "";
        // Provide the necessary output.
        temp += "\nnumdvds = " + numdvds;
        temp += "\ndvdArray.length = " + dvdArray.length;
        // Create for loop to display whats in here.
        for(int i = 0; i < dvdArray.length; i++)
            temp += "\ndvdArray[" + i + "] = " + dvdArray[i];

        // Then finally return the string.
        return temp; 
	}

	public void addOrModifyDVD(String title, String rating, String runningTime)
    {
		// NOTE: Be careful. Running time is a string here
		// since the user might enter non-digits when prompted.
		// If the array is full and a new DVD needs to be added,
		// double the size of the array first.
        boolean flag1 = true;
        int index = 0;
        
        /*
        Going to check first if the running time and the rating are correct.
        */
        for(int i = 0; i < runningTime.length() && flag1; i++)
        {
            if(runningTime.charAt(i) < '0' || runningTime.charAt(i) > '9')
                flag1 = false;
        }

        if(!rating.equals("G") && !rating.equals("PG") && !rating.equals("NC-17") && !rating.equals("R")
          && !rating.equals("PG-13"))
            flag1 = false;

        // Check if its an overall negative number as well.
        if(Integer.parseInt(runningTime) < 1)
            flag1 = false;
        
        // If our flag is still true then this means everything inputted is correct.
        if(flag1)
        {
            /*
            We will continue with the modifying of the DVD.
            */
            // This flag will be if the user wishes to add or modify.
            boolean flag2 = true;

            // Create a for loop to see if the title is the same that he wishes to modify.
            for(int i = 0; i < numdvds && flag2; i++)
            {
            	if(dvdArray[i].getTitle().equals(title))
            	{
            		// Then the user merely wishes to modify an existing dvd.
            		flag2 = false;
            		index = i;
            	}
            }

            // Continue with the adding if flag2 is still true.
            if(flag2)
            {
            	// Check first to see if the length of our dvd array is full, if it is create
            	// a new array with double the size.
            	if(numdvds == dvdArray.length)
            	{
            		DVD[] temp = new DVD[dvdArray.length * 2];

            		// Then write everything in our dvdArray into the temp.
            		for(int i = 0; i < numdvds; i++)
            		{
            			temp[i] = dvdArray[i];
            		}

            		// Then equal the dvdArray to the temp.
            		dvdArray = temp;
            	}

            	// Get the right positions.
            	while(index < numdvds && title.compareTo(dvdArray[index].getTitle()) >= 0)
            		index++;
            
            	// Shift elements over by 1.
            	for(int i = numdvds; i > index; i--)
            		dvdArray[i] = dvdArray[i - 1];
            	// Then add this by calling the constructor from the dvd class.
            	dvdArray[index] = new DVD(title, rating, Integer.parseInt(runningTime));
            	// And increase the number of dvds by 1.
            	numdvds++;
        	}	
        	else
        	{
        		// This is if he just wants to modify we will merely use the set methods.
        		dvdArray[index].setRating(rating);
        		dvdArray[index].setRunningTime(Integer.parseInt(runningTime));
        	}
        }
        else
        {
        	System.out.println("Error in input, either in the rating or runningTime returning...");
        	return;
        }
	}
	/*
    Double check on this one. It's not removing the element to null.
    */
	public void removeDVD(String title) 
	{
		// Let us first check to see if the title the user wants to remove is actually there.
		boolean flag1 = false;
		int location = 0;

		for(int i = 0; i < numdvds; i++)
		{
			if(dvdArray[i].getTitle().equals(title))
			{
				// Set our flag1 to true, and our location to the index location.
				flag1 = true;
				location = i;
			}
		}

		if(flag1)
		{
			// If we did find it, then we know the index location as well.
			dvdArray[location] = null;

			// Then make sure if its in the middle to move the elements back.
			if(location < numdvds - 1)
			{
                int p = location;
				while(dvdArray[p] != null || p == location)
                {
					dvdArray[p] = dvdArray[p + 1];
                    p++;
                }
			}
            // Then finally decrease the number of dvds in our collection.
            numdvds--;
		}
	}
	
	public String getDVDsByRating(String rating)
    {
        // This will return a string with all the ratings.
        String ratings = "";

        // Create a for loop for this.
        for(int i = 0; i < numdvds; i++)
            if(dvdArray[i].getRating().equals(rating))
                ratings += dvdArray[i].toString() + "\n";
        // The finally return this result.
        return ratings;
	}

	public int getTotalRunningTime() 
    {
        // Create a running time total.
        int total = 0;

        // Create a for loop.
        for(int i = 0; i < numdvds; i++)
            total += dvdArray[i].getRunningTime();

        return total;
	}

	
	public void loadData(String filename) 
    {
        // Use the sourcename we are given.
        sourceName = filename;

        try
        {
            BufferedReader file = new BufferedReader(new FileReader(sourceName));
            Scanner scan = new Scanner(file).useDelimiter(",|\n");

            // Creating some variables to hold the values we will be extracting from the file.
            String name, r, time;

            // Now go through each line.
            while(scan.hasNext())
            {
                /*
                Will use the scan.next function to gather the individual tokens
                that we see in the file the user types in.
                */
                name = scan.next();
                r = scan.next();
                time = scan.next();
                // Using our defined add function from above.
                addOrModifyDVD(name, r, time);
            }

            // Then close our scans.
            scan.close();
        }
        catch(FileNotFoundException e)
        {
            // This exception will handle if a file is not found.
            System.out.print("File not found\n");
            return;
        }		
	}
	
	public void save()
    {
        // Implement a try to open up filwriter.
        try
        {
            PrintWriter file = new PrintWriter(sourceName);

            // Set up a for loop to write to the file.
            for(int i = 0; i < numdvds; i++)
                file.println(dvdArray[i].getTitle() + "," + dvdArray[i].getRating() + "," + dvdArray[i].getRunningTime());

            // Closing the printwriter file.
            file.close();
        }
        catch(Exception e)
        {
            System.out.print("Problem saving the data to the file, returning...");
            return;
        }
	}

	// Additional private helper methods go here:



	
}
