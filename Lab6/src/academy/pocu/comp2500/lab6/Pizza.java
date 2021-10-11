package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Product {
    private final EPizzaType pizzaType;

    protected final ArrayList<Topping> toppings;

    protected int veggieCount;
    protected int meatCount;
    protected int cheeseCount;

    public EPizzaType getPizzaType() {
        return pizzaType;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public boolean isValid() {
        switch (this.pizzaType) {
            case HOUSE_PIZZA:
                return this.meatCount == HousePizza.MAX_MEAT_COUNT;

            case MEAT_LOVER_PIZZA:
                return this.veggieCount == MeatLoverPizza.MAX_VEGGIE_COUNT;

            case VEGGIE_PIZZA:
                return this.cheeseCount == VeggiePizza.MAX_CHEESE_COUNT;

            case FREE_SOUL_PIZZA:
                return this.meatCount == FreeSoulPizza.MAX_MEAT_COUNT
                        && this.veggieCount == FreeSoulPizza.MAX_VEGGIE_COUNT
                        && this.cheeseCount == FreeSoulPizza.MAX_CHEESE_COUNT;

            default:
                throw new IllegalArgumentException("unknown type");
        }
    }

    // protected
    protected Pizza(final EPizzaType pizzaType, final int price) {
        super(pizzaType.getProductType(), price);

        this.pizzaType = pizzaType;
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
