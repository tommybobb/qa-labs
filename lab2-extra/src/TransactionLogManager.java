import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionLogManager {
    
    private static List<ExchangeTransactionLog> transactionLogs = new ArrayList<>();

    public static void addLog(ExchangeTransactionLog log) {
        transactionLogs.add(log);
    }

    public static List<ExchangeTransactionLog> getAllLogs() {
        return new ArrayList<>(transactionLogs);
    }

    public static List<ExchangeTransactionLog> getLogsByCustomerName(String customerName) {
        return transactionLogs.stream()
                .filter(log -> log.getExchangeTransaction().getCustomerName().equals(customerName))
                .collect(Collectors.toList());
    }


    public static void displayLogsForCustomer(String customerName) {
        List<ExchangeTransactionLog> customerLogs = getLogsByCustomerName(customerName);
        
        System.out.println("------------------------");
        System.out.println("TRANSACTION LOGS FOR: " + customerName.toUpperCase());
        
        if (customerLogs.isEmpty()) {
            System.out.println("No transactions found for " + customerName);
        } else {
            for (ExchangeTransactionLog log : customerLogs) {
                log.displayLogInfo();
            }
            System.out.println("Total logs for " + customerName + ": " + customerLogs.size());
        }
        System.out.println("------------------------");

    }
}
