import {Movie} from "./movie";

export class StoreAccount {
    public totalSold: number = 0;
    // Implementation leak: MovieSale exposed
    public allSales: MovieSale[];

    constructor() {
        this.allSales = [];
    }

    // Consufing naming: is 'to' the customer name?
    sell(movie: Movie, to: string) {
        this.totalSold += movie.unitPrice;
        // Bug: if adding to the list fails, the total is increased regardless.
        this.allSales.push(new MovieSale(to, movie.title));
    }
}

class MovieSale {
    public clientName: string;
    public movieName: string;

    constructor(clientName: string, movieName: string) {
        this.clientName = clientName;
        this.movieName = movieName;
    }
}