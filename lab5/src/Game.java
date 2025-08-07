import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Game extends Canvas {
// create an array of 3 balls 
// call this array balls
    Random rand = new Random();
    List<Shape> shapes = new ArrayList<Shape>();

    Game() {
        Shape.setWorld(400  , 400);

        shapes.add( new Shape((int)rand.nextInt(Shape.worldW) + 1, (int)rand.nextInt(Shape.worldH) + 1, 20, 20,2,3, ShapeType.ThreeDRectangle, Color.BLUE));
        shapes.add( new Shape((int)rand.nextInt(Shape.worldW) + 1, (int)rand.nextInt(Shape.worldH) + 1, 30, 30,5,2, ShapeType.RoundRectangle, Color.RED));
        shapes.add( new Shape((int)rand.nextInt(Shape.worldW) + 1, (int)rand.nextInt(Shape.worldH) + 1, 10, 10,8,7, ShapeType.Oval, Color.DARK_GRAY));
        shapes.add( new Shape((int)rand.nextInt(Shape.worldW) + 1, (int)rand.nextInt(Shape.worldH) + 1, 10, 10,8,7, ShapeType.Rectangle, Color.GREEN));
        shapes.add( new Shape((int)rand.nextInt(Shape.worldW) + 1, (int)rand.nextInt(Shape.worldH) + 1, 5, 5,8,7, ShapeType.Rectangle, Color.PINK));
        shapes.add( new Shape((int)rand.nextInt(Shape.worldW) + 1, (int)rand.nextInt(Shape.worldH) + 1, 10, 10,8,7, ShapeType.RoundRectangle, Color.ORANGE));

        JFrame frame = new JFrame();
        this.setSize(400, 400);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        
        

        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
       
        @Override
        public void run() {
            draw();
        }
        };

        t.schedule(tt, 0, 50);

                
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                t.cancel();
                tt.cancel();
            }
            
        });
    }

    public void draw() {
        // call the move() method of each balls
        // Tip: use an enhanced for loop to pick 
        //	  each ball in the balls array.

        for(Shape ball : shapes){
            ball.move();
        }

        this.repaint();
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, Shape.worldW, Shape.worldH);
        // move and draw each ball in balls array
        // Tip: use an enhanced for loop to pick 
        //	  each ball in the balls array.
        for(Shape b : shapes){
            g.setColor(b.getColour());


            switch (b.getShapeType()) {
                case ShapeType.Arc:
                    g.fillArc( b.x, b.y, b.w, b.h, 100,10 ); 
                    break;

                case ShapeType.Oval:
                    g.fillOval( b.x, b.y, b.w, b.h); 
                    break;

                case ShapeType.Rectangle:
                    g.fillRect( b.x, b.y, b.w, b.h ); 
                    break;

                case ShapeType.RoundRectangle:
                    g.fillRoundRect( b.x, b.y, b.w, b.h, 10, 10 ); 
                    break;

                case ShapeType.ThreeDRectangle:
                    g.fill3DRect( b.x, b.y, b.w, b.h, true ); 
                    break;

                default:
                    throw new AssertionError();
            }

        }

    }
}
