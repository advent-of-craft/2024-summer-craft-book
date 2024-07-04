import java.util.ArrayList;

public class BookStore {
    private ArrayList<Book> inv = new ArrayList<>();

    public void addBook(String title, String author, int copies) {
        if (title != null && author != null && copies > 0) {
            Book foundBook = null;
            for (Book book : inv) {
                if (book.getTitle().equals(title)
                        && book.getAuthor().equals(author)) {
                    foundBook = book;
                    break;
                }
            }
            if (foundBook != null) {
                foundBook.addCopies(copies);
            } else {
                inv.add(new Book(title, author, copies));
            }
        }
    }

    public void sellBook(String title, String author, int copies) {
        for (Book book : inv) {
            if (book.getTitle().equals(title)
                    && book.getAuthor().equals(author)) {
                book.removeCopies(copies);
                if (book.getCopies() <= 0) {
                    inv.remove(book);
                }
                break;
            }
        }
    }
}
