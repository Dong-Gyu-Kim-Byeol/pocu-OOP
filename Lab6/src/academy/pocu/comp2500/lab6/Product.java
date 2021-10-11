package academy.pocu.comp2500.lab6;

public class Product {
    // private
    private final int price;

    // public
    public int getPrice() {
        return price;
    }

    // protected
    protected Product(final int price) {
        this.price = price;
    }
}
