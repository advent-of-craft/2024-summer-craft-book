namespace ExerciseMovieStore;

public class Movie(string movieID, string title, string director, int totalCopies, double unitPrice)
{
    public string MovieID { get; set; } = movieID;
    public string Title { get; set; } = title;
    public string Director { get; set; } = director;
    public double UnitPrice { get; set; } = unitPrice;
    public int TotalCopies { get; set; } = totalCopies;
    public int BorrowedCopies { get; set; } = 0;

    public bool CanSell()
    {
        return UnitPrice != 0d;
    }
}