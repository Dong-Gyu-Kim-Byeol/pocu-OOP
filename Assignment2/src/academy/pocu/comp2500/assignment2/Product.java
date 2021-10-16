package academy.pocu.comp2500.assignment2;

public class Product {
    // private
    private final EProductType productType;
    private Size size;
    private Color color;

    private int basePrice;
    private int aperturePrice;

    private EShippingMethod shippingMethod;

    // public method
    public EProductType getProductType() {
        return productType;
    }

    public String getName() {
        return productType.getName();
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

    protected int getBasePrice() {
        return basePrice;
    }

    protected void setBasePrice(final int basePrice) {
        this.basePrice = basePrice;
    }

    protected int getAperturePrice() {
        return aperturePrice;
    }

    protected void setAperturePrice(final int aperturePrice) {
        this.aperturePrice = aperturePrice;
    }

    protected void setSize(final Size size) {
        this.size = size;
    }

    protected void setColor(final Color color) {
        this.color = color;
    }
}
