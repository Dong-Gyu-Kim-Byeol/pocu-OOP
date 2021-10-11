package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Product {
    protected final ArrayList<Topping> toppings;

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    // protected
    protected Pizza(final int price) {
        super(price);

        this.toppings = new ArrayList<Topping>();
    }

    protected static boolean isMeat(final Topping topping) {
        return topping == Topping.BACON
                || topping == Topping.CHICKEN
                || topping == Topping.PEPERONI
                || topping == Topping.SAUSAGES
                || topping == Topping.HAM;
    }

    protected static boolean isVeggie(final Topping topping) {
        return topping == Topping.BLACK_OLIVES
                || topping == Topping.RED_ONIONS
                || topping == Topping.GREEN_PEPPERS;
    }

    protected static boolean isCheese(final Topping topping) {
        return topping == Topping.MOZZARELLA_CHEESE
                || topping == Topping.CHEDDAR_CHEESE
                || topping == Topping.FETA_CHEESE;
    }
}
