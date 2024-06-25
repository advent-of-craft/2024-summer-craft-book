import {fold, Option} from 'fp-ts/lib/Option';
import {Book} from './book';
import {BookInventory} from './bookInventory';

export class BookStore {
    private readonly inventory: BookInventory = new BookInventory();

    addBook(title: string | null, author: string | null, copies: number): void {
        if (copies <= 0 || !title || !author) return;

        fold(
            () => {
                const createdBook = Book.createBook(title, author, copies);
                fold(
                    () => {
                    },
                    (book: Book) => this.inventory.addBook(book)
                )(createdBook);
            },
            (book: Book) => book.addCopies(copies)
        )(this.inventory.getBook(title, author));
    }

    sellBook(title: string, author: string, copies: number): void {
        if (copies <= 0) return;

        const bookOption = this.inventory.getBook(title, author);

        fold(
            () => {
            },
            (book: Book) => {
                book.removeCopies(copies);
                this.inventory.removeBookIfNoMoreCopies(book);
            }
        )(bookOption);
    }

    getBookBy = (title: string | null, author: string | null): Option<Book> => this.inventory.getBook(title, author);
}