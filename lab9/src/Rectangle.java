import java.awt.Color;
import java.awt.Point;

public class Rectangle extends Shape {
    
    private int sideA;
    private int sideB;

    public Rectangle() {
        super();
        this.sideA = 10;
        this.sideB = 10;
    }

    public Rectangle(Color  colour, Point point) {
        super(colour, point);
        this.sideA = 10;
        this.sideB = 10;
    }

    int getArea(){
        return this.sideA * this.sideB;
    }

    String getCharacteritics(){
        return "Idk?";
    }

    int getCircumference(){
        return (this.sideA * 2) +  (this.sideB * 2);
    }

    void setSideA(int sideA){
        this.sideA = sideA;
    }

    void setSideB(int sideA){
        this.sideA = sideA;
    }

}