import java.util.ArrayList;
public class AList{
  public static void main(String[] args){
    ArrayList<String>list=new ArrayList();
    list.add("java");
    list.add("json");
    list.add("ajax");
    list.add("javaScript!");
    for(String s : list){
    System.out.println(""+s); }
  }
}
