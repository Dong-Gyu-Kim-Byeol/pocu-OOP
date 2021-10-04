package academy.pocu.comp2500.assignment2;

import java.util.HashMap;

public class ShoppingCart {
    private final HashMap<String, Product> products;
    private int totalPrice;

    // public
    public ShoppingCart() {
        this.products = new HashMap<String, Product>();
    }

    public void addProduct(final Product product) {
        final Product previous = this.products.put(product.getProductId(), product);
        if (previous != null) {
            this.totalPrice -= previous.getPrice();
        }
        this.totalPrice += product.getPrice();
    }

    public void removeProduct(final Product product) {
        final Product previous = this.products.remove(product.getProductId());
        if (previous != null) {
            assert (previous.getPrice() == product.getPrice());
            this.totalPrice -= product.getPrice();
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
