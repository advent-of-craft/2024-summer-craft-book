namespace ExerciseMovieStore;

public class StoreAccount
{
    public double TotalSold { get; set; } = 0d;
    public List<MovieSale> AllSales { get; set; }

    public StoreAccount()
    {
        AllSales = new List<MovieSale>();
    }

    public void Sell(Movie movie, string to)
    {
        TotalSold += movie.UnitPrice;
        AllSales.Add(new MovieSale(to, movie.Title));
    }

    public class MovieSale
    {
        public string ClientName { get; set; }
        public string MovieName { get; set; }

        public MovieSale(string clientName, string movieName)
        {
            ClientName = clientName;
            MovieName = movieName;
        }
    }
}