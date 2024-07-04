import org.junit.Test;
import store.Book;
import store.BookStore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookStoreTest {

    private final BookStoreForTest store = new BookStoreForTest();

    private static Book createABook(int copies) {
        return Book.tryCreateBook(
                "Lord of the ring",
                "JR Tolkien", copies
        ).orElseThrow();
    }

    private Book addBookToStore(int initialCopies) {
        var createdBook = createABook(initialCopies);
        store.addBook(createdBook.getTitle(), createdBook.getAuthor(), initialCopies);
        return createdBook;
    }

    @Test
    public void addANewBookToStore() {
        var bookToAdd = createABook(2);

        store.addBook(bookToAdd.getTitle(),
                bookToAdd.getAuthor(),
                bookToAdd.getCopies());

        assertTrue("The book should be in the inventory",
                store.verifyBookIsInStore(bookToAdd));
    }

    @Test
    public void doesNotAddBookToStoreIfNoCopy() {
        var noCopy = 0;
        var bookToAdd = createABook(noCopy);

        store.addBook(bookToAdd.getTitle(),
                bookToAdd.getAuthor(),
                noCopy
        );

        assertFalse("The book should not be in the inventory",
                store.verifyBookIsInStore(bookToAdd));
    }

    @Test
    public void doesNotAddBookToStoreIfInvalidTitle() {
        String invalidTitle = null;
        String author = "JR Tolkien";

        store.addBook(invalidTitle, author, 2);

        assertFalse("The book should not be in the inventory",
                store.bookInInventory(invalidTitle, author));
    }

    @Test
    public void doesNotAddBookToStoreIfInvalidAuthor() {
        String title = "Lord of the ring";
        String invalidAuthor = null;

        store.addBook(title, invalidAuthor, 2);

        assertFalse(
                "The book should not be in the inventory",
                store.bookInInventory(title, invalidAuthor)
        );
    }

    @Test
    public void addAnExistingBookToStoreIncreasesTheCopies() {
        var initialCopies = 2;
        var additionalCopies = 3;
        var bookAdded = addBookToStore(initialCopies);
        int expectedNumberOfCopy = additionalCopies + bookAdded.getCopies();

        store.addBook(bookAdded.getTitle(),
                bookAdded.getAuthor(),
                additionalCopies);

        assertTrue(
                "The book should have the following number of copies " + expectedNumberOfCopy,
                store.verifyNumberOfCopyForBook(bookAdded, expectedNumberOfCopy)
        );
    }

    @Test
    public void sellABookFromTheStore() {
        var copiesSold = 1;
        var initialCopies = 2;
        var bookToSell = addBookToStore(initialCopies);
        int expectedNumberOfCopy = bookToSell.getCopies() - copiesSold;

        store.sellBook(bookToSell.getTitle(),
                bookToSell.getAuthor(),
                copiesSold);

        assertTrue(
                "The book should have the following number of copies " + expectedNumberOfCopy,
                store.verifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy)
        );
    }

    @Test
    public void cannotSellZeroCopyOfABook() {
        var copiesSold = 0;
        var initialCopies = 2;
        var bookToSell = addBookToStore(initialCopies);
        int expectedNumberOfCopy = bookToSell.getCopies();

        store.sellBook(bookToSell.getTitle(),
                bookToSell.getAuthor(),
                copiesSold);

        assertTrue(
                "The book should have the following number of copies " + expectedNumberOfCopy,
                store.verifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy)
        );
    }

    @Test
    public void sellTheLastCopyOfABookFromTheStore() {
        var copiesSold = 1;
        var bookToSell = addBookToStore(copiesSold);

        store.sellBook(bookToSell.getTitle(),
                bookToSell.getAuthor(),
                copiesSold);

        assertFalse(
                "The book should no longer be in the inventory",
                store.verifyBookIsInStore(bookToSell)
        );
    }

    static class BookStoreForTest extends BookStore {
        public boolean bookInInventory(String title, String author) {
            return getBookBy(title, author).isPresent();
        }

        public boolean bookInInventory(Book bookSearched) {
            return getBookBy(bookSearched.getTitle(), bookSearched.getAuthor()).isPresent();
        }

        public boolean verifyBookIsInStore(Book book) {
            return bookInInventory(book);
        }

        public boolean verifyNumberOfCopyForBook(Book bookAdded, int expectedNumberOfCopy) {
            return verifyBookIsInStore(bookAdded)
                    && getBookBy(bookAdded.getTitle(), bookAdded.getAuthor())
                    .orElseThrow()
                    .getCopies() == expectedNumberOfCopy;

        }
    }
}


