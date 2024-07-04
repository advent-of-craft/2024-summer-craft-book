import {BookStore} from "../src/bookStore";
import {isSome} from 'fp-ts/Option';
import {Book} from "../src/book";

let store: BookStoreForTest;

beforeEach(() => {
    store = new BookStoreForTest();
});

const createABook = (copies: number) => {
    const createdBook = Book.createBook("Lord of the ring", "JR Tolkien", copies);
    if (isSome(createdBook)) {
        return createdBook.value;
    }
};

const addBookToStore = (initialCopies: number) => {
    const createdBook = createABook(initialCopies);
    store.addBook(createdBook.getTitle(), createdBook.getAuthor(), initialCopies);
    return createdBook;
};

test('add a new book to store', () => {
    const bookToAdd = createABook(2);

    store.addBook(bookToAdd.getTitle(), bookToAdd.getAuthor(), bookToAdd.getCopies());

    expect(store.verifyBookIsInStore(bookToAdd)).toBeTruthy();
});

test('does not add book to store if no copy', () => {
    const noCopy = 0;
    const bookToAdd = createABook(noCopy);

    store.addBook(bookToAdd.getTitle(), bookToAdd.getAuthor(), noCopy);

    expect(store.verifyBookIsInStore(bookToAdd)).toBeFalsy();
});

test('does not add book to store if invalid title', () => {
    const invalidTitle = null;
    const author = "JR Tolkien";

    store.addBook(invalidTitle, author, 2);

    expect(store.bookInInventory(invalidTitle, author)).toBeFalsy();
});

test('does not add book to store if invalid author', () => {
    const title = "Lord of the ring";
    const invalidAuthor = null;

    store.addBook(title, invalidAuthor, 2);

    expect(store.bookInInventory(title, invalidAuthor)).toBeFalsy();
});

test('add an existing book to store increases the copies', () => {
    const initialCopies = 2;
    const additionalCopies = 3;
    const bookAdded = addBookToStore(initialCopies);
    const expectedNumberOfCopy = additionalCopies + bookAdded.getCopies();

    store.addBook(bookAdded.getTitle(), bookAdded.getAuthor(), additionalCopies);

    store.verifyNumberOfCopyForBook(bookAdded, expectedNumberOfCopy);
});

test('sell a book from the store', () => {
    const copiesSold = 1;
    const initialCopies = 2;
    const bookToSell = addBookToStore(initialCopies);
    const expectedNumberOfCopy = bookToSell.getCopies() - copiesSold;

    store.sellBook(bookToSell.getTitle(), bookToSell.getAuthor(), copiesSold);

    store.verifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy);
});

test('cannot sell zero copy of a book', () => {
    const copiesSold = 0;
    const initialCopies = 2;
    const bookToSell = addBookToStore(initialCopies);
    const expectedNumberOfCopy = bookToSell.getCopies();

    store.sellBook(bookToSell.getTitle(), bookToSell.getAuthor(), copiesSold);

    store.verifyNumberOfCopyForBook(bookToSell, expectedNumberOfCopy);
});

test('sell the last copy of a book from the store', () => {
    const copiesSold = 1;
    const bookToSell = addBookToStore(copiesSold);

    store.sellBook(bookToSell.getTitle(), bookToSell.getAuthor(), copiesSold);
    store.verifyBookIsInStore(bookToSell);
});

export class BookStoreForTest extends BookStore {
    bookInInventory = (title: string | null, author: string | null): Boolean => isSome(this.getBookBy(title, author));
    verifyBookIsInStore = (book: Book) => this.bookInInventory(book.getTitle(), book.getAuthor());

    verifyNumberOfCopyForBook(book: Book, expectedNumberOfCopy: number): Boolean {
        if (this.verifyBookIsInStore(book)) {
            const foundBook = this.getBookBy(book.getTitle(), book.getAuthor());

            if (isSome(foundBook)) {
                return foundBook.value.getCopies() == expectedNumberOfCopy;
            }
        }
    }
}