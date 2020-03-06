package Toys;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore27
{
	public String myName() {
		return "Kaitlyn Wang";
	}
	private ArrayList<Toy> toyList;

	public ToyStore27()
	{
    toyList = new ArrayList<Toy>();
	}

  public ToyStore27(String toys)
	{
    toyList = new ArrayList<Toy>();
    loadToys(toys);
	}

	public void loadToys( String toys )
	{
    
    String[] toyNames = toys.split(" +");
   
    for (String toyName: toyNames)
    {
      addToy(toyName);
    }
    
	}

 
  public void addToy(String toyName)
  {
    Toy toy = getThatToy(toyName);
    
    if (toy == null)
      toyList.add(new Toy(toyName));
    //else
      //toy.addToy();
    
  }

  // another useful method
  public void removeToy(String toyName)
  {
    
    for (int i = 0; i < toyList.size(); i++)
    {
      Toy toy = toyList.get(i);
      if (toy.getName().equals(toyName))
      {
        //toy.removeToy();
        if (toy.getCount() == 0)
          toyList.remove(i);
        break;
      }
    }
  }

  public Toy getThatToy( String nm )
  {
    for (Toy t : toyList)
      if (t.getName().equals(nm))
        return t;
  	return null;
  }
  
  public String getMostFrequentToy()
  {
    sortToysByCount();
  	return (toyList.get(toyList.size()-1)).getName();
  }

  // example of getting a Toy object
  public Toy getMinToy()
  {
    if (toyList.size() == 0)
      return null;

    Toy minToy = toyList.get(0);
    for (Toy t : toyList)
      if (t.getCount() < minToy.getCount())
        minToy = t;
        
    return minToy;    
  }
  
  public void sortToysByCount()
  {
    //Collections.sort(toyList);
  }  
  	  
	public String toString()
	{
	   return toyList.toString();
	}
}