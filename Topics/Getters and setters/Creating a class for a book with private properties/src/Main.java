import java.util.Scanner;

public class Main {
    // Creating class
    public static class Book {
        // private properties
        private String title;
        private String author;
        private int numberOfPages;

        // getters and setters go here
        // Remember: 
        // 1. They must not allow empty string for 'title' and 'author'.
        // 2. They must not allow negative or zero value for 'numberOfPages'.
        // 3. If such values are attempted to be set, the property should remain unchanged.

        // getters
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        // setter
        public void setTitle(String title) {
            if (title != null) {
                this.title = title;
            }
        }

        public void setAuthor(String author) {
            if (author != null) {
                this.author = author;
            }
        }

        public void setNumberOfPages(int numberOfPages) {
            if (numberOfPages > 0) {
                this.numberOfPages = numberOfPages;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an object of the Book class
        Book book = new Book();

        // Take Title, Author and numberOfPages as next inputs and set them using the mutator methods
        // Your code here

        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int numberOfPages = scanner.nextInt();

        book.setTitle(title);
        book.setAuthor(author);
        book.setNumberOfPages(numberOfPages);

        // Then use the accessor methods to get and print these values.
        // Your code here

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getNumberOfPages());

        scanner.close();
    }
}