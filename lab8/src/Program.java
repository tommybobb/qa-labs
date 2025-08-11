import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        cars.add(new RacingCar("Ford", "Tom"));
        cars.add(new RacingCar("Lotus", "Bob"));
        cars.add(new RacingCar("Honda", "Stan"));
        cars.add(new RacingCar("Skoda", "Jerry"));
        cars.add(new RacingCar("Mini", "Mike"));

        processCars(cars);

    }

    public static void processCars (List<Car> cars){

        for(Car car : cars){
            car.getToSixty();
            car.accelerate(2);
            
            if (car instanceof RacingCar) {
                RacingCar racingCar = (RacingCar) car;
                System.out.println(racingCar.getDriver() + " driving the " + car.getModel() + " is moving at " + car.getSpeed() + "MPH");
            }

        }

    }
}
