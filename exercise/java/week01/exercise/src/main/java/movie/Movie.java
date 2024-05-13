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

    public void borrowMovie() {
        if (totalCopies - borrowedCopies > 0) {
            borrowedCopies++;
        } else {
            System.out.println("All copies are currently borrowed.");
        }
    }

    public void returnMovie() {
        if (borrowedCopies > 0) {
            borrowedCopies--;
        } else {
            System.out.println("Error: No copies were borrowed.");
        }
    }
}
