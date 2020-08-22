public class E18 {

   public static final int SIZE = 5;
   
   public static void main(String[] args) {
      printLine();
      printBox();
      printLine();
      printBox();
      printLine();
   }
   
   public static void printLine() {
      for(int i = 0; i < SIZE - 1; i++) {
         System.out.print("+");
         for(int j = 0; j < SIZE; j++) {
            System.out.print("=");
         }
      }
      System.out.println("+");
   }
   
   public static void printBox() {
      for(int i = 0; i < SIZE; i++) {
         for(int j = 0; j < SIZE; j++) {
            System.out.print("|");
            for(int k = 0; k < SIZE; k++) {
               System.out.print(" ");
            }
         }
         System.out.println();
      }
   }
}