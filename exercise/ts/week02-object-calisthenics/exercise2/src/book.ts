export class Book {
    private title: string;
    private author: string;
    private copies: number;

    constructor(title: string, author: string, copies: number) {
        this.title = title;
        this.author = author;
        this.copies = copies;
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

    getTitle(): string {
        return this.title;
    }

    getAuthor(): string {
        return this.author;
    }

    getCopies(): number {
        return this.copies;
    }
}