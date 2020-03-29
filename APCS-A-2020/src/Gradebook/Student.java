package Gradebook;


import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Student implements Comparable<Student>{
	private String myName;
	private Grades myGrades;

	public Student() {
		setName("");
		setGrades("");
	}

	public Student(String name, String gradeList) {
		setName(name);
		setGrades(gradeList);
	}

	public void setName(String name) {
		myName = name;
	}

	public void setGrades(String gradeList) {
		myGrades = new Grades(gradeList);
	}

	public void setGrade(int spot, double grade) {
		myGrades.setGrade(spot, grade);
	}

	public String getName() {
		return myName;
	}

	public int getNumGrades() {
		return myGrades.getNumGrades();
	}

	public double getSum() {
		return myGrades.getSum();
	}

	public double getAverage() {
		return getSum()/getNumGrades();
	}

	public double getAverageMinusLow() {
		return getAverage() - myGrades.getLowGrade();
	}

	public double getHighGrade() {
		return myGrades.getHighGrade();
	}

	public double getLowGrade() {
		return myGrades.getLowGrade();
	}
	
	public String getGradeList() {
		String grades = "";
		for(double grade:myGrades.getGrades()) {
			grades += grade + " ";
		}
		return grades;
	}
	
	public int compareTo(Student param)
	{
		if(getAverage()>param.getAverage())
		  return 1;
		else if (getAverage()<param.getAverage())
		  return -1;
		return 0;
	}

	public String toString() {
		return getName() +" = "+ getGradeList();
	}
}