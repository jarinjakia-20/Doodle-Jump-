public class FindGreatestNumber {
    public static void main(String[] args) {

        int[] numbers = {12, 45, 67, 89, 34, 23, 90, 56, 78};

        int greatest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > greatest) {
                greatest = numbers[i];
            }
        }

        System.out.println("The greatest number in the series is: " + greatest);
    }
}
