package Bio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DNAHashSet {

	public static ArrayList<String> s1List = new ArrayList<String>();
	
	public static ArrayList<String> s2List = new ArrayList<String>();
	public static ArrayList<String> s2RevCompList = new ArrayList<String>();
	
	public static ArrayList<String> combinedList = new ArrayList<String>();
	

	public static void main(String[] args) throws IOException {

		int n = 30;
		
		String file1 = "src/S_enterica.txt";
		String file2 = "src/E_coli.txt";
		Scanner input1 = new Scanner(new File(file1));
		Scanner input2 = new Scanner(new File(file2));
		
		String s1 = "";
		String s2 = "";
		
	    while(input1.hasNextLine()) {
	    	s1 += input1.nextLine();
	    }
	    
	    while(input2.hasNextLine()) {
	    	s2 += input2.nextLine();
	    }
		
		getNmers(n,s1, s1List);
		getForwardAndReverseNmers(n,s2, s2List, s2RevCompList);
		
		combineLists(s1List, s2List, s2RevCompList);
		
		System.out.println("Number of Matches:" + findNumMmerMatches(combinedList));
		
		
	}//end main method
	
	public static void combineLists(ArrayList<String> list1, ArrayList<String> list2, ArrayList<String> list3) {
		for(String s:list1) {
			combinedList.add(s);
		}
		for(String s:list2) {
			combinedList.add(s);
		}
		for(String s:list3) {
			combinedList.add(s);
		}
	}
	
	public static void getNmers(int n, String s, ArrayList list) {
		//System.out.println(n+ "-mers:");
		for(int i = 0; i < s.length() - (n-1); i++) {
			String sequence = s.substring(i,i+n);
			//System.out.println( sequence);
			list.add(sequence);
		}
	}//end get3Mers method
	
	public static void getForwardAndReverseNmers(int n, String s, ArrayList list, ArrayList rList) {
		//System.out.println("Forward and Reverse " + n+ "-mers:");
		for(int i = 0; i < s.length() - (n-1); i++) {
			String sequence = s.substring(i,i+n);
			String revComp = "";
			for(int j = 0; j < sequence.length(); j++) {
				if(sequence.charAt(j)=='A')
					revComp += "T";
				else if(sequence.charAt(j)=='G')
					revComp += "C";
				else if(sequence.charAt(j)=='T')
					revComp += "A";
				else if(sequence.charAt(j)=='C')
					revComp += "G";
				else
					revComp += sequence.substring(j,j+(n-1));
			}
			
			revComp = new StringBuffer(revComp).reverse().toString();
			
			//System.out.println( sequence + " Reverse Complement: " + revComp);
			list.add(sequence);
			rList.add(revComp);
		}
	}//end getForwardAndReverse3Mers method
	
	public static int findNumMmerMatches(ArrayList<String> list) {
		int foundMatches = 0;
		
		Set<String> sequenceSet = new HashSet<String>();
		
		for(String s:list) {
			if(!sequenceSet.add(s)) {
				foundMatches++;
			}
		}
		
		return foundMatches-1;
	}
	
	
}
