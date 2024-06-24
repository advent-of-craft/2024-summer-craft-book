package bookstore

import Book
import BookStore
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class BookStoreTest : StringSpec({
    var store: BookStoreUnderTest? = null

    beforeEach {
        store = BookStoreUnderTest()
    }

    fun createARandomBook(copies: Int): Book? =
        Book.tryCreateBook("Lord of the ring", "JR Tolkien", copies)

    fun addARandomBookToStore(initialCopies: Int): Book? =
        createARandomBook(initialCopies)
            ?.apply { store!!.addBook(title, author, initialCopies) }

    "addANewBookToStore" {
        createARandomBook(2)!!.let {
            store!!.addBook(it.title, it.author, it.copies())
            store!!.verifyBookIsInStore(it).shouldBeTrue()
        }
    }

    "doesNotAddBookToStoreIfNoCopy" {
        val noCopy = 0
        val bookToAdd = createARandomBook(noCopy)!!

        bookToAdd.let {
            store!!.addBook(it.title, it.author, noCopy)
            store!!.verifyBookIsInStore(it).shouldBeFalse()
        }
    }

    "doesNotAddBookToStoreIfInvalidTitle" {
        val invalidTitle: String? = null
        val author = "JR Tolkien"
        store!!.addBook(invalidTitle, author, 2)

        store!!.bookInInventory(invalidTitle, author).shouldBeFalse()
    }

    "doesNotAddBookToStoreIfInvalidAuthor" {
        val title = "Lord of the ring"
        val invalidAuthor: String? = null
        store!!.addBook(title, invalidAuthor, 2)
        store!!.bookInInventory(title, invalidAuthor).shouldBeFalse()
    }

    "addAnExistingBookToStoreIncreasesTheCopies" {
        val initialCopies = 2
        val additionalCopies = 3
        val bookAdded = addARandomBookToStore(initialCopies)
        val expectedNumberOfCopy = additionalCopies + (bookAdded?.copies() ?: 0)
        bookAdded?.let {
            store!!.addBook(it.title, it.author, additionalCopies)
            store!!.verifyNumberOfCopyForBook(it, expectedNumberOfCopy).shouldBeTrue()
        }
    }

    "sellABookFromTheStore" {
        val copiesSold = 1
        val initialCopies = 2
        val bookToSell = addARandomBookToStore(initialCopies)
        val expectedNumberOfCopy = (bookToSell?.copies() ?: 0) - copiesSold
        bookToSell?.let {
            store!!.sellBook(it.title, it.author, copiesSold)
            store!!.verifyNumberOfCopyForBook(it, expectedNumberOfCopy).shouldBeTrue()
        }
    }

    "cannotSellZeroCopyOfABook" {
        val copiesSold = 0
        val initialCopies = 2
        val bookToSell = addARandomBookToStore(initialCopies)
        val expectedNumberOfCopy = bookToSell?.copies() ?: 0
        bookToSell?.let {
            store!!.sellBook(it.title, it.author, copiesSold)
            store!!.verifyNumberOfCopyForBook(it, expectedNumberOfCopy).shouldBeTrue()
        }
    }

    "sellTheLastCopyOfABookFromTheStore" {
        val copiesSold = 1
        val bookToSell = addARandomBookToStore(copiesSold)
        bookToSell?.let {
            store!!.sellBook(it.title, it.author, copiesSold)
            store!!.verifyBookIsInStore(it).shouldBeFalse()
        }
    }
})

class BookStoreUnderTest : BookStore() {
    fun bookInInventory(title: String?, author: String?): Boolean {
        return getBookBy(title, author) != null
    }

    fun verifyBookIsInStore(book: Book): Boolean {
        return bookInInventory(book.title, book.author)
    }

    fun verifyNumberOfCopyForBook(book: Book, expectedNumberOfCopy: Int): Boolean {
        return verifyBookIsInStore(book) && (getBookBy(book.title, book.author)?.copies() == expectedNumberOfCopy)
    }
}
