using Xunit;

namespace ExerciseMovieStore.Tests;

public class MovieStoreTest
{
    private MovieStore store;

    public MovieStoreTest()
    {
        SetUp();
    }

    private void SetUp()
    {
        store = new MovieStore();
        store.AddMovie("001", "Inception", "Christopher Nolan", 10, 0d);
        store.AddMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8, 0d);
        store.AddMovie("003", "Dunkirk", "Christopher Nolan", 5, 0d);
    }

    [Fact]
    public void TestAddMovie()
    {
        store.AddMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8, 0d);
        Assert.NotNull(store.AllMovies["002"]);
        Assert.Equal(8, store.AllMovies["002"].TotalCopies);
    }

    [Fact]
    public void TestRemoveMovie()
    {
        store.RemoveMovie("001");
        Assert.False(store.AllMovies.ContainsKey("001"));
    }

    [Fact]
    public void TestBorrowMovie()
    {
        store.BorrowMovie("001");
        Assert.Equal(1, store.AllMovies["001"].BorrowedCopies);
    }

    [Fact]
    public void TestBuyMovie()
    {
        var movie = store.AllMovies["001"];
        movie.UnitPrice = 5d;

        store.BuyMovie("Durant", "001");

        Assert.Equal(9, store.AllMovies["001"].TotalCopies);
    }

    [Fact]
    public void TestReturnMovie()
    {
        store.ReturnMovie("001");
        Assert.Equal(0, store.AllMovies["001"].BorrowedCopies);
    }

    [Fact]
    public void TestFindMoviesByTitle()
    {
        List<Movie> movies = store.FindMoviesByTitle("Inception");
        Assert.Single(movies);
        Assert.Equal("Inception", movies[0].Title);
    }
}