import java.net.*;
 
public class Ping {
  public static void main(String[] args) {
 
    try {
      String ipAddress = "216.58.220.46";
      InetAddress inet = InetAddress.getByName(ipAddress);
      System.out.println("Sending Ping Request to " + ipAddress);
      if (inet.isReachable(5000)){
        System.out.println(ipAddress + " is reachable.");
      } else {
        System.out.println(ipAddress + " NOT reachable.");
      }
    } catch ( Exception e ) {
      System.out.println("Exception:" + e.getMessage());
    }
  }
}
