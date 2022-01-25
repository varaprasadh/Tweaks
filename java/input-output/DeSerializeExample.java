import java.io.*;

public class DeSerializeExample{
       public static void main(String[] args) throws ClassNotFoundException{
      ObjectInputStream obread=null;
      try{ 	 obread=new ObjectInputStream(new FileInputStream("Serializable"));}catch(Exception e){}
      
       try{	
       	Dummy d=(Dummy) obread.readObject();
       	System.out.println(d.name);
       }
       catch(IOException e){}

       }

}
class Dummy implements Serializable{
	int i;
	String name;

	Dummy(int i,String name){
		this.i=i;
		this.name=name;
	}
	public String toString(){
		return i+"name:"+name;
	}
}