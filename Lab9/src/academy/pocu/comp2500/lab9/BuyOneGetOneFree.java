package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public final class BuyOneGetOneFree implements IPricingModel {
    private final HashMap<UUID, Boolean> isSkuFrees;

    // ---

    public BuyOneGetOneFree(final HashSet<UUID> skus) {
        this.isSkuFrees = new HashMap<>(skus.size());
        for (final UUID sku : skus) {
            isSkuFrees.put(sku, false);
        }
    }

    // ---

    @Override
    public final int getTotalPrice(final ArrayList<Book> books) {
        int sum = 0;

        for (Book book : books) {
            if (this.isSkuFrees.containsKey(book.getSku())) {
                if (this.isSkuFrees.get(book.getSku())) {
                    this.isSkuFrees.put(book.getSku(), false);
                    continue;
                }

                this.isSkuFrees.put(book.getSku(), true);
            }

            sum += book.getPrice();
        }


        for (final UUID sku : this.isSkuFrees.keySet()) {
            isSkuFrees.put(sku, false);
        }

        return sum;
    }
}
