package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.UUID;

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

    public final void addBooks(final UUID[] skus, final String[] titles, final int[] prices, final int[] publishedYears) {
        if (skus.length != titles.length || skus.length != prices.length || skus.length != publishedYears.length) {
            return;
        }

        for (int i = 0; i < skus.length; ++i) {
            Book book = new Book(skus[i], titles[i], prices[i], publishedYears[i]);
            this.books.add(book);
        }
    }

    public final void addBook(final UUID sku, final String title, final int price, final int publishedYear) {
        Book book = new Book(sku, title, price, publishedYear);
        this.books.add(book);
    }

    public final boolean remove(int index) {
        if (this.books.size() <= index) {
            return false;
        }

        this.books.remove(index);

        return true;
    }

    public final int getTotalPrice() {
        int sum = 0;

        for (Book book : this.books) {
            sum += book.getPrice();
        }

        return sum;
    }
}