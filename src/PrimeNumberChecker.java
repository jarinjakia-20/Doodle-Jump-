import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number to check
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false; // Numbers less than or equal to 1 are not prime
        } else {
            // Check divisibility from 2 up to sqrt(number)
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        // Output result
        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        scanner.close();
    }
}
