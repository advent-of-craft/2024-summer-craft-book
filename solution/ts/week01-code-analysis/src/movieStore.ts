import {Movie} from "./movie";
import {StoreAccount} from "./storeAccount";

// SRP violation: the movie store has too many responsibilities
export class MovieStore {
    // inconsistent naming
    // Bad encapsulation: public field
    public allMovies: Map<string, Movie>;
    // confusing naming
    // Bad encapsulation: public field
    public sales: StoreAccount;

    constructor() {
        // we could inject some of the dependencies
        this.allMovies = new Map<string, Movie>();
        this.sales = new StoreAccount();
    }

    buyMovie(customer: string, id: string) {
        const movie = this.allMovies.get(id);
        if (movie != null) {
            if (movie.totalCopies - movie.borrowedCopies > 0) {
                // Implementation leak: accessing fields of movie
                movie.totalCopies--;
                // Level of indentation too complex
                if (movie.canSell()) {
                    // Argument switching between customer and movie. Can lead to error passing arguments.
                    this.sales.sell(movie, customer);
                } else {
                    console.log("Movie not for sale");
                }
            } else {
                console.log("All copies are currently borrowed.");
            }
        } else {
            // movie store logic tie to the console
            // error handling using the console is a bad practice
            console.log("Movie not available!");
        }
    }

    // Risk: we can add a movie with empty spaces as title?
    // Maintenance overhead: the number of parameters is high. Passing a movie instead?
    addMovie(id: string, title: string, director: string, totalCopies: number, unitPrice: number) {
        //Confusing name: the name of the method does not say what it does (update copies and add movies).
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
        // Duplication: the research and check if a copy is available is duplicated in the buyMovie method
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

    // Return, Borrow and Buy movie can be streamlined
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

    // Dead code? the method is never used, never tested
    displayMovies() {
        this.allMovies.forEach((m) => {
            console.log(`ID: ${m.movieID}, Title: ${m.title}, Director: ${m.director}, Available Copies: ${m.totalCopies - m.borrowedCopies}`);
        });
    }

    // Risk: no early return if, say, title is an empty string
    findMoviesByTitle(title: string): Movie[] {
        const result: Movie[] = [];
        this.allMovies.forEach((m) => {
            //Bug: the research by title is case-sensitive
            if (m.title.toLowerCase() === title.toLowerCase()) {
                result.push(m);
            }
        });
        return result;
    }
}