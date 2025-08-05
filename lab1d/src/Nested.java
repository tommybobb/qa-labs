public class Nested {
    public static void main(String[] args) {
        multiplicationTable();
    }

    static void multiplicationTable() {

        for (int col = 1; col <= 10; col++) {
            for (int row = 1; row <= 10; row++) {
                System.out.printf("%5d", col * row);
            }
            System.out.println();
        }


    }
}
