import java.util.Scanner;

public class MedalAward {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: student's letter grade
        System.out.print("Enter the student's letter grade (GPA): ");
        double grade = scanner.nextDouble();

        // Input: has the student completed the semester? (yes/no)
        System.out.print("Has the student completed the semester? (yes/no): ");
        String completed = scanner.next();

        // Nested if statement
        if (completed.equalsIgnoreCase("yes")) {
            if (grade >= 3.5) {
                System.out.println("The student is awarded a medal! 🏅");
            } else {
                System.out.println("The student did not qualify for a medal.");
            }
        } else {
            System.out.println("The student is not eligible as they have not completed the semester.");
        }

        scanner.close();
    }
}
