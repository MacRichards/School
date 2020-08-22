//This program computes the total amount awed for a meal,
//assuming 8% tax and a 15% tip.
public class Receipt {
   public static void main(String[] args) {
   
      //Var declaration
      int subTotal = 38 + 40 + 30;
      
      //Logic
      double tax = subTotal * .08;
      double tip = subTotal * .15;
      double total = subTotal + tax + tip;
      
      
      //Output
      System.out.println("Subtotal:");
      System.out.println(subTotal);
      System.out.println("Tax:");
      System.out.println(tax);
      System.out.println("Tip:");
      System.out.println(tax);
      System.out.println("Total:");
      System.out.println(total);
   }
}