package programGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class ProgramGenerator extends LoadMap
{
	private static HashMap<String, List<String>> hashMap;
	private static String masterString;
	private static Random random;
	
	public ProgramGenerator()
	{
		masterString = "";
		// Define a hashmap to store all the productions.
		hashMap = loadMap();
	}

	public static void main(String[] args)
	{	
		new ProgramGenerator();
		int counter = 0;
		
		// Begin our masterString.
		masterString = hashMap.get("<prog>").toString();
				
		// If the master string contains a terminal in any way we still have work to do.
		while(masterString.contains("<") || masterString.contains(">"))
		{
			if(counter == 30)
				break;

			// Begin our if statements.
			if(masterString.contains("<stat_list>"))
				stat_list();
			else if(masterString.contains("<stat>"))
				stat();
			else if(masterString.contains("<cmpd_stat>"))
				cmpd_stat();
			else if(masterString.contains("<if_stat>"))
				if_stat();
			else if(masterString.contains("<iter_stat>"))
				iter_stat();
			else if(masterString.contains("<assgn_stat>"))
				assgn_stat();
			else if (masterString.contains("<decl_stat>"))
				decl_stat();
			else if(masterString.contains("<exp>"))
				exp();
			else if(masterString.contains("<op"))
				op();
			else if(masterString.contains("<type>"))
				type();
			else if(masterString.contains("<id>"))
				id();
			else if(masterString.contains("<const>"))
				Const();
			else if(masterString.contains("<char_digit_seq>"))
				char_digit_seq();
			else if(masterString.contains("<digit_seq"))
				digit_seq();
			else if(masterString.contains("<char>"))
				Char();
			else if(masterString.contains("<digit"))
				digit();
			
			counter++;
			System.out.println(masterString + "\n\n\n\n\n\n");
		}
		if(masterString.contains("[empty]"))
		{
			String temp1 = masterString;
			String temp2 = temp1.replaceAll("[empty]", "");
			masterString = temp2;
		}
		
		System.out.println(masterString);
	}
	
	// The <stat_list> function.
	public static void stat_list()
	{
		random = new Random();
		// This is if the string contains a stat list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<stat_list>");
		
		// Determine which output here.
		String str1 = tempArray.get(Math.abs(random.nextInt() % 2));
		String str2 = masterString;
		String str3 = str2.replaceAll("<stat_list>", str1);
		masterString = str3;
	}
	
	// The stat function.
	public static void stat()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<stat>");
		
		// Determine which output here.
		String str1 = tempArray.get(random.nextInt(4) + 0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<stat>", str1);
		masterString = str3;
	}
	
	// The <cmpd_stat> function.
	public static void cmpd_stat()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<cmpd_stat>");

		// Determine which output here.
		String str1 = tempArray.get(0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<cmpd_stat>", str1);
		masterString = str3;
	}
	
	// The <if_stat> function.
	public static void if_stat()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<if_stat>");

		// Determine which output here.
		String str1 = tempArray.get(5) + 0;
		String str2 = masterString;
		String str3 = str2.replaceAll("<if_stat>", str1);
		masterString = str3;
	}
	
	// The <iter_stat> function.
	public static void iter_stat()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<iter_stat>");

		// Determine which output here.
		String str1 = tempArray.get(Math.abs(random.nextInt() % 2));
		String str2 = masterString;
		String str3 = str2.replaceAll("<iter_stat>", str1);
		masterString = str3;
	}
	
	// The <assgn_stat> function.
	public static void assgn_stat()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<assgn_stat>");

		// Determine which output here.
		String str1 = tempArray.get(0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<assgn_stat>", str1);
		masterString = str3;
	}
	
	// The <decl_stat> function.
	public static void decl_stat()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<decl_stat>");

		// Determine which output here.
		String str1 = tempArray.get(0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<decl_stat>", str1);
		masterString = str3;
	}
	
	// The <exp> function.
	public static void exp()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<exp>");

		// Determine which output here.
		String str1 = tempArray.get(2) + 0;
		String str2 = masterString;
		String str3 = str2.replaceAll("<exp>", str1);
		masterString = str3;
	}
	
	// The <op> function.
	public static void op()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<op>");

		// Determine which output here.
		String str1 = tempArray.get(3) + 0;
		String str2 = masterString;
		String str3 = str2.replaceAll("<op>", str1);
		masterString = str3;
	}
	
	// The <type> function.
	public static void type()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<type>");

		// Determine which output here.
		String str1 = tempArray.get(Math.abs(random.nextInt() % 2));
		String str2 = masterString;
		String str3 = str2.replaceAll("<type>", str1);
		masterString = str3;
	}
	
	// The <id> function.
	public static void id()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<id>");

		// Determine which output here.
		String str1 = tempArray.get(0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<id>", str1);
		masterString = str3;
	}
	
	// The <const> function.
	public static void Const()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<const>");

		// Determine which output here.
		String str1 = tempArray.get(0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<const>", str1);
		masterString = str3;
	}
	
	// The <char_digit_seq> function.
	public static void char_digit_seq()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<char_digit_seq>");

		// Determine which output here.
		String str1 = tempArray.get(random.nextInt(2) + 0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<char_digit_seq>", str1);
		masterString = str3;
	}
	
	// The <digit_seq> function.
	public static void digit_seq()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<digit_seq>");

		// Determine which output here.
		String str1 = tempArray.get(Math.abs(random.nextInt() % 2));
		String str2 = masterString;
		String str3 = str2.replaceAll("<digit_seq>", str1);
		masterString = str3;
	}
	
	// The <char> function.
	public static void Char()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<char>");

		// Determine which output here.
		String str1 = tempArray.get(random.nextInt(tempArray.size() - 1) + 0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<char>", str1);
		masterString = str3;
	}
	
	// The <digit> function.
	public static void digit()
	{
		// Generate new random.
		random = new Random();
		// Generate a new list.
		List<String> tempArray = new ArrayList<String>();
		tempArray = hashMap.get("<digit>");

		// Determine which output here.
		String str1 = tempArray.get(random.nextInt(tempArray.size() - 1) + 0);
		String str2 = masterString;
		String str3 = str2.replaceAll("<digit>", str1);
		masterString = str3;
	}

}





















