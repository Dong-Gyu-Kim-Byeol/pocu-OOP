package academy.pocu.comp2500.assignment2;

import java.util.HashMap;

public class ShoppingCart {
    private final HashMap<String, Product> products;

    // public
    public ShoppingCart() {
        this.products = new HashMap<String, Product>();
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }

    public void addProduct(final String productId, final Product product) {
        assert (productId.equals(product.getProductId()));
        final Product previous = this.products.put(productId, product);
    }

    public void removeProduct(final String productId) {
        final Product previous = this.products.remove(productId);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (final Product product : this.products.values()) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public void clear() {
        this.products.clear();
    }

}
