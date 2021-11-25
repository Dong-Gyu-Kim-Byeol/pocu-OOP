package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.HashMap;
import java.util.LinkedList;

public final class MovieStore implements IRequestHandler {
    private final HashMap<String, Movie> moviesTitleMap;
    private final LinkedList<Movie> movies;

    // ---

    public MovieStore() {
        this.moviesTitleMap = new HashMap<>();
        this.movies = new LinkedList<>();
    }

    // ---

    @Override
    public final ResultBase handle(final Request request) {
        if (this.moviesTitleMap.containsKey(request.getMovieTitle())) {
            return new OkResult(this.moviesTitleMap.get(request.getMovieTitle()));
        } else {
            return new NotFoundResult();
        }
    }

    public final void add(final Movie movie) {
        this.moviesTitleMap.put(movie.getTitle(), movie);
        this.movies.add(movie);
    }

    public final boolean remove(final int index) {
        if (index >= this.movies.size()) {
            return false;
        }

        final Movie movie = this.movies.remove(index);
        assert (movie != null);

        this.moviesTitleMap.remove(movie.getTitle());

        return true;
    }
}
