namespace ExerciseMovieStore;

public class StoreAccount
{
    public double TotalSold { get; set; } = 0d;
    //Implementation leak: MovieSale inner class exposed
    public List<MovieSale> AllSales { get; set; }

    public StoreAccount()
    {
        AllSales = new List<MovieSale>();
    }

    //Consufing naming: is 'to' the customer name?
    public void Sell(Movie movie, string to)
    {
        TotalSold += movie.UnitPrice;
        //Bug: if adding to the list fail, the total is increased regardless.
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