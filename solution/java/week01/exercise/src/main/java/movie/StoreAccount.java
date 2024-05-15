package movie;

import java.util.ArrayList;
import java.util.List;

public class StoreAccount {
    public Double totalSold = 0d;

    //Implementation leak: MovieSale inner class exposed
    public List<MovieSale> allSales;

    public StoreAccount() {
        this.allSales = new ArrayList<>();
    }

    //Consufing naming: is 'to' the customer name?
    public void sell(Movie movie, String to) {
        totalSold += movie.unitPrice;
        //Bug: if adding to the list fail, the total is increased regardless.
        allSales.add(new MovieSale(to, movie.title));
    }

    static class MovieSale {
        String clientName;
        String movieName;

        public MovieSale(String clientName, String movieName) {
            this.clientName = clientName;
            this.movieName = movieName;
        }
    }
}
