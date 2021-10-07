package academy.pocu.comp2500.assignment2;

import java.util.HashSet;

public class ShoppingCart {
    private final HashSet<Product> products;

    // public method
    public ShoppingCart() {
        this.products = new HashSet<Product>();
    }

    public HashSet<Product> getProducts() {
        return products;
    }

    public void addProduct(final Product product) {
        this.products.add(product);
    }

    public void removeProduct(final Product product) {
        this.products.remove(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (final Product product : this.products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public void clear() {
        this.products.clear();
    }

}
