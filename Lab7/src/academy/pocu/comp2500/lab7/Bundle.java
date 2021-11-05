package academy.pocu.comp2500.lab7;

import java.util.HashSet;

public final class Bundle {
    private final String name;
    private final HashSet<Book> books;

    public Bundle(final String name) {
        this.name = name;
        this.books = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public boolean add(final Book book) {
        return this.books.add(book);
    }

    public boolean remove(final Book book) {
        return this.books.remove(book);
    }

    public int hashCode() {
        int hash = this.name.hashCode();
        hash ^= this.books.size();
        for (final Book book : this.books) {
            hash ^= book.hashCode();
        }
        return hash;
    }

    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (object.hashCode() != this.hashCode()) {
            return false;
        }

        if (object instanceof Bundle == false) {
            return false;
        }


        final Bundle other = (Bundle) object;
        if (this.name.equals(other.name) == false) {
            return false;
        }

        if (this.books.size() != other.books.size()) {
            return false;
        }

        for (final Book thisBook : this.books) {
            if (other.books.contains(thisBook) == false) {
                return false;
            }
        }

        return true;
    }

}

