import java.util.*;

public class Ex12 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("How much will John be spending? ");
        double amount = console.nextDouble();
        int numBills1 = (int)(amount / 20);
        double out1 = math(numBills1, amount);
        System.out.print("How much will Jane be spending? ");
        amount = console.nextDouble();
        System.out.println();
        int numBills2 = (int)(amount / 20);
        double out2 = math(numBills2, amount);
        System.out.println("John needs " + out1 + " bills");
        System.out.println("Jane needs " + out2 + " bills");
    }

    public static double math(int a, double b) {
        if (a * 20 < b) {
            a++;
        }
        return a;
    }
}
