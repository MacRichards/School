public class EggStop {

   public static int x = 0;
   
   public static void top() {
      System.out.println("  _______\n /       \\\n/         \\");
   }
   
   public static void bottom() {
      System.out.println("\\         /\n \\_______/");
   }
   
   public static void line() {
      if (x == 0) {
         System.out.println(" +-------+");
         x = 1;
      } else {
         System.out.println("+---------+");
      }
   }
   
   public static void main(String[] args) {
      top();
      bottom();
      line();
      top();
      System.out.println("|   STOP  |");
      bottom();
      top();
      line();
   }
}