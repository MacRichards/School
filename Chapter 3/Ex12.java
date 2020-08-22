public class Ex12 {
   public static void main(String[] args){
      scientific(6.23, 5);
      scientific(1.9, -2);
   }
   
   public static void scientific(double base, int power) {
      double outPut = base * Math.pow(10, power);
      System.out.println();
   }
}