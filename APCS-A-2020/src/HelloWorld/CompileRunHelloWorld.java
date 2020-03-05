package HelloWorld;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CompileRunHelloWorld {
//https://www.journaldev.com/937/compile-run-java-program-another-java-program
    public static void main(String[] args) {
        try {
           //runProcess("javac -cp src src/HelloWorld/*.java");
        	//runProcess("pwd");
            System.out.println("**********");
			for(int num = 1; num <=4; num++){
				String fileToRun = "java -cp src HelloWorld"+num;//H:\\git\\APCSA2020\\APCS-A-2020\\bin
				runProcess(fileToRun);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	
    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + "\n" + line);
        }
      }

      private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command, pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
		System.out.println("============");
		System.out.println("\n");
        //System.out.println(command + " exitValue() " + pro.exitValue());
      }

}