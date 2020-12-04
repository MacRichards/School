public class Exercise1 {
   public static void main(String[] args) {
   
      //Var declaration
      double initalPosition = 0;
      double initalVelocity = 0;
      double time = 5;
      double acceleration = 9.8;
      
      //Logic
      double position = initalPosition + initalVelocity * time + .5 * acceleration * Math.pow(time, 2);
      
      //Output
      System.out.println(position);
   }
}