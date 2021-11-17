package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class DecadeMadness implements IPricingModel {
    private static final double DISCOUNTED_PRICE = 0.8;
    private static final int START_DISCOUNTING_EACH_COUNT = 2;

    // ---

    private final HashMap<Integer, LinkedList<Book>> generations;

    // ---

    public DecadeMadness() {
        this.generations = new HashMap<>();
    }

    // ---

    @Override
    public final int getTotalPrice(final ArrayList<Book> books) {
        for (final Book book : books) {
            final int generation = book.getPublishedYear() - (book.getPublishedYear() % 10);

            if (this.generations.containsKey(generation) == false) {
                this.generations.put(generation, new LinkedList<>());
            }

            this.generations.get(generation).add(book);
        }

        double sum = 0;

        for (final LinkedList<Book> bookLinkedList : this.generations.values()) {
            final double discountedPrice;
            if (bookLinkedList.size() >= START_DISCOUNTING_EACH_COUNT) {
                discountedPrice = DISCOUNTED_PRICE;
            } else {
                discountedPrice = 1.0;
            }

            for (final Book book : bookLinkedList) {
                sum += discountedPrice * (double) book.getPrice();
            }
        }


        // clear
        for (final LinkedList<Book> bookLinkedList : this.generations.values()) {
            bookLinkedList.clear();
        }


        return (int) sum;
    }
}
