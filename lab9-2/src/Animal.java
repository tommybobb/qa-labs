public abstract class Animal {

    enum AnimalType {
            Fish,
            Amphibian,
            Reptil,
            Mammal,
            Bird,
            Invertebrate
        }

    
    AnimalType animalType;
    String name;

    public Animal(String name) {
        this.name = name;
    }

    String getName(){
        return this.name;
    }



}
