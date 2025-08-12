public class Fish extends Animal implements Swimmable {
    

    public Fish(String name) {
        super(name);
        super.animalType = AnimalType.Fish;
    }

    public void swim(){
        System.out.println("Swimming like a fish");
    }

}
