package academy.pocu.comp2500.lab7;

public final class Book {
    private final String title;
    private final Author author;
    private final int releaseYear;
    private final Genre genre;

    public Book(final String title, final Author author, final int releaseYear, final Genre genre) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.title);
        sb.append(" [");
        sb.append(this.author.toString());
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return this.title.hashCode()
                ^ this.author.hashCode() << 1
                ^ this.releaseYear << 2
                ^ this.genre.hashCode() << 3;
    }

    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (other.hashCode() != this.hashCode()) {
            return false;
        }

        if (other instanceof Book == false) {
            return false;
        }

        final Book otherBook = (Book) other;
        return this.title.equals(otherBook.title)
                && this.author.equals(otherBook.author)
                && this.releaseYear == otherBook.releaseYear
                && this.genre.equals(otherBook.genre);
    }
}
