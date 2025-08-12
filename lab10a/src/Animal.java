public abstract class Animal implements Moveable {

    enum AnimalType {
            Fish,
            Amphibian,
            Reptile,
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

    public void move(){
        System.out.println(getName() + " is moving");
    }



}
