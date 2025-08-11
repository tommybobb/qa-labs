public abstract class Bird extends Animal {
    

    public Bird(String name) {
        super(name);
        super.animalType = AnimalType.Bird;

    }

    public abstract void makeNest();

}
