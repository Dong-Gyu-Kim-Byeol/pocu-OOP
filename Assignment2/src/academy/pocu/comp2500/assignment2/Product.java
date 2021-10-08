package academy.pocu.comp2500.assignment2;

public class Product {
    // private
    private final EProductType productType;
    private Size size;
    private Color color;

    private int price;

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
        return price;
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

    protected void addPrice(final int price) {
        this.price += price;
    }

    protected void setSize(final Size size) {
        this.size = size;
    }

    protected void setColor(final Color color) {
        this.color = color;
    }
}
