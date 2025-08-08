
import java.util.HashMap;



public class  Zoo {
    HashMap<String, Integer> animalMap;

    public Zoo() {

        animalMap = new HashMap<String, Integer>();

        String[] orginalAnimals = {"Zebra", "Lion", "Buffalo"};

        String[] newAnimals = {"Zebra", "Gazelle", "Buffalo", "Zebra"};

        addAnimals(orginalAnimals);
        addAnimals(newAnimals);

    }

    void addAnimals(String[] animals) {

        for (String animal : animals) {
            if (animalMap.containsKey(animal)) {
                animalMap.put(animal, animalMap.get(animal) + 1);
            } else {
                animalMap.put(animal, 1);
            }
        }

    }
    
    void displayAnimalData(){
        for (String animal : animalMap.keySet()) {
            System.out.println(animal + ": " + animalMap.get(animal));
        }
    }
}
