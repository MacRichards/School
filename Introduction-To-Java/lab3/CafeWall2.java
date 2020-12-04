//Student: Michael Richards
//Course: CS 140C
//Date: 1/28/19
//Project: Lab #3 Part B
//
//This progrom will produce the picture provided to us.

import java.awt.*;

public class CafeWall2 {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
         
      Graphics g = panel.getGraphics();
      
      drawUpperLeft(g);
      drawMidLeft(g);
      drawLowerLeft(g);
      drawLowerMiddle(g);
      drawLowerRight(g);
      drawUpperRight(g);
   }
   
   // Draws Upper Left
   public static void drawUpperLeft(Graphics g) {
      for (int i = 0; i < 4; i++) {
         int x1 = i * 40;
         g.setColor(Color.BLACK);
         g.fillRect(x1, 0, 20, 20);
         g.setColor(Color.BLUE);
         int x2 = i * 40 + 20;
         g.drawLine(x1, 0, x2, 20);
         g.drawLine(x2, 0, x1, 20);
         g.setColor(Color.WHITE);
         g.fillRect(x2, 0, 20, 20);
      }
   }
   
   // Draws Mid Left
   public static void drawMidLeft(Graphics g) {
      for (int i = 0; i < 5; i++) {
         int x1 = i * 60 + 50;
         g.setColor(Color.BLACK);
         g.fillRect(x1, 70, 30, 30);
         int x2 = i * 60 + 80;
         g.setColor(Color.BLUE);
         g.drawLine(x1, 70, x2, 100);
         g.drawLine(x2, 70, x1, 100);
         g.setColor(Color.WHITE);
         g.fillRect(x2, 70, 30, 30);
      }
   }
   
   // Draw Lower Left
   public static void drawLowerLeft(Graphics g) {
      for(int i = 0; i < 8; i++) {
         for (int j = 0; j < 4; j++) {
            int x1 = j * 50 + 10;
            int spacer = i * 2;
            int y = 123 + i * 25 + spacer;
            g.setColor(Color.BLACK);
            g.fillRect(x1, y, 25, 25);
            int x2 = j * 50 + 35;
            g.setColor(Color.BLUE);
            g.drawLine(x1, y, x2, y + 25);
            g.drawLine(x2, y, x1, y + 25);
            g.setColor(Color.WHITE);
            g.fillRect(x2, y, 25, 25);
         }
      }      
   }
   
   // Draw Lower Middle
   public static void drawLowerMiddle(Graphics g) {
      for(int i = 0; i < 6; i++) {
         int offset = (i % 2) * 10;
         for(int j = 0; j < 3; j++) {
            int spacer = i * 2;
            int y = 200 + i * 25 + spacer;
            int x1 = j * 50 + 250 + offset;
            g.setColor(Color.BLACK);
            g.fillRect(x1, y, 25, 25);
            int x2 = j * 50 + 275 + offset;
            g.setColor(Color.BLUE);
            g.drawLine(x1, y, x2, y + 25);
            g.drawLine(x2, y, x1, y + 25);
            g.setColor(Color.WHITE);
            g.fillRect(x2, y, 25, 25);
         }
      }
   }
   
   // Draw Lower Right
   public static void drawLowerRight(Graphics g) {
      for(int i = 0; i < 10; i++) {
         int offset = (i % 2) * 10;
         for(int j = 0; j < 4; j++) {
            int spacer = i * 2;
            int y = 180 + i * 20 + spacer;
            int x1 = j * 40 + 425 + offset;
            g.setColor(Color.BLACK);
            g.fillRect(x1, y, 20, 20);
            int x2 = j * 40 + 445 + offset;
            g.setColor(Color.BLUE);
            g.drawLine(x1, y, x2, y + 20);
            g.drawLine(x2, y, x1, y + 20);
            g.setColor(Color.WHITE);
            g.fillRect(x2, y, 20, 20);
         }
      }
   }
   
   // Draw Upper Right
   public static void drawUpperRight(Graphics g) {
      for(int i = 0; i < 4; i++) {
         int offset = (i % 2) * 35;
         for(int j = 0; j < 2; j++) {
            int spacer = i * 2;
            int y = 20 + i * 35 + spacer;
            int x1 = j * 70 + 400 + offset;
            g.setColor(Color.BLACK);
            g.fillRect(x1, y, 35, 35);
            int x2 = j * 70 + 435 + offset;
            g.setColor(Color.BLUE);
            g.drawLine(x1, y, x2, y + 35);
            g.drawLine(x2, y, x1, y + 35);
            g.setColor(Color.WHITE);
            g.fillRect(x2, y, 35, 35);
         }
      }
   }
}