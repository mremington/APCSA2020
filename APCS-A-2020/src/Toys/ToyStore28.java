package Toys;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore28
{
	private ArrayList<Toy> toyList;

	public ToyStore28()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys( String toys )
	{
		ArrayList<String> names = new ArrayList<String>();
		
		for (String name : toys.split(" ")) 
		{
			if (!names.contains(name)) 
			{
				toyList.add(new Toy(name));
				names.add(name);
			}
			else 
			{
				Toy t = getThatToy(name);
				t.setCount(t.getCount() + 1);
			}
		}		
	}
  
  	public Toy getThatToy( String nm )
  	{
  		for (Toy t : toyList) 
  		{
  			if (t.getName().equals(nm)) 
  			{
  				return t;
  			}
  		}
  		return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  		int mostTimes = 0;
  		String mostName = "error";
  		
  		for (Toy t : toyList) {
  			if (t.getCount() > mostTimes) {
  				mostTimes = t.getCount();
  				mostName = t.getName();
  			}
  		}
  		return "most popular toy is ::  " + mostName;
  	}  
  
  	public void sortToysByCount()
  	{
  		int check;
  		Toy temp;
  		
  		for (int i = 1; i < toyList.size(); i++) 
  		{
  			check = i - 1;
  			while (check >= 0 && toyList.get(i).getCount() < toyList.get(check).getCount()) 
  			{
  				check--;
  			}
  			temp = toyList.remove(i);
  			toyList.add(check + 1, temp);
  		}

  	}  
  	
  	public String myName()
  	{
  		return ("Eric Xu");
  	}

  	
	public String toString()
	{
		return "" + toyList.toString();
	}
}