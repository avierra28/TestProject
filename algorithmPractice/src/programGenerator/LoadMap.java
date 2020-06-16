package programGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoadMap
{
	public LoadMap()
	{
		super();
	}
	
	public HashMap<String, List<String>> loadMap()
	{
		HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
		List<String> tempList = new ArrayList<String>();
		
		tempList.add("int main()\n {\n <stat_list> \n\nreturn 0; }");
		hashMap.put("<prog>", tempList);
		
		tempList = new ArrayList<String>();
		tempList.add("<stat>");
		tempList.add("<stat_list> <stat>");
		hashMap.put("<stat_list>", tempList);
		
		tempList = new ArrayList<String>();
		
		tempList.add("<cmpd_stat>");
		tempList.add("<if_stat>");
		tempList.add("<iter_stat>");
		tempList.add("<assgn_stat>");
		tempList.add("<decl_stat>");
		hashMap.put("<stat>", tempList);
		
		tempList = new ArrayList<String>();
		
		tempList.add("{ <stat_list> }");
		hashMap.put("<cmpd_stat>", tempList);
		
		tempList = new ArrayList<String>();
		tempList.add("if ( <exp> )\n <stat>");
		tempList.add("if ( <exp> )\n <cmpd_stat>");
		tempList.add("if ( <exp> )\n <stat> else\n <stat>");
		tempList.add("if ( <exp> )\n <cmpd_stat> else\n <stat>");
		tempList.add("if ( <exp> )\n <stat> else\n <cmpd_stat>");
		tempList.add("if ( <exp> )\n <cmpd_stat> else\n <cmpd_stat>");
		hashMap.put("<if_stat>", tempList);
		
		tempList = new ArrayList<String>();
		
		tempList.add("while ( <exp> )\n <stat>");
		tempList.add("while ( <exp> )\n <cmpd_stat>");
		hashMap.put("<iter_stat>", tempList);
		
		tempList = new ArrayList<String>();
		
		tempList.add("<id> = <exp> ;");
		hashMap.put("<assgn_stat>", tempList);
		
		tempList = new ArrayList<String>();
		
		tempList.add("<type> <id> ;");
		tempList.add("<type> <assgn_stat>");
		hashMap.put("<decl_stat>", tempList);
		
		tempList = new ArrayList<String>();
		tempList.add("<exp> <op> <exp>");
		tempList.add("<id>");
		tempList.add("<const>");
		hashMap.put("<exp>", tempList);
		
		tempList = new ArrayList<String>();
		tempList.add("+");
		tempList.add("-");
		tempList.add("/");
		tempList.add("*");
		hashMap.put("<op>", tempList);
		
		tempList = new ArrayList<String>();
		
		tempList.add("int");
		tempList.add("double");
		hashMap.put("<type>", tempList);
		
		tempList = new ArrayList<String>();
		
		tempList.add("<char><char_digit_seq>");
		hashMap.put("<id>", tempList);
		
		tempList = new ArrayList<String>();
		
		tempList.add("<digit><digit_seq>");
		hashMap.put("<const>", tempList);
		
		tempList = new ArrayList<String>();
		tempList.add("[empty]");
		tempList.add("<char><char_digit_seq>");
		tempList.add("<digit><char_digit_seq>");
		hashMap.put("<char_digit_seq>", tempList);
		
		tempList = new ArrayList<String>();
		tempList.add("[empty]");
		tempList.add("<digit><digit_seq>");
		hashMap.put("<digit_seq>", tempList);
		
		tempList = new ArrayList<String>();
		tempList.add("A");
		tempList.add("B");
		tempList.add("C");
		tempList.add("D");
		tempList.add("E");
		tempList.add("F");
		tempList.add("G");
		tempList.add("H");
		tempList.add("I");
		tempList.add("J");
		tempList.add("K");
		tempList.add("L");
		tempList.add("M");
		tempList.add("N");
		tempList.add("O");
		tempList.add("P");
		tempList.add("Q");
		tempList.add("R");
		tempList.add("S");
		tempList.add("T");
		tempList.add("U");
		tempList.add("V");
		tempList.add("W");
		tempList.add("X");
		tempList.add("Y");
		tempList.add("Z");
		tempList.add("a");
		tempList.add("b");
		tempList.add("c");
		tempList.add("d");
		tempList.add("e");
		tempList.add("f");
		tempList.add("g");
		tempList.add("h");
		tempList.add("i");
		tempList.add("j");
		tempList.add("k");
		tempList.add("l");
		tempList.add("m");
		tempList.add("n");
		tempList.add("o");
		tempList.add("p");
		tempList.add("q");
		tempList.add("r");
		tempList.add("s");
		tempList.add("t");
		tempList.add("u");
		tempList.add("v");
		tempList.add("w");
		tempList.add("x");
		tempList.add("y");
		tempList.add("z");
		hashMap.put("<char>", tempList);
		
		tempList = new ArrayList<String>();
		tempList.add("1");
		tempList.add("2");
		tempList.add("3");
		tempList.add("4");
		tempList.add("5");
		tempList.add("6");
		tempList.add("7");
		tempList.add("8");
		tempList.add("9");
		hashMap.put("<digit>", tempList);
		
		return hashMap;
	}
}
