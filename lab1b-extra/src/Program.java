import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private static final Scanner s = new Scanner(System.in);

    private static final ArrayList<Currency> currencies = new ArrayList<>();
    
    static {
        currencies.add(new Currency("USD", 1.25));
        currencies.add(new Currency("EUR", 1.15));
        currencies.add(new Currency("JPY", 180.5));
        currencies.add(new Currency("THB", 43.08));
    }


    public static void main(String[] args) {
        
        int amountOfGBP = getCurrencyAmount();

        String currencyToConvertTo = getCurrencyAmountV2();

        double convertedAmount = convertCurrencyV2(amountOfGBP, currencyToConvertTo);

        double serviceFeeAmount = getServiceFeeAmount(convertedAmount);
        double totalChargeAfterFee = convertedAmount + serviceFeeAmount;

        double airportTaxAmount = getAirportTaxAmount(totalChargeAfterFee);
        double totalCharge = totalChargeAfterFee + airportTaxAmount;

        System.out.println("Converted " + amountOfGBP + " GBP to " + currencyToConvertTo + ": " + (int)convertedAmount);
        System.out.println("Charge with Service Fee: " + (int)totalChargeAfterFee + " (Service fee: " + (int)serviceFeeAmount + ")");
        System.out.println("Total charge after Airport Tax: " + (int)totalCharge + " (Airport tax: " + (int)airportTaxAmount + ")");

        closeScanner();
    }

    private static double getAirportTaxAmount(double totalChargeAfterFee) {

        // Assumes airport tax is on the converted amount + service fee?
        // Could probably create a class for the customer type and airport tax rate

        // Customer time, for example
        String customerType = "S";


        double airportTax = 0.1;
        if(customerType.equals("V")) {
            airportTax = 0.05;
        } else if (customerType.equals("S")){
            //If staff then no airport tax
            return 0;
        }
        
        return totalChargeAfterFee * airportTax;
    }

    private static double getServiceFeeAmount(double convertedAmount) {
        
        // Assumes service fee is on the converted amount?

        double serviceFee = 0.05;

        if (convertedAmount >= 100){
            serviceFee = 0.025;
        }

        return convertedAmount * serviceFee;

    }

    private static double convertCurrency(int amountOfGBP, String currencyToConvertTo) {
        // Could be improved with a class for currency conversion rates
        
        double convertedAmount = 0.0;
        
        switch (currencyToConvertTo){

            case "USD":
                convertedAmount = amountOfGBP * 1.25;
                break;

            case "EUR":
                convertedAmount = amountOfGBP * 1.15;
                break;
                
            default: //JPY default - already validated in input
                convertedAmount = amountOfGBP * 180.5;

        }
        return convertedAmount;
    }

    private static double convertCurrencyV2(int amountOfGBP, String currencyToConvertTo) {

        for (Currency currency : currencies) {
            if (currency.getCurrency().equals(currencyToConvertTo)) {
                return amountOfGBP * currency.getExchangeRate();
            }
        }

        // could throw an exception or handle error if currency not found
        return 0.0;

    }

    private static int getCurrencyAmount() {

        System.out.println("How much GBP do you wish to convert?");

        while (!s.hasNextInt()){
            System.out.println("Invalid input. Please enter a valid number.");
            s.next();
        }

        int currencyAmount = s.nextInt();
        s.nextLine();

        return currencyAmount;

    }

    private static String getCurrencyAmountV2() {

        String[] validCurrencies = new String[currencies.size()];
        for (int i = 0; i < currencies.size(); i++) {
            validCurrencies[i] = currencies.get(i).getCurrency();
        }
        
        System.out.print("Which currency do you wish to convert to (");
        for (int i = 0; i < validCurrencies.length; i++) {
            System.out.print(validCurrencies[i]);
            if (i < validCurrencies.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")?");
        
        String input = s.nextLine().trim().toUpperCase();
        
        while (!isValidCurrency(input, validCurrencies)) {
            System.out.println("Invalid input. Please enter a valid currency.");
            input = s.nextLine().trim().toUpperCase();
        }
        
        return input;
    }

    private static boolean isValidCurrency(String input, String[] validCurrencies) {
        for (String currency : validCurrencies) {
            if (currency.equals(input)) {
                return true;
            }
        }
        return false;
    }

    private static String getCurrencyToConvertTo() {

        System.out.println("Which currency do you wish to convert to (USD, EUR, JPY)?");

        String input = s.nextLine().trim().toUpperCase();

        while (!input.equals("USD") && !input.equals("EUR") && !input.equals("JPY")) {

            System.out.println("Invalid input. Please enter a valid currency.");
            input = s.nextLine().trim().toUpperCase();
        }

        return input;

    }

    private static void closeScanner() {
        if (s != null) {
            s.close();
        }
    }


}
