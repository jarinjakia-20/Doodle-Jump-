import java.util.Scanner;

    public class PositiveIntegerCheck {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number: ");

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();

                if (number > 0) {
                    System.out.println("The input is a positive integer.");
                } else {
                    System.out.println("The input is not a positive integer.");
                }
            } else {
                System.out.println("The input is not an integer.");
            }

            scanner.close();
        }
    }


