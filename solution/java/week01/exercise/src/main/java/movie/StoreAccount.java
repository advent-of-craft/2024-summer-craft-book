package movie;

import java.util.ArrayList;
import java.util.List;

public class StoreAccount {
    public Double totalSold = 0d;

    public List<MovieSale> allSales;

    public StoreAccount() {
        this.allSales = new ArrayList<>();
    }

    public void sell(Movie movie, String to) {
        totalSold += movie.unitPrice;
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
