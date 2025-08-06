
public class ExchangeTransactionLog {
    
    private int id;
    private double serviceFee;
    private double airportTax;
    private double finalAmount;
    private ExchangeTransaction transaction;
    
    private static int nextIdCounter = 1;


    public ExchangeTransactionLog(ExchangeTransaction transaction, double serviceFee, double airportTax, double finalAmount) {
        this.transaction = transaction;
        this.airportTax = airportTax;
        this.finalAmount = finalAmount;
        this.serviceFee = serviceFee;
        this.id = nextIdCounter++;
    }

    public ExchangeTransaction getExchangeTransaction(){
        return transaction;
    }

    public void displayLogInfo() {
        System.out.println(".....................");

        System.out.println("Transaction Log ID: " + id);
        System.out.println("Customer: " + transaction.getCustomerName());
        System.out.println("Original Amount: £" + String.format("%.2f", transaction.getGbpAmount()));
        System.out.println("Service Fee: £" + String.format("%.2f", serviceFee));
        System.out.println("Airport Tax: £" + String.format("%.2f", airportTax));
        System.out.println("Final Amount: £" + String.format("%.2f", finalAmount));
        System.out.println("Currency: " + transaction.getCurrency().getName());
        System.out.println(".....................");
    }


}
