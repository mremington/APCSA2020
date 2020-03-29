package Gradebook;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class {
	private String name;
	private Student[] studentList;

	public Class() {
		name = "";
		studentList = new Student[0];
	}

	public Class(String name, int stuCount) {
		this.name = name;
		studentList = new Student[stuCount];
	}

	public void addStudent(int stuNum, Student s) {
		studentList[stuNum] = s;
	}

	public String getClassName() {
		return name;
	}

	public double getClassAverage() {
		double classAverage = 0.0;
		double classSum = 0.0;
		for(Student s:studentList) {
			classSum += s.getAverage();
		}
		
		classAverage = classSum/studentList.length;
		
		return classAverage;
	}

	public double getStudentAverage(int stuNum) {
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName) {
		
		double average = 0.0;
		
		for(Student s:studentList) {
			if(s.getName().equals(stuName))
				average = s.getAverage();
		}
		
		
		return average;
	}

	public String getStudentName(int stuNum) {
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage() {
		double high = Double.MIN_VALUE;
		String hName = "";
		
		for(Student s:studentList) {
			if(s.getAverage() > high) {
				high = s.getAverage();
				hName = s.getName();
			}
		}

		return hName;
	}

	public String getStudentWithLowestAverage() {
		double low = Double.MAX_VALUE;
		String lowName = "";

		for(Student s:studentList) {
			if(s.getAverage() < low) {
				low = s.getAverage();
				lowName = s.getName();
			}
		}
		
		return lowName;
	}

	public String getFailureList(double failingGrade) {
		String output = "";
		int count = 0;
		for(Student s:studentList) {
			if(s.getAverage() < failingGrade) {
				count ++;
				output += s.getName();
			}
			if(count > 1 && count < studentList.length) {
				output += ", ";
			}
		}
		return output;
	}
	
	public void sort() {
		Arrays.sort(studentList);
	}

	public String toString() {
		String output = "" + getClassName() + "\n";
		for(Student s:studentList) {
			output += s.getName() +" = "+ s.getGradeList() +" "+s.getAverage() +"\n";
		}
		return output;
	}
}