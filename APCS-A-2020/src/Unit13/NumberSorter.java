package Unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter {
	// instance variables and other methods not shown

	private static int getNumDigits(int number) {
		int count = 0;
		while (number > 0) {
			count++;
			number = number / 10;
		}

		return count;
	}

	public static int[] getSortedDigitArray(int number) {
		int[] sorted = new int[getNumDigits(number)];
		int spot = 0;
		while (number > 0) {
			sorted[spot++] = number % 10;
			number = number / 10;
		}
		Arrays.sort(sorted);
		return sorted;
	}
}