package Toys;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static java.lang.System.*;

public class ToyStore10 {
	private Toy t = new Toy();
	private ArrayList<Toy> toyList;
	private String[] toyRay;

	public ToyStore10(String toys) {
		toyList  = new ArrayList<Toy>();
		loadToys(toys);
	}

	public void loadToys(String toys) {
		toyRay = toys.split(" ");
		@SuppressWarnings("resource")
		Scanner next = new Scanner(toys);
		while (next.hasNext()) {
			Toy t2;
			String temp = next.next();
			Toy tst = getThatToy(temp);
			if (tst == null) {
				t2 = new Toy(temp, 1);
				toyList.add(t2);
			} else
				tst.setCount(tst.getCount() + 1);
		}
	}

	public Toy getThatToy(String nm) {
		for (Toy k : toyList) {
			if (k.getName().equals(nm))
				return k;
		}
		return null;
	}

	public Toy getMostFrequentToy() {
		int currentMax = 0;
		Toy currentToy = new Toy();
		for(Toy y: toyList) {
			if(y.getCount() > currentMax) {
				currentMax = y.getCount();
				currentToy = y;
			}
		}
		return currentToy;
	}

	public ArrayList<Toy> sortToysByCount() {
  		ArrayList<Toy> placeholder = new ArrayList<Toy>();
  		while(toyList.size() > 0)
  		{
  			placeholder.add(getMostFrequentToy());
  			toyList.remove(getMostFrequentToy());
  		}
  		return placeholder;
	}

	public String myName(){
		return "\nCarl Cheng\n";
	}
	
	public String toString() {
		return toyList.toString() + "\n" + "most freq; " + getMostFrequentToy() + "\n" + "sorted from most to least; " + sortToysByCount() + myName();
	}
}