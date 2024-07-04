class Book(var title: String, var author: String, var copies: Int) {

    fun addCopies(additionalCopies: Int) {
        if (additionalCopies > 0) {
            this.copies += additionalCopies
        }
    }

    fun removeCopies(soldCopies: Int) {
        if (soldCopies > 0 && this.copies >= soldCopies) {
            this.copies -= soldCopies
        }
    }
}