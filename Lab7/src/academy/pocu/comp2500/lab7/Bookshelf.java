package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public final class Bookshelf {
    private final ArrayList<Book> books;
    private final int capacity;

    public Bookshelf(final int capacity) {
        this.books = new ArrayList<Book>(capacity);
        this.capacity = capacity;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public int capacity() {
        return capacity;
    }

    public boolean add(final Book book) {
        if(this.books.size() >= this.capacity){
            return false;
        }

        this.books.add(book);
        return true;
    }

    public boolean remove(final Book book) {
        return this.books.remove(book);
    }
}
