package academy.pocu.comp2500.assignment2;

public class Product {
    // private
    private final EProductType productType;
    private Size size;
    private Color color;

    private int basePrice;

    private EShippingMethod shippingMethod;

    // protected
    protected int aperturePrice;

    // public method
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
        return basePrice + aperturePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public EShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(final EShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    // protected method
    protected Product(final EProductType productType) {
        this.productType = productType;
        this.shippingMethod = EShippingMethod.SHIP;
    }

    protected void setSize(final Size size) {
        this.size = size;
    }

    protected void setColor(final Color color) {
        this.color = color;
    }

    protected void setBasePrice(final int basePrice) {
        this.basePrice = basePrice;
    }
}
