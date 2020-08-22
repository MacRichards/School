public class Number37 {
   public static void main(String[] args) {
   int heigt = 8; //heigt
   int width = ((heigt - 2) * 4) + 10;
   int space = -2;
      for(int i = 1; i <= heigt; i++) {
         width = width - 4;
         space = space + 2;
            for(int x = 0; x < space; x++) {
               System.out.print("\\");
            }
            for(int j = 0; j < width; j++) {
               System.out.print("!");
            }
            for(int x = 0; x < space; x++) {
               System.out.print("/");
            }
         System.out.println();
      }
   }
}