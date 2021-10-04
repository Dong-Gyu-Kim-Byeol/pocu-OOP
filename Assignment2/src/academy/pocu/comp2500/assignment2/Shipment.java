package academy.pocu.comp2500.assignment2;

public class Shipment {
    private final Product product;
    private int count;

    public Shipment(final Product product) {
        this.product = product;
        this.count = 1;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getCount() {
        return this.count;
    }

    public void increaseCount() {
        ++this.count;
    }

    public void decreaseCount() {
        --this.count;
        if (this.count < 0) {
            this.count = 0;
        }
    }
}
