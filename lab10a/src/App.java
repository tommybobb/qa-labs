
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        

        List<Animal> animals = new ArrayList<>();

        animals.add(new Goldfish("Goldfish"));
        animals.add(new Penguin("Pengu"));
        animals.add(new Duck("Seagul"));
        animals.add(new Lizard("Gek"));

        for(Animal a : animals){

            System.out.println("Animal: " + a.name + " of type " + a.animalType);

            // if(a instanceof Flyable f){
            //     f.fly();
            // }

            // if(a instanceof Moveable m){
            //     m.move();
            // }

            if(a instanceof Swimmable s){
                s.swim();
            }


        }
        
    }
}
