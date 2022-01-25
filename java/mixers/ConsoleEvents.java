/*
* not a executable program, tried to do something different!
*@varaprasadh
*/
import java.awt.*;
import java.awt.event.*;

class Console implements KeyListener,Runnable{
  Thread t;
  public Console(){
   /* want to add listener to the console ,
   * so i can manage key events from console;
   * but the error is can't find Symbol;
    */
     addKeyListener(this);
    t=new Thread(this);
    t.start();
  }
  public void keyPressed(KeyEvent ke){
  System.out.println(ke.getKeyChar());
  }
  public void keyReleased(KeyEvent ke){}
  public void keyTyped(KeyEvent ke){}
  public void run(){
    for(;;){
      try{
        t.sleep(100);
      }
      catch(InterruptedException ie){}
    }
  }
}

public class ConsoleEvents {
  public static void main(String[] args){
    new Console();
  }
}
