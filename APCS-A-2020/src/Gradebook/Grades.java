package Gradebook;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades {
	private double[] grades;

	public Grades() {
		setGrades("");
	}

	public Grades(String gradeList) {
		setGrades(gradeList);
	}

	public void setGrades(String gradeList) {
		Scanner input = new Scanner(gradeList);
		int numGrades = input.nextInt();
		//System.out.println(numGrades);
		
		grades = new double[numGrades];
		
		//System.out.println(input.next());
		input.next();
		
		for (int i = 0; i < numGrades; i++) {
			//grades[i] = Double.parseDouble(input.next());
			grades[i] = input.nextDouble();
		}
	}

	public void setGrade(int spot, double grade) {
		grades[spot] = grade;
	}

	public double getSum() {
		double sum = 0.0;
		for(double grade:grades) {
			sum += grade;
		}
		return sum;
	}

	public double getLowGrade() {
		double low = Double.MAX_VALUE;
		for(double grade:grades) {
			if(grade<low)
				low = grade;
		}
		return low;
	}

	public double getHighGrade() {
		double high = Double.MIN_VALUE;
		for(double grade:grades) {
			if(grade>high)
				high = grade;
		}
		return high;
	}

	public int getNumGrades() {
		return grades.length;
	}
	
	public String getLetterGrade(double grade) {
		if(grade < 60) 
			return "F";
		else if(grade < 70 ) 
			return "D";
		else if(grade < 80)
			return "C";
		else if(grade < 90)
			return "B";
		else
			return "A";
	}
	
	public double[] getGrades() {
		return grades;
	}

	public String toString() {
		String output = "";
		for(double grade:grades) {
			output += grade + "\n" + getLetterGrade(grade) + "\n";
		}
		return output;
	}
}