namespace BookStore;

public class BookStore
{
    private readonly List<Book> _inv = new();

    public void AddBook(string? title, string? author, int copies)
    {
        if (title != null && author != null && copies > 0)
        {
            Book? foundBook = null;
            foreach (var book in _inv)
            {
                if (book.Title == title && book.Author == author)
                {
                    foundBook = book;
                    break;
                }
            }

            if (foundBook != null)
            {
                foundBook.AddCopies(copies);
            }
            else
            {
                _inv.Add(new Book(title, author, copies));
            }
        }
    }

    public void SellBook(string title, string author, int copies)
    {
        foreach (var book in _inv)
        {
            if (book.Title == title && book.Author == author)
            {
                book.RemoveCopies(copies);
                if (book.Copies <= 0)
                {
                    _inv.Remove(book);
                }

                break;
            }
        }
    }
}