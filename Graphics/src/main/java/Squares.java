import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Squares extends Canvas{

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Squares();
        canvas.setSize(600,600);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        
    }
    public void paint (Graphics g) {
        int sizeSquare = 300;
        int sizeCanvas = 600;
        int startX = sizeCanvas/4;
        int startY = sizeCanvas/4;
        
        g.drawLine(startX, startY, startX+sizeSquare, startY);
        g.drawLine(startX, startY, startX, startY+sizeSquare);
        g.drawLine(startX+sizeSquare, startY+sizeSquare, startX+sizeSquare, startY);
        g.drawLine(startX+sizeSquare, startY+sizeSquare, startX, startY+sizeSquare);
    }
}
   
    

