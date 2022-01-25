import java.io.*;

public class ConsoleClass{
	public static void main(String[] args){
		Console console=System.console();
		String name,password;
	    System.out.print("enter name");
	    name =console.readLine();
	    System.out.print("enter password");
	    password=console.readPassword().toString();
	    System.out.print(name+" "+password);
	}
}