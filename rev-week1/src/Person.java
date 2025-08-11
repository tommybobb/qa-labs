public class Person {
    
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    String getDetails(){
        return this.name + "(" + this.email + ")";
    }



}
