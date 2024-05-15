package movie;

public class Movie {
    public String movieID;
    public String title;
    public String director;
    public int totalCopies;
    public int borrowedCopies;

    public Movie(String movieID, String title, String director, int totalCopies) {
        this.movieID = movieID;
        this.title = title;
        this.director = director;
        this.totalCopies = totalCopies;
        this.borrowedCopies = 0;
    }
}
