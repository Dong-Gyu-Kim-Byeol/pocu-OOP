package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza {
    private final EPizzaType pizzaType;

    private final ArrayList<Topping> toppings;
    private int veggieCount;
    private int meatCount;
    private int cheeseCount;

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public int getPrice() {
        switch (this.pizzaType) {
            case HOUSE_PIZZA:
                return HousePizza.PRICE;

            case MEAT_LOVER_PIZZA:
                return MeatLoverPizza.PRICE;

            case VEGGIE_PIZZA:
                return VeggiePizza.PRICE;

            case FREE_SOUL_PIZZA:
                return FreeSoulPizza.PRICE;

            default:
                throw new IllegalArgumentException("unknown type");
        }
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
    protected Pizza(final EPizzaType pizzaType) {
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

    protected void initTopping(final Topping... toppings) {
        for (final Topping topping : toppings) {
            this.toppings.add(topping);
        }
    }

    protected boolean add(final Topping topping) {
        final int maxMeatCount;
        final int maxVeggieCount;
        final int maxCheeseCount;

        switch (this.pizzaType) {
            case HOUSE_PIZZA:
                maxMeatCount = HousePizza.MAX_MEAT_COUNT;
                maxVeggieCount = 0;
                maxCheeseCount = 0;
                break;

            case MEAT_LOVER_PIZZA:
                maxMeatCount = 0;
                maxVeggieCount = MeatLoverPizza.MAX_VEGGIE_COUNT;
                maxCheeseCount = 0;
                break;

            case VEGGIE_PIZZA:
                maxMeatCount = 0;
                maxVeggieCount = 0;
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

        if ((isMeat(topping) && this.meatCount >= maxMeatCount)
                || (isVeggie(topping) && this.veggieCount >= maxVeggieCount)
                || (isCheese(topping) && this.cheeseCount >= maxCheeseCount)) {
            return false;
        }

        this.toppings.add(topping);

        if (isMeat(topping)) {
            ++this.meatCount;
        }

        if (isVeggie(topping)) {
            ++this.veggieCount;
        }

        if (isCheese(topping)) {
            ++this.cheeseCount;
        }

        return true;
    }

    protected boolean remove(final Topping topping) {
        boolean isRemoved = this.toppings.remove(topping);

        if (isRemoved) {
            if (isMeat(topping)) {
                --this.meatCount;
            }

            if (isVeggie(topping)) {
                --this.veggieCount;
            }

            if (isCheese(topping)) {
                --this.cheeseCount;
            }
        }

        return isRemoved;
    }
}
