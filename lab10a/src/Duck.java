public class Duck extends Bird implements Flyable, Swimmable {
    

    public Duck(String name) {
        super(name);
    }

    public void makeNest(){
        System.out.println("Made a quacking nest");
    }

    public void fly() {
        System.out.println("Flying like a Duck!");					         
    }

    public void swim(){
        System.out.println("Swimming like a duck");
    }


}
