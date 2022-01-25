import java.io.*;
/*
*printwriter calls toString() internally..so parameters are converted to strings and then printed.
*/
public class PrintWriterExample{
	public static void main(String[] args){
		PrintWriter pw=new PrintWriter(System.out,true);
		String st1="hey there!",st2="qwerty";
		int var=3242;

		pw.println(st1);
		pw.println(var); 
		pw.println(var+st2);
		//System.out.println(var+st2);

	}
}