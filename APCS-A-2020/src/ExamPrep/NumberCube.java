package ExamPrep;

import java.util.Random;

public class NumberCube {
	
	public int toss() {
		Random rNum = new Random();
		return rNum.nextInt(7);
	}

}
