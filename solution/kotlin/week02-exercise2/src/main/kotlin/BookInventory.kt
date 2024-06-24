class BookInventory : ArrayList<Book>() {
    fun removeBookIfNoMoreCopies(book: Book) {
        if (!book.hasCopies()) {
            remove(book)
        }
    }
}