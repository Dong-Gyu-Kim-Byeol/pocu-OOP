package academy.pocu.comp2500.assignment2;

public class Product {
    // private
    private final EProductType productType;

    private int width;
    private int height;

    private Color color;

    public short getColorRed() {
        return color.getRed();
    }

    public short getColorGreen() {
        return color.getGreen();
    }

    public short getColorBlue() {
        return color.getBlue();
    }

    private int basePrice;

    private EShippingMethod shippingMethod;

    // protected
    protected int aperturePrice;

    // public method
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
