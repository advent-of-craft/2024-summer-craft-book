namespace Exercise2BookStore
{
    public class Book(string title, string author, int copies)
    {
        public void AddCopies(int additionalCopies) {
        if (additionalCopies > 0) {
            copies += additionalCopies;
        }
    }

        public void RemoveCopies(int soldCopies) {
        if (soldCopies > 0 && copies >= soldCopies) {
            copies -= soldCopies;
        }
    }

        public string GetTitle() {
        return title;
    }

        public string GetAuthor() {
        return author;
    }

        public int GetCopies() {
        return copies;
    }
    
        public bool HasCopies() {
        return GetCopies() > 0;
    }

        public static Book? TryCreateBook(string? title, string? author, int copies)
    {
        return InformationInvalid(title, author, copies) 
            ? null 
            : new Book(title!, author!, copies);
    }

        private static bool InformationInvalid(string? title, string? author, int copies) {
        return title is null
               || author == null
               || copies < 0;
    }
    }
}