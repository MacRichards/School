public class printDesign {
   public static void main(String[] args) {
      int height = 5;
      int width = 11;
      int inner = 1;
      for(int j = height; j > 0; j--) {
         for(int i = 0; i < j; i++) {
            System.out.print("-");
         }
         for(int x = width - (j * 2); x > 0; x--) {
            System.out.print(inner);
         }
         inner = inner + 2;
         for(int i = 0; i < j; i++) {
            System.out.print("-");
         }
         System.out.println();
      }
   }
}