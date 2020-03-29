package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSearch
{
	public static int getNextLargest(int[] numArray, int searchNum)
	{
		Arrays.sort(numArray);
		
		int nextPosition = 0;
		
		//Arrays.binarySearch() will return -1 + -(where it should/would be if it was present)
		if(Arrays.binarySearch(numArray,searchNum) < 0) {
			//subtract 1 to adjust for the length of the array given the index starts at 0
			nextPosition= Math.abs(Arrays.binarySearch(numArray,searchNum)) -1;
		}
		else {
			nextPosition= Arrays.binarySearch(numArray,searchNum) + 1;
		}
		
		
		return numArray[ nextPosition ];
	}
}