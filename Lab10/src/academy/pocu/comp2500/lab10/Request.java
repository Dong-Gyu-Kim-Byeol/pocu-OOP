package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public final class Request {
    private static final User DEFAULT_NULL_USER = new User("", "");

    // ---

    private final String movieTitle;
    private User user;

    // ---

    public Request(final String movieTitle) {
        this.movieTitle = movieTitle;
        this.user = DEFAULT_NULL_USER;
    }

    // ---

    public final String getMovieTitle() {
        return movieTitle;
    }

    public final User getUser() {
        return user;
    }

    public final void setUser(final User user) {
        this.user = user;
    }

    @Override
    public final boolean equals(final Object obj) {
        assert (obj != null);

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Request) || obj.hashCode() != this.hashCode()) {
            return false;
        }

        final Request other = (Request) obj;
        return this.movieTitle.equals(other.movieTitle)
                && this.user.equals(other.user);
    }

    @Override
    public int hashCode() {
        return this.movieTitle.hashCode()
                & this.user.hashCode() << 2;
    }
}
