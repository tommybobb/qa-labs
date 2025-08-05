
import java.util.Scanner;

public class ProgramThree {
    public static void main(String[] args) throws Exception {

        Utils utils = new Utils();

        System.out.println("What is the weight in pounds?");
        
        Scanner s = new Scanner(System.in);
        // Error handling for integer input
        while (!s.hasNextInt()){
            System.out.println("Invalid input. Please enter a valid number.");
            s.next();
        }

        int pounds = s.nextInt();

        utils.convertInputToStonesPounds(pounds);

        Utils.closeScanner();

    }


    
}