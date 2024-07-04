export class Movie {
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

    canSell(): boolean {
        return this.unitPrice !== 0;
    }
}