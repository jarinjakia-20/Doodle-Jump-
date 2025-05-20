public class CountOddEven {
    public static void main(String[] args) {
        // Example array of numbers
        int[] numbers = {12, 7, 5, 10, 23, 18, 40, 55, 60, 31};

        int evenCount = 0;
        int oddCount = 0;

        // Loop to check each number
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Total even numbers: " + evenCount);
        System.out.println("Total odd numbers: " + oddCount);
    }
}
