import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape {
    
    private int radius;

    public Circle() {
        super();
        this.radius = 10;
    }

    public Circle(Color  colour, Point point) {
        super(colour, point);
        this.radius = 10;

    }

    double getCircumference(){
        return 2 * Math.PI * radius;
    }

    double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }


    double getDiameter(){
        return 2 * radius;
    }


    double getRadius(){
        return radius;
    }

    void setRadius (int radius){
        this.radius = radius;
    }

}