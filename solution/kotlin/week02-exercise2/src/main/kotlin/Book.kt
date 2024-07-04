class Book private constructor(
    val title: String,
    val author: String,
    private var copies: Int
) {
    companion object {
        fun tryCreateBook(title: String?, author: String?, copies: Int): Book? {
            return if (title != null && author != null && copies >= 0) {
                Book(title, author, copies)
            } else {
                null
            }
        }
    }

    fun addCopies(additionalCopies: Int) {
        if (additionalCopies > 0) {
            copies += additionalCopies
        }
    }

    fun removeCopies(soldCopies: Int) {
        if (soldCopies in 1..copies) {
            copies -= soldCopies
        }
    }

    fun copies(): Int = copies
    fun hasCopies(): Boolean = copies > 0
}
