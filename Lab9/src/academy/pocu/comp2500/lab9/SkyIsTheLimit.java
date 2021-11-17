package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public final class SkyIsTheLimit implements IPricingModel {
    private static final double DISCOUNTED_PRICE = 0.5;
    private static final int DISCOUNT_MAX_COUNT = 2;
    private static final int START_DISCOUNTING_COUNT = 5;

    // ---

    private final int startDiscountPrice;
    private final SimplePricing simplePricing;

    // ---

    public SkyIsTheLimit(final int startDiscountPrice) {
        this.startDiscountPrice = startDiscountPrice;
        this.simplePricing = new SimplePricing();
    }

    // ---

    @Override
    public final int getTotalPrice(ArrayList<Book> books) {
        double sum = this.simplePricing.getTotalPrice(books);
        if (sum < startDiscountPrice) {
            return (int) sum;
        }

        if (books.size() < START_DISCOUNTING_COUNT) {
            return (int) sum;
        }

        Sort.radixSort(books, Book::getPrice);

        final int lastIndex = books.size() - DISCOUNT_MAX_COUNT;
        for (int i = books.size() - 1; i >= lastIndex; --i) {
            sum -= (double) (books.get(i).getPrice()) * (1.0 - DISCOUNTED_PRICE);
        }

        return (int) sum;
    }
}
