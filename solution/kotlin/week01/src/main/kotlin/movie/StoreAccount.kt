package movie

class StoreAccount {
    var totalSold: Double = 0.0
    // Implementation leak: MovieSale inner class exposed
    var allSales: MutableList<MovieSale> = mutableListOf()

    // Consufing naming: is 'to' the customer name?
    fun sell(movie: Movie, to: String) {
        totalSold += movie.unitPrice
        //Bug: if adding to the list fails, the total is increased regardless.
        allSales.add(MovieSale(to, movie.title))
    }

    class MovieSale(val clientName: String, val movieName: String)
}
