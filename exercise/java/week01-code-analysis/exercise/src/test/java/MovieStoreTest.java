import movie.Movie;
import movie.MovieStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieStoreTest {
    private MovieStore store;

    @BeforeEach
    public void setUp() {
        store = new MovieStore();
        store.addMovie("001", "Inception", "Christopher Nolan", 10, 0d);
        store.addMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8, 0d);
        store.addMovie("003", "Dunkirk", "Christopher Nolan", 5, 0d);
    }

    @Test
    void testAddMovie() {
        store.addMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8, 0d);

        assertNotNull(store.allMovies.get("002"), "Movie should not be null");
        assertEquals(8, store.allMovies.get("002").totalCopies, "Incorrect count of total copies");
    }

    @Test
    void testRemoveMovie() {
        store.removeMovie("001");
        assertNull(store.allMovies.get("001"), "Movie should be removed");
    }

    @Test
    void testBorrowMovie() {
        store.borrowMovie("001");
        assertEquals(1, store.allMovies.get("001").borrowedCopies, "Borrowed copies should be incremented");
    }

    @Test
    void testBuyMovie() {
        var movie = store.allMovies.get("001");
        movie.unitPrice = 5d;

        store.buyMovie("Durant", "001");

        assertEquals(9, store.allMovies.get("001").totalCopies, "Movie bought should decrease all copies");
    }

    @Test
    void testReturnMovie() {
        store.returnMovie("001");
        assertEquals(0, store.allMovies.get("001").borrowedCopies, "Borrowed copies should be decremented");
    }

    @Test
    void testFindMoviesByTitle() {
        List<Movie> movies = store.findMoviesByTitle("Inception");
        assertEquals(1, movies.size(), "Should find one movie");
        assertEquals("Inception", movies.get(0).title, "Movie title should be 'Inception'");
    }
}
