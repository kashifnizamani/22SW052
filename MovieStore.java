import java.util.ArrayList;

class MovieStore {
    private ArrayList<Movie> movieCollection;

    public MovieStore() {
        movieCollection = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movieCollection.add(movie);
    }

    public Movie findMovieByName(String name) {
        for (Movie movie : movieCollection) {
            if (movie.getName().equalsIgnoreCase(name)) {
                return movie;
            }
        }
        return null;
    }

    public ArrayList<Movie> findMoviesByGenre(String genre) {
        ArrayList<Movie> matchingMovies = new ArrayList<>();
        for (Movie movie : movieCollection) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }

    public ArrayList<Movie> findMoviesByDirector(String director) {
        ArrayList<Movie> matchingMovies =  new ArrayList<>();
        for (Movie movie : movieCollection) {
            if (movie.getDirector().equalsIgnoreCase(director)) {
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }
}
