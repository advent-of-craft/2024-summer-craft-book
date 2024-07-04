package movie

//Anemic domain anti-pattern: the entity Movie has no behavior
class Movie(
    //Inconsistent naming
    // Poor encapsulation
    // Mutation everywhere...
    var movieID: String,
    var title: String,
    var director: String,
    var totalCopies: Int,
    var unitPrice: Double
) {
    var borrowedCopies: Int = 0

    //Fragile implementation: a movie with a zero price cannot be sold?
    fun canSell(): Boolean {
        //Incomplete rule: what if the unit price is negative?
        return unitPrice != 0.0
    }
}
