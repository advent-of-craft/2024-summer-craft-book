namespace BookStore
{
    public class Book
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public int Copies { get; set; }

        public Book(string title, string author, int copies)
        {
            Title = title;
            Author = author;
            Copies = copies;
        }

        public void AddCopies(int additionalCopies)
        {
            if (additionalCopies > 0)
            {
                Copies += additionalCopies;
            }
        }

        public void RemoveCopies(int soldCopies)
        {
            if (soldCopies > 0 && Copies >= soldCopies)
            {
                Copies -= soldCopies;
            }
        }
    }
}