package academy.pocu.comp2500.assignment2;

public class Product {
    private final EProductType productType;

    private int width;
    private int height;

    private short red;
    private short green;
    private short blue;

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
        return red;
    }

    public short getGreen() {
        return green;
    }

    public short getBlue() {
        return blue;
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

    protected void setColor(final short r, final short g, final short b) {
        if (r < 0) {
            this.red = 0;
        } else if (r > 0xff) {
            this.red = 0xff;
        } else {
            this.red = r;
        }

        if (g < 0) {
            this.green = 0;
        } else if (g > 0xff) {
            this.green = 0xff;
        } else {
            this.green = g;
        }

        if (b < 0) {
            this.blue = 0;
        } else if (b > 0xff) {
            this.blue = 0xff;
        } else {
            this.blue = b;
        }

        assert (0 <= r && r <= 0xff);
        assert (0 <= g && g <= 0xff);
        assert (0 <= b && b <= 0xff);
    }

    protected void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    protected void setAperturesPrice(int aperturesPrice) {
        this.aperturesPrice = aperturesPrice;
    }
}
