package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Product {
    protected ArrayList<Topping> toppings;
    protected int veggieCount;
    protected int meatCount;
    protected int cheeseCount;

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    // protected
    protected Pizza(final int price, final Topping... toppings) {
        super(price);

        this.toppings = new ArrayList<Topping>();
        for (final Topping topping : toppings) {
            this.toppings.add(topping);
        }
    }

    protected boolean isValid(final int maxMeatCount, final int maxVeggieCount, final int maxCheeseCount) {
        return this.meatCount == maxMeatCount
                && this.veggieCount == maxVeggieCount
                && this.cheeseCount == maxCheeseCount;
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
