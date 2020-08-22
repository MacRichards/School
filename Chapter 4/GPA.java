import java.util.Scanner;

public class GPA {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a student record: ");
        String in = console.nextLine();
        printGPA(in);
    }

    public static void printGPA(String data) {
        int nameEnd = data.indexOf(" ");
        System.out.println(nameEnd);
        String name = data.substring(0, nameEnd);
        int totalValues = Integer.valueOf(data.substring(nameEnd + 1, nameEnd + 2));
        String values = data.substring(nameEnd + 2, data.length());
        String valuesToPrint = "";
        for (int i = 0; i < totalValues; i++) {
            int stop = values.indexOf(" ");
            valuesToPrint = valuesToPrint + " " + values.substring(0, stop);
            values = values.substring(stop, values.length());
        }

        System.out.println(name + "'s grade is " + grade);
    }
}
