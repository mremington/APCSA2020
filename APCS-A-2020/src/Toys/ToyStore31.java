//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package Toys;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore31
{
	private ArrayList<Toy> toyList = new ArrayList<Toy>();
	private ArrayList<Toy> sortedList=new ArrayList<Toy>();
	private String toyName;


	public ToyStore31()
	{
		toyName = "default";
		
	}

	public void loadToys( String toys )
	{
		boolean condition = true;
		while (condition)
		{
			
			Toy toy = new Toy(toys.substring(0,toys.indexOf(' ')));
			toyList.add(toy);
			toys =  toys.substring(toys.indexOf(' ')+1);
			
			
			
			if (toys.indexOf(' ') == -1) {
				Toy newToy = new Toy(toys);
				toyList.add(toy);
				condition = false;
			}
		}
		sortToysByCount();
	}
  
  	public Toy getThatToy( String nm )
  	{
  		for (int x = 0; x < toyList.size(); x++) {
  			if (toyList.get(x).getName().equals(nm)) {
  				return toyList.get(x);
  			}
  		}
  		return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  		Toy mostToy = sortedList.get(0);
  		for (int x = 1; x < sortedList.size();x++) {
  			if (sortedList.get(x).getCount() > mostToy.getCount()) {
  				mostToy = sortedList.get(x);
  			}
  		}
  		
  		
  		return mostToy.getName();
  	}  
  
  	public void sortToysByCount()
  	{
  		
  		for (int x = 0; x < toyList.size(); x++) {
  	  		int count = 0;

  			for (int y = 0; y < toyList.size();y++) {
  				if (toyList.get(x).getName().equals(toyList.get(y).getName())) {
  					count++;
  				}
  			}
  			Toy newToy = new Toy(toyList.get(x).getName());
  			newToy.setCount(count);
  	  		sortedList.add(newToy);
  	  		for (int y = 1; y < toyList.size();y++) {
				if (toyList.get(y).getName().equals(newToy.getName())) {
					toyList.remove(toyList.get(y));
				}
			}
  	  		

  		}
  		
  		
  	}  
  	public String myName(){
  		
  		System.out.println("Paul Han");
  		
  		return "Paul Han";
  	}

  	  
	public String toString()
	{
	   return sortedList.toString();
	}
}