public class Ex15 {
   public static void main(String[] args) {
      sphereVolume(2.0);
   }
   
   public static void sphereVolume(double r) {
      double volume = 4d/3d * (Math.PI * Math.pow(r, 3));
      System.out.println(volume);
   }
}