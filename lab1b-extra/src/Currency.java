public class Currency {
    private String currency;
    private double exchangeRate;

    public Currency(String currency, double exchangeRate) {
        this.currency = currency;
        this.exchangeRate = exchangeRate;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public double getExchangeRate() {
        return exchangeRate;
    }
}
