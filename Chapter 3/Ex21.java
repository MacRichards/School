import java.util.*;

public class Ex21 {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.println("What is your full name?");
      String fullName = console.next();
      processName(fullName);
   }
   
   public static void processName(String fullName) {
      int space = fullName.indexOf(" ");
      String firstName = fullName.substring(0, 5);
      int end = fullName.length();
      String lastName = fullName.substring(5, 6);
      System.out.println("Your name in reverser order is " + lastName + ", " + firstName);
   }
}