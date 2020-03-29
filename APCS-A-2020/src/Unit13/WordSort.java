package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import static java.lang.System.*; 

public class WordSort
{
	private String[] wordRay;

	public WordSort(String line)
	{
	   setList(line);
	}

	public void setList(String line)
	{
		wordRay = line.split(" ");
	}

	//selection sort
	public void sort()
	{
		   for(int i=0; i< wordRay.length-1; i++){
		      int min = i;
		      for(int j = i+1; j<  wordRay.length; j++)
		      {
		         if( wordRay[j].compareTo(wordRay[min]) > 0 )
		            min = j;    		//find location of smallest
		      }
		      if(min != i) {
		         String temp = wordRay[min];
		         wordRay[min] = wordRay[i];
		         wordRay[i] = temp;   	//put smallest in spot i
		      }
		   }
		

	}

	public String toString( )
	{
		//System.out.println(wordRay[1].compareTo(wordRay[0]));
		
		sort();
		
		
		
		//Arrays.sort(wordRay);
		
		String output="";
		int num = 0;
		for(String word:wordRay) {
			output += "word " + num + " :: " + word + "\n";
		}
		return output+"\n\n";
	}
}