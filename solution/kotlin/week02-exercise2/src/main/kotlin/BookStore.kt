open class BookStore {
    private val inventory = BookInventory()

    fun addBook(title: String?, author: String?, copies: Int) {
        if (copies <= 0) return

        getBookBy(title, author)?.let {
            it.addCopies(copies)
        } ?: run {
            Book.tryCreateBook(title, author, copies)?.let {
                inventory.add(it)
            }
        }
    }

    fun sellBook(title: String, author: String, copies: Int) {
        if (copies <= 0) return

        getBookBy(title, author)?.let {
            it.removeCopies(copies)
            inventory.removeBookIfNoMoreCopies(it)
        }
    }

    protected fun getBookBy(title: String?, author: String?): Book? {
        return inventory.find { it.title == title && it.author == author }
    }
}
