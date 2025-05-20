public class AverageCalculatorInt {
    public static void main(String[] args) {
        // Example array with integer numbers
        int[] numbers = {10, 20, 30, 40, 50};

        int sum = 0;

        // Loop through array to calculate sum
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        // Calculate average (cast to double for accurate result)
        double average = (double) sum / numbers.length;

        System.out.println("The average is: " + average);
    }
}
