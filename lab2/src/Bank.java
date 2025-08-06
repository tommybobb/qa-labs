
public class Bank {
    
    Account[] storage = new Account[3];

    public Bank() {

    }

    public Account addAccount (String owner, double balance){

        int nextId = getNextId();
        
        Account account = new Account(nextId, owner, balance);

        for(int i = 0; i < storage.length; i++){
            if(storage[i] == null){
                storage[i] = account;
                return account;
            }
        }

        throw new IllegalArgumentException("Storage is full"); 
    }


    Account getAccount(String owner){

        for(Account acc : storage){
            if(acc.owner.equals(owner)){
                return acc;
            }
        }

        return null;

    }


    private int getNextId() {
        if (storage.length == 0) {
            return 1;
        }
        
        int maxId = 1;

        for (Account account : storage) {

            if (account != null) {
                maxId = account.getId();
            }

        }
        return maxId + 1;
    }
    

}
