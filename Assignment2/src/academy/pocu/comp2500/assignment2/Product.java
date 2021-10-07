package academy.pocu.comp2500.assignment2;

public class Product {
    // private
    private final EProductType productType;

    private int width;
    private int height;

    private Color color;

    private int basePrice;

    private EShippingMethod shippingMethod;

    // protected
    protected int aperturesPrice;

    // public
    public EProductType getProductType() {
        return productType;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return basePrice + aperturesPrice;
    }

    public EShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(final EShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    // protected
    protected Product(final EProductType productType) {
        this.productType = productType;
        this.shippingMethod = EShippingMethod.SHIP;
    }

    protected void setWidth(final int width) {
        this.width = width;
    }

    protected void setHeight(final int height) {
        this.height = height;
    }

    protected void setColor(final Color color) {
        this.color = color;
    }

    protected void setBasePrice(final int basePrice) {
        this.basePrice = basePrice;
    }
}
