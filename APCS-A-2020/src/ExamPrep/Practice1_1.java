package ExamPrep;

import java.util.Arrays;

public class Practice1_1 {

	public static void main(String[] args) {
		
		int[] tosses = getCubeTosses(new NumberCube(), 18);
		System.out.println(Arrays.toString(tosses));
		System.out.println(getLongestRun(tosses));
	}
	
	//part a
	public static int[] getCubeTosses(NumberCube cube, int numTosses) {
		int[] tosses = new int[numTosses];
		for(int i = 0; i < tosses.length; i++) {
			tosses[i] = cube.toss();
		}
		return tosses;
	}
	
	//part b
	public static int getLongestRun(int[] values) {
		int count = 0;
		int maxCount = 0;
		int startRun = -1;
		
		for(int i = 0; i < values.length-1; i++) {
			if(values[i] == values[i+1]) {			
				if(count == 0 && count == maxCount) {
					startRun = i;
				}			
				count++;
			}
			else {
				count = 0;
			}
			
			if(count > maxCount) {
				maxCount = count;
			}
			
		}	
		
		return startRun;
	}

}
