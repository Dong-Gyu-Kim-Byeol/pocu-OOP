package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public final class SimplePricing implements IPricingModel {
    public final int getTotalPrice(final ArrayList<Book> books) {
        int sum = 0;

        for (Book book : books) {
            sum += book.getPrice();
        }

        return sum;
    }
}
