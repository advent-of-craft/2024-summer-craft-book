import {MovieStore} from "../src/movieStore";

let store: MovieStore;

//Tests interdependency: the setup assumes a set of movies for all tests which makes them prone to fail.
beforeEach(() => {
    store = new MovieStore();
    store.addMovie("001", "Inception", "Christopher Nolan", 10, 0.0);
    store.addMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8, 0.0);
    store.addMovie("003", "Dunkirk", "Christopher Nolan", 5, 0.0);
});

//Poor naming testxxx
test("testAddMovie", () => {
    store.addMovie("002", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8, 0.0);
    //Implementation leak: tight to the implementation details of MovieStore
    expect(store.allMovies.get("002")?.totalCopies).toBe(8);
});

test("testRemoveMovie", () => {
    store.removeMovie("001");
    expect(store.allMovies.get("001")).toBeUndefined();
});

test("testBorrowMovie", () => {
    store.borrowMovie("001");
    expect(store.allMovies.get("001")?.borrowedCopies).toBe(1);
});

test("testBuyMovie", () => {
    const movie = store.allMovies.get("001");
    if (movie) {
        //Mutable state between tests: changing global set for a specific state
        movie.unitPrice = 5.0;
    }

    store.buyMovie("Durant", "001");
    expect(store.allMovies.get("001")?.totalCopies).toBe(9);
});

test("testReturnMovie", () => {
    store.returnMovie("001");
    expect(store.allMovies.get("001")?.borrowedCopies).toBe(0);
});

test("testFindMoviesByTitle", () => {
    const movies = store.findMoviesByTitle("Inception");
    expect(movies).toHaveLength(1);
    expect(movies[0].title).toBe("Inception");
});
