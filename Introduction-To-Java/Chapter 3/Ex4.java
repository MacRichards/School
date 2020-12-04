public class Ex4 {
   public static void main(String[] args) {
      printSquare(3, 7);
   }
   
   public static void printSquare(int start, int stop) {
      for(int i = start; i <= stop; i++) {
         for(int j = i; j <= stop; j++) {
            System.out.print(j);
         }
         for(int k = start; k < i; k++) {
               System.out.print(k);
            }
         System.out.println();
      }
   }
}