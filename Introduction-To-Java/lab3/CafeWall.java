//Michael Richards

import java.awt.*;

public class CafeWall {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
         
      Graphics g = panel.getGraphics();
      
      //Upper Left
      readySquare(g, 8, 20, 0, 0);
   
      //Mid Left
      readySquare(g, 10, 30, 50, 70);
      
      //Lower Left
      for(int i = 1; i <= 8; i++) {
         int spacer = i * 2;
         int y = 123 + i * 25 + spacer;
         readySquare(g, 8, 25, 10, y);
      }
      
      //Lower Middle
      for(int i = 1; i <= 6; i++) {
         int spacer = i * 2;
         int y = 173 + i * 25 + spacer;
         if (i % 2 == 0) {
            readySquare(g, 6, 25, 260, y);
         } else {
            readySquare(g, 6, 25, 250, y);
         }
      }
      
      //Lower Right
      for(int i = 1; i <=10; i++) {
         int spacer = i * 2;
         int y = 158 + i * 20 + spacer;
         if (i % 2 == 0) {
            readySquare(g, 10, 20, 435, y);
         } else {
            readySquare(g, 10, 20, 425, y);
         }
      }
      
      //Upper Right
      for(int i = 1; i <= 4; i++) {
         int spacer = i * 2;
         int y = i * 35 + spacer - 17;
         if (i % 2 == 0) {
            readySquare(g, 4, 35, 435, y);
         } else {
            readySquare(g, 4, 35, 400, y);
         }
      }
   }
   
   public static void readySquare(Graphics g, int count, int size, int x, int y) {
      for(int i = 0; i < count; i++) {
         int start = i * size + x;
         if(i % 2 == 0) {
            drawSquare(g, Color.BLACK, start, y, size);
            g.setColor(Color.BLUE);
            g.drawLine(start, y, start + size, size + y);
            g.drawLine(start + size, y, start, size + y);
         } else {
            drawSquare(g, Color.WHITE, start, y, size);
         }
      }

   }
 
   public static void drawSquare(Graphics g, Color c, int x, int y, int size) {
      g.setColor(c);
      g.fillRect(x, y, size, size);
   }
}