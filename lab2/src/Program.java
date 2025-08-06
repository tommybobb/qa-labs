

public class Program {



    public static void main(String[] args)  {

        Account account = new Account(0, "Tom Clarke", 0);

        System.out.println(account.getDetails());

        try {
            account.Withdraw(200);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        try {
            account.Deposit(-200);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            account.Deposit(200);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println(account.getDetails());

        try {
            account.Withdraw(100);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println(account.getDetails());
        


    }



}
