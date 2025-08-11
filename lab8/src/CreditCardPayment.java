public class CreditCardPayment extends PaymentMethod {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        super();
        this.cardNumber = cardNumber;
    }

    private boolean validateCardNumber (){

        if(this.cardNumber.length() != 16){
            return false;
        }

        return true;

    }

    @Override
    public void processPayment(double amount) {
        
       
    }
    
    @Override
    public String getPaymentDetails() {
        return  "";
    }
    
}
