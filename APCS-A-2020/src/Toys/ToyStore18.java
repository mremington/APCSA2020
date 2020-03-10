package Toys;
// (c) A+ Computer Science
// www.apluscompsci.com
// Name - andrew tian

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore18
{
	private List<Toy> toyList;

	public ToyStore18()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys(String toys )
	{
		//will place a single instance of each toy into the list for every time it appears.
		int spacecounter = 0;
		//loops through every char, to check if there's a space then seperates it.
		for (int i = 0; i < toys.length(); i++) {
			//if there's a space
			if (toys.charAt(i) ==' ') {
				//the spacecoutner should give us the length of the word.
				//check, you can remove this print statement later.
				//System.out.println(toys.substring(i-spacecounter, i));
				Toy addToy = getThatToy(toys.substring(i-spacecounter, i));
				//if the addtoy is UNIQUE
				if( addToy == null )
				{
					//check, you can remove this print statement later.
					//System.out.println(toys.substring(i-spacecounter, i));
					toyList.add(new Toy(toys.substring(i-spacecounter, i)));
				}
				//if it just another one
				else
				{
					//check, you can remove this print statement later.
					//System.out.println(toys.substring(i-spacecounter, i));
					addToy.setCount(addToy.getCount() + 1);
					//check, you can remove this print statement later.
					//System.out.println(addToy.getCount());
				}
				spacecounter = 0;
			}	
			//if there's no space
			else {
				spacecounter += 1;
				//check, you can remove this print statement later.
				//System.out.println(spacecounter);
			}	
		}
   }
		
	
	 
  public Toy getThatToy( String nm )
  {
  	for (Toy t : toyList)
  	{
  		if( t.getName().equals( nm ))
  			 return t;
  	}
  	return null;
  }
  
  public String getMostFrequentToy()
  {
  	String name = "";
  	int largest = 0;
  	for(Toy t : toyList)
  	{
  		if(largest < t.getCount())
  		{
  			largest = t.getCount();
  			name = t.getName();
  		}
  	}
  	return name;
    //VERY OLD AND CUMBERSOME METHOD. DOES NOT WORK! Attempt from inclass.
  	
  	//Notes to self for future reference: don't always use so many lists and just use the built in count for the toy instead of trying to make 2d lists but using 1d lists.
		/*
		//this first part is essentially a get count.
		//three lists, one to store the toy names, the other the counts of those toys matched up, the last to store the toys themselves.
		ArrayList<String> uniquenames = new ArrayList<String>();
		ArrayList<Integer> adjcounts = new ArrayList<Integer>();
		ArrayList<Toy> copy = new ArrayList<Toy>();
		copy = toyList;
		String tempstring = "";
		String u = "";
		int storage = 0;
		
		//first elements adds the toy name into the unique names and a count/
		uniquenames.add(copy.get(0).getName());
		adjcounts.add(1);
		
		//System.out.println(copy.size());
		
		for (int i2 = 1; i2 < copy.size(); i2++){
			Toy t = copy.get(i2);
			tempstring = t.getName();
			//System.out.println(uniquenames.size());  			
			for (int i1 = 0; i1 < uniquenames.size(); i1++) {
				u = uniquenames.get(i1);
				//if the same add to the count.
			if (u.equals(tempstring)) {
	  			//loops through to find identical, take that index to add 1 to the count in each of the count in the count list for the corresponding word
	  			storage = adjcounts.get(i1)+1;
				adjcounts.set(i1,storage);
	  			System.out.println("destination1");
	  			System.out.println(u + "1");
	  		}
			//if they're unique, add one to the uniquelist
  			else {
  				uniquenames.add(u);
  				adjcounts.add(1);
  				System.out.println("destination2");
  				System.out.println(t);
  				System.out.println("uniquenamesize: " + uniquenames.size());
  				i1 += 1;
  			}
		}
			uniquenames.add(tempstring);
		}
		
		//now look through the counts list to find the largest, then match its index to the correspodning unique name
		int largestindex = 0;
		for (int i = 0; i < adjcounts.size()-1; i++) {
			if (adjcounts.get(i) < adjcounts.get(i+1)) {
				largestindex = adjcounts.get(i+1);
			}
		}
		*/
		//return toyList.get(largestindex).getName();
  }
  
  public void sortToysByCount()
  {
		//bubble sorting method. Compares every count for each then bubble sorts it and then matches it to the subsequent toy.
	    Toy temp = new Toy();
	    for (int i = 0; i < toyList.size()-1; i++) {
	        if (toyList.get(i).getCount() - toyList.get(i + 1).getCount() > 0) {
	           temp = toyList.get(i);
	           toyList.set(i, toyList.get(i + 1));
	           toyList.set(i + 1, temp);
	               
	        }
	    }
 //a stupidly complex way to do bubblesort. DOESN't WORK. ATTEMPT FROM INCLASS.
  		
  		/*
  		String toyName = "";
  	  	int largestnum = 0;
  	  	ArrayList<Toy> reorg1 = new ArrayList<Toy>();
  	  	reorg1 = toyList;
  	    ArrayList<Toy> reorg2 = new ArrayList<Toy>();
  	  	//gets us the largest num.
  	  	for( Toy toycounter : toyList )
  	  	{
  	  		if( largestnum < toycounter.getCount() )
  	  		{
  	  			toyName = toycounter.getName();
  	  			largestnum = toycounter.getCount();
  	  		}
  	  	}
  	  	
  	  	int checkcopy = 0;
  	    for (int i = 0; i<reorg1.size();i++) {
  	    	if (checkcopy == 0 && reorg1.get(i).getCount() == largestnum) {
  	    		reorg2.add(reorg1.get(i));
  	    		reorg1.remove(i);
  	    		checkcopy +=1;
  	    		i -=1;
  	    	}
  	    	else if (checkcopy > 0 && reorg1.get(i).getCount() == largestnum) {
  	    		reorg1.remove(i);
  	    		checkcopy +=1;
  	    		i -=1;
  	    	}
  	    }
  	  	
  	  	
  	  	
  	  	
  	  	
  	  	for (int i = 0; i<reorg1.size();i++) {
  	  		if (reorg1.get(i).getCount()==largestnum) {
  	  			reorg2.add(reorg1.get(i));
  	  			reorg1.remove(i);
  	  		}
  	  	}
  	  	
  	  	toyList = reorg2;
  	  	*/
	}
  
	public String toString()
	{
	   return "" + toyList;
	}
	
	public String myName() {
		return "Andrew Tian";
	}
}

/*
 * * Test your Toy and ToyStore classes to work with the attached ToyStoreRunner

* Add the following method to your ToyStore.java file:
public String myName(){
System.out.printLn("First Name Last Name");
}

* Right Click on your ToyStore.java file and Refactor-->Rename: Rename the file with your computer number.
Ex) ToyStore1.java for computer #1. toystore18

* Turn in your ToyStore.java file --> Right Click --> Show In --> System Explorer
** ONLY TURN IN ToyStore.java no other files
 */
