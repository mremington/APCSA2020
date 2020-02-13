package Unit1;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

public class Cone
{
	//class variable (global scope)
	double rad = 10;
	
	//default constructor - no argument constructor
	public Cone() {
		
	}
	
	//constructor with parameters
    public Cone(double radius, int height) {
    	//radius & height have local scope - often used to assign class/global variables
		
	}
	
    //non static method
	public void test() {
		
	}
	
	
	public static double volume( double radius, int height)
	{		
		// 1/3 as integers = 0
		return (double)1/3 * Math.PI * Math.pow(radius, 2) * height;
	}
	
	
	//string representation of the class
	public String toString() {
		return "I have a cone with a radius of " + rad;
	}
}