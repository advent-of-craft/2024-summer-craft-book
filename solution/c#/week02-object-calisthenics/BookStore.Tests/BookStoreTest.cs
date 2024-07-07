using Xunit;

namespace BookStore.Tests
{
    public class BookStoreTest
    {
        private readonly BookStoreUnderTest _store = new();

        [Fact]
        public void AddANewBookToStore()
        {
            var bookToAdd = CreateABook(2);
            _store.AddBook(bookToAdd!.Title, bookToAdd.Author, bookToAdd.Copies);

            Assert.True(_store.VerifyBookIsInStore(bookToAdd), "The book should be in the inventory");
        }


        [Fact]
        public void DoesNotAddBookToStoreIfNoCopy()
        {
            const int noCopy = 0;
            var bookToAdd = CreateABook(noCopy);

            _store.AddBook(bookToAdd!.Title, bookToAdd.Author, noCopy);

            Assert.False(_store.VerifyBookIsInStore(bookToAdd), "The book should not be in the inventory");
        }

        [Fact]
        public void DoesNotAddBookToStoreIfInvalidTitle()
        {
            string? invalidTitle = null;
            const string author = "JR Tolkien";

            _store.AddBook(invalidTitle, author, 2);

            Assert.False(_store.BookInInventory(invalidTitle, author), "The book should not be in the inventory");
        }

        [Fact]
        public void DoesNotAddBookToStoreIfInvalidAuthor()
        {
            const string title = "Lord of the ring";
            string? invalidAuthor = null;

            _store.AddBook(title, invalidAuthor, 2);

            Assert.False(_store.BookInInventory(title, invalidAuthor), "The book should not be in the inventory");
        }

        [Fact]
        public void AddAnExistingBookToStoreIncreasesTheCopies()
        {
            const int initialCopies = 2;
            const int additionalCopies = 3;
            var bookAdded = AddBookToStore(initialCopies);
            var expectedNumberOfCopy = additionalCopies + bookAdded.Copies;

            _store.AddBook(bookAdded.Title, bookAdded.Author, additionalCopies);

            Assert.True(_store.VerifyNumberOfCopyForBook(bookAdded, expectedNumberOfCopy),
                $"The book should have the following number of copies {expectedNumberOfCopy}");
        }

        [Fact]
        public void SellABookFromTheStore()
        {
            const int copiesSold = 1;
            const int initialCopies = 2;
            var bookToSell = AddBookToStore(initialCopies);
            var expectedNumberOfCopy = bookToSell.Copies - copiesSold;

            _store.SellBook(bookToSell.Title, bookToSell.Author, copiesSold);

            Assert.True(_store.VerifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy),
                $"The book should have the following number of copies {expectedNumberOfCopy}");
        }

        [Fact]
        public void CannotSellZeroCopyOfABook()
        {
            const int copiesSold = 0;
            const int initialCopies = 2;
            var bookToSell = AddBookToStore(initialCopies);
            var expectedNumberOfCopy = bookToSell.Copies;

            _store.SellBook(bookToSell.Title, bookToSell.Author, copiesSold);

            Assert.True(_store.VerifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy),
                $"The book should have the following number of copies {expectedNumberOfCopy}");
        }

        [Fact]
        public void SellTheLastCopyOfABookFromTheStore()
        {
            const int copiesSold = 1;
            var bookToSell = AddBookToStore(copiesSold);

            _store.SellBook(bookToSell.Title, bookToSell.Author, copiesSold);

            Assert.False(_store.VerifyBookIsInStore(bookToSell), "The book should no longer be in the inventory");
        }

        private static Book? CreateABook(int copies)
            => Book.TryCreateBook("Lord of the ring", "JR Tolkien", copies);

        private Book AddBookToStore(int initialCopies)
        {
            var createdBook = CreateABook(initialCopies);
            _store.AddBook(createdBook!.Title, createdBook.Author, initialCopies);
            return createdBook;
        }

        private class BookStoreUnderTest : BookStore
        {
            public bool BookInInventory(string title, string author) => GetBookBy(title, author) != null;

            private bool BookInInventory(Book bookSearched)
                => GetBookBy(bookSearched.Title, bookSearched.Author) != null;

            public bool VerifyBookIsInStore(Book? book) => book != null && BookInInventory(book);

            public bool VerifyNumberOfCopyForBook(Book? bookAdded, int expectedNumberOfCopy)
                => VerifyBookIsInStore(bookAdded) &&
                   GetBookBy(bookAdded!.Title, bookAdded.Author)!.Copies == expectedNumberOfCopy;
        }
    }
}