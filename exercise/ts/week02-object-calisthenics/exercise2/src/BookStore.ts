import { Book } from './Book';

export class BookStore {
    private inv: Book[] = [];

    addBook(title: string | null, author: string | null, copies: number): void {
        if (title !== null && author !== null && copies > 0) {
            let foundBook: Book | null = null;
            for (const book of this.inv) {
                if (book.getTitle() === title && book.getAuthor() === author) {
                    foundBook = book;
                    break;
                }
            }
            if (foundBook !== null) {
                foundBook.addCopies(copies);
            } else {
                this.inv.push(new Book(title, author, copies));
            }
        }
    }

    sellBook(title: string, author: string, copies: number): void {
        for (const book of this.inv) {
            if (book.getTitle() === title && book.getAuthor() === author) {
                book.removeCopies(copies);
                if (book.getCopies() <= 0) {
                    this.inv = this.inv.filter(b => b !== book);
                }
                break;
            }
        }
    }
}