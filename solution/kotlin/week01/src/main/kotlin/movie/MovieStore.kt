package movie

class MovieStore {
    var allMovies: HashMap<String, Movie> = HashMap()
    var sales: StoreAccount = StoreAccount()

    fun buyMovie(customer: String, id: String) {
        val movie = allMovies[id]
        if (movie != null) {
            if (movie.totalCopies - movie.borrowedCopies > 0) {
                movie.totalCopies--
                if (movie.canSell()) {
                    sales.sell(movie, customer)
                } else {
                    println("Movie not for sale")
                }
            } else {
                println("All copies are currently borrowed.")
            }
        } else {
            println("Movie not available!")
        }
    }

    fun addMovie(id: String, title: String, director: String, totalCopies: Int, unitPrice: Double) {
        if (allMovies.containsKey(id)) {
            println("Movie already exists! Updating total copies.")
            updateMovieCopies(id, totalCopies)
        } else {
            allMovies[id] = Movie(id, title, director, totalCopies, unitPrice)
        }
    }

    fun updateMovieCopies(id: String, newTotalCopies: Int) {
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

    fun displayMovies() {
        for ((_, m) in allMovies) {
            println("ID: ${m.movieID}, Title: ${m.title}, Director: ${m.director}, Available Copies: ${m.totalCopies - m.borrowedCopies}")
        }
    }

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
