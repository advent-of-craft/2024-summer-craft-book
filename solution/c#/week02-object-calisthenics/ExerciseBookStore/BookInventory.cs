namespace ExerciseBookStore;

public class BookInventory : List<Book>
{
    public void RemoveBookIfNoMoreCopies(Book book) {
        if (!book.HasCopies()) {
            Remove(book);
        }
    }
}