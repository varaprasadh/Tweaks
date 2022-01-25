
/*
* the classes that implements serializable interface can be stored as objects in persistent sorage devices,
*just like any other files..

*/
import java.io.*;

public class SerializableExample{
       public static void main(String[] args){
      ObjectOutputStream obwrite=null;
      try{ 	 obwrite=new ObjectOutputStream(new FileOutputStream("Serializable"));}catch(Exception e){}
       	Dummy d=new Dummy(123,"bean");
       	System.out.println(d);
       try{	obwrite.writeObject(d);
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