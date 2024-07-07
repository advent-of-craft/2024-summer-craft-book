namespace MovieStore
{
    //Anemic domain anti-pattern: the entity Movie has no behavior
    public class Movie(string movieId, string title, string director, int totalCopies, double unitPrice)
    {
        //Inconsistent naming
        public string MovieId { get; set; } = movieId;
        public string Title { get; set; } = title;
        public string Director { get; set; } = director;
        public double UnitPrice { get; set; } = unitPrice;
        public int TotalCopies { get; set; } = totalCopies;
        public int BorrowedCopies { get; set; } = 0;

        //Fragile implementation: a movie with a zero price cannot be sold?
        public bool CanSell()
        {
            //Incomplete rule: what is the unit price is negative?
            return UnitPrice != 0d;
        }
    }
}