package Toys;
// (c) A+ Computer Science
// www.apluscompsci.com
// Name -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

import java.lang.reflect.Method;

public class ToyStoreGrader
{
	public static void main( String args[] )
	{
		ToyStore sto = new ToyStore();
		System.out.println(sto.myName());
		System.out.println( sto );
		sto.loadToys("sorry bat sorry sorry sorry train train teddy teddy ball ball" );
		System.out.println( sto );	
		System.out.println( "max == " + sto.getMostFrequentToy() );
		System.out.println("\n");
		System.out.println("==========");
		
		for (int i = 1; i <= 40; i++) {
			
			String studentFile = "Toys.ToyStore"+i;
			
			try {
				
				//get java class
				Class test = Class.forName(studentFile);
				
				//Create an instance of the java class
				Object store = test.newInstance();
				
				//Declare methods for testing
				Method name = test.getMethod("myName");
				Method load = test.getMethod("loadToys", String.class);
				Method most = test.getMethod("getMostFrequentToy");
				
				//Print initial tests
				System.out.println(test);
				System.out.println(name.invoke(test.newInstance()));
				System.out.println(store);
				
				//Print tests showing toy store methods work properly
				String toyList = "sorry bat sorry sorry sorry train train teddy teddy ball ball"; 
				load.invoke(store,toyList);
				System.out.println(store);
				System.out.println( "max == " + most.invoke(store) );
				System.out.println("============");
				System.out.println("\n");
				
			} catch (ReflectiveOperationException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}