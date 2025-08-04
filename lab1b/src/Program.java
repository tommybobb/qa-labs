public class Program {
    public static void main(String[] args) throws Exception {

        int mark = 100;

        if (mark < 50) {
            System.out.println("You have failed your exam.");
        } else if (mark >= 50 && mark <= 60) {
            System.out.println("You have earned a Pass.");
        } else if (mark >= 61 && mark <= 70) {
            System.out.println("You have earned a Merit.");
        } else {
            System.out.println("You have earned a Distinction.");
        }


    }
}
