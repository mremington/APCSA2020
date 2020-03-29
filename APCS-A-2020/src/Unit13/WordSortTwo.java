package Unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class WordSortTwo {
	private String[] wordRay;

	public WordSortTwo(String sentence) {
		wordRay = sentence.split(" ");
	}

	public void setWords(String sentence) {
		wordRay = sentence.split(" ");
	}

	void sort() {
		Arrays.sort(wordRay);
	}

	public String toString() {
		String output = "";
		for (String s : wordRay) {
			output += s + "\n";
		}
		return output + "\n\n";
	}
}