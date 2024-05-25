package movie;

public class Movie {
    public String movieID;
    public String title;
    public String director;
    public Double unitPrice;
    public int totalCopies;
    public int borrowedCopies;

    public Movie(String movieID, String title, String director, int totalCopies, Double unitPrice) {
        this.movieID = movieID;
        this.title = title;
        this.director = director;
        this.totalCopies = totalCopies;
        this.unitPrice = unitPrice;
        this.borrowedCopies = 0;
    }

    public boolean canSell() {
        return unitPrice != 0d;
    }
}
