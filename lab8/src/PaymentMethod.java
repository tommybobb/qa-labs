

public abstract class PaymentMethod {
    

    abstract void processPayment(double amount);

    abstract String getPaymentDetails (); 
}