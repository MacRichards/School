import java.util.concurrent.SynchronousQueue;

public class Ex21_2 {
    public static void main(String[] args) {
        String quote = "Four score and seven years ago";

        String newQuote = quote.substring(5, 10).toUpperCase();
        System.out.println(newQuote);

        String newQuote2 = quote.substring(0, 4).toLowerCase() + " " + quote.substring(21, 27);
        System.out.println(newQuote2);
    }
}
