import {Movie} from "./movie";

export class StoreAccount {
    public totalSold: number = 0;
    public allSales: MovieSale[];

    constructor() {
        this.allSales = [];
    }

    sell(movie: Movie, to: string) {
        this.totalSold += movie.unitPrice;
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