import {Movie} from "./movie";
import {StoreAccount} from "./storeAccount";

export class MovieStore {
    public allMovies: Map<string, Movie>;
    public sales: StoreAccount;

    constructor() {
        this.allMovies = new Map<string, Movie>();
        this.sales = new StoreAccount();
    }

    buyMovie(customer: string, id: string) {
        const movie = this.allMovies.get(id);
        if (movie != null) {
            if (movie.totalCopies - movie.borrowedCopies > 0) {
                movie.totalCopies--;
                if (movie.canSell()) {
                    this.sales.sell(movie, customer);
                } else {
                    console.log("Movie not for sale");
                }
            } else {
                console.log("All copies are currently borrowed.");
            }
        } else {
            console.log("Movie not available!");
        }
    }

    addMovie(id: string, title: string, director: string, totalCopies: number, unitPrice: number) {
        if (this.allMovies.has(id)) {
            console.log("Movie already exists! Updating total copies.");
            this.updateMovieCopies(id, totalCopies);
        } else {
            this.allMovies.set(id, new Movie(id, title, director, totalCopies, unitPrice));
        }
    }

    updateMovieCopies(id: string, newTotalCopies: number) {
        const movie = this.allMovies.get(id);
        if (movie != null) {
            if (newTotalCopies < movie.borrowedCopies) {
                console.log("Cannot reduce total copies below borrowed copies.");
            } else {
                movie.totalCopies = newTotalCopies;
            }
        } else {
            console.log("Movie not found!");
        }
    }

    removeMovie(id: string) {
        if (this.allMovies.has(id)) {
            this.allMovies.delete(id);
        } else {
            console.log("Movie not found!");
        }
    }

    borrowMovie(id: string) {
        const movie = this.allMovies.get(id);
        if (movie != null) {
            if (movie.totalCopies - movie.borrowedCopies > 0) {
                movie.borrowedCopies++;
            } else {
                console.log("All copies are currently borrowed.");
            }
        } else {
            console.log("Movie not available!");
        }
    }

    returnMovie(id: string) {
        const movie = this.allMovies.get(id);
        if (movie != null) {
            if (movie.borrowedCopies > 0) {
                movie.borrowedCopies--;
            } else {
                console.log("Error: No copies were borrowed.");
            }
        } else {
            console.log("Invalid movie ID!");
        }
    }

    displayMovies() {
        this.allMovies.forEach((m) => {
            console.log(`ID: ${m.movieID}, Title: ${m.title}, Director: ${m.director}, Available Copies: ${m.totalCopies - m.borrowedCopies}`);
        });
    }

    findMoviesByTitle(title: string): Movie[] {
        const result: Movie[] = [];
        this.allMovies.forEach((m) => {
            if (m.title.toLowerCase() === title.toLowerCase()) {
                result.push(m);
            }
        });
        return result;
    }
}