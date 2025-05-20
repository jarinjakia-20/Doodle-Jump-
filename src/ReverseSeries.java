public class ReverseSeries {
    public static void main(String[] args) {
        // Example array (series)
        int[] numbers = {10, 20, 30, 40, 50, 60, 70};

        System.out.println("Original series:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\nReversed series:");
        // Loop to print the array in reverse order
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
