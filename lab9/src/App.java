
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<Shape> shapes = new ArrayList<>();

        // Rectangle rec1 = new Rectangle();
        // Circle circ1 = new Circle();
        // Sphere sph1 = new Sphere();

        // System.out.println("Rec1 area: " + rec1.getArea());


        // System.out.println("Circ1 diamerter: " + circ1.getDiameter());
        // System.out.println("Circ1 circumference: " + circ1.getCircumference());


        // System.out.println("Sphere circ: " + sph1.getCircumference());
        // System.out.println("Sphere volume: " + sph1.getVolume());
        

        shapes.add(new Rectangle(Color.BLUE, new Point(5,7)));
        shapes.add(new Circle(Color.PINK, new Point(10,7)));
        shapes.add(new Sphere());

        for(Shape shape : shapes){

            System.out.println("For shape " + shape.getClass().getName());

            System.out.println("Colour: " + shape.getColour());
            System.out.println("X:" + shape.getPosition().x + ", Y:" + shape.getPosition().y);

        }




    }
}
