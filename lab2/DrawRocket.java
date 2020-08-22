/*
Student: Michael Richards
Course: CS 140C
Date: 1/15/19
Project: Lab #2 Part B

This progrom will produce a rocketship of a specifiyed size.
*/
public class DrawRocket {
   public static int SIZE = 3;
   //Calculates the whole width of the object.
   public static int WHOLE_WIDTH = SIZE * 4 + 4;

   //Prints Cone
   public static void printCone() {
      int height = SIZE * 2;
      int width = WHOLE_WIDTH / 2 - 2;
      for (int i = 1; i < height; i++) {
         //Leading Spacing
         for(int j = 0; j < width - i; j++) {
            System.out.print(" ");
         }
         //Left Slashes
         for(int j = width - i; j < width; j++) {
            System.out.print("/");
         }
         System.out.print("**");
         //Right Slashes
         for(int j = width - i; j < width; j++) {
            System.out.print("\\");
         }
         System.out.println();
      }
   }

   //Prints Line
   public static void printLine() {
      System.out.print("+");
      for(int i = 0; i < WHOLE_WIDTH / 2 - 2; i++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }

   //Prints the first part of the body.
   public static void printBoddyPart1() {
      for(int i = 1; i < SIZE + 1; i++) {
         int totalPeriods = (WHOLE_WIDTH / 2 - 2) / 2 - i;
         System.out.print("|");
            //Leading Periods
            for(int j = 0; j < totalPeriods; j++) {
               System.out.print(".");
            }
            //Left Pyramid
            for(int j = 1; j < i + 1; j++) {
               System.out.print("/\\");
            }
            //Middle Periods
            for(int j = 0; j < totalPeriods * 2; j++) {
            System.out.print(".");
            }
            //Right Pyramid
            for(int j = 1; j < i + 1; j++) {
               System.out.print("/\\");
            }
            //Ending Periods
            for(int j = 0; j < totalPeriods; j++) {
               System.out.print(".");
            }
         System.out.print("|");
         System.out.println();
      }
   }

   //Prints the second part of the body.
   public static void printBoddyPart2() {
      for(int i = 1; i < SIZE + 1; i++) {
         int pyrimidSize = (WHOLE_WIDTH / 2 - 2) / 2 - i + 1;
         System.out.print("|");
         //Leading Periods
         for(int j = 1; j < i; j++) {
         System.out.print(".");
         }
         //Left Pyramid
         for(int j = 0; j < pyrimidSize; j++) {
            System.out.print("\\/");
         }
         //Middle Periods
         for(int j = 2; j < i * 2; j++) {
            System.out.print(".");
         }
         //Right Pyramid
         for(int j = 0; j < pyrimidSize; j++) {
            System.out.print("\\/");
         }
         //Ending Periods
         for(int j = 1; j < i; j++) {
            System.out.print(".");
         }
      System.out.print("|");
      System.out.println();
      }
   }

   //Executes all parts to draw the rocket ship.
   public static void main(String[] args) {
      printCone();
      printLine();
      printBoddyPart1();
      printBoddyPart2();
      printLine();
      printBoddyPart2();
      printBoddyPart1();
      printLine();
      printCone();
   }
}
