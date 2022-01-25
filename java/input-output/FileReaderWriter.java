import java.io.*;

public class FileReaderWriter {
	public static void main(String[] args){
		File file=new File("status.png");
            FileReader filereader=null;
            FileWriter filewriter=null;
            int ch=0;
		try{
			 filereader=new FileReader(file);
	     	 try{filewriter=new FileWriter("status2.png",true);}catch(Exception e){}
	     	 do{
	     	  try{
                ch=filereader.read();
                filewriter.write(ch);
	     	 }catch(IOException e){}

	     	 }while(ch!=-1);

		}catch(FileNotFoundException e){}



	}
}