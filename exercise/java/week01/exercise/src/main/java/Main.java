import movie.MovieStore;

public class Main {
    public static void main(String[] args) {
        MovieStore store = new MovieStore();
        store.addMovie("001", "Inception", "Christopher Nolan", 10, 5d);
        store.addMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8, 4d);
        store.displayMovies();
        store.borrowMovie("001");
        store.displayMovies();
        store.returnMovie("001");
        store.displayMovies();
    }
}
