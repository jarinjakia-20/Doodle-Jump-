public class SeriesForLoop {
    public static void main(String[] args) {
        System.out.println("Even numbers (2 to 20):");
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }

        System.out.println("\nOdd numbers (1 to 19):");
        for (int i = 1; i < 20; i += 2) {
            System.out.print(i + " ");
        }
    }
}
