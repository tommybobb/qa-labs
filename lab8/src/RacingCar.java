public class RacingCar extends Car {
    private String driver;
    private int turboFactor;
    
    public RacingCar(String model, String driver) {
        super(model);
        this.driver = driver;
        this.turboFactor = 4;
    }
    
    public void accelerate() {
        super.accelerate( super.getSpeed() * turboFactor );
    }

    @Override
    public String getModel() {
        return super.getModel();
    }
    
    public String getDriver() {
        return driver;
    }
    
    public double getTurboFactor() {
        return turboFactor;
    }
    
    public void racingCar() {
        System.out.println("Racing car " + getModel() + " driven by " + driver + " is racing!");
    }
    
    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    public void setTurboFactor(int turboFactor) {
        if (turboFactor > 0) {
            this.turboFactor = turboFactor;
        }
    }
}