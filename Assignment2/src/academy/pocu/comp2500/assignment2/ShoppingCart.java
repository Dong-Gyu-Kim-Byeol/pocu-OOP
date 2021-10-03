package academy.pocu.comp2500.assignment2;

import java.util.HashSet;

public class ShoppingCart {
    private final HashSet<Shipment> shipments;
    private int totalPrice;

    // public
    public ShoppingCart() {
        this.shipments = new HashSet<Shipment>();
    }

    public void addShipment(final Shipment shipment) {
        if (this.shipments.add(shipment)) {
            this.totalPrice += shipment.getPrice();
        }
    }

    public void removeShipment(final Shipment shipment) {
        if (this.shipments.remove(shipment)) {
            this.totalPrice -= shipment.getPrice();
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
