

public class Program4 {



    public static void main(String[] args)  {

        Bank bank = new Bank();

        bank.addAccount("Bob Ross", 100);
        bank.addAccount("Stan Lee", 130);
        bank.addAccount("John Doe", 400);


        Account acc = bank.getAccount("Bob Ross");

        if(acc != null){
            System.out.println(acc.owner + " BALANCE: " + acc.balance);
        } else {
            System.out.println("Account not found");
        }

        try {
            bank.addAccount("Bob Doe", 400);
            
        } catch (Exception e) {
            System.out.println("ERROR: "+ e.getMessage());
        }


        Account acc2 = bank.getAccount("Bob Rdasdsaoss");

        if(acc2 != null){
            System.out.println(acc2.owner + " BALANCE: " + acc2.balance);
        } else {
            System.out.println("Account not found");
        }

    }



}
