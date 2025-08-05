import java.util.Scanner;

public class Program {

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        
        int amountOfGBP = getCurrencyAmount();

        String currencyToConvertTo = getCurrencyToConvertTo();

        double convertedAmount = convertCurrency(amountOfGBP, currencyToConvertTo);

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

        String customerType = "V";
        double airportTax = 0.1;
        if(customerType.equals("V")) {
            airportTax = 0.05;
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
