/*
*provide name with extension..
*/

import java.io.*;
import java.util.Scanner;

public class DupDetecter {
	public static void main(String[] args){
	  FileInputStream fin1=null,fin2=null;
      Scanner s=new Scanner(System.in);
      boolean same=false;
      System.out.println("enter name of 1st file");
      String file1=s.nextLine();
      System.out.println("name of 2nd file ");
      String file2=s.nextLine();

      try{
      	fin1=new FileInputStream(file1);
      	fin2=new FileInputStream(file2);
        try{
          int bit=fin1.read();
          while(bit != -1){
          	if(bit==fin2.read()){
          		same=true;
          		bit=fin1.read();
          	}
          	else{
          		same=false;
          		System.out.println("these are not duplicates");
          		break;
          	}
          }
          if(same){
          	System.out.println("duplicates");
          }
           
        }
        catch(IOException e){}   
      }catch(FileNotFoundException e){}
      finally{
      	if(fin1 != null || fin2 !=null){
      		try{
      			fin1.close();
      			fin2.close();
      		}catch(Exception e){}
      	}
      }
      

	}
}