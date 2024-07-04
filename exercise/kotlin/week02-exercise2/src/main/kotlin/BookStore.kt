class BookStore {
    private var inv: ArrayList<Book> = ArrayList()

    fun addBook(title: String?, author: String?, copies: Int) {
        if (title != null && author != null && copies > 0) {
            var foundBook: Book? = null
            for (book in inv) {
                if (book.title == title && book.author == author) {
                    foundBook = book
                    break
                }
            }
            if (foundBook != null) {
                foundBook.addCopies(copies)
            } else {
                inv.add(Book(title, author, copies))
            }
        }
    }

    fun sellBook(title: String, author: String, copies: Int) {
        for (book in inv) {
            if (book.title == title && book.author == author) {
                book.removeCopies(copies)
                if (book.copies <= 0) {
                    inv.remove(book)
                }
                break
            }
        }
    }
}
