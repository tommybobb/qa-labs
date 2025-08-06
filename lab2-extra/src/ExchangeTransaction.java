public class ExchangeTransaction {
    
    private Customer customer;
    private Currency currency;
    private double gbpAmount;

    public ExchangeTransaction(Customer customer, Currency currency, double gbpAmount ) {
        this.customer = customer;
        this.currency = currency;
        this.gbpAmount = gbpAmount;
    }

    public String getCustomerName(){
        return this.customer.getName();
    }

    public double calculateServiceFee(){

        return gbpAmount < 100 ? gbpAmount * 0.05 : gbpAmount * 0.025;

    }

    public double getGbpAmount() {
        return gbpAmount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double calculateTax(double ammountAfterFee){
        return customer.getIsVip() ? ammountAfterFee * 0.05 : ammountAfterFee * 0.1;
    }

    public void processTransaction() {

        double serviceFee = calculateServiceFee();

        double afterFee = gbpAmount - calculateServiceFee();

        double airportTax =  calculateTax(afterFee);
        double afterTax = afterFee - calculateTax(afterFee);

        double finalAmount = currency.convertToGBP(afterTax);

        int rounded = (int) finalAmount;


        System.out.printf("Customer: %s | Original: %.2f GBP | After Fees: %.2f GBP | After Tax: %.2f GBP | From: %s | Final: %d %s%n",
                      customer.getName(), gbpAmount, afterFee, afterTax, currency.getName(), rounded, currency.getName());


        ExchangeTransactionLog log = new ExchangeTransactionLog(this, serviceFee, airportTax, finalAmount);
        TransactionLogManager.addLog(log);


    }

}
