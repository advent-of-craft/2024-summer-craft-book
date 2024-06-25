import {none, Option, some} from 'fp-ts/lib/Option';

export class Book {
    private constructor(
        private readonly title: string,
        private readonly author: string,
        private copies: number
    ) {
    }

    static createBook(title: string | null, author: string | null, copies: number): Option<Book> {
        return this.isInvalidInformation(title, author, copies) ? none : some(new Book(title!, author!, copies));
    }

    private static isInvalidInformation(title: string | null, author: string | null, copies: number): boolean {
        return !title || !author || copies < 0;
    }

    addCopies(additionalCopies: number): void {
        if (additionalCopies > 0) {
            this.copies += additionalCopies;
        }
    }

    removeCopies(soldCopies: number): void {
        if (soldCopies > 0 && this.copies >= soldCopies) {
            this.copies -= soldCopies;
        }
    }

    getTitle = (): string => this.title;

    getAuthor = (): string => this.author;

    getCopies = (): number => this.copies;

    hasCopies = (): boolean => this.getCopies() > 0;
}
