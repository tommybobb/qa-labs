

public class Program3 {



    public static void main(String[] args)  {

        Account myAccount = new Account(1, "Tom", 100);
        //Account partnerAccount = myAccount; // is a reference to my accoutn NOT a copy

        System.out.println(myAccount.getDetails());

        try {
            myAccount.addInterest();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //applies it to both partner and my as partner is a ref to my
        // try {
        //     partnerAccount.addInterest();
        // } catch (Exception e) {
        //     System.out.println("ERROR: " + e.getMessage());
        // }

        System.out.println(myAccount.getDetails());

        processAccount(myAccount);
        System.out.println(myAccount.getDetails());

        int k = 100;

        incInt(k);

        System.out.println(k);


    }

    static void processAccount(Account account){
        account.addInterest();
    }

    private static void incInt(int x){
        x++;
    }


}
