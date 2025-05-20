import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Sales percentage
        System.out.print("Enter the percentage of target sales achieved: ");
        double salesPercent = scanner.nextDouble();

        // Input: Attendance percentage
        System.out.print("Enter the attendance percentage: ");
        double attendancePercent = scanner.nextDouble();

        double bonusPercent;

        // Check conditions
        if (salesPercent >= 95 && attendancePercent == 100) {
            bonusPercent = 60;
        } else if (salesPercent >= 95 && attendancePercent >= 90) {
            bonusPercent = 40;
        } else if (salesPercent >= 80 && attendancePercent == 100) {
            bonusPercent = 40;
        } else if (salesPercent >= 80 && attendancePercent >= 90) {
            bonusPercent = 20;
        } else {
            bonusPercent = 5;
        }

        System.out.println("The bonus is: " + bonusPercent + "%");
        scanner.close();
    }
}
