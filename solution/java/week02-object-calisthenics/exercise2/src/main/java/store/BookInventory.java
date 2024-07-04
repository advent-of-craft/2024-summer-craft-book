package store;

import java.util.ArrayList;

public class BookInventory extends ArrayList<Book> {

    public void removeBookIfNoMoreCopies(Book book) {
        if (!book.hasCopies()) {
            remove(book);
        }
    }
}
