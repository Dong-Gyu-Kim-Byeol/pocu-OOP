package academy.pocu.comp2500.lab6;

public class Product {
    private boolean isValid;
    private final int price;

    // public
    public int getPrice() {
        return price;
    }

    public boolean isValid() {
        return isValid;
    }

    // protected
    protected Product(final int price) {
        this.price = price;
    }

    protected void setIsValid(boolean valid) {
        isValid = valid;
    }
}
