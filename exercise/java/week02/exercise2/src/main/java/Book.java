import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

private class Book {
    private String title;
    private String author;
    private int copies;

    public Book(String title, String author, int copies) {
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
}
