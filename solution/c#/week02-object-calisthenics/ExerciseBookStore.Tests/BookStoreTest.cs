using Xunit;

namespace Exercise2BookStore.Tests
{
    public class BookStoreTest
    {
        private readonly BookStoreUnderTest _store = new();

        [Fact]
        public void AddANewBookToStore()
    {
        var bookToAdd = CreateARandomBook(2);

        _store.AddBook(bookToAdd!.GetTitle(), bookToAdd.GetAuthor(), bookToAdd.GetCopies());

        Assert.True(_store.VerifyBookIsInStore(bookToAdd), "The book should be in the inventory");
    }

        [Fact]
        public void DoesNotAddBookToStoreIfNoCopy()
    {
        var noCopy = 0;
        var bookToAdd = CreateARandomBook(noCopy);

        _store.AddBook(bookToAdd!.GetTitle(), bookToAdd.GetAuthor(), noCopy);

        Assert.False(_store.VerifyBookIsInStore(bookToAdd), "The book should not be in the inventory");
    }

        [Fact]
        public void DoesNotAddBookToStoreIfInvalidTitle()
    {
        string? invalidTitle = null;
        var author = "JR Tolkien";

        _store.AddBook(invalidTitle, author, 2);

        Assert.False(_store.BookInInventory(invalidTitle, author), "The book should not be in the inventory");
    }

        [Fact]
        public void DoesNotAddBookToStoreIfInvalidAuthor()
    {
        var title = "Lord of the ring";
        string? invalidAuthor = null;

        _store.AddBook(title, invalidAuthor, 2);

        Assert.False(_store.BookInInventory(title, invalidAuthor), "The book should not be in the inventory");
    }

        [Fact]
        public void AddAnExistingBookToStoreIncreasesTheCopies()
    {
        var initialCopies = 2;
        var additionalCopies = 3;
        var bookAdded = AddARandomBookToStore(initialCopies);
        var expectedNumberOfCopy = additionalCopies + bookAdded!.GetCopies();

        _store.AddBook(bookAdded.GetTitle(), bookAdded.GetAuthor(), additionalCopies);

        Assert.True(_store.VerifyNumberOfCopyForBook(bookAdded, expectedNumberOfCopy), 
                    $"The book should have the following number of copies {expectedNumberOfCopy}");
    }

        [Fact]
        public void SellABookFromTheStore()
    {
        var copiesSold = 1;
        var initialCopies = 2;
        var bookToSell = AddARandomBookToStore(initialCopies);
        var expectedNumberOfCopy = bookToSell!.GetCopies() - copiesSold;

        _store.SellBook(bookToSell.GetTitle(), bookToSell.GetAuthor(), copiesSold);

        Assert.True(_store.VerifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy), 
                    $"The book should have the following number of copies {expectedNumberOfCopy}");
    }

        [Fact]
        public void CannotSellZeroCopyOfABook()
    {
        var copiesSold = 0;
        var initialCopies = 2;
        var bookToSell = AddARandomBookToStore(initialCopies);
        var expectedNumberOfCopy = bookToSell!.GetCopies();

        _store.SellBook(bookToSell.GetTitle(), bookToSell.GetAuthor(), copiesSold);

        Assert.True(_store.VerifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy), 
                    $"The book should have the following number of copies {expectedNumberOfCopy}");
    }

        [Fact]
        public void SellTheLastCopyOfABookFromTheStore()
    {
        var copiesSold = 1;
        var bookToSell = AddARandomBookToStore(copiesSold);

        _store.SellBook(bookToSell!.GetTitle(), bookToSell.GetAuthor(), copiesSold);

        Assert.False(_store.VerifyBookIsInStore(bookToSell), "The book should no longer be in the inventory");
    }

        private static Book? CreateARandomBook(int copies)
    {
        return Book.TryCreateBook("Lord of the ring", "JR Tolkien", copies);
    }

        private Book? AddARandomBookToStore(int initialCopies)
    {
        var createdBook = CreateARandomBook(initialCopies);
        _store.AddBook(createdBook!.GetTitle(), createdBook.GetAuthor(), initialCopies);
        return createdBook;
    }

        private class BookStoreUnderTest : BookStore
        {
            public bool BookInInventory(string title, string author)
        {
            return GetBookBy(title, author) != null;
        }

            public bool BookInInventory(Book bookSearched)
        {
            return GetBookBy(bookSearched.GetTitle(), bookSearched.GetAuthor()) != null;
        }

            public bool VerifyBookIsInStore(Book? book)
        {
            return book != null && BookInInventory(book);
        }

            public bool VerifyNumberOfCopyForBook(Book? bookAdded, int expectedNumberOfCopy)
        {
            return VerifyBookIsInStore(bookAdded) &&
                   GetBookBy(bookAdded!.GetTitle(), bookAdded.GetAuthor())!.GetCopies() == expectedNumberOfCopy;
        }
        }
    }
}