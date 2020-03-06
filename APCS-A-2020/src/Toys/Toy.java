package Toys;
// (c) A+ Computer Science
// www.apluscompsci.com
// Name -

import static java.lang.System.*;

public class Toy
{
	private String name;
	private int count;

	public Toy()
	{
		name = "toy";
		count = 1;
	}

	public Toy( String nm )
	{
		name = nm;
		count = 1;
	}
	
	public Toy( String nm, int c )
	{
		name = nm;
		count = c;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount( int cnt )
	{
		count = cnt;		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName( String nm )
	{
		name = nm;
	}

	public String toString()
	{
	   return "" + name + " " + count;
	}
}