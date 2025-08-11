
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        

        List<Animal> animals = new ArrayList<>();

        animals.add(new Fish("Godlfish"));
        animals.add(new Penguin("Pengu"));
        animals.add(new Duck("Seagul"));
        animals.add(new Lizard("Gek"));

        for(Animal a : animals){

            System.out.println("Animal: " + a.name);

            if(a instanceof Bird){
                ((Bird) a).makeNest();
            }

            if(a instanceof Fish){
                ((Fish) a).swim();
            }

            if(a instanceof Lizard){
                ((Lizard) a).shootsTongue();
            }



        }
        
    }
}
