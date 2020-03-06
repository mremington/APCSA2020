package HelloWorld;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class CompileRunHelloWorld {
//https://www.journaldev.com/937/compile-run-java-program-another-java-program
	public static void main(String[] args) {


		for (int i = 1; i <= 4; i++) {

			try {
				Class test = Class.forName("HelloWorld.HelloWorld"+i);
				Method m = test.getMethod("main", String[].class);
				String[] params = null;
				m.invoke(null, (Object) params);
				System.out.println("============");
				System.out.println("\n");
			} catch (ReflectiveOperationException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		


	}



}