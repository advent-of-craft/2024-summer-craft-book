import java.util.Optional;

public class Book {
    private final String title;
    private final String author;
    private int copies;

    private Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public void addCopies(int additionalCopies) {
        if (additionalCopies > 0) {
            this.copies += additionalCopies;
        }
    }

    public void removeCopies(int soldCopies) {
        if (soldCopies > 0 && this.copies >= soldCopies) {
            this.copies -= soldCopies;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    public boolean hasCopies() {
        return getCopies() > 0;
    }

    public static Optional<Book> tryCreateBook(String title, String author, int copies) {
        if (informationInvalid(title, author, copies))
            Optional.empty();

        return Optional.of(new Book(title, author, copies));
    }

    public static boolean informationInvalid(String title, String author, int copies) {
        return title == null
                || author == null
                || copies <= 0;
    }
}
