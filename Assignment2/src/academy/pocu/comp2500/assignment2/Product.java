package academy.pocu.comp2500.assignment2;

public class Product {
    private final EProductType productType;

    private int width;
    private int height;
    private int color;

    private int basePrice;
    private int aperturesPrice;

    private EShippingMethod shippingMethod;

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

    public String getColor() {
        return Integer.toHexString(color);
    }

    public int getPrice() {
        return basePrice + aperturesPrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getAperturesPrice() {
        return aperturesPrice;
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

    protected void setColor(int color) {
        if (color < 0) {
            color = 0;
        } else if (color > 0xffffff) {
            color = 0xffffff;
        }

        this.color = color;
    }

    protected void setBasePrice(final int basePrice) {
        this.basePrice = basePrice;
    }

    protected void setAperturesPrice(final int aperturesPrice) {
        this.aperturesPrice = aperturesPrice;
    }
}
