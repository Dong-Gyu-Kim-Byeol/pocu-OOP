package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Product {
    private final EPizzaType pizzaType;

    protected ArrayList<Topping> toppings;
    protected int veggieCount;
    protected int meatCount;
    protected int cheeseCount;

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public boolean isValid() {
        final int maxMeatCount;
        final int maxVeggieCount;
        final int maxCheeseCount;

        switch (this.pizzaType) {
            case HOUSE_PIZZA:
                maxMeatCount = HousePizza.MAX_MEAT_COUNT;
                maxVeggieCount = HousePizza.MAX_VEGGIE_COUNT;
                maxCheeseCount = HousePizza.MAX_CHEESE_COUNT;
                break;

            case MEAT_LOVER_PIZZA:
                maxMeatCount = MeatLoverPizza.MAX_MEAT_COUNT;
                maxVeggieCount = MeatLoverPizza.MAX_VEGGIE_COUNT;
                maxCheeseCount = MeatLoverPizza.MAX_CHEESE_COUNT;
                break;

            case VEGGIE_PIZZA:
                maxMeatCount = VeggiePizza.MAX_MEAT_COUNT;
                maxVeggieCount = VeggiePizza.MAX_VEGGIE_COUNT;
                maxCheeseCount = VeggiePizza.MAX_CHEESE_COUNT;
                break;

            case FREE_SOUL_PIZZA:
                maxMeatCount = FreeSoulPizza.MAX_MEAT_COUNT;
                maxVeggieCount = FreeSoulPizza.MAX_VEGGIE_COUNT;
                maxCheeseCount = FreeSoulPizza.MAX_CHEESE_COUNT;
                break;

            default:
                throw new IllegalArgumentException("unknown type");
        }

        return this.meatCount == maxMeatCount
                && this.veggieCount == maxVeggieCount
                && this.cheeseCount == maxCheeseCount;
    }

    // protected
    protected Pizza(final EPizzaType pizzaType, final Topping... toppings) {
        super(pizzaType.getProductType());

        this.pizzaType = pizzaType;

        this.toppings = new ArrayList<Topping>();
        for (final Topping topping : toppings) {
            this.toppings.add(topping);
        }
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
