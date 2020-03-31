package Bio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DNA {
	
	
	//public static String s1 = "AAACTCATC";
	//public static String s2 =  "TTTCAAATC";
	
	public static ArrayList<String> s1List = new ArrayList<String>();
	//public static ArrayList<String> s1RevCompList = new ArrayList<String>();
	
	public static ArrayList<String> s2List = new ArrayList<String>();
	public static ArrayList<String> s2RevCompList = new ArrayList<String>();
	

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
		System.out.println("\n");
		getForwardAndReverse3Mers(n,s2, s2List, s2RevCompList);
		System.out.println("\n");
		System.out.println("Number of Matches:" + 
				getNumNmerMatches(s1List, s2List, s2RevCompList));
		
		
	}//end main method
	
	public static void getNmers(int n, String s, ArrayList list) {
		//System.out.println(n+ "-mers:");
		for(int i = 0; i < s.length() - (n-1); i++) {
			String sequence = s.substring(i,i+n);
			//System.out.println( sequence);
			list.add(sequence);
		}
	}//end get3Mers method
	
	public static void getForwardAndReverse3Mers(int n, String s, ArrayList list, ArrayList rList) {
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
	
	
	
	public static int getNumNmerMatches(ArrayList a1, ArrayList a2, ArrayList ra2) {
		int numMatches = 0;
		
		for(int i = 0; i < a1.size(); i++) {
			for(int j = 0; j < a2.size(); j++) {
				if(a1.get(i).equals(a2.get(j))) {
					numMatches++;
				}
			}
		}
		System.out.println("Number of forward matches: " + numMatches);
		for(int i = 0; i < a1.size(); i++) {
			for(int j = 0; j < ra2.size(); j++) {
				if(a1.get(i).equals(ra2.get(j))) {
					numMatches++;
				}
			}
		}
		
		return numMatches;
	}

}
