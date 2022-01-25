import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;
/*<applet code="FirstAp.java",width=500 height=500></applet>*/
public class FirstAp extends Applet{
public void init(){
  setBackground(Color.black);
  setForeground(Color.white);

}
public void start(){
  repaint();
}
public void paint(Graphics g){
  g.setFont(new Font("sans",Font.BOLD+Font.ITALIC,30));
  g.drawString("happy new year!",50,100);

}

}
