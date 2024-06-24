package movie

// SRP violation: the movie store has too many responsibilities
class MovieStore {
    //inconsistent naming
    //Bad encapsulation: public field
    var allMovies: HashMap<String, Movie> = HashMap()
    //confusing naming
    //Bad encapsulation: public field
    //we could inject some of the dependencies
    var sales: StoreAccount = StoreAccount()

    fun buyMovie(customer: String, id: String) {
        val movie = allMovies[id]
        if (movie != null) {
            //Implementation leak: accessing fields of movie
            if (movie.totalCopies - movie.borrowedCopies > 0) {
                movie.totalCopies--
                //Level of indentation too complex
                if (movie.canSell()) {
                    //Argument switching between customer and movie. Can lead to error passing arguments.
                    sales.sell(movie, customer)
                } else {
                    println("Movie not for sale")
                }
            } else {
                println("All copies are currently borrowed.")
            }
        } else {
            //movie store logic tie to the console
            //error handling using the console is a bad practice
            println("Movie not available!")
        }
    }

    //Risk: we can add a movie with empty spaces as title?
    //Maintenance overhead: the number of parameters is high. Passing a movie instead?
    fun addMovie(id: String, title: String, director: String, totalCopies: Int, unitPrice: Double) {
        //Confusing name: the name of the method does not say what it does (update copies and add movies).
        if (allMovies.containsKey(id)) {
            println("Movie already exists! Updating total copies.")
            updateMovieCopies(id, totalCopies)
        } else {
            allMovies[id] = Movie(id, title, director, totalCopies, unitPrice)
        }
    }

    fun updateMovieCopies(id: String, newTotalCopies: Int) {
        //Performance: possibly multiple iterations
        val movie = allMovies[id]
        if (movie != null) {
            if (newTotalCopies < movie.borrowedCopies) {
                println("Cannot reduce total copies below borrowed copies.")
            } else {
                movie.totalCopies = newTotalCopies
            }
        } else {
            println("Movie not found!")
        }
    }

    fun removeMovie(id: String) {
        if (allMovies.containsKey(id)) {
            allMovies.remove(id)
        } else {
            println("Movie not found!")
        }
    }

    fun borrowMovie(id: String) {
        val movie = allMovies[id]
        //Duplication: the research and check if a copy is available is duplicated in the buyMovie method
        if (movie != null) {
            if (movie.totalCopies - movie.borrowedCopies > 0) {
                movie.borrowedCopies++
            } else {
                println("All copies are currently borrowed.")
            }
        } else {
            println("Movie not available!")
        }
    }

    //Return, Borrow and Buy movie can be streamlined
    fun returnMovie(id: String) {
        val movie = allMovies[id]
        if (movie != null) {
            if (movie.borrowedCopies > 0) {
                movie.borrowedCopies--
            } else {
                println("Error: No copies were borrowed.")
            }
        } else {
            println("Invalid movie ID!")
        }
    }

    //Dead code? the method is never used, never tested
    fun displayMovies() {
        for ((_, m) in allMovies) {
            println("ID: ${m.movieID}, Title: ${m.title}, Director: ${m.director}, Available Copies: ${m.totalCopies - m.borrowedCopies}")
        }
    }

    //Risk: no early return if, say, title is an empty string
    fun findMoviesByTitle(title: String): List<Movie> {
        val result = mutableListOf<Movie>()
        for ((_, m) in allMovies) {
            if (m.title.equals(title, ignoreCase = true)) {
                result.add(m)
            }
        }
        return result
    }
}
