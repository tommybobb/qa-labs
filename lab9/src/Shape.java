import java.awt.Color;
import java.awt.Point;

public abstract class Shape {
    
    private Color colour;
    private Point position;

    public Shape() {
        this.colour = Color.blue;
        this.position = new Point(5,5);
    }

    public Shape(Color  colour, Point point) {
        this.colour = colour;
        this.position = point;
    }

    Color getColour(){
        return this.colour;
    }

    Point getPosition(){
        return this.position;
    }

    void setColour(Color colour){
        this.colour = colour;
    }

    void setPosition(Point position){
        this.position = position;
    }



}


