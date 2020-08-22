//Student: Michael Richards
//Course: CS 140C
//Date: 1/28/19
//Project: Lab #3 Part A
//
//This progrom will produce a picture that I made.

import java.awt.*;

public class Doodle {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(350, 200);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.BLUE);
      
      g.setColor(Color.WHITE);
      g.fillOval(15, 15, 20, 20);
      g.drawOval(50, 50, 10, 30);
      g.fillRect(100, 100, 50, 20);
      
      g.setColor(Color.GREEN);
      g.setFont(new Font("SansSerif", Font.PLAIN, 15));
      g.drawString("X", 20, 30);
      
      g.setColor(Color.PINK);
      g.drawLine(300, 50, 200, 30);
      g.drawLine(200, 30, 300, 10);
      g.drawLine(300, 50, 300, 10);
      
      g.setColor(Color.YELLOW);
      g.drawRect(0, 0, 50, 50);
      g.drawLine(0, 25, 25, 0);
      g.drawLine(25, 0, 50, 25);
      g.drawLine(50, 25, 25, 50);
      g.drawLine(25, 50, 0, 25);
   }
}