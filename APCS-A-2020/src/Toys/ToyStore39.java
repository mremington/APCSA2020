package Toys;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name - Daniel Gharib

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.*;

public class ToyStore39 {
	ArrayList<Toy> toyList;

	public void myName() {
		System.out.println("Daniel Gharib");
	}

	public ToyStore39() {
		toyList = new ArrayList<Toy>();
		System.out.print(toyList);
	}

	public void loadToys(String toys) {
		int wordCount = 1;
		for (int i = 0; i < toys.length(); i++) {
			if (toys.charAt(i) == ' ') {
				wordCount++;
			}
		}
		String[] toyArray = new String[wordCount];
		int lastSpace = 0;
		wordCount = 0;
		for (int i = 0; i < toys.length(); i++) {
			if (toys.charAt(i) == ' ') {
				toyArray[wordCount] = (toys.substring(lastSpace, i));
				wordCount++;
				lastSpace = i + 1;
			}
			if (i == toys.length() - 1) {
				toyArray[wordCount] = (toys.substring(lastSpace, i + 1));
			}
		}

		for (String toyType : toyArray) {
			boolean inList = false;
			for (Toy toy : toyList) {
				if (toy.getName().equals(toyType)) {
					toy.setCount(toy.getCount() + 1);
					inList = true;
				}
			}
			if (inList == false) {
				toyList.add(new Toy(toyType));
			}

		}
		System.out.print(toyList);
	}

	public Toy getThatToy(String nm) {
		return null;
	}

	public String getMostFrequentToy() {
		String biggestName = "";
		for (int i = 0; i < toyList.size() - 1; i++) {
			if (toyList.get(i + 1).getCount() < toyList.get(i).getCount()) {
				biggestName = toyList.get(i).getName();
			}
		}
		return biggestName;
	}

	public void sortToysByCount() {

	}

	public String toString() {
		return "";
	}
}