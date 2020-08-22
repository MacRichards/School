public class Num10 {
   public static void main(String[] args) {
      printString("abc", 5);
   }
   
   public static void printString(String printText, int printTimes) {
      for(int i = 0; i < printTimes; i++) {
         System.out.print(printText + " ");
      }
   }
}