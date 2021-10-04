package academy.pocu.comp2500.assignment2;

import java.util.UUID;

public class Product {
    private final EProductType productType;
    private final String productId;

    private Size size;
    private Color color;
    private int price;
    private int aperturesPrice;

    private EShippingMethod shippingMethod;

    // public
    public String getProductId() {
        return productId;
    }

    public EProductType getProductType() {
        return productType;
    }

    public Size getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price + aperturesPrice;
    }

    public EShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(EShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    // protected
    protected Product(final String productId, final EProductType productType) {
        this.productId = productId;
        this.productType = productType;
        this.shippingMethod = EShippingMethod.SHIP;
    }

    protected void setSize(final Size size) {
        this.size = size;
    }

    protected void setColor(final Color color) {
        this.color = color;
    }

    protected void setPrice(final int price) {
        this.price = price;
    }

    protected void setAperturesPrice(int aperturesPrice) {
        this.aperturesPrice = aperturesPrice;
    }
}
