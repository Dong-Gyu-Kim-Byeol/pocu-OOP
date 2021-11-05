package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public final class ReadingList {
    private final String name;
    private final ArrayList<Book> books;

    public ReadingList(final String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void add(final Book book) {
        this.books.add(book);
    }

    public boolean remove(final Book book) {
        return this.books.remove(book);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        int i = 1;
        for (final Book book : this.books) {
            sb.append(i);
            sb.append(". ");
            sb.append(book.toString());
            sb.append(System.lineSeparator());
            ++i;
        }

        return sb.toString();
    }

    public int hashCode() {
        int hash = this.name.hashCode();
        hash ^= this.books.size();
        for (final Book book : this.books) {
            hash ^= book.hashCode();
        }

        return hash;
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.hashCode() != this.hashCode()) {
            return false;
        }

        if (o instanceof ReadingList == false) {
            return false;
        }


        final ReadingList other = (ReadingList) o;
        if (other.name.equals(this.name) == false) {
            return false;
        }

        if (other.books.size() != this.books.size()) {
            return false;
        }

        for (int i = 0; i < this.books.size(); ++i) {
            if (other.books.get(i).equals(this.books.get(i)) == false) {
                return false;
            }
        }

        return true;
    }
}
