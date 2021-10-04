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

    public int getColor() {
        return color;
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

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected void setColor(short r, short g, short b) {
        if (r < 0) {
            r = 0;
        } else if (r > 0xff) {
            r = 0xff;
        } else {
            r = r;
        }

        if (g < 0) {
            g = 0;
        } else if (g > 0xff) {
            g = 0xff;
        } else {
            g = g;
        }

        if (b < 0) {
            b = 0;
        } else if (b > 0xff) {
            b = 0xff;
        } else {
            b = b;
        }

        int color = 0;
        color |= r << 16;
        color |= g << 8;
        color |= b;
        this.color = color;
    }

    protected void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    protected void setAperturesPrice(int aperturesPrice) {
        this.aperturesPrice = aperturesPrice;
    }
}
