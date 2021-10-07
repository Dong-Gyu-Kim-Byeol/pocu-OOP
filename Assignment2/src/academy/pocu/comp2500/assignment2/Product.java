package academy.pocu.comp2500.assignment2;

public class Product {
    private final EProductType productType;

    private int width;
    private int height;

    private final short[] rgb;

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

    public short getRed() {
        return rgb[0];
    }

    public short getGreen() {
        return rgb[1];
    }

    public short getBlue() {
        return rgb[2];
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
        this.rgb = new short[3];
        this.shippingMethod = EShippingMethod.SHIP;
    }

    protected void setWidth(final int width) {
        this.width = width;
    }

    protected void setHeight(final int height) {
        this.height = height;
    }

    protected void setRgb(short r, short g, short b) {
        if (r < 0) {
            r = 0;
        } else if (r > 0xff) {
            r = 0xff;
        }

        if (g < 0) {
            g = 0;
        } else if (g > 0xff) {
            g = 0xff;
        }

        if (b < 0) {
            b = 0;
        } else if (b > 0xff) {
            b = 0xff;
        }

        this.rgb[0] = r;
        this.rgb[1] = g;
        this.rgb[2] = b;
    }

    protected void setBasePrice(final int basePrice) {
        this.basePrice = basePrice;
    }

    protected void setAperturesPrice(final int aperturesPrice) {
        this.aperturesPrice = aperturesPrice;
    }
}
