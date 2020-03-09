package Toys;
// (c) A+ Computer Science
// www.apluscompsci.com
// Name -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

import java.io.File;
import java.lang.reflect.Method;

public class ToyStoreGrader
{
	public static void main( String args[] )
	{
		ArrayList<String> filesToGrade = new ArrayList<String>();
		String fileNameToGrade = "ToyStore";
		
		// try-catch block to handle exceptions 
        try { 
  
            // Create a file object 
            File f = new File("src/Toys"); 
  
            // Get all the names of the files present 
            // in the given directory 
            File[] files = f.listFiles(); 
  
            System.out.println("Files are:"); 
  
            // Display the names of the files 
            for (int i = 0; i < files.length; i++) {
            	
            	String fileName = files[i].getName().substring(0, files[i].getName().length()-5);
            	
            	if(fileName.contains(fileNameToGrade) && !fileName.equals(fileNameToGrade)) {
            		char digit = fileName.charAt(fileNameToGrade.length());
            		if(Character.isDigit(digit))
            			filesToGrade.add(fileName);
            	}
            		
            } 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        }
        
        //print all file names in the grading directory
        for(String fileName:filesToGrade) {
        	System.out.println(fileName);
        }
		
		ToyStore sto = new ToyStore();
		System.out.println(sto.myName());
		System.out.println( sto );
		sto.loadToys("sorry bat sorry sorry sorry train train teddy teddy ball ball");
		System.out.println( sto );	
		System.out.println( "max == " + sto.getMostFrequentToy() );
		System.out.println("\n");
		System.out.println("==========");
		
		for (String file : filesToGrade) {
			
			try {
				
				//get java class
				Class test = Class.forName("Toys."+file);
				
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
				e.printStackTrace();
			}
		}
		
	}

}