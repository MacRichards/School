//Student: Michael Richards
//Course: CS 140C
//Date: 2/15/19
//Project: Assignment Part 2
//
//This program will produce a calendar of a specific month.

import java.io.*;
import java.time.*;
import java.util.*;

public class MyCalendar3 {

    public static int NUM_MONTH = 0;
    public static int NUM_DAY = 0;
    public static int NUM_YEAR = 0;
    public static String PRINT_STUFF = "";
    public static String[][][] EVENTS = new String[12][31][1];

    public static void main(String[] args) { //Main method to call everything
        try {
            File fileIn = new File("calendarEvents.txt");
            Scanner in = new Scanner(fileIn);
            
            while (in.hasNextLine()) { // MM/DD event_title
                String data = in.nextLine();
                int end = data.length();
                int mid = data.indexOf("/");
                int mid2 = data.indexOf(" ");

                int month = Integer.valueOf(data.substring(0, mid)) - 1;
                int day = Integer.valueOf(data.substring(mid + 1, mid2)) - 1;
                String event_name = data.substring(mid2 + 1, end);

                EVENTS[month][day][0] = event_name;
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        menu();
    }

    /* Methods for the menu */

    public static void menu() {
        System.out.println("Please type a command.");
        System.out.println("     \"e\" to enter a date and display the corresponding calendar");
        System.out.println("     \"t\" to get today's date and display today's calendar");
        System.out.println("     \"n\" to display the next month");
        System.out.println("     \"p\" to display the previous month");
        System.out.println("     \"ev\" to enter an event");
        System.out.println("     \"fp\" to print calendar");
        System.out.println("     \"q\" to quit the program");
        Scanner console = new Scanner(System.in);
        String userIn = console.next();
        whatToDo(userIn);
    }

    public static void whatToDo(String userIn) {
        if (userIn.toLowerCase().equals("e")) {
            // Enter date and display
            enterDate();
            menu();
        } else if (userIn.toLowerCase().equals("t")) {
            // Today's date and calendar
            todaysDate();
            menu();
        } else if (userIn.toLowerCase().equals("n")) {
            // Next month
            nextMonth();
            menu();
        } else if (userIn.toLowerCase().equals("p")) {
            // Previous month
            previousMonth();
            menu();
        } else if (userIn.toLowerCase().equals("ev")) {
            event();
            menu();
        } else if (userIn.toLowerCase().equals("fp")) {
            printCal();
            menu();
        } else if (userIn.toLowerCase().equals("q")) {
            // Quit
            System.out.println("Sorry to see you go. Come back soon!");
            System.exit(0);
        } else {
            System.out.println();
            System.out.println("Invalid input. Please try again.");
            menu();
        }
    }

    // Method for "e"
    public static void enterDate() {
        Scanner console = new Scanner(System.in);

        System.out.println("What date would you like to look at? MM/DD/YYYY");
        String userInput = console.next();
        drawCalendar(userInput, false);
    }

    // Method for "t"
    public static void todaysDate() {
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);

        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int year = c.get(Calendar.YEAR);
        String out = month + "/" + day + "/" + year;

        System.out.println();
        System.out.println("Today's Date:");
        drawCalendar(out, false);
    }

    // Method for "n"
    public static void nextMonth() {
        if (NUM_DAY == 0) {
            System.out.println("You need to select a month with \"e\" or \"t\"");
            menu();
        } else {
            int month = NUM_MONTH + 1;
            int day = NUM_DAY;
            int year = NUM_YEAR;
            if (month == 13) {
                month = 1;
                year = NUM_YEAR + 1;
            }
            String out = month + "/" + day + "/" + year;

            System.out.println();
            System.out.println("Next Month's Date:");
            drawCalendar(out, false);
        }
    }

    // Method for "p"
    public static void previousMonth() {
        if (NUM_DAY == 0) {
            System.out.println("You need to select a month with \"e\" or \"t\"");
            menu();
        } else {
            int month = NUM_MONTH - 1;
            int day = NUM_DAY;
            int year = NUM_YEAR;
            if (month == 0) {
                month = 12;
                year = NUM_YEAR - 1;
            }
            String out = month + "/" + day + "/" + year;

            System.out.println();
            System.out.println("Last Month's Date:");
            drawCalendar(out, false);
        }
    }

    // Method for "ev"
    public static void event() {
        Scanner console = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter the date of your event (MM/DD) and the name of your event.");
        System.out.println("i.e. 1/5 Doctors Appointment");
        String app = console.nextLine();

        int end = app.length();
        int mid = app.indexOf("/");
        int mid2 = app.indexOf(" ");

        int month = Integer.valueOf(app.substring(0, mid)) - 1;
        int day = Integer.valueOf(app.substring(mid + 1, mid2)) - 1;
        String event_name = app.substring(mid2 + 1, end);

        EVENTS[month][day][0] = event_name;
    }
    
    // Method for "fp"
    public static void printCal() {
        Scanner console = new Scanner(System.in);

        System.out.println("What date would you like to print? MM/DD/YYYY");
        String userInput = console.next();
        System.out.println("-----PREVIEW-----");
        drawCalendar(userInput, true);
    }

    /* Methods to draw the calendar */

    // Method to draw the calendar
    public static void drawCalendar(String userInput, Boolean print) { //Draws the calendar
        int[] date = {1, 1};
        int end = userInput.length();
        int mid = userInput.indexOf("/");
        int mid2 = userInput.lastIndexOf("/");

        NUM_MONTH = Integer.valueOf(userInput.substring(0, mid));
        String month = userInput.substring(0, mid);
        NUM_DAY = Integer.valueOf(userInput.substring(mid + 1, mid2));
        String day = userInput.substring(mid + 1, mid2);
        NUM_YEAR = Integer.valueOf(userInput.substring(mid2 + 1, end));
        String year = userInput.substring(mid2 + 1, end);

        PRINT_STUFF += drawArt();
        int month2 = Integer.parseInt(month);
        int monthNum = findMonth(month2);
        for (int i = 0; i < 35; i++) {
            System.out.print(" ");
            PRINT_STUFF += " ";
        }
        System.out.println(monthNum + 1);
        PRINT_STUFF += (monthNum + 1) + "\n";
        PRINT_STUFF += drawLine();
        System.out.println("|   Sun   |   Mon   |  Tues   |   Wed   |  Thurs  |   Fri   |   Sat   |");
        PRINT_STUFF += "|   Sun   |   Mon   |  Tues   |   Wed   |  Thurs  |   Fri   |   Sat   |\n";

        int weekDay = findWeek(month2);
        date[0] -= weekDay;
        date[1] -= weekDay;

        for (int i = 0; i < 6; i++) { //Number of rows
            drawLine();
            date = drawRow(day, monthNum + 1, date);
        }
        PRINT_STUFF += drawLine();

        System.out.println("Year: " + year);
        PRINT_STUFF += "Year: " + year + "\n";
        System.out.println("Month: " + month);
        PRINT_STUFF += "Month: " + month + "\n";
        System.out.println("Day: " + day);
        PRINT_STUFF += "Day: " + day + "\n";

        if (print) {
            System.out.println("What would you like the file name to be?");
            System.out.println("ex: fileOut.txt");
            Scanner console = new Scanner(System.in);
            String fileName = console.next();
            File fileOut = new File(fileName);
            try {
                PrintStream printStream = new PrintStream(fileOut);
                printStream.print(PRINT_STUFF);
                printStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to draw ASCII art
    public static String drawArt() {
        for (int lead = 0; lead < (10 * 7 / 2) - 20; lead++) {
            System.out.print(" ");
            PRINT_STUFF += " ";
            
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" ");
                PRINT_STUFF += " ";
            }
            System.out.print("/\\");
            PRINT_STUFF += "/\\";
        }
        System.out.println();
        PRINT_STUFF += "\n";
        for (int lead = 0; lead < (10 * 7 / 2) - 20; lead++) {
            System.out.print(" ");
            PRINT_STUFF += " ";
        }
        System.out.print(" ");
        PRINT_STUFF += " ";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" ");
                PRINT_STUFF += " ";
            }
            System.out.print("/");
            PRINT_STUFF += "/";
            for (int j = 0; j < 2; j++) {
                System.out.print(" ");
                PRINT_STUFF += " ";
            }
            System.out.print("\\");
            PRINT_STUFF += "\\";
        }
        System.out.println();
        PRINT_STUFF += "\n";
        for (int lead = 0; lead < (10 * 7 / 2) - 20; lead++) {
            System.out.print(" ");
            PRINT_STUFF += " ";
        }
        for (int j = 0; j < 2; j++) {
            System.out.print(" ");
            PRINT_STUFF += " ";
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(" ");
            PRINT_STUFF += " ";
            for (int j = 0; j < 3; j++) {
                System.out.print("/\\");
                PRINT_STUFF += "/\\";
            }
        }
        System.out.println();
        PRINT_STUFF += "\n";
        for (int lead = 0; lead < (10 * 7 / 2) - 20; lead++) {
            System.out.print(" ");
            PRINT_STUFF += " ";
        }
        for (int i = 0; i < 2; i++) {
            System.out.print(" ");
            PRINT_STUFF += " ";
        }
        System.out.print("/");
        PRINT_STUFF += "/";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(" ");
                PRINT_STUFF += " ";
            }
            System.out.print("\\");
            PRINT_STUFF += "\\";
        }
        System.out.println();
        PRINT_STUFF += "\n";
        return PRINT_STUFF;
    }

    // Method to draw the line in the calendar
    public static String drawLine() { //Draws the line
        int length = 10 * 7;
        for (int i = 0; i < length; i++) {
            System.out.print("=");
            PRINT_STUFF += "=";
            
        }
        System.out.println();
        PRINT_STUFF += "\n";
        return PRINT_STUFF;
    }

    // Finds the month
    public static int findMonth(int monthNum) { //Puts the month number with the month
        int month = Calendar.JANUARY;
        if (monthNum == 2) {
            month = Calendar.FEBRUARY;
        } else if (monthNum == 3) {
            month = Calendar.MARCH;
        } else if (monthNum == 4) {
            month = Calendar.APRIL;
        } else if (monthNum == 5) {
            month = Calendar.MAY;
        } else if (monthNum == 6) {
            month = Calendar.JUNE;
        } else if (monthNum == 7) {
            month = Calendar.JULY;
        } else if (monthNum == 8) {
            month = Calendar.AUGUST;
        } else if (monthNum == 9) {
            month = Calendar.SEPTEMBER;
        } else if (monthNum == 10) {
            month = Calendar.OCTOBER;
        } else if (monthNum == 11) {
            month = Calendar.NOVEMBER;
        } else if (monthNum == 12) {
            month = Calendar.DECEMBER;
        }
        return month;
    }

    // Finds the day of the week
    public static int findWeek(int monthNum) {
        int weekDay = 7;

        LocalDate localDate = LocalDate.of(2019, monthNum, 1);
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.MONDAY) {
            weekDay = 1;
        } else if (dayOfWeek == DayOfWeek.TUESDAY) {
            weekDay = 2;
        } else if (dayOfWeek == DayOfWeek.WEDNESDAY) {
            weekDay = 3;
        } else if (dayOfWeek == DayOfWeek.THURSDAY) {
            weekDay = 4;
        } else if (dayOfWeek == DayOfWeek.FRIDAY) {
            weekDay = 5;
        } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            weekDay = 0;
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            weekDay = 6;
        }

        return weekDay;
    }

    public static int[] drawRow(String day, int monthNum, int[] date) { //Draws the rows
        int height = 5;
        int width;
        int day2 = Integer.parseInt(day);
        String eventName = null;

        Calendar c = new GregorianCalendar(NUM_YEAR, monthNum, day2);
        int totalDays = (c.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;

        for (int i = 1; i <= height; i++) { //Height of day box
            for (int j = 0; j < 8; j++) { //Number of lines in a row
                //Finds Width
                if (date[0] > 0) {
                    width = 10 - (int) (Math.log10(date[0]) + 2); //Finds the new width with day number
                } else {
                    width = 9;
                }

                System.out.print("|");
                PRINT_STUFF += "|";

                //First line of row
                if (i == 1 && j != 7 && date[0] == day2) { //Bolds the date selected or today's date
                    System.out.print("\033[1m" + date[0] + "\033[0m");
                    PRINT_STUFF += date[0];
                    date[0]++;
                } else if (i == 1 && j != 7 && date[0] <= totalDays && date[0] > 0) {
                    System.out.print(date[0]);
                    PRINT_STUFF += date[0];
                    date[0]++;
                } else if (i == 1 && j != 7 && date[0] <= totalDays) {
                    date[0]++;
                }

                //Second Row
                if (date[1] > 0 && date[1] <= totalDays - 1) {
                    eventName = EVENTS[NUM_MONTH - 1][date[1] - 1][0];
                }
                if (i == 2 && j != 7 && eventName != null) {
                    System.out.print(eventName);
                    PRINT_STUFF += eventName;
                }
                if (i == 2 && j != 7) {
                    date[1]++;
                }

                //Spacing
                if (i == 1 && date[0] <= totalDays) {
                    for (int k = 0; k < width; k++) {
                        System.out.print(" ");
                        PRINT_STUFF += " ";
                    }
                } else if (i == 2 && eventName != null) {
                    for (int k = 0; k < (9 - eventName.length()); k++) {
                        System.out.print(" ");
                        PRINT_STUFF += " ";
                    }
                } else {
                    for (int k = 0; k < 9; k++) {
                        System.out.print(" ");
                        PRINT_STUFF += " ";
                    }
                }

                if (date[0] == totalDays) {
                    date[0] = date[0] + 100;
                    date[1] = date[1] + 100;
                }
            }
            System.out.println();
            PRINT_STUFF += "\n";
        }
        return date;
    }
}