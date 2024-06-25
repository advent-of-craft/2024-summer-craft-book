// Anemic domain anti-pattern: the entity Movie has no behavior
export class Movie {
    // Inconsistent naming
    public movieID: string;
    public title: string;
    public director: string;
    public unitPrice: number;
    public totalCopies: number;
    public borrowedCopies: number;

    constructor(movieID: string, title: string, director: string, totalCopies: number, unitPrice: number) {
        this.movieID = movieID;
        this.title = title;
        this.director = director;
        this.totalCopies = totalCopies;
        this.unitPrice = unitPrice;
        this.borrowedCopies = 0;
    }

    // Fragile implementation: a movie with a zero price cannot be sold?
    canSell(): boolean {
        // Incomplete rule: what if the unit price is negative?
        return this.unitPrice !== 0;
    }
}