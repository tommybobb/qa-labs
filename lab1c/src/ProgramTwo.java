

public class ProgramTwo {
    public static void main(String[] args) throws Exception {

        theLunchQueue();

        
        // What main dish would you like(Fish, Burgers or veg) ?
        // Fish
        // How many roast potatoes would you like?
        // 5
        // How many Brussel Sprouts would you like?
        // 20
        // Hello, your lunch is Fish with 5 roast potatoes and 20 Brussel Sprouts.
        
    }

    public static void theLunchQueue() {
        Utils utils = new Utils();

        String mainCourse = utils.getString("What main dish would you like(Fish, Burgers or veg) ?");
        int potatoCount = utils.getInt("How many roast potatoes would you like?");
        int sproutCount = utils.getInt("How many Brussel Sprouts would you like?");


        System.out.println("Hello, your lunch is " + mainCourse + " with " + potatoCount + " roast potatoes and " + sproutCount + " Brussel Sprouts.");
    }

    
}