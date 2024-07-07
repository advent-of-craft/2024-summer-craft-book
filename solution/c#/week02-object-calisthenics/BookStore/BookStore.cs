namespace BookStore
{
    public class BookStore
    {
        private readonly BookInventory _inventory = [];

        public void AddBook(string? title, string? author, int copies)
        {
            if (copies <= 0)
                return;

            var book = GetBookBy(title, author);
            if (book != null)
            {
                book.AddCopies(copies);
            }
            else
            {
                var newBook = Book.TryCreateBook(title, author, copies);
                if (newBook != null)
                {
                    _inventory.Add(newBook);
                }
            }
        }

        public void SellBook(string title, string author, int copies)
        {
            if (copies <= 0)
                return;

            var book = GetBookBy(title, author);

            if (book == null) return;

            book.RemoveCopies(copies);
            _inventory.RemoveBookIfNoMoreCopies(book);
        }

        protected Book? GetBookBy(string? title, string? author)
            => _inventory.Find(b =>
                b.Title == title && b.Author == author
            );
    }
}