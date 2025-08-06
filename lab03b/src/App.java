import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {


    public static void main(String[] args)  {
        Random rand = new Random();
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle(0, 1));
        vehicles.add(new Vehicle(0, 2));
        vehicles.add(new Vehicle(0, 3));
        vehicles.add(new Vehicle(0, 4));
        vehicles.add(new Vehicle(0, 5));
        vehicles.add(new Vehicle(0, 6));



        int maxDistance = 0;
        Vehicle winningVehicle = null;

        while(maxDistance < 1000){

            for(Vehicle vehicle : vehicles){

                vehicle.accelerate(rand.nextInt(10)+1);


                System.out.println("VEHICLE IN LANE: " + vehicle.lane + " traveling at : " + vehicle.speed + "MPH" +
                    " - REG: " +  vehicle.registrationPlate.getNumber() + " - Distance: " + vehicle.distanceTravelled);

                if(vehicle.distanceTravelled >  maxDistance){
                    maxDistance = vehicle.distanceTravelled;

                }

                if(vehicle.distanceTravelled >= 1000){
                    winningVehicle = vehicle;
                }
            }

        }

        System.out.println("WINNER IS LANE: " + winningVehicle.lane + " REG: " + winningVehicle.registrationPlate.getNumber());




        //Vehicle.showTotalVehicles();

    }
}
