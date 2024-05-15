package movie;

//Anemic domain anti-pattern: the entity Movie has no behavior
public class Movie {
    //Inconsistent naming
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

    //Fragile implementation: a movie with a zero price cannot be sold?
    public boolean canSell() {
        //Incomplete rule: what is the unit price is negative?
        return unitPrice != 0d;
    }
}
