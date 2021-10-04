package academy.pocu.comp2500.assignment2;

import java.util.HashMap;

public class ShoppingCart {
    private final HashMap<String, Shipment> products;

    // public
    public ShoppingCart() {
        this.products = new HashMap<String, Shipment>();
    }

    public HashMap<String, Shipment> getProducts() {
        return products;
    }

    public void addProduct(final Product product) {
        if (this.products.containsKey(product.getProductId())) {
            this.products.get(product.getProductId()).increaseCount();
        } else {
            this.products.put(product.getProductId(), new Shipment(product));
        }
    }

    public void removeProduct(final String productId) {
        if (this.products.containsKey(productId)) {
            this.products.get(productId).decreaseCount();
            if (this.products.get(productId).getCount() <= 0) {
                this.products.remove(productId);
            }
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (final Shipment shipment : this.products.values()) {
            totalPrice += shipment.getProduct().getPrice() * shipment.getCount();
        }

        return totalPrice;
    }

    public void clear() {
        this.products.clear();
    }

}
