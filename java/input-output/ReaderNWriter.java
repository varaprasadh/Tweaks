import java.io.*;
import java.util.Scanner;

public class ReaderNWriter {
	public static void main(String[] args){
		FileInputStream fin=null;
		FileOutputStream fout=null;
		int ch=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("from :");
		String from=scan.nextLine();
		System.out.println("to:");
		String to=scan.nextLine();
 
		try{
			fin=new FileInputStream(from);
			fout=new FileOutputStream(to);
			do{

				try{ch=fin.read();
				fout.write(ch);
				System.out.print((char)ch);
                    }
                 catch(IOException e){}   

			}while(ch !=-1);

		}
		catch(FileNotFoundException e){
			System.out.println("error"+e);
		}
		finally{
			if(fin != null || fout !=null){
				try {fin.close();
				    fout.close();
			     }
			     catch(IOException e){

			     }
			}
		}

	}
}