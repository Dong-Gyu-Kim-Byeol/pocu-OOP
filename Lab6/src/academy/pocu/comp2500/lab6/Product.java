package academy.pocu.comp2500.lab6;

public class Product {
    // private
    private final EProductType productType;
    private final int price;

    // public
    public int getPrice() {
        return price;
    }

    public EProductType getProductType() {
        return productType;
    }

    // protected
    protected Product(final EProductType productType, final int price) {
        this.productType = productType;
        this.price = price;
    }
}
