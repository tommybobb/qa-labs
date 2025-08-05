public class DoubleMoney {
    public static void main(String[] args) {
        
        int yearsToDouble = interestCalulator(1000, 2000);
        System.out.println("Years to double the money: " + yearsToDouble);

    }

    static int interestCalulator( double initialValue, double targetValue  ){
        double interestRate = 0.05; 
        int years = 0;

        while (initialValue < targetValue) {
            initialValue += initialValue * interestRate;
            years++;
        }
        return years;
    }


}
