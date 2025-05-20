public class SumSeriesForLoop {
    public static void main(String[] args) {
        int evenSum = 0;
        int oddSum = 0;

        // Sum of even numbers
        for (int i = 2; i <= 20; i += 2) {
            evenSum += i;
        }

        // Sum of odd numbers
        for (int i = 1; i < 20; i += 2) {
            oddSum += i;
        }

        System.out.println("Sum of even numbers (2 to 20): " + evenSum);
        System.out.println("Sum of odd numbers (1 to 19): " + oddSum);
    }
}
