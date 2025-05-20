import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter first integer (a): ");
        int a = scan.nextInt();

        System.out.print("Enter second integer (b): ");
        int b = scan.nextInt();

        System.out.print("Enter operator (+, -, *, /): ");
        char ch = scan.next().charAt(0);

        int result = 0;
        boolean validOperation = true;

        if (ch == '+') {
            result = a + b;
        } else if (ch == '-') {
            result = a - b;
        } else if (ch == '*') {
            result = a * b;
        } else if (ch == '/') {
            if (b != 0) {
                result = a / b;
            } else {
                System.out.println("Error: Division by zero is not allowed.");
                validOperation = false;
            }
        } else {
            System.out.println("Invalid operator.");
            validOperation = false;
        }

        if (validOperation) {
            System.out.println("Result: " + result);
        }

        scan.close();
    }
}

