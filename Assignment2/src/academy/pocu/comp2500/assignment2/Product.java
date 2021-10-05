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

//    public String getRgbString() {
//        return String.format("0x%02X%02X%02X", rgb[0], rgb[1], rgb[2]);
//    }

    public short[] getRgb() {
        return rgb;
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

        this.rgb[ERgbIndex.RED.getIndex()] = r;
        this.rgb[ERgbIndex.GREEN.getIndex()] = g;
        this.rgb[ERgbIndex.BLUE.getIndex()] = b;
    }

    protected void setBasePrice(final int basePrice) {
        this.basePrice = basePrice;
    }

    protected void setAperturesPrice(final int aperturesPrice) {
        this.aperturesPrice = aperturesPrice;
    }
}
