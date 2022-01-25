import java.util.Scanner;
import java.io.*;

public class CharStreamReaderWriter{
	public static void main(String[] args){
     FileReader fr=null;
     FileWriter fw=null;
     int i=0;
     Scanner scan=new Scanner(System.in);
     System.out.println("from:");
     String from=scan.nextLine();
     System.out.println("to:");
     String to=scan.nextLine();

     try{+
         fr=new FileReader(from);
        try{ fw=new FileWriter(to); }catch(IOException e){}
         do{
         try{
         	i=fr.read();
         	fw.write(i);

         }catch(IOException e){}
     }while(i !=-1);
     }
     catch(FileNotFoundException e){}
     finally{
     	if(fr !=null || fw !=null){
     		try{fr.close();
     		fw.close();}
     		catch(IOException e){}
     	}
     }
	}
}