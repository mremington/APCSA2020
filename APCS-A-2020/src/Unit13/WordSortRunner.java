package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import static java.lang.System.*; 

public class WordSortRunner
{
	public static void main(String args[])
	{
		//add test cases
		WordSort case1 = new WordSort("abc ABC 12321 fred alexander");
		System.out.println(case1);
		
		WordSort case2 = new WordSort("a zebra friendly acrobatics 435 TONER PRinTeR");
		System.out.println(case2);
		
		WordSort case3 = new WordSort("b x 4 r s y $");
		System.out.println(case3);
		
		WordSort case4 = new WordSort("123 ABC abc 034 dog cat sally sue bob 2a2");
		System.out.println(case4);
	}
}