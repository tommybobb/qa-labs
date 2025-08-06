public class Customer {

    private String name;
    private int age;
    private boolean isVip;


    public Customer() {

    }

    public Customer(String name, int age, boolean isVip) {
        this.name = name;
        this.age = age;
        this.isVip = isVip;
    }
    
    public String getName(){
        return  this.name;
    }

    public int getAge(){
        return  this.age;
    }

    public boolean getIsVip(){
        return  this.isVip;
    }

}
