public class AverageCalculatorWhile {
    public static void main(String[] args) {
        double[] numbers = {12.5, 15.0, 18.75, 20.0, 14.5};

        double sum = 0;
        int i = 0;

        while (i < numbers.length) {
            sum += numbers[i];
            i++;
        }

        double average = sum / numbers.length;
        System.out.println("The average is: " + average);
    }
}
