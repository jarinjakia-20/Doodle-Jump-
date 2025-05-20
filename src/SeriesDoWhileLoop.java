public class SeriesDoWhileLoop {
    public static void main(String[] args) {
        System.out.println("Even numbers (2 to 20):");
        int i = 2;
        do {
            System.out.print(i + " ");
            i += 2;
        } while (i <= 20);

        System.out.println("\nOdd numbers (1 to 19):");
        int j = 1;
        do {
            System.out.print(j + " ");
            j += 2;
        } while (j < 20);
    }
}
