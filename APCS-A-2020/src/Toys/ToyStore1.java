package Toys;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore1
{
	private ArrayList<Toy> toyList;

	public ToyStore1()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys( String toys )
	{
		String[] list = toys.split(" ");
		for (String i : list) {
			Toy toy = getThatToy(i);
			if (toy != null) {
				toy.setCount(toy.getCount());
			}
			else {
				toyList.add(new Toy(i));
			}
		}
		
	}
  
  	public Toy getThatToy( String nm )
  	{
  		for (Toy a : toyList) {
  			if(a.getName().equals(nm)) {
  	  			return a;
  			}
  		}
  		return null;
  	}
  
  	
  	//ex
  	public String getMostFrequentToy()
  	{
  		String name = "";
		double max = Integer.MIN_VALUE;
		for(Toy x: toyList)
		{
			if(max < x.getCount())
			{
				max = x.getCount();
				name = x.getName();
			}
		}
		return name;
  	}  
  
  	
  	//ex
  	public void sortToysByCount()
  	{
  		ArrayList<Toy> sorted = new ArrayList<Toy>();
  		while (toyList.size() > 0) {
  			Toy biggestCountToy = getThatToy(getMostFrequentToy());
  			toyList.remove(biggestCountToy);
  			sorted.add(biggestCountToy);
  		}
  		
  		toyList = sorted;
  	}  
  	  
  	public String myName() {
  		System.out.println("Dylan Greany");
  		return "Dylan Greany";
  	}
  	
	public String toString()
	{
		String output = "";
		for (Toy toy : toyList) {
			output += toy + ", ";
		}
		return output;
	}
}