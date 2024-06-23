namespace ExerciseMovieStore;

//SPR violation: the movie store has too many responsibilities
public class MovieStore
{
    //inconsistent naming
    //Bad encapsulation: public field
    public Dictionary<string, Movie> AllMovies { get; set; }
    //confusing naming
    //Bad encapsulation: public field
    public StoreAccount Sales { get; set; }

    public MovieStore()
    {
        //we could inject some of the dependencies
        AllMovies = new Dictionary<string, Movie>();
        Sales = new StoreAccount();
    }

    public void BuyMovie(string customer, string id)
    {
        if (AllMovies.TryGetValue(id, out Movie movie))
        {
            if (movie.TotalCopies - movie.BorrowedCopies > 0)
            {
                //Implementation leak: accessing fields of movie
                movie.TotalCopies--;
                //Level of indentation too complex
                if (movie.CanSell())
                {
                    //Argument switching between customer and movie. Can lead to error passing arguments.
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
            //movie store logic tie to the console
            //error handling using the console is a bad practice
            Console.WriteLine("Movie not available!");
        }
    }

    //Risk: we can add a movie with empty spaces as title?
    //Maintenance overhead: the number of parameters is high. Passing a movie instead?
    public void AddMovie(string id, string title, string director, int totalCopies, double unitPrice)
    {
        //Confusing name: the name of the method does not say what it does (update copies and add movies).
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
        //Performance: possibly multiple iterations
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
        //Duplication: the research and check if a copy is available is duplicated in the buyMovie method
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

    //Return, Borrow and Buy movie can be streamlined
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

    //Dead code? the method is never used, never tested
    public void DisplayMovies()
    {
        foreach (var movie in AllMovies.Values)
        {
            Console.WriteLine($"ID: {movie.MovieId}, Title: {movie.Title}, Director: {movie.Director}, Available Copies: {movie.TotalCopies - movie.BorrowedCopies}");
        }
    }

    //Risk: no early return if, say, title is an empty string
    public List<Movie> FindMoviesByTitle(string title)
    {
        List<Movie> result = new List<Movie>();
        foreach (var movie in AllMovies.Values)
        {
            //Bug: the research by title is case-sensitive
            if (movie.Title.Equals(title, StringComparison.OrdinalIgnoreCase))
            {
                result.Add(movie);
            }
        }
        return result;
    }
}