package academy.pocu.comp2500.assignment2;

public class Product {
    private final EProductType productType;
    private Size size;
    private Color color;
    private int price;
    private int addPrice;

    // public
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
        return price + addPrice;
    }

    // protected
    protected Product(final EProductType productType) {
        this.productType = productType;
    }

    protected void setSize(final Size size) {
        this.size = size;
    }

    protected void setColor(final Color color) {
        this.color = color;
    }

    protected void setPrice(final int price) {
        this.price = price;
    }

    protected void setAddPrice(final int addPrice) {
        this.addPrice = addPrice;
    }
}
