namespace ExerciseMovieStore
{
    public class Movie
    {
        public string MovieID { get; set; }
        public string Title { get; set; }
        public string Director { get; set; }
        public double UnitPrice { get; set; }
        public int TotalCopies { get; set; }
        public int BorrowedCopies { get; set; }

        public Movie(string movieID, string title, string director, int totalCopies, double unitPrice)
        {
            MovieID = movieID;
            Title = title;
            Director = director;
            TotalCopies = totalCopies;
            UnitPrice = unitPrice;
            BorrowedCopies = 0;
        }

        public bool CanSell()
        {
            return UnitPrice != 0d;
        }
    }
}