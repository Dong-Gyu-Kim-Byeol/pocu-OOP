package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class Pizza extends Product {
    private final ArrayList<Topping> toppings;
    private int veggieCount;
    private int meatCount;
    private int cheeseCount;

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

    protected boolean addToppingAndSetIsValid(final Topping topping, final int maxMeatCount, final int maxVeggieCount, final int maxCheeseCount) {
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

        this.setIsValid(maxMeatCount, maxVeggieCount, maxCheeseCount);
        return true;
    }

    protected boolean removeToppingAndSetIsValid(final Topping topping, final int maxMeatCount, final int maxVeggieCount, final int maxCheeseCount) {
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

        this.setIsValid(maxMeatCount, maxVeggieCount, maxCheeseCount);
        return isRemoved;
    }

    // private
    private void setIsValid(final int maxMeatCount, final int maxVeggieCount, final int maxCheeseCount) {
        super.setIsValid(this.meatCount == maxMeatCount
                && this.veggieCount == maxVeggieCount
                && this.cheeseCount == maxCheeseCount);
    }
}
