package Bio;

import java.util.ArrayList;

public class DNA3 {
	
	
	public static String s1 = "AAACTCATC";
	public static String s2 =  "TTTCAAATC";
	
	public static ArrayList<String> s1List = new ArrayList<String>();
	//public static ArrayList<String> s1RevCompList = new ArrayList<String>();
	
	public static ArrayList<String> s2List = new ArrayList<String>();
	public static ArrayList<String> s2RevCompList = new ArrayList<String>();
	

	public static void main(String[] args) {

		get3Mers(s1, s1List);
		System.out.println("\n");
		getForwardAndReverse3Mers(s2, s2List, s2RevCompList);
		System.out.println("\n");
		System.out.println("Number of Matches between " + s1 + " and " + s2 + " is: " + 
				getNum3MerMatches(s1List, s2List, s2RevCompList));
		
		
	}//end main method
	
	public static void get3Mers(String s, ArrayList list) {
		System.out.println("3-mer sequences in " + s);
		for(int i = 0; i < s.length() - 2; i++) {
			String sequence = s.substring(i,i+3);	
			System.out.println( sequence);
			list.add(sequence);
		}
	}//end get3Mers method
	
	public static void getForwardAndReverse3Mers(String s, ArrayList list, ArrayList rList) {
		System.out.println("3-mer sequences in " + s);
		for(int i = 0; i < s.length() - 2; i++) {
			String sequence = s.substring(i,i+3);
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
					revComp += sequence.substring(j,j+2);
			}
			
			revComp = new StringBuffer(revComp).reverse().toString();
			
			System.out.println( sequence + " Reverse Complement: " + revComp);
			list.add(sequence);
			rList.add(revComp);
		}
	}//end getForwardAndReverse3Mers method
	
	
	public static int getNum3MerMatches(ArrayList a1, ArrayList a2, ArrayList ra2) {
		int numMatches = 0;
		
		for(int i = 0; i < a1.size(); i++) {
			for(int j = 0; j < a2.size(); j++) {
				if(a1.get(i).equals(a2.get(j))) {
					numMatches++;
				}
			}
		}
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