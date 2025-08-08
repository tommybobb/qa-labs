public class Vehicle {
    
    int speed;
    int lane;
    RegistrationPlate registrationPlate;
    int distanceTravelled = 0;

    private static int totalVehicles = 0;


    public Vehicle(int speed, int lane) throws NoRegistrationPlatesException {
        this.speed = speed;
        this.lane = lane;

        this.registrationPlate = RegistrationPlateFactory.getNextRegistrationPlate();
        totalVehicles++;
    }

    public static void showTotalVehicles(){
        System.out.println(totalVehicles + " in system!");
    }

    public void accelerate (int amount){
        
        int newSpeed = this.speed += amount;
        distanceTravelled += amount;

        if(newSpeed > 200){
            this.speed = 200;
            return;
        }


        this.speed = newSpeed;
    }

    public void brake (int amount){
        int newSpeed = this.speed -= amount;

        if(newSpeed <= 0){
            throw new Error("You are stopped!");
        }

        this.speed = newSpeed;
    }

    // String getDetails() {



    // }


}
