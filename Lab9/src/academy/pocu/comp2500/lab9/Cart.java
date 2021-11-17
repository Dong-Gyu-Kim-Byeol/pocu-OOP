package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public final class Cart {
    private final ArrayList<Book> books;

    // ---

    public Cart() {
        this.books = new ArrayList<>();
    }

    // ---

    public final Book getBookOrNull(int index) {
        if (this.books.size() <= index) {
            return null;
        }

        return this.books.get(index);
    }

    public final int getBookCount() {
        return this.books.size();
    }

    public final void addBooks(final Book[] books) {
        for (final Book book : books) {
            this.books.add(book);
        }
    }

    public final void addBook(final Book book) {
        this.books.add(book);
    }

    public final boolean remove(int index) {
        if (this.books.size() <= index) {
            return false;
        }

        this.books.remove(index);

        return true;
    }

    public final int getTotalPrice(final IPricingModel pricingModel) {
        return pricingModel.getTotalPrice(this.books);
    }
}