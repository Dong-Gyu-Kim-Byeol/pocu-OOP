package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;

public final class CachedRequest {
    private final Request request;
    private final Movie movie;
    private int expiryCount;

    // ---

    public CachedRequest(final Request request, final Movie movie, final int expiryCount) {
        assert (request.getMovieTitle().equals(movie.getTitle()));

        this.request = request;
        this.movie = movie;
        this.expiryCount = expiryCount;
    }

    // ---


    public Movie getMovie() {
        return movie;
    }

    public final void subExpiryCount() {
        --this.expiryCount;
    }

    public int getExpiryCount() {
        return expiryCount;
    }
//
//    @Override
//    public final boolean equals(final Object object) {
//        if (object == null) {
//            return false;
//        }
//
//        if (this == object) {
//            return true;
//        }
//
//        if (!(object instanceof CachedRequest) || this.hashCode() != object.hashCode()) {
//            return false;
//        }
//
//        final CachedRequest other = (CachedRequest) object;
//        return this.request.equals(other.request)
//                && this.movie.equals(other.movie);
//    }
//
//    @Override
//    public final int hashCode() {
//        return request.hashCode()
//                ^ movie.hashCode() << 4;
//    }
}
