public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 12; // Number of terms to print

        int first = 0;
        int second = 1;

        System.out.print("Fibonacci series: ");

        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");

            // Calculate the next number
            int next = first + second;
            first = second;
            second = next;
        }
    }
}
