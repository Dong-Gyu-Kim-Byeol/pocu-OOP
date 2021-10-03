package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.Color;
import academy.pocu.comp2500.assignment2.EShippingMethod;
import academy.pocu.comp2500.assignment2.EStampColor;
import academy.pocu.comp2500.assignment2.EStampSize;
import academy.pocu.comp2500.assignment2.Shipment;
import academy.pocu.comp2500.assignment2.ShoppingCart;
import academy.pocu.comp2500.assignment2.Stamp;

public class Program {

    public static void main(String[] args) {
        // write your code here

        {
            final Stamp redStamp40x30 = new Stamp(EStampSize.MM_40_X_30, EStampColor.RED, "redStamp40x30");

            final Color color = redStamp40x30.getColor();
            assert color.getR() == EStampColor.RED.getColor().getR();
            assert color.getG() == EStampColor.RED.getColor().getG();
            assert color.getB() == EStampColor.RED.getColor().getB();

            final ShoppingCart shoppingCart = new ShoppingCart();

            final Shipment redStamp40x30Shipment = new Shipment(redStamp40x30);
            shoppingCart.addShipment(redStamp40x30Shipment);
            redStamp40x30Shipment.setShippingMethod(EShippingMethod.PICKUP);
            assert redStamp40x30Shipment.getShippingMethod() == EShippingMethod.PICKUP;
        }
    }
}
