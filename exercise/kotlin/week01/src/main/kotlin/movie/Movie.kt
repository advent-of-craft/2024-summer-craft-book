package movie

class Movie(
    var movieID: String,
    var title: String,
    var director: String,
    var totalCopies: Int,
    var unitPrice: Double
) {
    var borrowedCopies: Int = 0

    fun canSell(): Boolean {
        return unitPrice != 0.0
    }
}
