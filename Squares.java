import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.*;

public class Squares extends Canvas{

    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Canvas canvas = new Squares();
        canvas.setSize(500,500);
        frame.add(canvas);
        
        frame.pack();
        frame.setTitle("Drawing Squares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int sizeCanvas = 500;
        int sizeLine =  sizeCanvas/2;
        int startX = sizeCanvas/4;
        int startY = sizeCanvas/4;
        
        g.setColor(Color.GREEN);
        g.fillRect(startX, startY, sizeLine, sizeLine);

        g.setColor(Color.RED);

        g.drawLine(startX, startY, startX+sizeLine, startY);
        g.drawLine(startX, startY, startX, startY+sizeLine);
        g.drawLine(startX+sizeLine, startY+sizeLine, startX+sizeLine, startY);
        g.drawLine(startX+sizeLine, startY+sizeLine, startX, startY+sizeLine);
        g.drawLine(0, sizeLine, sizeCanvas, sizeLine);
        g.drawLine(sizeLine, 0, sizeLine, sizeCanvas);

        g.drawRect(0, 0, 400, 400);
        g.setColor(Color.BLUE);
        g.fillRect(sizeLine, 0, startX, startY);
        g.setColor(Color.YELLOW);
        g.fillRect(startX, sizeCanvas-startX, startX, startY);
        }
}


