public class App {
    public static void main(String[] args) {

        int[] numbers = { 1, 3, -5, 7, 0, 4, 6, 8 };

        int arraySum = 0;
        for( int number : numbers ) {
            arraySum += number; 
        }
        System.out.println("Sum of array elements: " + arraySum);

        double arrayAverage = (double) arraySum / numbers.length;
        System.out.println("Average of array elements: " + arrayAverage);

        int arrayMin = numbers[0];
        int arrayMax = numbers[0];

        for (int number : numbers) {
            if (number < arrayMin) {
                arrayMin = number;
            }
            if (number > arrayMax) {
                arrayMax = number;
            }
        }
        System.out.println("Minimum element in array: " + arrayMin);
        System.out.println("Maximum element in array: " + arrayMax);

        int zeroIndex = 0;

        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0 ){
                zeroIndex = i;
                break;
            }
        }

        System.out.println("Index of zero in array: " + zeroIndex);

    }
}
