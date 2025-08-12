public class Account implements Comparable<Account> {
    
    int id; 
    double balance; 
    String owner;

    public Account(int id, String owner, double balance) {

        this.id = id;
        this.balance = balance;
        this.owner = owner;

    }

    @Override
    public int compareTo(Account o) {
	    return (int)(this.id - o.id);
    }


    void withdraw(double amount)   {

        double newBalance = this.balance - amount;
        
        if( newBalance < 0 ){
            throw new IllegalArgumentException("You do not have enough money to withdraw that amount");
        }

        this.balance = newBalance;

    }

    void deposit(double amount)   {

        this.balance += amount;

    }

    void close(){
        System.out.println("Account " + this.id + " is closed.");
    }

    String getDetials(){

        return "Account Id: "+ this.id +" Acount Owner: "+ this.owner +" Account Balance: " + this.balance;

    }
}
