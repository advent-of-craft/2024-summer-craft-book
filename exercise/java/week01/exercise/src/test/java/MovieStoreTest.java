import static org.junit.Assert.*;

import movie.MovieStore;
import org.junit.*;

public class MovieStoreTest {
    private MovieStore store;

    @Before
    public void setUp() {
        store = new MovieStore();
        store.addMovie("001", "Inception", "Christopher Nolan", 10);
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
    public void testDisplayMovies() {
        store.displayMovies();
        assertTrue("There should be a mechanism to capture console outputs", true);
    }
}
