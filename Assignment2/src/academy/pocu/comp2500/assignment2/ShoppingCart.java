package academy.pocu.comp2500.assignment2;

import java.util.HashMap;

public class ShoppingCart {
    private final HashMap<String, Product> products;
    private int totalPrice;

    // public
    public ShoppingCart() {
        this.products = new HashMap<String, Product>();
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }

    public void addProduct(final Product product) {
        final Product previous = this.products.put(product.getProductId(), product);
        if (previous != null) {
            this.totalPrice -= previous.getTotalPrice();
        }
        this.totalPrice += product.getTotalPrice();
    }

    public void removeProduct(final Product product) {
        final Product previous = this.products.remove(product.getProductId());
        if (previous != null) {
            assert (previous.getTotalPrice() == product.getTotalPrice());
            this.totalPrice -= product.getTotalPrice();
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void clear() {
        this.products.clear();
        this.totalPrice = 0;
    }

}
