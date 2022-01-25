import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.net.URL;
/*<applet code="Floppy.java" width= 600 height=400></applet>*/

public class Floppy extends Applet{
  Image pic;
  int xdir=600,ydir=400;
public void init(){
 setBackground(Color.pink);
}
public void paint(Graphics g){
  URL url=getCodeBase();
  pic=getImage(url,"boats.jpg.jpg");
//  g.drawImage(pic,0,0,this);
  g.setColor(Color.ORANGE);
  g.drawRect(0,0,-20,-400);
}
public void start(){
  repaint();
}


}
