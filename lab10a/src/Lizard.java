public class Lizard extends Animal {

    public Lizard(String name) {
        super(name);
        this.animalType = animalType.Reptile;
    }

    public void shootsTongue(){
        System.out.println("Shoots for a fly");
    }
}
