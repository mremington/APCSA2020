package Toys;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Phillip Huang

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore16
{
	private ArrayList<Toy> toyList;
	
	public ToyStore16()
	{
		toyList = new ArrayList<Toy>();
	}

	public String myName(){
		return "Phillip Huang";
	}
	
	public ToyStore16(String toys) {
		toyList = new ArrayList<Toy>();
        for (String t: toys.split(" ")){
            loadToys(t);
        }
	}
	
	public void loadToysStart( String toys )
	{
		
		Toy that = getThatToy(toys);
		if (that == null){
			toyList.add(new Toy(toys));
		} else{
			that.setCount(that.getCount()+1);
		}

	}
	
	public void loadToys( String toys )
	{
		toyList.clear();
		for (String t: toys.split(" ")){
            loadToysStart(t);
        }
	}
  
  	public Toy getThatToy(String nm)
  	{
  		for (Toy toy : toyList) {
  			if (toy.getName().equals(nm))
  				return toy;
  		}
  		return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  		Toy max = toyList.get(0);
  		int m = 0;
        for(int i = 0; i < toyList.size(); i++) {
            m = toyList.get(0).getCount();
            if (toyList.get(i).getCount()>m){
                max = toyList.get(i);
                m = toyList.get(i).getCount();
                
            }
        }
        return max.getName();
  	}  
  
  	public void sortToysByCount()
  	{
  		Collections.sort(toyList, Collections.reverseOrder());
  	}  
  	  
	public String toString()
	{ 
		return toyList+"";
	}
}