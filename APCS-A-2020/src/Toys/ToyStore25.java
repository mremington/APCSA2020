package Toys;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.System.*;

class ToyStore25
{
	private ArrayList<Toy> toyList;
	private int count;
	public ToyStore25()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys( String toys )
	{
		String[] array = toys.split(" ");
		for(String name: array) {
			toyList.add(new Toy(name));
			toySort();
		}
		sortToysByCount();
		
		
		
	}
	
	public void toySort() {
		int last = toyList.size()-1;
		toyList.get(last).setCount(1);
		for(int i = 0; i < toyList.size()-1; i++) {
			if(toyList.get(i).getName().equals(toyList.get(last).getName())){
				toyList.get(i).setCount(toyList.get(i).getCount()+1);
				toyList.remove(last);
				break;
			}
		}
	}
  
  	public Toy getThatToy( String nm )
  	{
  		
  		for(Toy toy: toyList) {
  			if(toy.getName().equals(nm)) {
  				return toy;
  			}
  		}
  		return toyList.get(0);
  	}
  
  	public String getMostFrequentToy()
  	{
  		int max = 0;
  		for(int i = 0; i < toyList.size(); i++) {
  			if(toyList.get(i).getCount()>toyList.get(max).getCount()) {
  				max = i;
  			}
  		}
  		return toyList.get(max).getName();
  	}  
  
  	public void sortToysByCount()
  	{
  		Toy sort;
  		for(int i = 1; i < toyList.size()-1; i++) {
  			if(toyList.get(i).getCount() < toyList.get(i+1).getCount()) {
  				sort = toyList.get(i);
  				toyList.set(i,toyList.get(i+1));
  				toyList.set(i+1, sort);
  				if(toyList.get(i).getCount() > toyList.get(i-1).getCount()){
  					i-=2;
  				}
  			}
  		}
  			
  	}
  	public String myName(){
			System.out.println("Joshua Goodman");
			return "";
			}
  	  
	public String toString()
	{
	   String rtn = "[";
	   for(Toy toy: toyList) {
		   rtn = rtn + toy.toString() + ", ";
	   }
	   rtn = rtn + "]";
	   return rtn;
		
	}
}