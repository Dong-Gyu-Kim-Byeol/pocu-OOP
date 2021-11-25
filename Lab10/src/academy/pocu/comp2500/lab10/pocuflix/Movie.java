package academy.pocu.comp2500.lab10.pocuflix;

public final class Movie {
    private final String title;
    private final Rating rating;
    private final int playTime;

    public Movie(final String title,
                 final Rating rating,
                 final int playTime) {
        this.title = title;
        this.rating = rating;
        this.playTime = playTime;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getPlayTime() {
        return this.playTime;
    }

    public final Rating getRating() {
        return this.rating;
    }
}
