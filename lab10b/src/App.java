
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args)  {

            List<Account> accounts = new ArrayList<>();

            accounts.add(new Account(100, "Bob", 1000));
            accounts.add(new Account(500, "Linda", 3000));
            accounts.add(new Account(300, "David", 2000));
            Collections.sort(accounts);


            for (Account account : accounts) {
                System.out.println(account.getDetials());
            }



    }
}
