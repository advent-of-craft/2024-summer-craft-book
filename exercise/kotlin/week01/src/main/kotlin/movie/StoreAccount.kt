package movie

class StoreAccount {
    var totalSold: Double = 0.0
    var allSales: MutableList<MovieSale> = mutableListOf()

    fun sell(movie: Movie, to: String) {
        totalSold += movie.unitPrice
        allSales.add(MovieSale(to, movie.title))
    }

    class MovieSale(val clientName: String, val movieName: String)
}
