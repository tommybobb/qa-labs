



public class Program {
    public static void main(String[] args) throws Exception {
        Utils utils = new Utils();

        int number = utils.getInt("Enter a number:" );
        System.out.println("Your number is: " + number);

        String string = utils.getString("Enter a string:");
        System.out.println("Your string is: " + string);



        Utils.closeScanner();
    }

    // orginal code for Utils methods

    // public static int getInt(String prompt) {
    //     Scanner s = new Scanner(System.in);

    //     while (!s.hasNextInt()){
    //         System.out.println("Invalid input. Please enter a valid integer.");
    //         s.next();
    //     }

    //     return s.nextInt();
    // }

    // public static String getString(String prompt) {
    //     Scanner s = new Scanner(System.in);

    //     return s.nextLine();
    // }
}