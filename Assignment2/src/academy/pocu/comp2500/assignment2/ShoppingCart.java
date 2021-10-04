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

    public void addProduct(final Product product) {
        this.products.put(product.getProductId(), product);
    }

    public void removeProduct(final String productId) {
        this.products.remove(productId);
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
