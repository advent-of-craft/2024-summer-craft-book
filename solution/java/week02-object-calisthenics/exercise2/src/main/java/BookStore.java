import java.util.Optional;

public class BookStore {
    BookInventory inventory = new BookInventory();

    public void addBook(String title, String author, int copies) {
        if (copies <= 0)
            return;

        getBookBy(title, author)
            .ifPresentOrElse(
                b -> b.addCopies(copies),
                () -> Book.tryCreateBook(title, author, copies)
                    .ifPresent(inventory::add));
    }

    public void sellBook(String title, String author, int copies) {
        if (copies <= 0)
            return;

        getBookBy(title, author)
            .ifPresent(book -> {
                book.removeCopies(copies);
                inventory.removeBookIfNoMoreCopies(book);
            }
        );
    }

    protected Optional<Book> getBookBy(String title, String author) {
        return inventory.stream()
                .filter(b ->
                    b.getTitle().equals(title)
                    && b.getAuthor().equals(author))
                .findFirst();
    }
}
