//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Nicholas Cornick

package Toys;

import java.util.ArrayList;

public class ToyStore32 {
	private ArrayList<Toy> toyList;

	public ToyStore32() {
		toyList = new ArrayList<Toy>();
	}

	public void myName() {
		System.out.println("Nicholas Cornick");
	}

	public void loadToys(String toys) {
		int indexOf = toys.indexOf(" ");
		toyList.add(new Toy(toys.substring(0, indexOf)));
		while (indexOf > 0) {
			String toyName = toys.substring(0, indexOf);
			Toy newToy = new Toy(toyName);
			boolean added = false;

			for (int i = 0; i < toyList.size(); i++) {
				if (toyList.get(i).getName().equals(toyName)) {
					toyList.get(i).setCount(toyList.get(i).getCount() + 1);
					added = true;
				}
			}
			if (!added) {
				toyList.add(newToy);
				toyList.get(toyList.size() - 1).setCount(1);
			}
			toys = toys.substring(indexOf + 1);
			indexOf = toys.indexOf(" ");
		}
		String toyName = toys.substring(0);
		boolean added = false;
		for (int i = 0; i < toyList.size(); i++) {
			if (toyList.get(i).getName().equals(toyName)) {
				toyList.get(i).setCount(toyList.get(i).getCount() + 1);
				added = true;
			}
		}
		if (!added) {
			toyList.add(new Toy(toyName));
		}
	}

	public Toy getThatToy(String nm) {
		for (Toy toy : toyList) {
			if (toy.getName().equals(nm)) {
				return toy;
			}
		}
		return null;
	}

	public String getMostFrequentToy() {
		int greatest = 0;
		for (int i = 0; i < toyList.size(); i++) {
			if (toyList.get(i).getCount() > toyList.get(greatest).getCount()) {
				greatest = i;
			}
		}
		return toyList.get(greatest).getName();
	}

	public void sortToysByCount() {
		int index = 0;
		for (int i = 0; i < toyList.size(); i++) {
			int greatest = toyList.get(i).getCount();
			for (int k = i; k < toyList.size(); k++) {
				if (greatest < toyList.get(k).getCount()) {
					greatest = toyList.get(k).getCount();
					index = k;
				}
			}

			toyList.add(i, new Toy(toyList.get(index).getName()));
			toyList.get(i).setCount(toyList.get(index + 1).getCount());
			toyList.remove(index + 1);
		}
	}

	public String toString() {
		String output = "[";
		for (int i = 0; i < toyList.size(); i++) {
			if (i == toyList.size() - 1) {
				output += toyList.get(i).toString();
				break;
			}
			output += toyList.get(i).toString() + ", ";
		}
		output += "]";
		return output;
	}
}