
public class Book {

    private String title;
    private String author;

    public Book(String title) {
        this.title = title;
        this.author = "Unknown";
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
    }

    // Main method to test constructor overloading
    public static void main(String[] args) {
        // Creating a book with only title
        Book book1 = new Book("Java Programming");

        // Creating a book with title and author
        Book book2 = new Book("Effective Java", "Joshua Bloch");

        // Display book details
        System.out.println("---- Book 1 ----");
        book1.displayBookInfo();

        System.out.println("\n---- Book 2 ----");
        book2.displayBookInfo();
    }
}
