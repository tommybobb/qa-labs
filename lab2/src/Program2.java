

public class Program2 {



    public static void main(String[] args)  {

        Account[] accounts = {
            new Account(1, "Tom Clarke", 10),
            new Account(2, "Bob Ross", 130),
            new Account(3, "Stan Lee", 330)
        };


        for(Account account  : accounts ){
            System.out.println(account.getDetails());
        }


        


    }



}
