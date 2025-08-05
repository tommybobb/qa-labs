import java.util.Scanner;

public class Utils {
    private static final Scanner s = new Scanner(System.in);
    

    public  int getInt(String prompt) {
        System.out.println(prompt);

        while (!s.hasNextInt()){
            System.out.println("Invalid input. Please enter a valid integer.");
            s.next();
        }
        int result = s.nextInt();
        s.nextLine();
        return result;
    }

    public  String getString(String prompt) {
        System.out.println(prompt);

        return s.nextLine();
    }

    public int getWeightInPounds() {

        System.out.println("What is the weight in pounds?");

        while (!s.hasNextInt()){
            System.out.println("Invalid input. Please enter a valid number.");
            s.next();
        }
        int result = s.nextInt();
        s.nextLine();

        return result;
    }

    public void convertInputToStonesPounds(int pounds){

        int stones = pounds / 14;
        int remainingPounds = pounds % 14;

        System.out.println("The weight is " + stones + " stones and " + remainingPounds + " pounds.");
    }

    public static void closeScanner() {
        if (s != null) {
            s.close();
        }
    }

}
