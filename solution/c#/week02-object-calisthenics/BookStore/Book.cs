namespace BookStore
{
    public class Book(string title, string author, int copies)
    {
        public string Title => title;
        public string Author => author;
        public int Copies => copies;
        public bool HasCopies => Copies > 0;

        public static Book? TryCreateBook(string? title, string? author, int copies)
            => InformationInvalid(title, author, copies)
                ? null
                : new Book(title!, author!, copies);

        private static bool InformationInvalid(string? title, string? author, int copies)
            => title is null
               || author == null
               || copies < 0;

        public void AddCopies(int additionalCopies)
        {
            if (additionalCopies > 0)
            {
                copies += additionalCopies;
            }
        }

        public void RemoveCopies(int soldCopies)
        {
            if (soldCopies > 0 && copies >= soldCopies)
            {
                copies -= soldCopies;
            }
        }
    }
}