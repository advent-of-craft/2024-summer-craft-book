package movie;

import java.util.*;

// SRP violation: the movie store has too many responsibilities
public class MovieStore {
    // inconsistent naming
    // Bad encapsulation: public field
    public HashMap<String, Movie> allMovies;
    // confusing naming
    // Bad encapsulation: public field
    public StoreAccount sales;

    public MovieStore() {
        // we could inject some of the dependencies
        allMovies = new HashMap<>();
        sales = new StoreAccount();
    }

    public void buyMovie(String customer, String id) {
        Movie movie = allMovies.get(id);
        if (movie != null) {
            if (movie.totalCopies - movie.borrowedCopies > 0) {
                // Implementation leak: accessing fields of movie
                movie.totalCopies--;
                // Level of indentation too complex
                if(movie.canSell()) {
                    // Argument switching between customer and movie. Can lead to error passing arguments.
                    sales.sell(movie, customer);
                }
                else
                    System.out.println("Movie not for sale");
            } else {
                System.out.println("All copies are currently borrowed.");
            }
        } else {
            // movie store logic tie to the console
            // error handling using the console is a bad practice
            System.out.println("Movie not available!");
        }
    }

    // Risk: we can add a movie with empty spaces as title?
    // Maintenance overhead: the number of parameters is high. Passing a movie instead?
    public void addMovie(String id, String title, String director, int totalCopies, Double unitPrice) {
        //Confusing name: the name of the method does not say what it does (update copies and add movies).
        if (allMovies.containsKey(id)) {
            System.out.println("Movie already exists! Updating total copies.");
            updateMovieCopies(id, totalCopies);
        } else {
            allMovies.put(id, new Movie(id, title, director, totalCopies, unitPrice));
        }
    }

    public void updateMovieCopies(String id, int newTotalCopies) {
        if (allMovies.containsKey(id)) {
            Movie movie = allMovies.get(id);
            if (newTotalCopies < movie.borrowedCopies) {
                System.out.println("Cannot reduce total copies below borrowed copies.");
            } else {
                movie.totalCopies = newTotalCopies;
            }
        } else {
            System.out.println("Movie not found!");
        }
    }

    public void removeMovie(String id) {
        if (allMovies.containsKey(id)) {
            allMovies.remove(id);
        } else {
            System.out.println("Movie not found!");
        }
    }

    public void borrowMovie(String id) {
        Movie movie = allMovies.get(id);
        // Duplication: the research and check if a copy is available is duplicated in the buyMovie method
        if (movie != null) {
            if (movie.totalCopies - movie.borrowedCopies > 0) {
                movie.borrowedCopies++;
            } else {
                System.out.println("All copies are currently borrowed.");
            }
        } else {
            System.out.println("Movie not available!");
        }
    }

    // Return, Borrow and Buy movie can be streamlined
    public void returnMovie(String id) {
        Movie movie = allMovies.get(id);
        if (movie != null) {
            if (movie.borrowedCopies > 0) {
                movie.borrowedCopies--;
            } else {
                System.out.println("Error: No copies were borrowed.");
            }
        } else {
            System.out.println("Invalid movie ID!");
        }
    }

    // Dead code? the method is never used, never tested
    public void displayMovies() {
        for (Movie m : allMovies.values()) {
            System.out.println("ID: " + m.movieID + ", Title: " + m.title + ", Director: " + m.director + ", Available Copies: " + (m.totalCopies - m.borrowedCopies));
        }
    }

    // Risk: no early return if, say, title is an empty string
    public List<Movie> findMoviesByTitle(String title) {
        List<Movie> result = new ArrayList<>();
        for (Movie m : allMovies.values()) {
            //Bug: the research by title is case-sensitive
            if (m.title.equalsIgnoreCase(title)) {
                result.add(m);
            }
        }
        return result;
    }
}
