import static org.junit.Assert.*;

import movie.Movie;
import movie.MovieStore;
import org.junit.*;

import java.util.List;

public class MovieStoreTest {
    private MovieStore store;

    @Before
    public void setUp() {
        store = new MovieStore();
        store.addMovie("001", "Inception", "Christopher Nolan", 10);
        store.addMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8);
        store.addMovie("003", "Dunkirk", "Christopher Nolan", 5);
    }

    @Test
    public void testAddMovie() {
        store.addMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8);
        assertNotNull("Movie should not be null", store.allMovies.get("002")); // Checks for not null but not for correct properties
        assertEquals("Incorrect count of total copies", 8, store.allMovies.get("002").totalCopies);
    }

    @Test
    public void testRemoveMovie() {
        store.removeMovie("001");
        assertNull("Movie should be removed", store.allMovies.get("001"));
    }

    @Test
    public void testBorrowMovie() {
        store.borrowMovie("001");
        assertEquals("Borrowed copies should be incremented", 1, store.allMovies.get("001").borrowedCopies);
    }

    @Test
    public void testReturnMovie() {
        store.borrowMovie("001");
        store.returnMovie("001");
        assertEquals("Borrowed copies should be decremented", 0, store.allMovies.get("001").borrowedCopies);
    }

    @Test
    public void testGetTotalMovies() {
        assertEquals("Total number of movies should be 3", 3, store.getTotalMovies());
    }

    @Test
    public void testFindMoviesByTitle() {
        List<Movie> movies = store.findMoviesByTitle("Inception");
        assertEquals("Should find one movie", 1, movies.size());
        assertEquals("Movie title should be 'Inception'", "Inception", movies.get(0).title);
    }

    @Test
    public void testGetMoviesByDirector() {
        List<Movie> movies = store.getMoviesByDirector("Christopher Nolan");
        assertEquals("Should find two movies by Christopher Nolan", 2, movies.size());
    }
}
