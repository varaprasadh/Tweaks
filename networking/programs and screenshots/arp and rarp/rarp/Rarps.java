import java.io.*; 
import java.net.*;
import java.util.*; 
class Rarps 
{  
public static void main(String args[]) 
{ 
try
 { 
ServerSocket obj=new ServerSocket(5555); 
Socket obj1=obj.accept();
 while(true) 
{ 
DataInputStream din=new DataInputStream(obj1.getInputStream());
 DataOutputStream dout=new DataOutputStream(obj1.getOutputStream()); 
String str=din.readLine();
 String ip[]={"10.0.10.33"}; 
String mac[]={"6C:F0:49:FC:A5:63"};
//String mac[]={"mohanteja"}; 
for(int i=0;i<ip.length;i++) 
{
 if(str.equals(mac[i]))
  {
 dout.writeBytes(ip[i]+'\n');
  break;
  }
 } 
obj.close(); 
 } 
}
 catch(Exception e)
 { 
System.out.println(e);
 }
 }
 }
