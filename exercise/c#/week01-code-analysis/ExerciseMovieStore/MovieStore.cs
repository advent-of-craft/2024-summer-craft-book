namespace ExerciseMovieStore;

public class MovieStore
{
    public Dictionary<string, Movie> AllMovies { get; set; }
    public StoreAccount Sales { get; set; }

    public MovieStore()
    {
        AllMovies = new Dictionary<string, Movie>();
        Sales = new StoreAccount();
    }

    public void BuyMovie(string customer, string id)
    {
        if (AllMovies.TryGetValue(id, out Movie movie))
        {
            if (movie.TotalCopies - movie.BorrowedCopies > 0)
            {
                movie.TotalCopies--;
                if (movie.CanSell())
                {
                    Sales.Sell(movie, customer);
                }
                else
                {
                    Console.WriteLine("Movie not for sale");
                }
            }
            else
            {
                Console.WriteLine("All copies are currently borrowed.");
            }
        }
        else
        {
            Console.WriteLine("Movie not available!");
        }
    }

    public void AddMovie(string id, string title, string director, int totalCopies, double unitPrice)
    {
        if (AllMovies.ContainsKey(id))
        {
            Console.WriteLine("Movie already exists! Updating total copies.");
            UpdateMovieCopies(id, totalCopies);
        }
        else
        {
            AllMovies.Add(id, new Movie(id, title, director, totalCopies, unitPrice));
        }
    }

    public void UpdateMovieCopies(string id, int newTotalCopies)
    {
        if (AllMovies.TryGetValue(id, out Movie movie))
        {
            if (newTotalCopies < movie.BorrowedCopies)
            {
                Console.WriteLine("Cannot reduce total copies below borrowed copies.");
            }
            else
            {
                movie.TotalCopies = newTotalCopies;
            }
        }
        else
        {
            Console.WriteLine("Movie not found!");
        }
    }

    public void RemoveMovie(string id)
    {
        if (AllMovies.ContainsKey(id))
        {
            AllMovies.Remove(id);
        }
        else
        {
            Console.WriteLine("Movie not found!");
        }
    }

    public void BorrowMovie(string id)
    {
        if (AllMovies.TryGetValue(id, out Movie movie))
        {
            if (movie.TotalCopies - movie.BorrowedCopies > 0)
            {
                movie.BorrowedCopies++;
            }
            else
            {
                Console.WriteLine("All copies are currently borrowed.");
            }
        }
        else
        {
            Console.WriteLine("Movie not available!");
        }
    }

    public void ReturnMovie(string id)
    {
        if (AllMovies.TryGetValue(id, out Movie movie))
        {
            if (movie.BorrowedCopies > 0)
            {
                movie.BorrowedCopies--;
            }
            else
            {
                Console.WriteLine("Error: No copies were borrowed.");
            }
        }
        else
        {
            Console.WriteLine("Invalid movie ID!");
        }
    }

    public void DisplayMovies()
    {
        foreach (var movie in AllMovies.Values)
        {
            Console.WriteLine($"ID: {movie.MovieID}, Title: {movie.Title}, Director: {movie.Director}, Available Copies: {movie.TotalCopies - movie.BorrowedCopies}");
        }
    }

    public List<Movie> FindMoviesByTitle(string title)
    {
        List<Movie> result = new List<Movie>();
        foreach (var movie in AllMovies.Values)
        {
            if (movie.Title.Equals(title, StringComparison.OrdinalIgnoreCase))
            {
                result.Add(movie);
            }
        }
        return result;
    }
}