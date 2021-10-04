package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.App;
import academy.pocu.comp2500.assignment2.EShippingMethod;
import academy.pocu.comp2500.assignment2.EStampColor;
import academy.pocu.comp2500.assignment2.EStampSize;
import academy.pocu.comp2500.assignment2.ShoppingCart;
import academy.pocu.comp2500.assignment2.Stamp;
import academy.pocu.comp2500.assignment2.registry.Registry;

import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        // write your code here
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        {
            final Stamp redStamp40x30 = new Stamp(UUID.randomUUID().toString(), EStampSize.MM_40_X_30, EStampColor.RED, "redStamp40x30");

            final ShoppingCart shoppingCart = new ShoppingCart();

            shoppingCart.addProduct(redStamp40x30.getProductId(), redStamp40x30);
            redStamp40x30.setShippingMethod(EShippingMethod.PICKUP);
            assert redStamp40x30.getShippingMethod() == EShippingMethod.PICKUP;
        }
    }

}
