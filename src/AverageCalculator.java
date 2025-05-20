public class AverageCalculator {
    public static void main(String[] args) {
        double[] numbers = {10.5, 20.0, 30.75, 15.25, 25.0};

        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        double average = sum / numbers.length;

        System.out.println("The average is:a " + average);
    }
}
