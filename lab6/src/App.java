public class App {
    public static void main(String[] args)  {

            Account acc = new Account(1,100,"Tom");

            try {
                acc.withdraw(50);
                
            } catch (Exception e) {
                System.out.println("Unable to withdraw, you dont have enough money");
            } finally {
                acc.close();
            }

            try {
                acc.withdraw(60);
                
            } catch (Exception e) {
                System.out.println("Unable to withdraw, you dont have enough money");
            } finally {
                acc.close();
            }

            System.out.println(acc.getDetials());



    }
}
