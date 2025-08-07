import java.awt.Color;
import java.util.Random;

enum  ShapeType {Rectangle, ThreeDRectangle, RoundRectangle, Oval, Arc};


public class Shape {
    public int x,y,w,h;
    private int dirX, dirY;
    private ShapeType shapeType;
    private Color colour;

    public static int worldW;
    public static int worldH;

    public Shape(int x, int y, int size) {
        this(x, y, size, size, 0, 0, ShapeType.Oval, Color.BLACK);
    }

    public Shape(int x,int y,int w,int h, int dirX, int dirY, ShapeType shapeType, Color colour) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dirX = dirX;
        this.dirY = dirY;
        this.shapeType = shapeType;
        this.colour = colour;
    }

    public static void setWorld(int w, int h) {
        worldW = w;
        worldH = h;
    }

    public ShapeType getShapeType(){
        return this.shapeType;
    }

    public Color getColour(){
        return this.colour;
    }

    public void move(){
        

        x += dirX;
        y += dirY;

        if (x < 0){
            x = 0;
            dirX = -dirX;
            modifyBounce();
        }

        if (y < 0){
            y = 0;
            dirY = -dirY;
            modifyBounce();
        }

        if (x > worldW - w){
            x = worldW - w;
            dirX = -dirX;
            modifyBounce();
        }

        if (y > worldH - h){
            y = worldH - h;
            dirY = -dirY;
            modifyBounce();
        }

    }

    private void modifyBounce(){
        Random r = new Random();
        int modifier = r.nextInt(3) - 1; 
        dirX += modifier;
        dirY += modifier;
    }
}
