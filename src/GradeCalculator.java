import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the score (0-100): ");

        if (scanner.hasNextInt()) {
            int score = scanner.nextInt();

            String grade;

            if (score >= 90) {
                grade = "A+";
            } else if (score >= 80) {
                grade = "A";
            } else if (score >= 70) {
                grade = "A-";
            } else if (score >= 60) {
                grade = "B";
            } else if (score >= 40) {
                grade = "C+";
            } else if (score >= 0) {
                grade = "F";
            } else {
                grade = "Invalid score (cannot be negative)";
            }

            System.out.println("The grade is: " + grade);
        } else {
            System.out.println("Invalid input. Please enter an integer score.");
        }

        scanner.close();
    }
}
