public class Car {
    private String model;
    private int speed;
    
    public Car(String model) {
        this.model = model;
        this.speed = 0;
    }
    
    public void accelerate(int seconds) {
        this.speed = 5 * seconds;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void getToSixty() {
        this.speed = 60;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }
}
