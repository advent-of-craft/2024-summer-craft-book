import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class BookStoreTest {

    private final BookStoreUnderTest store = new BookStoreUnderTest();

    @Test
    public void addANewBookToStore() {
        var bookToAdd = createARandomBook(2);

        store.addBook(bookToAdd.get().getTitle(),
                bookToAdd.get().getAuthor(),
                bookToAdd.get().getCopies());

        assertTrue("The book should be in the inventory",
                store.verifyBookIsInStore(bookToAdd));
    }

    @Test
    public void doesNotAddBookToStoreIfNoCopy() {
        var noCopy = 0;
        var bookToAdd = createARandomBook(noCopy);

        store.addBook(bookToAdd.get().getTitle(),
                bookToAdd.get().getAuthor(),
                noCopy);

        assertFalse("The book should not be in the inventory",
                store.verifyBookIsInStore(bookToAdd));
    }

    @Test
    public void doesNotAddBookToStoreIfInvalidTitle() {
        String invalidTitle = null;
        String author = "JR Tolkien";

        store.addBook(invalidTitle, author,2);

        assertFalse("The book should not be in the inventory",
                store.bookInInventory(invalidTitle, author));
    }

    @Test
    public void doesNotAddBookToStoreIfInvalidAuthor() {
        String title = "Lord of the ring";
        String invalidAuthor = null;

        store.addBook(title, invalidAuthor,2);

        assertFalse("The book should not be in the inventory",
                store.bookInInventory(title, invalidAuthor));
    }

    @Test
    public void addAnExistingBookToStoreIncreasesTheCopies() {
        var initialCopies = 2;
        var additionalCopies = 3;
        var bookAdded = addARandomBookToStore(initialCopies);
        int expectedNumberOfCopy = additionalCopies + bookAdded.get().getCopies();

        store.addBook(bookAdded.get().getTitle(),
                bookAdded.get().getAuthor(),
                additionalCopies);

        assertTrue("The book should have the following number of copies " + expectedNumberOfCopy,
                store.verifyNumberOfCopyForBook(bookAdded, expectedNumberOfCopy));
    }

    @Test
    public void sellABookFromTheStore() {
        var copiesSold = 1;
        var initialCopies = 2;
        var bookToSell = addARandomBookToStore(initialCopies);
        int expectedNumberOfCopy = bookToSell.get().getCopies() - copiesSold;

        store.sellBook(bookToSell.get().getTitle(),
                bookToSell.get().getAuthor(),
                copiesSold);

        assertTrue("The book should have the following number of copies " + expectedNumberOfCopy,
                store.verifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy));
    }

    @Test
    public void cannotSellZeroCopyOfABook() {
        var copiesSold = 0;
        var initialCopies = 2;
        var bookToSell = addARandomBookToStore(initialCopies);
        int expectedNumberOfCopy = bookToSell.get().getCopies();

        store.sellBook(bookToSell.get().getTitle(),
                bookToSell.get().getAuthor(),
                copiesSold);

        assertTrue("The book should have the following number of copies " + expectedNumberOfCopy,
                store.verifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy));
    }

    @Test
    public void sellTheLastCopyOfABookFromTheStore() {
        var copiesSold = 1;
        var bookToSell = addARandomBookToStore(copiesSold);

        store.sellBook(bookToSell.get().getTitle(),
                bookToSell.get().getAuthor(),
                copiesSold);

        assertFalse("The book should no longer be in the inventory",
                store.verifyBookIsInStore(bookToSell));
    }

    private static Optional<Book> createARandomBook(int copies) {
        return Book
                .tryCreateBook(
                        "Lord of the ring",
                        "JR Tolkien", copies);
    }

    private Optional<Book> addARandomBookToStore(int initialCopies) {
        var createdBook = createARandomBook(initialCopies);
        store.addBook(createdBook.get().getTitle(), createdBook.get().getAuthor(), initialCopies);
        return createdBook;
    }

    static class BookStoreUnderTest extends BookStore {

        public boolean bookInInventory(String title, String author) {
            return getBookBy(title, author).isPresent();
        }

        public boolean bookInInventory(Book bookSearched) {
            return getBookBy(bookSearched.getTitle(), bookSearched.getAuthor()).isPresent();
        }

        public boolean verifyBookIsInStore(Optional<Book> book) {
            return book.isPresent()
                    && bookInInventory(book.get());
        }

        public boolean verifyNumberOfCopyForBook(Optional<Book> bookAdded, int expectedNumberOfCopy) {
            return verifyBookIsInStore(bookAdded)
                    && getBookBy(bookAdded.get().getTitle(),
                                 bookAdded.get().getAuthor())
                            .get().getCopies() == expectedNumberOfCopy;

        }
    }
}


