public class Account {
    int id;
    String owner;
    double balance;

    public Account(int id, String owner, double balance){
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public String getDetails (){

        return "Owner: " + this.owner + ", Balance: £" + this.balance;

    }

    public void addInterest(){
        if(this.balance <= 0){
            throw new IllegalArgumentException("Amount must be more than 0"); 
        }

        double interestRate = 0.025;

        this.balance += this.balance * interestRate;
    }

    public void Deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be more than 0"); 
        }

        this.balance += amount;
    }

    public void Withdraw(double amount){
        
        if(this.balance <= 0){
            throw new IllegalArgumentException("Unable to withdraw, you have no balance."); 
        }

        this.balance -= amount;

    }

    public int getId() {
        return id;
    }
}
