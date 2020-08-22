import java.io.*;
import java.lang.*;
import java.util.*;

public class DNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program reports information about DNA");
        System.out.println("nucleotide sequences that may encode proteins.");
        System.out.print("Input file name? ");
        String fileName = scanner.next();
        System.out.print("Output file name? ");
        String fileName2 = scanner.next();
        File fileIn = new File(fileName);
        File fileOut = new File(fileName2);
        readData(fileIn, fileOut);
    }

    public static void readData(File fileIn, File fileOut) {
        String[] regionName = new String[9];
        String[] nucleotides = new String[9];

        try {
            Scanner in = new Scanner(fileIn);
            int counter = 0;
            int i = 0;
            int j = 0;

            while (in.hasNextLine()) {
                if (counter % 2 == 0) {
                    regionName[i] = in.nextLine();
                    i++;
                } else {
                    nucleotides[j] = in.nextLine();
                    j++;
                }
                counter++;
            }

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        readyData(regionName, nucleotides, fileOut);
    }

    public static void readyData(String[] regionName, String[] nucleotides, File fileOut) {
        String printStuff = "";
        for (int i = 0; i < regionName.length; i++) {
            String nucs = nucleotides[i];

            // Puts all the nucleotides in an array
            int stopper = nucs.length() / 3;
            String[] nucPrint = new String[stopper];
            for (int j = 0; j <= stopper - 1; j++) {
                nucPrint[j] = nucs.substring(0, 3);
                nucs = nucs.substring(3, nucs.length());
            }
            double totalMass = 0;
            double[] mass = new double[4];
            double[] values = {135.128, 111.103, 151.128, 125.107};
            double junk = 100.0;
            int[] counter = new int[4];
            int useless = 0;
            String isIt = "NO";
            for (int j = 0; j < nucPrint.length; j++) {
                for (int k = 0; k < 3; k++) {
                    char letter = nucPrint[j].toLowerCase().charAt(k);
                    if (letter == 'a') {
                        counter[0]++;
                    } else if (letter == 'c') {
                        counter[1]++;
                    } else if (letter == 'g') {
                        counter[2]++;
                    } else if (letter == 't') {
                        counter[3]++;
                    } else {
                        useless++;
                    }
                }
            }
            for (int j = 0; j < 4; j++) {
                mass[j] = counter[j] * values[j];
            }

            for (double j : mass) {
                totalMass += j;
            }
            totalMass += useless * junk;
            for (int j = 0; j < 4; j++) {
                mass[j] = Math.round(((counter[j] * values[j]) / totalMass) * 1000.0) / 10.0;
            }

            if (nucPrint.length >= 5) {
                isIt = "YES";
            }
            printStuff += "Region Name: " + regionName[i] + "\n";
            printStuff += "Nucleotides: " + nucleotides[i].toUpperCase() + "\n";
            printStuff += "Nuc. Counts: " + Arrays.toString(counter) + "\n";
            printStuff += "Total Mass%: " + Arrays.toString(mass) + " of " + (Math.round(totalMass * 10.0) / 10.0) + "\n";
            printStuff += "Codons List: " + Arrays.toString(nucPrint).toUpperCase() + "\n" + "\n";
            printStuff += "Is Protein?: " + isIt + "\n" + "\n";
        }

        printData(printStuff, fileOut);
    }

    public static void printData(String stuffPrint, File fileOut) {
        try {
            PrintStream printStream = new PrintStream(fileOut);
            printStream.print(stuffPrint);
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
