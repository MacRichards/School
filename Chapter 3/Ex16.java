public class Ex16 {
   public static void main(String[] args) {
      triangleArea(8, 5.2, 7.1);
   }
   
   public static void triangleArea(double a, double b, double c) {
      double s = (a + b + c) / 2;
      double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
      System.out.println(area);
   }
}