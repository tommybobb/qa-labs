import java.awt.Color;
import java.awt.Point;

public class Sphere extends Circle {
    
    double getVolume(){
        return  Math.pow(this.getRadius(),3);
    }

    public Sphere() {
        super();
    }

    public Sphere(Color  colour, Point point) {
        super(colour, point);
    }
    

}