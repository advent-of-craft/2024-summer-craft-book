import {Book} from './book';
import {none, Option, some} from "fp-ts/lib/Option";

export class BookInventory {
    private inventory: Book[] = [];

    addBook(book: Book): void {
        this.inventory.push(book);
    }

    removeBook(book: Book): void {
        this.inventory = this.inventory.filter(b => b !== book);
    }

    getBook(title: string, author: string): Option<Book> {
        const book = this.inventory.find(b => b.getTitle() === title && b.getAuthor() === author);
        return book ? some(book) : none;
    }

    removeBookIfNoMoreCopies(book: Book): void {
        if (!book.hasCopies()) {
            this.removeBook(book);
        }
    }
}