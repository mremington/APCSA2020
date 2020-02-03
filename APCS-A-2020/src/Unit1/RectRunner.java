package Unit1;
//(c) A+ Computer Science 
//www.apluscompsci.com
//Name -
//Date -

public class RectRunner
{
	public static void main( String[] args )
	{
		/*
		 * Sample Data: 12 5 131 75 20 25 9 256 36 72 8 6 18 16
		 */

		
		System.out.println( Rect.perimeter(12,5) );
		System.out.println( Rect.perimeter(131,75) );
		System.out.println( Rect.perimeter(20,25) );
		System.out.println( Rect.perimeter(9,256) );
		System.out.println( Rect.perimeter(36,72) );
		System.out.println( Rect.perimeter(8,6) );
		System.out.println( Rect.perimeter(18,16) );
	}
}


/*

34.0
412.0
90.0
530.0
216.0
28.0
68.0

*/