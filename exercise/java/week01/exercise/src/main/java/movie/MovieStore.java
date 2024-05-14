package movie;

import java.util.*;

public class MovieStore {
    public HashMap<String, Movie> allMovies;

    public MovieStore() {
        allMovies = new HashMap<>();
    }

    public void addMovie(String id, String title, String director, int totalCopies) {
        if (allMovies.containsKey(id)) {
            System.out.println("Movie already exists! Updating total copies.");
            updateMovieCopies(id, totalCopies);
        } else {
            allMovies.put(id, new Movie(id, title, director, totalCopies));
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
        if (movie != null) {
            movie.borrowMovie();
        } else {
            System.out.println("Movie not available!");
        }
    }

    public void returnMovie(String id) {
        Movie movie = allMovies.get(id);
        if (movie != null) {
            movie.returnMovie();
        } else {
            System.out.println("Invalid movie ID!");
        }
    }

    public void displayMovies() {
        for (Movie m : allMovies.values()) {
            System.out.println("ID: " + m.movieID + ", Title: " + m.title + ", Director: " + m.director + ", Available Copies: " + (m.totalCopies - m.borrowedCopies));
        }
    }

    public int getTotalMovies() {
        return allMovies.size();
    }

    public List<Movie> findMoviesByTitle(String title) {
        List<Movie> result = new ArrayList<>();
        for (Movie m : allMovies.values()) {
            if (m.title.equalsIgnoreCase(title)) {
                result.add(m);
            }
        }
        return result;
    }

    public List<Movie> getMoviesByDirector(String director) {
        List<Movie> result = new ArrayList<>();
        for (Movie m : allMovies.values()) {
            if (m.director.equals(director)) {
                result.add(m);
            }
        }
        return result;
    }
}
