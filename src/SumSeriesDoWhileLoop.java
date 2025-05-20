public class SumSeriesDoWhileLoop {
    public static void main(String[] args) {
        int evenSum = 0;
        int oddSum = 0;

        int i = 2;
        do {
            evenSum += i;
            i += 2;
        } while (i <= 20);

        int j = 1;
        do {
            oddSum += j;
            j += 2;
        } while (j < 20);

        System.out.println("Sum of even numbers (2 to 20): " + evenSum);
        System.out.println("Sum of odd numbers (1 to 19): " + oddSum);
    }
}
