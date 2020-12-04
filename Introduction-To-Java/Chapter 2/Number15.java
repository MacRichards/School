public class Number15 {
   public static void printDesing() {
      boolean one = false;
      for (int a = 0; a < 5; a++) {
         System.out.print("-");
         if (a == 4 && one == false) {
            System.out.print("1");
            a = 0;
            one = true;
         } else if (a == 4 && one == true) {
            System.out.print("-\n");
         }
      }
   }
   
   public static void main(String[] args) {
      printDesing();
   }
}