package Toys;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore12 {
	private ArrayList<Toy> toyList;

	public ToyStore12() {
		toyList = new ArrayList<Toy>();
	}

	public String myName() {
		return "Kevin Lee";
	}

	public void loadToys(String toys) {
		String[] toysArray = toys.split(" ");
		for (String str : toysArray) {
			Toy toy = getThatToy(str);
			if (toy != null) {
				toy.setCount(toy.getCount() + 1);
			} else {
				toyList.add(new Toy(str));
			}
		}

	}

	public Toy getThatToy(String nm) {
		for (int i = 0; i < toyList.size(); i++) {
			if (toyList.get(i).getName().equals(nm))
				return toyList.get(i);
		}
		return null;
	}

	public String getMostFrequentToy() {
		int mostCount = 0;
		String mostName = "";
		for (int i = 0; i < toyList.size(); i++) {
			if (toyList.get(i).getCount() > mostCount) {
				mostCount = toyList.get(i).getCount();
				mostName = toyList.get(i).getName();
			}
		}
		return mostName;
	}

	public void sortToysByCount() {
		ArrayList<Toy> sorted = new ArrayList<Toy>();
		while (toyList.size() > 0) {
			Toy mostToy = getThatToy(getMostFrequentToy());
			toyList.remove(mostToy);
			sorted.add(mostToy);
		}

		toyList = sorted;
	}

	public String toString() {
		String output = "";
		sortToysByCount();

		for (int i = 0; i < toyList.size(); i++) {
			output += toyList.get(i) + ", ";
		}

		return output;
	}
}