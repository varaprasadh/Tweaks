import java.io.*;

public class BufferedReaderExample {
	public static void main(String[] args){
		//to read from keyboard
	  BufferedWriter bw=null;
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     try{
      bw=new BufferedWriter(new FileWriter("buffereddemo.txt"));
      }catch(Exception e){}
     String ch=null;
   
     try{    
       do {
    	try{
        ch=br.readLine();		
         bw.write(ch);     
        //  System.out.println(ch);	
        }catch(Exception e){}
        } while(!ch.equals("quit") );
    }catch(Exception e){}
     finally{
     	if(bw !=null || br != null){
     	try{
         bw.close();
         br.close();
     	}
     	catch(Exception e){}
     }
     }
     System.out.println("completed!");
	}
}