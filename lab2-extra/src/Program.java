

public class Program {

    public static void main(String[] args)  {

        Currency usdCurrency = new Currency("USD", 1.25);
        Currency eurCurrency = new Currency("EUR", 1.15);

        Customer customer1 = new Customer("Tom", 33, false);
        Customer customer2 = new Customer("Alice", 28, true);
        Customer customer3 = new Customer("Bob", 45, false);

        ExchangeTransaction transaction1 = new ExchangeTransaction(customer1, usdCurrency, 200);
        ExchangeTransaction transaction4 = new ExchangeTransaction(customer1, usdCurrency, 300);
        ExchangeTransaction transaction5 = new ExchangeTransaction(customer1, usdCurrency, 3100);

        ExchangeTransaction transaction2 = new ExchangeTransaction(customer2, eurCurrency, 300);
        ExchangeTransaction transaction3 = new ExchangeTransaction(customer3, usdCurrency, 150);

        transaction1.processTransaction();
        transaction2.processTransaction();
        transaction3.processTransaction();
        transaction4.processTransaction();
        transaction5.processTransaction();

        TransactionLogManager.displayLogsForCustomer("Tom");

        
   
    }


    
}
