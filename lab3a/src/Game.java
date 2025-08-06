import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Game extends Canvas {
// create an array of 3 balls 
// call this array balls

    Ball[] balls = new Ball[3];

    Game() {
        balls[0] = new Ball(12, 15, 20, 20,2,3);
        balls[1] = new Ball(52, 55, 30, 30,5,2);
        balls[2] = new Ball(99, 99, 10, 10,8,7);

        JFrame frame = new JFrame();
        this.setSize(400, 400);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        
        Ball.setWorld(200, 200);

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

        for(Ball ball : balls){
            ball.move();
        }

        this.repaint();
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, Ball.worldW, Ball.worldH);
        // move and draw each ball in balls array
        // Tip: use an enhanced for loop to pick 
        //	  each ball in the balls array.
        for(Ball b : balls){
            g.drawOval( b.x, b.y, b.w, b.h );   
        }

    }
}
