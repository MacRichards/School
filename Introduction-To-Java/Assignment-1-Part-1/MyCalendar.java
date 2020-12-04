//Student: Michael Richards
//Course: CS 140C
//Date: 1/29/19
//Project: Assignment Part A
//
//This program will produce a calendar of a specific month.

import java.util.*;

public class MyCalendar {

    public static final int SIZE = 10; //Must be 3 or more
    public static int DATE = 1;
    public static int MONTH;
    public static String MONTH_NAME;

    public static void main(String[] args) { //Main method to call everything
        Scanner console = new Scanner(System.in);

        System.out.println("What date would you like to look at? MM/DD");
        String userInput = console.next();
        drawCalendar(userInput);
        DATE = 1;
        todayDate();
    }

    /* Functions to draw ASCII art */

    public static void drawArt() {
        for (int lead = 0; lead < (SIZE * 7 / 2) - 20; lead++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" ");
            }
            System.out.print("/\\");
        }
        System.out.println();
        for (int lead = 0; lead < (SIZE * 7 / 2) - 20; lead++) {
            System.out.print(" ");
        }
        System.out.print(" ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int j = 0; j < 2; j++) {
                System.out.print(" ");
            }
            System.out.print("\\");
        }
        System.out.println();
        for (int lead = 0; lead < (SIZE * 7 / 2) - 20; lead++) {
            System.out.print(" ");
        }
        for (int j = 0; j < 2; j++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print("/\\");
            }
        }
        System.out.println();
        for (int lead = 0; lead < (SIZE * 7 / 2) - 20; lead++) {
            System.out.print(" ");
        }
        for (int i = 0; i < 2; i++) {
            System.out.print(" ");
        }
        System.out.print("/");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(" ");
            }
            System.out.print("\\");
        }
        System.out.println();
    }

    /*  Functions to draw Calendar for user  */

    public static void todayDate() {
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);

        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String out = month + "/" + day;

        System.out.println();
        System.out.println("Today's Date:");
        drawCalendar(out);
    }

    public static void drawCalendar(String userInput) { //Draws the calendar
        drawArt();
        int end = userInput.length();
        int mid = userInput.indexOf("/");
        String month = userInput.substring(0, mid);
        String day = userInput.substring(mid + 1, end);
        int month2 = Integer.parseInt(month);
        findMonth(month2);
        int space = ((SIZE * 7 / 2) - (MONTH_NAME.length() / 2)); //Finds the space for the header
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(MONTH_NAME);
        for (int i = 0; i < 5; i++) { //Number of rows
            drawLine();
            drawRow(day);
        }
        drawLine();

        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
    }

    public static void drawLine() { //Draws the line
        int length = SIZE * 7;
        for (int i = 0; i < length; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    //This part is for the extra credit. Without this would print to 35
    public static void findMonth(int monthNum) { //Puts the month number with the month
        if (monthNum == 1) {
            MONTH = Calendar.JANUARY;
            MONTH_NAME = "January";
        } else if (monthNum == 2) {
            MONTH = Calendar.FEBRUARY;
            MONTH_NAME = "February";
        } else if (monthNum == 3) {
            MONTH = Calendar.MARCH;
            MONTH_NAME = "March";
        } else if (monthNum == 4) {
            MONTH = Calendar.APRIL;
            MONTH_NAME = "April";
        } else if (monthNum == 5) {
            MONTH = Calendar.MAY;
            MONTH_NAME = "May";
        } else if (monthNum == 6) {
            MONTH = Calendar.JUNE;
            MONTH_NAME = "June";
        } else if (monthNum == 7) {
            MONTH = Calendar.JULY;
            MONTH_NAME = "July";
        } else if (monthNum == 8) {
            MONTH = Calendar.AUGUST;
            MONTH_NAME = "August";
        } else if (monthNum == 9) {
            MONTH = Calendar.SEPTEMBER;
            MONTH_NAME = "September";
        } else if (monthNum == 10) {
            MONTH = Calendar.OCTOBER;
            MONTH_NAME = "October";
        } else if (monthNum == 11) {
            MONTH = Calendar.NOVEMBER;
            MONTH_NAME = "November";
        } else if (monthNum == 12) {
            MONTH = Calendar.DECEMBER;
            MONTH_NAME = "December";
        } else {
            MONTH = Calendar.JANUARY;
            MONTH_NAME = "NULL";
        }
    }

    public static void drawRow(String day) { //Draws the rows

        int height = SIZE / 2;
        int day2 = Integer.parseInt(day);

        Calendar c = new GregorianCalendar(2019, MONTH, day2);
        int totalDays = (c.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1; //Number of doys in the month

        for (int i = 1; i <= height; i++) { //Height of day box
            for (int j = 0; j < 8; j++) { //Number of lines in a row
                int width = SIZE - (int)(Math.log10(DATE)+2); //Finds the new width with day number
                System.out.print("|");
                if (i == 1 && j != 7 && DATE == day2) { //Bolds the date selected or today's date
                    System.out.print("\033[1m" + DATE + "\033[0m");
                    DATE++;
                } else if (i == 1 && j != 7 && DATE <= totalDays) {
                    System.out.print(DATE);
                    DATE++;
                }
                if (i == 1 && DATE <= totalDays) {
                    for (int k = 0; k < width; k++) {
                        System.out.print(" ");
                    }
                } else {
                    for (int k = 0; k < (SIZE - 1); k++) {
                        System.out.print(" ");
                    }
                }
                if (DATE == totalDays) {
                    DATE = DATE + 100;
                }
            }
            System.out.println();
        }
    }
}