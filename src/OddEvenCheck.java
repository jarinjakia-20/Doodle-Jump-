import java.util.Scanner;

public class OddEvenCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");

        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            if (number % 2 == 0) {
                System.out.println("The number is even.");
            } else {
                System.out.println("The number is odd.");
            }
        } else {
            System.out.println("The input is not an integer.");
        }

        scanner.close();
    }
}
