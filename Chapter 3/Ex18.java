public class Ex18 {
   public static void main(String[] args) {
      vertical("hey now");
   }
   
   public static void vertical(String stuff) {
      for (int i = 0; i < stuff.length(); i++) {
         char a = stuff.charAt(i);
         System.out.println(a);
      }
   }
}