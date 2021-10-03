package academy.pocu.comp2500.assignment2;

public class Shipment {
    private EShippingMethod shippingMethod;
    private final Product product;

    // public
    public Shipment(final Product product) {
        this.product = product;
        this.shippingMethod = EShippingMethod.SHIP;
    }

    public Product getProduct() {
        return product;
    }

    public EProductType getProductType() {
        return this.getProduct().getProductType();
    }

    public Size getSize() {
        return this.getProduct().getSize();
    }

    public Color getColor() {
        return this.getProduct().getColor();
    }

    public int getPrice() {
        return this.getProduct().getPrice();
    }

    public EShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(EShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
